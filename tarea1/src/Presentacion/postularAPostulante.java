package Presentacion;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

import excepciones.NicknameNoExisteException;
import excepciones.OfertaNoExisteException;
import excepciones.UsuarioNoEsPostulanteException;
import logica.ControladorOfertas;
import logica.ControladorUsuarios;
import logica.IControladorOfertas;
import logica.IControladorUsuario;
import utils.DTOferta;
import utils.DTPostulante;

public class postularAPostulante extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;
	
	private JTextField nombreOferta;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private String ofertaNombre;
	private JComboBox<String> comboBox;
    private JTextArea textAreaCV;
    private JTextArea textAreaMotivacion;
	private IControladorOfertas controlOL;
	private IControladorUsuario controlU;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IControladorOfertas controlOL = new ControladorOfertas();
					IControladorUsuario controlU = new ControladorUsuarios();
					postularAPostulante frame = new postularAPostulante(controlOL, controlU);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws PropertyVetoException 
	 */
	public postularAPostulante(IControladorOfertas iol, IControladorUsuario ICU) throws PropertyVetoException {
		
		controlOL = iol;
		controlU = ICU;
		
		setClosable(true);
		setMaximum(true);
		setResizable(true);
		setBounds(100, 100, 1060, 685);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Seleccione un postulante:");
		lblNewLabel.setBounds(10, 288, 392, 14);
		getContentPane().add(lblNewLabel);
		
		comboBox = new JComboBox<String>();
		comboBox.setBounds(10, 309, 338, 22);
		getContentPane().add(comboBox);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 277, 1005, 2);
		getContentPane().add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Datos Oferta Laboral:");
		lblNewLabel_1.setBounds(10, 11, 247, 14);
		getContentPane().add(lblNewLabel_1);
		
		nombreOferta = new JTextField();
		nombreOferta.setEditable(false);
		nombreOferta.setBounds(125, 36, 255, 20);
		getContentPane().add(nombreOferta);
		nombreOferta.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre:");
		lblNewLabel_2.setBounds(31, 36, 84, 14);
		getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(125, 67, 255, 175);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Descripción:");
		lblNewLabel_3.setBounds(31, 70, 84, 14);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Ciudad:");
		lblNewLabel_4.setBounds(402, 39, 76, 14);
		getContentPane().add(lblNewLabel_4);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(489, 36, 157, 20);
		getContentPane().add(textField_1);
		
		JLabel lblNewLabel_5 = new JLabel("Departamento:");
		lblNewLabel_5.setBounds(402, 70, 84, 14);
		getContentPane().add(lblNewLabel_5);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(489, 67, 157, 20);
		getContentPane().add(textField_2);
		
		JLabel lblNewLabel_6 = new JLabel("Horario:");
		lblNewLabel_6.setBounds(402, 101, 46, 14);
		getContentPane().add(lblNewLabel_6);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(489, 98, 157, 20);
		getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(489, 129, 157, 20);
		getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(489, 166, 157, 20);
		getContentPane().add(textField_5);
		
		JLabel lblNewLabel_7 = new JLabel("Remuneración:");
		lblNewLabel_7.setBounds(402, 132, 84, 14);
		getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_7_1 = new JLabel("Fecha Alta:");
		lblNewLabel_7_1.setBounds(402, 169, 84, 14);
		getContentPane().add(lblNewLabel_7_1);
		
		textAreaCV = new JTextArea();
        textAreaCV.setBounds(10, 371, 328, 184);
        getContentPane().add(textAreaCV);
                
        JLabel lblNewLabel_8 = new JLabel("Ingrese CV reducido:");
        lblNewLabel_8.setBounds(10, 342, 328, 14);
        getContentPane().add(lblNewLabel_8);
                
        textAreaMotivacion = new JTextArea();
        textAreaMotivacion.setBounds(348, 371, 301, 99);
        getContentPane().add(textAreaMotivacion);
                
        JLabel lblNewLabel_9 = new JLabel("Ingrese Motivación:");
        lblNewLabel_9.setBounds(348, 342, 301, 14);
        getContentPane().add(lblNewLabel_9);

		// Calcular la posición y de los botones basándose en la altura y posición y del textAreaMotivacion.
		int yBotones = textAreaMotivacion.getBounds().y + textAreaMotivacion.getBounds().height + 20;  

		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.setBounds(348, yBotones, 97, 23);  
		getContentPane().add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	try {
					postularPostulanteElegido();
				} catch (NicknameNoExisteException | UsuarioNoEsPostulanteException | OfertaNoExisteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    }
		});
				
		JButton buttonCancelar = new JButton("Cancelar");
		buttonCancelar.setBounds(btnNewButton.getBounds().x + btnNewButton.getBounds().width + 10, yBotones, 89, 23);  
		getContentPane().add(buttonCancelar);
				
		buttonCancelar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        dispose();
		    }
		});
		
	
	}
	
	 public void recibirNombreOferta(String nombre) {
	        this.ofertaNombre = nombre;
	    }
	
	public void mostrarDatosOferta() throws OfertaNoExisteException {
		String oferta = this.ofertaNombre;
		//Obtengo datos oferta 
		DTOferta datosOferta = controlOL.obtenerDatosOferta(oferta);
		
		System.out.println("Hay datos?" + datosOferta.getCiudad());
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		   //Asignando valores del objeto DTOferta a los JTextField
	    nombreOferta.setText(datosOferta.getNombre());
	    textField.setText(datosOferta.getDescripcion());
	    textField_1.setText(datosOferta.getCiudad());
	    textField_2.setText(datosOferta.getDepartamento());
	    textField_3.setText(datosOferta.getHorario());
	    textField_4.setText(String.valueOf(datosOferta.getRemuneracion())); // suponiendo que Remuneracion es un número, lo convertimos a String
	    textField_5.setText(datosOferta.getFechaAlta().format(formatter));
		
	}
	
	public void comboMostrarPostulatntes() {
		JComboBox<String> combobox = this.comboBox;
		combobox.removeAllItems();
		if(controlOL != null) {
		List<DTPostulante> postulantes = controlU.listarPostulantes();
		if (!postulantes.isEmpty()) {
			for (DTPostulante postulante : postulantes) {
		        comboBox.addItem(postulante.getNombre()); 
		    }
		}
		}
	}
	
	public void postularPostulanteElegido() throws NicknameNoExisteException, UsuarioNoEsPostulanteException, OfertaNoExisteException {
		String oferta = this.ofertaNombre;
		String postulanteSeleccionado = (String) comboBox.getSelectedItem();
		String cv = textAreaCV.getText();
	    String motivacion = textAreaMotivacion.getText();
	    LocalDateTime fecha = LocalDateTime.now();
	    
	    controlOL.postularAOferta(oferta, postulanteSeleccionado, cv, motivacion, fecha);
		
	}
	
	
}

