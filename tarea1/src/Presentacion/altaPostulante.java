package Presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import java.awt.Panel;
import javax.swing.JToolBar;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import java.awt.Button;

public class altaPostulante extends JInternalFrame {
	
	
	private JTextField nicknameField;
	private JTextField nombreField;
	private JTextField apellidoField;
	private JTextField correoField;
	private JTextField nacionalidadField;
	private JSpinner dia;
	private JSpinner mes;
	private JSpinner año;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					altaPostulante frame = new altaPostulante();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public altaPostulante() {
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
		
		JSpinner dia = new JSpinner();
		dia.setBounds(202, 134, 33, 20);
		getContentPane().add(dia);
		
		JSpinner mes = new JSpinner();
		mes.setBounds(245, 134, 33, 20);
		getContentPane().add(mes);
		
		JSpinner año = new JSpinner();
		año.setBounds(288, 134, 33, 20);
		getContentPane().add(año);
		
		nacionalidadField = new JTextField();
		nacionalidadField.setBounds(145, 162, 176, 20);
		getContentPane().add(nacionalidadField);
		nacionalidadField.setColumns(10);
		
		Button button = new Button("Aceptar");
		button.setBounds(27, 214, 70, 22);
		getContentPane().add(button);
		
		Button button_1 = new Button("Cancelar");
		button_1.setBounds(251, 214, 70, 22);
		getContentPane().add(button_1);

	}
}
