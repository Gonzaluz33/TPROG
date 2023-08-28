package Presentacion;

import java.awt.Button;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.beans.PropertyVetoException;

import javax.swing.JToolBar;

import excepciones.UsuarioRepetidoException;
import logica.ControladorUsuarios;
import logica.IControladorUsuario;

import javax.swing.JTextArea;

public class altaEmpresa extends JInternalFrame {
	
	// Controlador de usuarios que se utilizará para las acciones del JFrame
    private IControladorUsuario controlUsr;
	
	private JTextField nicknameField;
	private JTextField apellidoField;
	private JTextField nombreField;
	private JTextField correoField;
	private JTextField linkWebField;
	private JTextArea descripcionField;
	private JTextField nombreEmpresaField;

	/**
	 * Create the frame.
	 * @throws PropertyVetoException 
	 */
	public altaEmpresa(IControladorUsuario icu) throws PropertyVetoException {
		//Inicializacion internal frame con controlador de usuarios.
		controlUsr = icu;
		
		
		setResizable(false);
		setMaximum(true);
		setClosable(true);
		setTitle("Alta de Empresa");
		setBounds(100, 100, 631, 595);
		getContentPane().setLayout(null);
		
		nicknameField = new JTextField();
		nicknameField.setBounds(185, 25, 191, 20);
		getContentPane().add(nicknameField);
		nicknameField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nickname:");
		lblNewLabel.setBounds(43, 25, 74, 14);
		getContentPane().add(lblNewLabel);
		
		apellidoField = new JTextField();
		apellidoField.setBounds(185, 78, 191, 20);
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
		nombreField.setBounds(185, 50, 191, 20);
		getContentPane().add(nombreField);
		
		correoField = new JTextField();
		correoField.setBounds(185, 109, 191, 20);
		getContentPane().add(correoField);
		correoField.setColumns(10);
		
		Button buttonAceptar = new Button("Aceptar");
		buttonAceptar.setBounds(47, 312, 70, 22);
		getContentPane().add(buttonAceptar);
		
		buttonAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                registrarEmpresa(arg0);
            }
        });

		Button buttonCancelar = new Button("Cancelar");
		buttonCancelar.setBounds(282, 312, 70, 22);
		getContentPane().add(buttonCancelar);
		
		
		buttonCancelar.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 dispose();
	            }
		});
		
		JLabel labelDescripcion = new JLabel("Descripcion General:");
		labelDescripcion.setBounds(43, 170, 126, 14);
		getContentPane().add(labelDescripcion);
		
		descripcionField = new JTextArea();
		descripcionField.setBounds(213, 168, 163, 93);
		getContentPane().add(descripcionField);
		
		JLabel linkField = new JLabel("Link Web (Opcional):");
		linkField.setBounds(43, 272, 146, 14);
		getContentPane().add(linkField);
		
		linkWebField = new JTextField();
		linkWebField.setBounds(223, 272, 153, 20);
		getContentPane().add(linkWebField);
		linkWebField.setColumns(10);
		
		nombreEmpresaField = new JTextField();
		nombreEmpresaField.setColumns(10);
		nombreEmpresaField.setBounds(185, 137, 191, 20);
		getContentPane().add(nombreEmpresaField);
		
		JLabel lblNewLabel_4 = new JLabel("Nombre de Empresa:");
		lblNewLabel_4.setBounds(43, 137, 146, 14);
		getContentPane().add(lblNewLabel_4);


	}
	
	public void registrarEmpresa(ActionEvent arg0) {	
		if (esValido()) {
			String nick = this.nicknameField.getText();
			String nombre = this.nombreField.getText();
			String apellido = this.apellidoField.getText();
			String email = this.correoField.getText();
			String nomEmpresa = this.nombreEmpresaField.getText();
			String desc = this.descripcionField.getText();
			String link = this.linkWebField.getText();
			
			try {
				controlUsr.altaEmpresa(nick, nombre, apellido, email, nomEmpresa,desc, link);
				//Muestro mensaje de éxito
                JOptionPane.showMessageDialog(this, "El Usuario se ha creado con éxito", "Registrar Usuario",
                        JOptionPane.INFORMATION_MESSAGE);
    			// Limpio el internal frame antes de cerrar la ventana
                limpiarFormulario();
                setVisible(false);
			}
			catch(UsuarioRepetidoException err){
				// Muestro error de registro
                JOptionPane.showMessageDialog(this, err.getMessage(), "Registrar Usuario", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	public Boolean esValido() {
		String nick = this.nicknameField.getText();
		String nombre = this.nombreField.getText();
		String apellido = this.apellidoField.getText();
		String email = this.correoField.getText();
		String nomEmpresa = this.nombreEmpresaField.getText();
		String desc = this.descripcionField.getText();
		String link = this.linkWebField.getText();
		if (nick.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || email.isEmpty() || nomEmpresa.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Registrar Usuario",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        } else return true;
	}
	
	private void limpiarFormulario() {
		nicknameField.setText("");
		nombreField.setText("");
		apellidoField.setText("");
		correoField.setText("");
		nombreEmpresaField.setText("");
		descripcionField.setText("");
		linkWebField.setText("");
	   }
}


