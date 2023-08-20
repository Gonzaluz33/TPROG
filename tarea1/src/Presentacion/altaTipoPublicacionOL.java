package Presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import java.awt.Panel;
import javax.swing.JToolBar;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class altaTipoPublicacionOL extends JInternalFrame {
	private JTextField nombreField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					altaTipoPublicacionOL frame = new altaTipoPublicacionOL();
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
	public altaTipoPublicacionOL() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Alta de Tipo de Publicación de Oferta Laboral");
		setBounds(100, 100, 1017, 585);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setBounds(23, 11, 514, 14);
		getContentPane().add(lblNewLabel);
		
		nombreField = new JTextField();
		nombreField.setBounds(23, 27, 514, 20);
		getContentPane().add(nombreField);
		nombreField.setColumns(10);
		
		JLabel lblDescripcin = new JLabel("Descripción:");
		lblDescripcin.setBounds(23, 57, 514, 14);
		getContentPane().add(lblDescripcin);
		
		JTextArea descripcionArea = new JTextArea();
		descripcionArea.setBounds(23, 76, 514, 85);
		getContentPane().add(descripcionArea);
		
		JLabel lblNewLabel_1 = new JLabel("Exposición:");
		lblNewLabel_1.setBounds(23, 172, 514, 14);
		getContentPane().add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(23, 188, 271, 22);
		getContentPane().add(comboBox);
		
		JLabel lblNewLabel_1_1 = new JLabel("Duración de Publicación (Días):");
		lblNewLabel_1_1.setBounds(23, 221, 514, 14);
		getContentPane().add(lblNewLabel_1_1);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(23, 237, 149, 20);
		getContentPane().add(spinner);
		
		JLabel lblNewLabel_2 = new JLabel("Costo:");
		lblNewLabel_2.setBounds(23, 268, 46, 14);
		getContentPane().add(lblNewLabel_2);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(23, 283, 149, 20);
		getContentPane().add(spinner_1);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(106, 368, 89, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(332, 368, 89, 23);
		getContentPane().add(btnCancelar);

	}
}
