package Presentacion;

import javax.swing.*;
import excepciones.NicknameNoExisteException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.beans.PropertyVetoException;
import java.util.List;
import logica.IControladorUsuario;
import utils.DTEmpresa;
import utils.DTPostulante;
import utils.DTUsuario;

public class modificarDatosUsuario extends JInternalFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IControladorUsuario controladorUser;
	private JTextField textFieldNombreEmpresa;
	private JTextField textFieldLinkWeb;
	private JTextField textFieldFechaNacimiento;
	private JTextField textFieldNacionalidad;
	
    public modificarDatosUsuario(IControladorUsuario iCU) throws PropertyVetoException {
        controladorUser = iCU;
        initUI();
    }
    
    private void initUI() throws PropertyVetoException {
        setTitle("Modificar Datos de Usuario");
        setSize(400, 300);
        setMaximum(true);
		setMaximizable(true);
		setResizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 1074, 633);
		
        // Establecer la nueva ubicación
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getContentPane().removeAll();
        // Crear componentes de la UI
        JComboBox<String> listaUsuarios = new JComboBox<>();
        listaUsuarios.setBounds(37, 43, 299, 33);
        JTextField campoNombre = new JTextField();
        campoNombre.setBounds(37, 141, 202, 19);
        JTextField campoApellido = new JTextField();
        campoApellido.setBounds(37, 193, 202, 19);
        JButton botonActualizar = new JButton("Actualizar");
        botonActualizar.setBounds(37, 248, 97, 33);
        
        
        JLabel lblNombreEmpresa = new JLabel("Nombre Empresa:");
    	lblNombreEmpresa.setBounds(317, 118, 116, 13);
        
    	 textFieldNombreEmpresa = new JTextField();
         textFieldNombreEmpresa.setBounds(317, 141, 202, 19);
         textFieldNombreEmpresa.setColumns(10);
         
         JLabel lblDescripcion = new JLabel("Descripción:");
         lblDescripcion.setBounds(317, 170, 179, 13);
         
         JTextArea textDescripcion = new JTextArea();
         textDescripcion.setBounds(317, 190, 320, 96);
         textDescripcion.setLineWrap(true);  // Ajustar al final de la línea
         textDescripcion.setWrapStyleWord(true);
        
        
        
         JLabel lblLinkWeb = new JLabel("Link Web:");
         lblLinkWeb.setBounds(317, 314, 263, 13);
         
         textFieldLinkWeb = new JTextField();
         textFieldLinkWeb.setBounds(317, 350, 202, 19);
         textFieldLinkWeb.setColumns(10);
         
         JLabel lblFechaNacimiento = new JLabel("Fecha Nacimiento:");
     	lblFechaNacimiento.setBounds(319, 118, 167, 13);
     	
     	 textFieldFechaNacimiento = new JTextField();
         textFieldFechaNacimiento.setBounds(319, 141, 210, 19);
         textFieldFechaNacimiento.setColumns(10);
         
         JTextField campoFechaNacimiento = new JTextField();
     	campoFechaNacimiento.setBounds(66, 141, 202, 19);
     	
     	
     	JLabel lblNacionalidad = new JLabel("Nacionalidad:");
        lblNacionalidad.setBounds(319, 170, 190, 13);
        
        textFieldNacionalidad = new JTextField();
        textFieldNacionalidad.setBounds(319, 193, 210, 19);
        textFieldNacionalidad.setColumns(10);
         
        // Poblar JComboBox con usuarios
        List<DTUsuario> usuarios = controladorUser.listarUsuarios();
        for (DTUsuario user : usuarios) {
            listaUsuarios.addItem(user.getNickname()+"("+user.getNombre()+")");
        }
        listaUsuarios.revalidate();
        listaUsuarios.repaint();
        
        // Manejar selección de usuario
        listaUsuarios.addActionListener(new ActionListener() {
        	
            @Override
            public void actionPerformed(ActionEvent e) {
            	getContentPane().remove(lblNombreEmpresa);
             	getContentPane().remove(textFieldNombreEmpresa);
             	getContentPane().remove(lblDescripcion);

             	getContentPane().remove(textDescripcion);
             	getContentPane().remove(lblLinkWeb);
             	getContentPane().remove(textFieldLinkWeb);
             	getContentPane().remove(lblFechaNacimiento);
             	getContentPane().remove(textFieldFechaNacimiento);
             	getContentPane().remove(lblNacionalidad);
             	getContentPane().remove(textFieldNacionalidad);
             	getContentPane().revalidate(); // Para que se tengan en cuenta los cambios
             	getContentPane().repaint(); 
             	          	
                String nicknameSeleccionado = (String) listaUsuarios.getSelectedItem();
                DTUsuario usuario = null;
               
				try {
					String textoNick = nicknameSeleccionado;
			        int posicion = textoNick.indexOf("(");
			        String resultado = nicknameSeleccionado; 
			        if (posicion != -1) { // Verifica si el carácter "(" se encuentra en el string
			            resultado = textoNick.substring(0, posicion).trim(); // trim() elimina espacios en blanco al principio y al final
			            
			        } 
			        usuario = controladorUser.consultarUsuario(resultado);
			        campoNombre.setText(usuario.getNombre());
	                campoApellido.setText(usuario.getApellido());
	                
	                
	                
	                
			        if(usuario instanceof DTEmpresa) {
			        	DTEmpresa empresa = (DTEmpresa) usuario;

			            getContentPane().add(lblNombreEmpresa);

			            getContentPane().add(textFieldNombreEmpresa);
			            
			            textFieldNombreEmpresa.setText(empresa.getNombreEmpresa());
			           
			            
			            getContentPane().add(lblDescripcion);
			            
			            
			            getContentPane().add(textDescripcion);
			          
			   
			            textDescripcion.setText(empresa.getDescripcion());
			           
			         
			            
			            
			            
			            getContentPane().add(lblLinkWeb);
			            
			            
			            getContentPane().add(textFieldLinkWeb);
			           
			            textFieldLinkWeb.setText(empresa.getLinkWeb());
          
			       
			            
			        }else {
			        	DTPostulante postulante = (DTPostulante) usuario;

			            getContentPane().add(lblFechaNacimiento);
			            textFieldFechaNacimiento.setText(postulante.getFechaNacimiento().toString());
			            getContentPane().add(textFieldFechaNacimiento);
			              
			            
			            getContentPane().add(lblNacionalidad);
			            
			            textFieldNacionalidad.setText(postulante.getNacionalidad());
			            getContentPane().add(textFieldNacionalidad);
        
			        	
			        }
			        
			        
					campoNombre.setText(usuario.getNombre());
	                campoApellido.setText(usuario.getApellido());
				} catch (NicknameNoExisteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });

        // Manejar actualización de usuario
        botonActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
                String nicknameSeleccionado = (String) listaUsuarios.getSelectedItem();
                String textoNick = nicknameSeleccionado;
		        int posicion = textoNick.indexOf("(");
		        String resultado = nicknameSeleccionado;
		        if (posicion != -1) { // Verifica si el carácter "(" se encuentra en el string
		            resultado = textoNick.substring(0, posicion).trim(); // trim() elimina espacios en blanco al principio y al final
		           
		        } 
                String nuevoNombre = campoNombre.getText();
                String nuevoApellido = campoApellido.getText();
                
                controladorUser.actualizarDatosUsuario(resultado,nuevoNombre,nuevoApellido);
                
               JOptionPane.showMessageDialog(null, "Usuario actualizado con éxito");
            }
        });
        getContentPane().setLayout(null);
        getContentPane().add(listaUsuarios);
        JLabel label = new JLabel("Nombre:");
        label.setBounds(37, 118, 97, 13);
        getContentPane().add(label);
        getContentPane().add(campoNombre);
        JLabel label_1 = new JLabel("Apellido:");
        label_1.setBounds(37, 170, 97, 13);
        getContentPane().add(label_1);
        getContentPane().add(campoApellido);
        getContentPane().add(botonActualizar);
        
        JLabel lblNewLabel = new JLabel("Seleccione el Usuario a modificar:");
        lblNewLabel.setBounds(37, 20, 252, 13);
        getContentPane().add(lblNewLabel);
        
        JSeparator separator = new JSeparator();
        separator.setBounds(37, 96, 600, 2);
        getContentPane().add(separator);
        
        JButton buttonCancelar = new JButton("Cancelar");
        buttonCancelar.setBounds(158, 248, 97, 33);
        getContentPane().add(buttonCancelar);
        

        
        
        JSeparator separator_1 = new JSeparator();
        separator_1.setBounds(37, 461, 614, 2);
        getContentPane().add(separator_1);
        
        
        
        
        buttonCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	 dispose();
            }
        });
     
    }
}
