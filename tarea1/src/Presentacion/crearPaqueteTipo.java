package Presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

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
	private JTextField textFieldFecha;
	
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
		
		JLabel lblNewLabel_3 = new JLabel("Fecha de Alta (opcional):");
		lblNewLabel_3.setBounds(23, 306, 172, 13);
		getContentPane().add(lblNewLabel_3);
		
		textFieldFecha = new JTextField();
		textFieldFecha.setBounds(23, 329, 136, 19);
		getContentPane().add(textFieldFecha);
		textFieldFecha.setColumns(10);
		
		
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(23, 371, 89, 23);
		getContentPane().add(btnAceptar);
		btnAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
					altaPaquete(arg0);
            }
        });
		
		
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(352, 371, 89, 23);
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
			 int descuento = (int) this.descuentoSpinner.getValue();
			 
			 String fechaAlta = textFieldFecha.getText();
             SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
             formato.setLenient(false);  // Hacer que el formato sea estricto

             if(!fechaAlta.isEmpty()) {
            	 try {
                     formato.parse(fechaAlta);
                     Date fecha = formato.parse(fechaAlta);
                     Calendar calendario = Calendar.getInstance();
                     calendario.setTime(fecha);
                     int anio = calendario.get(Calendar.YEAR);
                     if (anio >= 1500 && anio <= 4000) {
                    	 confirmarCrearPaquete( nombreTipo,descripcionTipo, validez, descuento,fechaAlta);
                     } else {
                     	JOptionPane.showMessageDialog(null, "La fecha es válida pero el año está fuera del rango permitido."); 
                     }
                 } catch (ParseException e1) {
                 	JOptionPane.showMessageDialog(null, "Fecha Invalida!");
                 }
             }
             else {
            	 confirmarCrearPaquete( nombreTipo,descripcionTipo, validez, descuento,fechaAlta);
            	 
             }
		}
	 }
	
	private void confirmarCrearPaquete(String nombreTipo, String descripcionTipo, int validez, int descuento, String fechaAlta) {
	   	 try {                		 
				 controlPub.altaPaqueteTipoPublicacion(nombreTipo, descripcionTipo, validez, descuento,fechaAlta);
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
