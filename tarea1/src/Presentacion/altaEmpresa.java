package Presentacion;

import java.awt.Button;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import java.awt.Panel;
import javax.swing.JToolBar;
import javax.swing.JTextArea;

public class altaEmpresa extends JInternalFrame {
	private JTextField nicknameField;
	private JTextField apellidoField;
	private JTextField nombreField;
	private JTextField correoField;
	private JTextField linkWebField;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					altaEmpresa frame = new altaEmpresa();
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
	public altaEmpresa() {
		setResizable(true);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Alta de Empresa");
		setBounds(100, 100, 631, 392);
		getContentPane().setLayout(null);
		
		nicknameField = new JTextField();
		nicknameField.setBounds(161, 22, 191, 20);
		getContentPane().add(nicknameField);
		nicknameField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nickname:");
		lblNewLabel.setBounds(43, 25, 74, 14);
		getContentPane().add(lblNewLabel);
		
		apellidoField = new JTextField();
		apellidoField.setBounds(161, 75, 191, 20);
		getContentPane().add(apellidoField);
		apellidoField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setBounds(43, 50, 74, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Apellido:");
		lblNewLabel_2.setBounds(43, 78, 74, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Correo:");
		lblNewLabel_3.setBounds(43, 109, 74, 14);
		getContentPane().add(lblNewLabel_3);
		
		nombreField = new JTextField();
		nombreField.setColumns(10);
		nombreField.setBounds(161, 47, 191, 20);
		getContentPane().add(nombreField);
		
		correoField = new JTextField();
		correoField.setBounds(161, 106, 191, 20);
		getContentPane().add(correoField);
		correoField.setColumns(10);
		
		Button button = new Button("Aceptar");
		button.setBounds(47, 313, 70, 22);
		getContentPane().add(button);
		
		Button button_1 = new Button("Cancelar");
		button_1.setBounds(282, 313, 70, 22);
		getContentPane().add(button_1);
		
		JLabel labelDescripcion = new JLabel("Descripcion General:");
		labelDescripcion.setBounds(43, 147, 126, 14);
		getContentPane().add(labelDescripcion);
		
		JTextArea descripcionField = new JTextArea();
		descripcionField.setBounds(189, 142, 163, 93);
		getContentPane().add(descripcionField);
		
		JLabel linkField = new JLabel("Link Web (Opcional):");
		linkField.setBounds(43, 256, 146, 14);
		getContentPane().add(linkField);
		
		linkWebField = new JTextField();
		linkWebField.setBounds(199, 253, 153, 20);
		getContentPane().add(linkWebField);
		linkWebField.setColumns(10);


	}
}
