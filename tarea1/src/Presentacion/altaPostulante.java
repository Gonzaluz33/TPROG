package Presentacion;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import excepciones.CorreoRepetidoException;
import excepciones.UsuarioRepetidoException;
import logica.IControladorUsuario;
import javax.swing.JPasswordField;

@SuppressWarnings("serial")
public class altaPostulante extends JInternalFrame {
	// Controlador de usuarios que se utilizará para las acciones del JFrame
    private IControladorUsuario controlUsr;
    //Componentes Graficos
    private JComboBox<String> nacionalidadDropdown;
	private JTextField nicknameField;
	private JTextField nombreField;
	private JTextField apellidoField;
	private JTextField correoField;
	private JSpinner dia;
	private JSpinner mes;
	private JSpinner ano;
	private JPasswordField contraseñaField;
	private JPasswordField confContraseñaField;

	/**
	 * Create the frame.
	 * @throws PropertyVetoException 
	 */
	public altaPostulante(IControladorUsuario icu) throws PropertyVetoException {
		//Inicializacion internal frame con controlador de usuarios.
		controlUsr = icu;
		
		setResizable(false);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Alta de Postulante");
		setBounds(100, 100, 647, 480);
		getContentPane().setLayout(null);
		
		nicknameField = new JTextField();
		nicknameField.setBounds(145, 16, 203, 20);
		getContentPane().add(nicknameField);
		nicknameField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nickname:");
		lblNewLabel.setBounds(27, 19, 102, 14);
		getContentPane().add(lblNewLabel);
		
		nombreField = new JTextField();
		nombreField.setBounds(145, 69, 203, 20);
		getContentPane().add(nombreField);
		nombreField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setBounds(27, 44, 102, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Apellido:");
		lblNewLabel_2.setBounds(27, 72, 102, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Correo:");
		lblNewLabel_3.setBounds(27, 97, 102, 14);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Fecha de Nacimiento:");
		lblNewLabel_4.setBounds(27, 207, 139, 14);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Nacionalidad:");
		lblNewLabel_5.setBounds(27, 232, 102, 14);
		getContentPane().add(lblNewLabel_5);
		
		apellidoField = new JTextField();
		apellidoField.setColumns(10);
		apellidoField.setBounds(145, 41, 203, 20);
		getContentPane().add(apellidoField);
		
		correoField = new JTextField();
		correoField.setBounds(145, 100, 203, 20);
		getContentPane().add(correoField);
		correoField.setColumns(10);
		
		JLabel lblNewLabel_3_1 = new JLabel("Contraseña:");
		lblNewLabel_3_1.setBounds(27, 134, 102, 14);
		getContentPane().add(lblNewLabel_3_1);
		
		contraseñaField = new JPasswordField();
		contraseñaField.setBounds(194, 131, 154, 20);
		getContentPane().add(contraseñaField);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Confirmación de Contraseña:");
		lblNewLabel_3_1_1.setBounds(27, 171, 169, 14);
		getContentPane().add(lblNewLabel_3_1_1);
		
		confContraseñaField = new JPasswordField();
		confContraseñaField.setBounds(194, 168, 154, 20);
		getContentPane().add(confContraseñaField);
		
		dia = new JSpinner();
		dia.setBounds(176, 204, 33, 20);
		getContentPane().add(dia);
		
		mes = new JSpinner();
		mes.setBounds(219, 204, 33, 20);
		getContentPane().add(mes);
		
		ano = new JSpinner();
		ano.setBounds(262, 204, 59, 20);
		getContentPane().add(ano);
		
		String currentDirectory = System.getProperty("user.dir");
		
        String csvNacionalidades = currentDirectory + File.separator + "Datos" + File.separator + "Nacionalidades.csv";
		
		String[] nacionalidades = cargarNacionalidadesDesdeCSV(csvNacionalidades);
		
		nacionalidadDropdown = new JComboBox<>(nacionalidades);
		nacionalidadDropdown.setBounds(145, 229, 176, 20);
		getContentPane().add(nacionalidadDropdown);
		
		
		
		Button buttonAceptar = new Button("Aceptar");
		buttonAceptar.setBounds(27, 281, 70, 22);
		getContentPane().add(buttonAceptar);
		
		buttonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                registrarPostulante(e);
			}
		});
		
		Button buttonCancelar = new Button("Cancelar");
		buttonCancelar.setBounds(251, 281, 70, 22);
		getContentPane().add(buttonCancelar);
		

		
		buttonCancelar.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 dispose();
	            }
		});

	}
	
	private String[] cargarNacionalidadesDesdeCSV(String rutaArchivo) {
	    List<String> nacionalidades = new ArrayList<>();
	    try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
	        String linea;
	        while ((linea = br.readLine()) != null) {
	            nacionalidades.add(linea);
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return nacionalidades.toArray(new String[0]);
	}


	public void registrarPostulante(ActionEvent e) {
		String nick = this.nicknameField.getText();
		String nombre = this.nombreField.getText();
		String apellido = this.apellidoField.getText();
		String email = this.correoField.getText();
		String contraseña = this.contraseñaField.getPassword().toString();
		String confContraseña = this.confContraseñaField.getPassword().toString();
		int year = (Integer) this.ano.getValue();
		String stringifiedMonth = this.mes.getValue() + "";
		Integer month = Integer.parseInt(stringifiedMonth);
		String stringifiedDay = this.dia.getValue() + "";
		Integer day = Integer.parseInt(stringifiedDay);
		Date date = new GregorianCalendar(year, month-1, day).getTime();
		String nacion = (String) nacionalidadDropdown.getSelectedItem();
		
		if(checkFormulario()) {
			  try {
	                controlUsr.altaPostulante(nick, nombre, apellido, email, contraseña ,date, nacion);
	                // Muestro éxito de la operación
	                JOptionPane.showMessageDialog(this, "El Usuario se ha creado con éxito", "Registrar Usuario",
	                        JOptionPane.INFORMATION_MESSAGE);
	                
	                
	    			// Limpio el internal frame antes de cerrar la ventana
		            limpiarFormulario();
		            setVisible(false);
		            

	            } catch (UsuarioRepetidoException | CorreoRepetidoException err) {
	                // Muestro error de registro
	                JOptionPane.showMessageDialog(this, err.getMessage(), "Registrar Usuario", JOptionPane.ERROR_MESSAGE);
	            }
		}
	}
	
	public Boolean esValidoFecha() {
		Integer year = (Integer) this.ano.getValue();
		String stringifiedMonth = this.mes.getValue() + "";
		Integer month = Integer.parseInt(stringifiedMonth) - 1;
		String stringifiedDay = this.dia.getValue() + "";
		Integer day = Integer.parseInt(stringifiedDay);
		
		GregorianCalendar calendar = new GregorianCalendar(year, month, day);
		
		if (day.equals(calendar.get(GregorianCalendar.DAY_OF_MONTH)) && (year > 1900 && year < 3000)) {
			return true;
		} else {
			JOptionPane.showMessageDialog(this, "Fecha Inválida", "Registrar Usuario",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}
	
	private boolean checkFormulario() {
	    String nick = this.nicknameField.getText();
	    String nombre = this.nombreField.getText();
	    String apellido = this.apellidoField.getText();
	    String email = this.correoField.getText();
	    String nacion = this.nacionalidadDropdown.getSelectedItem().toString();
	    String contraseña = new String(this.contraseñaField.getPassword());
		String confContraseña = new String(this.confContraseñaField.getPassword());

	    // Verificar si están vacíos
	    if (nick.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || email.isEmpty() || nacion.isEmpty()|| contraseña.isEmpty() || confContraseña.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Registrar Usuario",
	                JOptionPane.ERROR_MESSAGE);
	        return false;
	    }

	    // Verificar si exceden los 50 caracteres
	    if(nick.length() > 50 || nombre.length() > 50 || apellido.length() > 50 || email.length() > 50 || nacion.length() > 50) {
	        JOptionPane.showMessageDialog(this, "Los campos no pueden exceder los 50 caracteres", "Registrar Usuario",
	                JOptionPane.ERROR_MESSAGE);
	        return false;
	    }
	    
	    if(!contraseña.equals(confContraseña)) {
	    	JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden.", "Registrar Usuario",
	                JOptionPane.ERROR_MESSAGE);
	        return false;
	    }
	    

	    return esValidoFecha();
	}

	private void limpiarFormulario() {
		nicknameField.setText("");
		nombreField.setText("");
		apellidoField.setText("");
		correoField.setText("");
		ano.setValue(Integer.valueOf(0));
		mes.setValue(Integer.valueOf(0));
		dia.setValue(Integer.valueOf(0));;
	}
}

