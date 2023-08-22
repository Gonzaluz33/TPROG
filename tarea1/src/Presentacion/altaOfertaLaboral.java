package Presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.Panel;
import java.awt.Label;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.awt.TextArea;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import java.awt.Button;
import java.awt.Color;



@SuppressWarnings("serial")
public class altaOfertaLaboral extends JInternalFrame {
	private JTextField horarioField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					altaOfertaLaboral frame = new altaOfertaLaboral();
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
	public altaOfertaLaboral() throws PropertyVetoException {
		setResizable(false);
		setMaximum(true);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Alta de Oferta Laboral");
		setBounds(100, 100, 985, 543);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Seleccione una empresa:");
		lblNewLabel.setBounds(25, 21, 878, 14);
		getContentPane().add(lblNewLabel);
		
		JComboBox boxEmpresa = new JComboBox();
		boxEmpresa.setBounds(25, 46, 721, 22);
		getContentPane().add(boxEmpresa);
		
		JLabel lblSeleccioneUnTipo = new JLabel("Seleccione un tipo de publicación:");
		lblSeleccioneUnTipo.setBounds(25, 79, 878, 14);
		getContentPane().add(lblSeleccioneUnTipo);
		
		JComboBox boxTipoPublicacion = new JComboBox();
		boxTipoPublicacion.setBounds(25, 102, 721, 22);
		getContentPane().add(boxTipoPublicacion);
		
		JLabel lblIngreseNombreDe = new JLabel("Nombre:");
		lblIngreseNombreDe.setBounds(25, 135, 878, 14);
		getContentPane().add(lblIngreseNombreDe);
		
		TextField nombreField = new TextField();
		nombreField.setBounds(25, 155, 354, 22);
		getContentPane().add(nombreField);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setBounds(25, 191, 878, 14);
		getContentPane().add(lblDescripcion);
		
		TextArea descripcionTextArea = new TextArea();
		descripcionTextArea.setBounds(25, 211, 721, 88);
		getContentPane().add(descripcionTextArea);
		
		JLabel lblNewLabel_1 = new JLabel("Horario:");
		lblNewLabel_1.setBounds(25, 310, 179, 14);
		getContentPane().add(lblNewLabel_1);
		
		horarioField = new JTextField();
		horarioField.setBounds(25, 335, 178, 20);
		getContentPane().add(horarioField);
		horarioField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Remuneración:");
		lblNewLabel_2.setBounds(25, 366, 178, 14);
		getContentPane().add(lblNewLabel_2);
		
		JSpinner remuneracionSpiner = new JSpinner();
		remuneracionSpiner.setBounds(25, 392, 178, 20);
		getContentPane().add(remuneracionSpiner);
		
		JLabel lblNewLabel_3 = new JLabel("Ciudad:");
		lblNewLabel_3.setBounds(241, 310, 178, 14);
		getContentPane().add(lblNewLabel_3);
		
		TextField ciudadField = new TextField();
		ciudadField.setBounds(241, 333, 178, 22);
		getContentPane().add(ciudadField);
		
		JLabel lblNewLabel_3_1 = new JLabel("Departamento:");
		lblNewLabel_3_1.setBounds(241, 366, 178, 14);
		getContentPane().add(lblNewLabel_3_1);
		
		TextField departamentoField = new TextField();
		departamentoField.setBounds(241, 390, 178, 22);
		getContentPane().add(departamentoField);
		
		Button buttonAceptar = new Button("Aceptar ");
		buttonAceptar.setBackground(new Color(255, 255, 255));
		buttonAceptar.setBounds(25, 481, 70, 22);
		getContentPane().add(buttonAceptar);
		
		Button buttonCancelar = new Button("Cancelar");
		buttonCancelar.setBackground(Color.WHITE);
		buttonCancelar.setBounds(349, 481, 70, 22);
		getContentPane().add(buttonCancelar);
		
		buttonCancelar.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 dispose();
	            }
		});

	}
}
