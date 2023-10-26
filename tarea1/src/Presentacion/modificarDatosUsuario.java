package Presentacion;

import javax.swing.*;
import excepciones.NicknameNoExisteException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import logica.IControladorUsuario;
import utils.DTEmpresa;
import utils.DTPostulante;
import utils.DTUsuario;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class modificarDatosUsuario extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private IControladorUsuario controladorUser;
	private JTextField textFieldNombreEmpresa;
	private JTextField textFieldLinkWeb;
	private JTextField textFieldFechaNacimiento;
	private JComboBox<String> nacionalidadDropdown;
	
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
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getContentPane().removeAll();
      
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
         textDescripcion.setLineWrap(true);
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
         
     	
     	JLabel lblNacionalidad = new JLabel("Nacionalidad:");
        lblNacionalidad.setBounds(319, 170, 190, 13);
        
        String currentDirectory = System.getProperty("user.dir");
		
        String csvNacionalidades = currentDirectory + File.separator + "Datos" + File.separator + "Nacionalidades.csv";
		
		String[] nacionalidades = cargarNacionalidadesDesdeCSV(csvNacionalidades);
		
		nacionalidadDropdown = new JComboBox<>(nacionalidades);
		nacionalidadDropdown.setBounds(319, 194, 176, 20);    
    
        // Poblar JComboBox con usuarios
        List<DTUsuario> usuarios = controladorUser.listarUsuarios();
        for (DTUsuario user : usuarios) {
            listaUsuarios.addItem(user.getNickname()+"("+user.getNombre()+" "+user.getApellido()+")");
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
             	getContentPane().remove(nacionalidadDropdown);
             	getContentPane().revalidate();
             	getContentPane().repaint(); 
         
                String nicknameSeleccionado = (String) listaUsuarios.getSelectedItem();
                DTUsuario usuario = null;
   
				try {
					String textoNick = nicknameSeleccionado;
			        int posicion = textoNick.indexOf("(");
			        String resultado = nicknameSeleccionado; 
			        if (posicion != -1) { 
			            resultado = textoNick.substring(0, posicion).trim(); 
			            
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
			            LocalDate fecha = postulante.getFechaNacimiento();
			            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			            String fechaFormateada = formato.format(fecha);
			            textFieldFechaNacimiento.setText(fechaFormateada);
			            getContentPane().add(textFieldFechaNacimiento);
			            getContentPane().add(lblNacionalidad);
			            getContentPane().add(nacionalidadDropdown);
			            for (int i = 0; i < nacionalidades.length; i++) {
			                if (nacionalidades[i].equals(postulante.getNacionalidad())) {
				                nacionalidadDropdown.setSelectedIndex(i);
			                    break;
			                }
			        }
			       }
 
					campoNombre.setText(usuario.getNombre());
	                campoApellido.setText(usuario.getApellido());
				} catch (NicknameNoExisteException e1) {
					e1.printStackTrace();
				}
            }
        });

        botonActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nicknameSeleccionado = (String) listaUsuarios.getSelectedItem();
                String textoNick = nicknameSeleccionado;
		        int posicion = textoNick.indexOf("(");
		        String nickFiltrado = nicknameSeleccionado;
		        if (posicion != -1) { 
		        	nickFiltrado = textoNick.substring(0, posicion).trim();    
		        } 
		        DTUsuario usuario = null;
                try {
					usuario = controladorUser.consultarUsuario(nickFiltrado);
				} catch (NicknameNoExisteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                String nuevoNombre = campoNombre.getText();
                String nuevoApellido = campoApellido.getText();
                
                if(usuario instanceof DTEmpresa) {
	                	String nombreEmpresa = textFieldNombreEmpresa.getText();
	                	String descripcionEmpresa = textDescripcion.getText();
	                	String linkWebEmpresa = textFieldLinkWeb.getText();
	                	if(((nuevoNombre.isEmpty()) || ( nuevoApellido.isEmpty()) || ( nombreEmpresa.isEmpty()) ||( descripcionEmpresa.isEmpty()) || ( linkWebEmpresa.isEmpty()))) {
	                		JOptionPane.showMessageDialog(null, "Datos ingresados Invalidos!");
	                	}else {
	                		controladorUser.actualizarDatosEmpresa(nickFiltrado,nuevoNombre,nuevoApellido,nombreEmpresa,descripcionEmpresa,linkWebEmpresa);
	                		JOptionPane.showMessageDialog(null, "Usuario actualizado con éxito");	
	                	}
                	}else {
	                	String fechaNacimiento = textFieldFechaNacimiento.getText();
	                	
	                	
	                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	                    formato.setLenient(false);  // Hacer que el formato sea estricto

	                    try {
	                        formato.parse(fechaNacimiento);
	                        Date fecha = formato.parse(fechaNacimiento);
	                        Calendar calendario = Calendar.getInstance();
	                        calendario.setTime(fecha);
	                        int anio = calendario.get(Calendar.YEAR);
	                        if (anio >= 1500 && anio <= 4000) {
	                            
	                            String nacionalidad = (String) nacionalidadDropdown.getSelectedItem();
			                	if(((nuevoNombre.isEmpty()) ||( nuevoApellido.isEmpty()) || ( fechaNacimiento.isEmpty()) ||( nacionalidad.isEmpty()))) {
			                		JOptionPane.showMessageDialog(null, "Datos ingresados Invalidos!");
			                	}else {
			                		controladorUser.actualizarDatosPostulante(nickFiltrado,nuevoNombre,nuevoApellido,fechaNacimiento,nacionalidad);
			                		JOptionPane.showMessageDialog(null, "Usuario actualizado con éxito");
			                		
			                	}	
	                        } else {
	                        	JOptionPane.showMessageDialog(null, "La fecha es válida pero el año está fuera del rango permitido.");
	                           
	                        }

	                    } catch (ParseException e1) {
	                    	JOptionPane.showMessageDialog(null, "Fecha Invalida!");
	                    }
	                	
	                	
	                	
                	}
               
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
    private String[] cargarNacionalidadesDesdeCSV(String rutaArchivo) {
	    List<String> nacionalidades = new ArrayList<>();
	    try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
	        String linea;
	        while ((linea = br.readLine()) != null) {
	            nacionalidades.add(linea);
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return nacionalidades.toArray(new String[0]);
	}
}
