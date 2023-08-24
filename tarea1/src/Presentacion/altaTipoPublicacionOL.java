package Presentacion;

import logica.ControladorPublicaciones;
import logica.IControladorPublicaciones;


import java.awt.EventQueue;
import javax.swing.JInternalFrame;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import java.awt.Panel;
import javax.swing.JToolBar;

import excepciones.TipoPublicExisteException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.awt.event.ActionEvent;

public class altaTipoPublicacionOL extends JInternalFrame {
	
	private IControladorPublicaciones controlPub;
	
	private JTextField nombreField;
	private JTextArea descripcionArea; 
    private JComboBox comboBox; 
    private JSpinner spinner; 
    private JSpinner spinner_1;

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
	 * @throws PropertyVetoException 
	 */
	public altaTipoPublicacionOL() throws PropertyVetoException {
		setResizable(false);
		setMaximum(true);
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
		
		descripcionArea = new JTextArea();
		descripcionArea.setBounds(23, 76, 514, 85);
		getContentPane().add(descripcionArea);
		
		JLabel lblNewLabel_1 = new JLabel("Exposición:");
		lblNewLabel_1.setBounds(23, 172, 514, 14);
		getContentPane().add(lblNewLabel_1);
		
		comboBox = new JComboBox();
		comboBox.setBounds(23, 188, 271, 22);
		getContentPane().add(comboBox);
		
		JLabel lblNewLabel_1_1 = new JLabel("Duración de Publicación (Días):");
		lblNewLabel_1_1.setBounds(23, 221, 514, 14);
		getContentPane().add(lblNewLabel_1_1);
		
		spinner = new JSpinner();
		spinner.setBounds(23, 237, 149, 20);
		getContentPane().add(spinner);
		
		JLabel lblNewLabel_2 = new JLabel("Costo:");
		lblNewLabel_2.setBounds(23, 268, 46, 14);
		getContentPane().add(lblNewLabel_2);
		
		spinner_1 = new JSpinner();
		spinner_1.setBounds(23, 283, 149, 20);
		getContentPane().add(spinner_1);
		
		JButton buttonAceptar = new JButton("Aceptar");
		buttonAceptar.setBounds(106, 368, 89, 23);
		getContentPane().add(buttonAceptar);
		buttonAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                cmdRegistroTipoActionPerformed(arg0);
            }
        });
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(332, 368, 89, 23);
		getContentPane().add(btnCancelar);

		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
	
	 protected void cmdRegistroTipoActionPerformed(ActionEvent arg0) {
		 
		 if (esValido()) {
			//Obtengo los datos de las entradas
			 String nombreTipo = this.nombreField.getText();
			 String descripcionTipo = this.descripcionArea.getText();
			 String exposicionTipo = this.comboBox.getSelectedItem().toString();
			 Integer duracionTipo = (int) this.spinner.getValue();
			 Integer costoTipo = (int) this.spinner_1.getValue();
			 
			 try {
				 controlPub.altaTipoPublicacionOL(nombreTipo, descripcionTipo, exposicionTipo, duracionTipo, costoTipo, fecha);
				 //Muestro mensake de exito
				 JOptionPane.showMessageDialog(this, "El Tipo de Publicacion de Oferta Laboral se ha creado con éxito", "Registrar Tipo de Publicacion",
	                        JOptionPane.INFORMATION_MESSAGE);
				 limpiarFormulario();
				 setVisible(false);
			 }
				 catch(TipoPublicExisteException err){
						// Muestro error de registro
		                JOptionPane.showMessageDialog(this, err.getMessage(), "Registrar Tipo de Publicacion", JOptionPane.ERROR_MESSAGE);
					}

			 }
		 
		 
	 }
	 
	 public Boolean esValido() {
		 String nombreTipo = this.nombreField.getText();
		 String descripcionTipo = this.descripcionArea.getText();
		 String exposicionTipo = this.comboBox.getSelectedItem().toString();
		 Integer duracionTipo = (int) this.spinner.getValue();
		 Integer costoTipo = (int) this.spinner_1.getValue();
			if (nombreTipo.isEmpty() || descripcionTipo.isEmpty() || exposicionTipo.isEmpty() || duracionTipo <= 0 || costoTipo < 0) {
	            JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Registrar Tipo de Publicacion de Oferta Laboral",
	                    JOptionPane.ERROR_MESSAGE);
	            return false;
	        } else return true;
		}
	 
	 private void limpiarFormulario() {
		 nombreField.setText("");
		 descripcionArea.setText("");
		 comboBox.setSelectedIndex(0); 
		 spinner.setValue(0); 
		 spinner_1.setValue(0);
		   }


}
