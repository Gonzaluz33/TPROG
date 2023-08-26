package Presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JToolBar;

import excepciones.UsuarioRepetidoException;
import logica.ControladorUsuarios;
import logica.IControladorUsuario;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import java.awt.Button;

public class altaPostulante extends JInternalFrame {
	// Controlador de usuarios que se utilizará para las acciones del JFrame
    private IControladorUsuario controlUsr;
    //Componentes Graficos
	private JTextField nicknameField;
	private JTextField nombreField;
	private JTextField apellidoField;
	private JTextField correoField;
	private JTextField nacionalidadField;
	private JSpinner dia;
	private JSpinner mes;
	private JSpinner ano;

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
		setBounds(100, 100, 647, 300);
		getContentPane().setLayout(null);
		
		nicknameField = new JTextField();
		nicknameField.setBounds(145, 16, 176, 20);
		getContentPane().add(nicknameField);
		nicknameField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nickname:");
		lblNewLabel.setBounds(27, 19, 102, 14);
		getContentPane().add(lblNewLabel);
		
		nombreField = new JTextField();
		nombreField.setBounds(145, 69, 176, 20);
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
		lblNewLabel_4.setBounds(27, 140, 139, 14);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Nacionalidad:");
		lblNewLabel_5.setBounds(27, 165, 102, 14);
		getContentPane().add(lblNewLabel_5);
		
		apellidoField = new JTextField();
		apellidoField.setColumns(10);
		apellidoField.setBounds(145, 41, 176, 20);
		getContentPane().add(apellidoField);
		
		correoField = new JTextField();
		correoField.setBounds(145, 100, 176, 20);
		getContentPane().add(correoField);
		correoField.setColumns(10);
		
		dia = new JSpinner();
		dia.setBounds(176, 137, 33, 20);
		getContentPane().add(dia);
		
		mes = new JSpinner();
		mes.setBounds(219, 137, 33, 20);
		getContentPane().add(mes);
		
		ano = new JSpinner();
		ano.setBounds(262, 137, 59, 20);
		getContentPane().add(ano);
		
		nacionalidadField = new JTextField();
		nacionalidadField.setBounds(145, 162, 176, 20);
		getContentPane().add(nacionalidadField);
		nacionalidadField.setColumns(10);
		
		Button buttonAceptar = new Button("Aceptar");
		buttonAceptar.setBounds(27, 214, 70, 22);
		getContentPane().add(buttonAceptar);
		
		buttonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                registrarPostulante(e);
			}
		});
		
		Button buttonCancelar = new Button("Cancelar");
		buttonCancelar.setBounds(251, 214, 70, 22);
		getContentPane().add(buttonCancelar);
		
		buttonCancelar.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 dispose();
	            }
		});

	}


	public void registrarPostulante(ActionEvent e) {
		String nick = this.nicknameField.getText();
		String nombre = this.nombreField.getText();
		String apellido = this.apellidoField.getText();
		String email = this.correoField.getText();
		int year = (Integer) this.ano.getValue();
		String stringifiedMonth = this.mes.getValue() + "";
		Integer month = Integer.parseInt(stringifiedMonth);
		String stringifiedDay = this.dia.getValue() + "";
		Integer day = Integer.parseInt(stringifiedDay);
		Date date = new GregorianCalendar(year, month-1, day).getTime();
		String nacion = this.nacionalidadField.getText();
		
		if(checkFormulario()) {
			  try {
	                controlUsr.altaPostulante(nick, nombre, apellido, email, date, nacion);
	                // Muestro éxito de la operación
	                JOptionPane.showMessageDialog(this, "El Usuario se ha creado con éxito", "Registrar Usuario",
	                        JOptionPane.INFORMATION_MESSAGE);
	                
	                
	    			// Limpio el internal frame antes de cerrar la ventana
		            limpiarFormulario();
		            setVisible(false);
		            

	            } catch (UsuarioRepetidoException err) {
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
		String nacion = this.nacionalidadField.getText();

        if (nick.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || email.isEmpty() || nacion.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Registrar Usuario",
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
		nacionalidadField.setText("");
	   }
}

