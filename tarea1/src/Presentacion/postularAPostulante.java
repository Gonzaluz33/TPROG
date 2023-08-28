package Presentacion;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextPane;

public class postularAPostulante extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;
	
	private JTextField nombreOferta;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					postularAPostulante frame = new postularAPostulante();
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
	public postularAPostulante() throws PropertyVetoException {
		setClosable(true);
		setMaximum(true);
		setResizable(true);
		setBounds(100, 100, 1060, 685);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Seleccione un postulante:");
		lblNewLabel.setBounds(10, 288, 392, 14);
		getContentPane().add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
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
		
		JTextArea textAreaCV = new JTextArea();
		textAreaCV.setBounds(10, 371, 328, 184);
		getContentPane().add(textAreaCV);
		
		JLabel lblNewLabel_8 = new JLabel("Ingrese CV reducido:");
		lblNewLabel_8.setBounds(10, 342, 328, 14);
		getContentPane().add(lblNewLabel_8);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(348, 371, 301, 99);
		getContentPane().add(textArea);
		
		JLabel lblNewLabel_9 = new JLabel("Ingrese Motivación:");
		lblNewLabel_9.setBounds(348, 342, 301, 14);
		getContentPane().add(lblNewLabel_9);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.setBounds(310, 610, 97, 23);
		getContentPane().add(btnNewButton);
		
		JButton buttonCancelar = new JButton("Cancelar");
		buttonCancelar.setBounds(611, 610, 89, 23);
		getContentPane().add(buttonCancelar);
		
		buttonCancelar.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 dispose();
	            }
		});

	}
}
