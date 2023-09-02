package Presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import excepciones.PaqueteExisteException;
import excepciones.TipoPublicExisteException;
import logica.IControladorPublicaciones;

import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class crearPaqueteTipo extends JInternalFrame {
	private IControladorPublicaciones controlPub;
	
	private JTextField nombreField;
	private JTextArea descripcionField;
	private JSpinner validezSpinner;
	private JSpinner descuentoSpinner;
	
	/**
	 * Create the frame.
	 */
	public crearPaqueteTipo(IControladorPublicaciones icp) {
		controlPub = icp;
		
		setTitle("Crear Paquete de Tipos de Publicación de Ofertas Laborales");
		setBounds(100, 100, 1068, 659);
		getContentPane().setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(23, 27, 391, 14);
		getContentPane().add(lblNombre);
		
		nombreField = new JTextField();
		nombreField.setBounds(23, 44, 196, 20);
		getContentPane().add(nombreField);
		nombreField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Descripción");
		lblNewLabel.setBounds(23, 75, 196, 14);
		getContentPane().add(lblNewLabel);
		
		descripcionField = new JTextArea();
		descripcionField.setLineWrap(true);
		descripcionField.setWrapStyleWord(true);
		descripcionField.setBounds(23, 100, 418, 130);
		getContentPane().add(descripcionField);

		JLabel lblNewLabel_1 = new JLabel("Validez (días):");
		lblNewLabel_1.setBounds(23, 242, 101, 14);
		getContentPane().add(lblNewLabel_1);
		
		validezSpinner = new JSpinner();
		validezSpinner.setBounds(23, 267, 90, 20);
		getContentPane().add(validezSpinner);
		
		JLabel lblNewLabel_2 = new JLabel("Descuento:");
		lblNewLabel_2.setBounds(157, 242, 120, 14);
		getContentPane().add(lblNewLabel_2);
		
		descuentoSpinner = new JSpinner();
		descuentoSpinner.setBounds(157, 267, 90, 20);
		getContentPane().add(descuentoSpinner);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(24, 359, 89, 23);
		getContentPane().add(btnAceptar);
		btnAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
					altaPaquete(arg0);
            }
        });
		
		
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(352, 359, 89, 23);
		getContentPane().add(btnCancelar);

		btnCancelar.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 dispose();
	            }
		});
	}
	protected void altaPaquete(ActionEvent arg0){	 
		 if (esValido()) {
			//Obtengo los datos de las entradas
			 String nombreTipo = this.nombreField.getText();
			 String descripcionTipo = this.descripcionField.getText();
			 int validez = (int) this.validezSpinner.getValue();
			 int duracion = (int) this.descuentoSpinner.getValue();
			 try {
				 controlPub.altaPaqueteTipoPublicacion(nombreTipo, descripcionTipo, validez, duracion);
				 //Muestro mensake de exito
				 JOptionPane.showMessageDialog(this, "El paquete se ha creado con éxito", "Crear Paquete de Tipo de Publicacion",
	                        JOptionPane.INFORMATION_MESSAGE);
				 limpiarFormulario();
				 setVisible(false);
			 }
				 catch(PaqueteExisteException err){
						// Muestro error de registro
		                JOptionPane.showMessageDialog(this, err.getMessage(), "Crear Paquete de Tipo de Publicacion", JOptionPane.ERROR_MESSAGE);
					}
			 }
	 }
	
	private Boolean esValido() {
		String nombre = this.nombreField.getText();
		String descripcion = this.descripcionField.getText();
		int validez = (int) this.validezSpinner.getValue();
		int duracion = (int) this.descuentoSpinner.getValue();
		if(nombre.isEmpty() || descripcion.isEmpty()) {
			  JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Registrar Usuario", JOptionPane.ERROR_MESSAGE);
		      return false;
		}
		else if(validez <=0) {
			 JOptionPane.showMessageDialog(this, "La validez debe ser mayor que 0", "Registrar Usuario", JOptionPane.ERROR_MESSAGE);
			 return false;
		}
		else {
			return true;
		}
	}
	
	private void limpiarFormulario() {
		 nombreField.setText("");
		 descripcionField.setText("");
		 validezSpinner.setValue(0);
		 descuentoSpinner.setValue(0); 
	}
}
