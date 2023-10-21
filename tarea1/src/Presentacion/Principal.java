package Presentacion;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JInternalFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import excepciones.CorreoRepetidoException;
import excepciones.KeywordExisteException;
import excepciones.NicknameNoExisteException;
import excepciones.NombreExisteException;
import excepciones.OfertaNoExisteException;
import excepciones.PaqueteExisteException;
import excepciones.TipoPublicExisteException;
import excepciones.UsuarioNoEsPostulanteException;
import excepciones.UsuarioRepetidoException;

//para carga de datos
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import logica.Fabrica;
import logica.IControladorOfertas;
import logica.IControladorPublicaciones;
import logica.IControladorUsuario;

public class Principal {
	
	//Interfaces
	private IControladorUsuario ICU;
	private IControladorOfertas ICO;
	private IControladorPublicaciones ICP;
	
	//Componentes Swing
	
	private JFrame frame;
	private altaPostulante altaPostulanteInternalFrame;
	private altaEmpresa altaEmpresaInternalFrame;
	private consultaUsuario consultaUsuarioInternalFrame;
	private altaOfertaLaboral altaOfertaLaboralInternalFrame;
	private consultaOfertaLaboral consultaOfertaLaboralInternalFrame;
	private altaTipoPublicacionOL altaTipoPublicacionOLInternalFrame;
	private postulacionOfertaLaboral postulacionOfertaLaboralInternalFrame;
	private modificarDatosUsuario modificarDatosUsuarioInternalFrame;
	private crearPaqueteTipo crearPaqueteTipoInternalFrame;
	private consultaPaquete consultaPaqueteInternalFrame;
	private agregarTipoPubAPaquete agregarTipoAPaqueteInternalFrame;
	private AceptarRechazarOfertaLaboral aceptarRechazarInternalFrame;
	private JInternalFrame currentInternalFrame = null;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws PropertyVetoException 
	 */
	public Principal() throws PropertyVetoException {
		initialize();
		//Inicializacion fabrica y controladores
		Fabrica fabrica = Fabrica.getInstance();
		ICU = fabrica.getIControladorUsuario();
		ICP = fabrica.getIControladorPublicaciones();	
		ICO = fabrica.getIControladorOfertas();		
		
		altaPostulanteInternalFrame = new altaPostulante(ICU);
		altaPostulanteInternalFrame.setResizable(false);
		altaPostulanteInternalFrame.setBorder(null);
		altaPostulanteInternalFrame.setVisible(false);
		
		altaEmpresaInternalFrame = new altaEmpresa(ICU);
		altaEmpresaInternalFrame.setResizable(false);
		altaEmpresaInternalFrame.setBorder(null);
		altaEmpresaInternalFrame.setVisible(false);
		
		
		consultaUsuarioInternalFrame = new consultaUsuario(ICU,ICO);
		consultaUsuarioInternalFrame.setResizable(false);
		consultaUsuarioInternalFrame.setBorder(null);
		consultaUsuarioInternalFrame.setVisible(false);
		
		altaOfertaLaboralInternalFrame = new altaOfertaLaboral(ICU, ICP, ICO);
		altaOfertaLaboralInternalFrame.setResizable(false);
		altaOfertaLaboralInternalFrame.setBorder(null);
		altaOfertaLaboralInternalFrame.setVisible(false);
		
		consultaOfertaLaboralInternalFrame = new consultaOfertaLaboral(ICU, ICO);
		consultaOfertaLaboralInternalFrame.setResizable(false);
		consultaOfertaLaboralInternalFrame.setBorder(null);
		consultaOfertaLaboralInternalFrame.setVisible(false);
		
		
		altaTipoPublicacionOLInternalFrame = new altaTipoPublicacionOL(ICP);
		altaTipoPublicacionOLInternalFrame.setResizable(false);
		altaTipoPublicacionOLInternalFrame.setBorder(null);
		altaTipoPublicacionOLInternalFrame.setVisible(false);
		
		postulacionOfertaLaboralInternalFrame = new postulacionOfertaLaboral(ICO, ICU);
		postulacionOfertaLaboralInternalFrame.setResizable(false);
		postulacionOfertaLaboralInternalFrame.setBorder(null);
		postulacionOfertaLaboralInternalFrame.setVisible(false);
		
		crearPaqueteTipoInternalFrame = new crearPaqueteTipo(ICP);
		crearPaqueteTipoInternalFrame.setResizable(false);
		crearPaqueteTipoInternalFrame.setBorder(null);
		crearPaqueteTipoInternalFrame.setVisible(false);
		
		consultaPaqueteInternalFrame = new consultaPaquete(ICP);
		consultaPaqueteInternalFrame.setResizable(false);
		consultaPaqueteInternalFrame.setBorder(null);
		consultaPaqueteInternalFrame.setVisible(false);
		
		agregarTipoAPaqueteInternalFrame = new agregarTipoPubAPaquete(ICP);
		agregarTipoAPaqueteInternalFrame.setResizable(false);
		agregarTipoAPaqueteInternalFrame.setBorder(null);
		agregarTipoAPaqueteInternalFrame.setVisible(false);
		
		aceptarRechazarInternalFrame = new AceptarRechazarOfertaLaboral(ICU,ICO);
		aceptarRechazarInternalFrame.setResizable(false);
		aceptarRechazarInternalFrame.setBorder(null);
		aceptarRechazarInternalFrame.setVisible(false);
		

		frame.getContentPane().add(altaPostulanteInternalFrame);
		frame.getContentPane().add(altaEmpresaInternalFrame);
		frame.getContentPane().add(consultaUsuarioInternalFrame);
		frame.getContentPane().add(altaOfertaLaboralInternalFrame);
		frame.getContentPane().add(consultaOfertaLaboralInternalFrame);
		frame.getContentPane().add(altaTipoPublicacionOLInternalFrame);
		frame.getContentPane().add(postulacionOfertaLaboralInternalFrame);
		frame.getContentPane().add(crearPaqueteTipoInternalFrame);
		frame.getContentPane().add(consultaPaqueteInternalFrame);
		frame.getContentPane().add(agregarTipoAPaqueteInternalFrame);
		frame.getContentPane().add(aceptarRechazarInternalFrame);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1081, 687);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu menuPrincipal = new JMenu("Menú Principal");
		menuBar.add(menuPrincipal);
		
		JMenu menuUsuarios = new JMenu("Usuarios");
		menuBar.add(menuUsuarios);
		
		JMenu menuOfertasLaborales = new JMenu("Ofertas Laborales");
		menuBar.add(menuOfertasLaborales);
		
		JMenuItem mItemAltaPostulante = new JMenuItem("Alta de Postulante");
		mItemAltaPostulante.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 if (currentInternalFrame != null) {
			            currentInternalFrame.setVisible(false);
			        }

	                altaPostulanteInternalFrame.setVisible(true);
	                currentInternalFrame = altaPostulanteInternalFrame;
	            }
		});

		
		JMenuItem mItemAltaEmpresa = new JMenuItem("Alta de Empresa");
		mItemAltaEmpresa.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 if (currentInternalFrame != null) {
			            currentInternalFrame.setVisible(false);
			        }
	                altaEmpresaInternalFrame.setVisible(true);
	                currentInternalFrame = altaEmpresaInternalFrame;
	            }
		});
			
		menuUsuarios.add(mItemAltaPostulante);
		menuUsuarios.add(mItemAltaEmpresa);
		
		
		JMenuItem mItemConsultaUsuario = new JMenuItem("Consulta de Usuario");
		mItemConsultaUsuario.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 if (currentInternalFrame != null) {
			            currentInternalFrame.setVisible(false);
			        }
				 	consultaUsuarioInternalFrame.llenar_comboListaUsuario();
	                consultaUsuarioInternalFrame.setVisible(true);
	                currentInternalFrame = consultaUsuarioInternalFrame;
	            }
		});
		menuUsuarios.add(mItemConsultaUsuario);
		
		JMenuItem mItemModificarDatosUsuario = new JMenuItem("Modificar datos de Usuario");
		
		mItemModificarDatosUsuario.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if (currentInternalFrame != null) {
		            currentInternalFrame.setVisible(false);
		        }
		        try {
					modificarDatosUsuarioInternalFrame = new modificarDatosUsuario(ICU);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			    modificarDatosUsuarioInternalFrame.setResizable(false);
			    modificarDatosUsuarioInternalFrame.setBorder(null);
			    frame.getContentPane().add(modificarDatosUsuarioInternalFrame);
		        modificarDatosUsuarioInternalFrame.setVisible(true);
		        currentInternalFrame = modificarDatosUsuarioInternalFrame;
		    }
		});
		menuUsuarios.add(mItemModificarDatosUsuario);

		JMenuItem mItemOfertaLaboral = new JMenuItem("Alta de Oferta Laboral");
		mItemOfertaLaboral.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 altaOfertaLaboralInternalFrame.cargarUsuarios();
				 altaOfertaLaboralInternalFrame.cargarTipos();
				 altaOfertaLaboralInternalFrame.cargarKeywords();
				 if (currentInternalFrame != null) {
			            currentInternalFrame.setVisible(false);
			        }
				 altaOfertaLaboralInternalFrame.setVisible(true);
				 currentInternalFrame = altaOfertaLaboralInternalFrame;
	            }
		});	
		menuOfertasLaborales.add(mItemOfertaLaboral);
		
		
		
		JMenuItem mItemConsultaOfertaLaboral = new JMenuItem("Consulta de Oferta Laboral");
		mItemConsultaOfertaLaboral.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 if (currentInternalFrame != null) {
			            currentInternalFrame.setVisible(false);
				 }
				 consultaOfertaLaboralInternalFrame.llenar_comboListaEmpresa();
				 consultaOfertaLaboralInternalFrame.setVisible(true);
				 currentInternalFrame = consultaOfertaLaboralInternalFrame;
	            }
		});	
		menuOfertasLaborales.add(mItemConsultaOfertaLaboral);
		
		JMenuItem mItemPostulacionOfertaLaboral = new JMenuItem("Postulación a Oferta Laboral");
		mItemPostulacionOfertaLaboral.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 if (currentInternalFrame != null) {
			            currentInternalFrame.setVisible(false);
				 }
				 postulacionOfertaLaboralInternalFrame.comboMostrarEmpresas();
				 postulacionOfertaLaboralInternalFrame.setVisible(true);
				 currentInternalFrame = postulacionOfertaLaboralInternalFrame;
	            }
		});	
		menuOfertasLaborales.add(mItemPostulacionOfertaLaboral);
		
		JMenuItem mItemAltaTipoPublicacion = new JMenuItem("Alta de Tipo de Publicación de Oferta Laboral");
		mItemAltaTipoPublicacion.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 if (currentInternalFrame != null) {
			            currentInternalFrame.setVisible(false);
				 }
				 altaTipoPublicacionOLInternalFrame.setVisible(true);
				 currentInternalFrame = altaTipoPublicacionOLInternalFrame;
	            }
		});	
		menuOfertasLaborales.add(mItemAltaTipoPublicacion);
		
		JMenuItem mItemCrearPaquetes = new JMenuItem("Crear Paquete de Tipos de Publicación");
		menuOfertasLaborales.add(mItemCrearPaquetes);
		mItemCrearPaquetes.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 if (currentInternalFrame != null) {
			            currentInternalFrame.setVisible(false);
				 }
				 crearPaqueteTipoInternalFrame.setVisible(true);
				 currentInternalFrame = crearPaqueteTipoInternalFrame;
	            }
		});	
		
		
		
		JMenuItem mItemAgregarTipoAPaquete = new JMenuItem("Agregar Tipo de Publicación a Paquete");
		menuOfertasLaborales.add(mItemAgregarTipoAPaquete);
		mItemAgregarTipoAPaquete.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 if (currentInternalFrame != null) {
			            currentInternalFrame.setVisible(false);
				 }
				 agregarTipoAPaqueteInternalFrame.llenar_listaTipos();
				 agregarTipoAPaqueteInternalFrame.llenar_listaPaquetes();
				 agregarTipoAPaqueteInternalFrame.setVisible(true);
				 currentInternalFrame = agregarTipoAPaqueteInternalFrame;
	            }
		});
		
		
		JMenuItem mItemConsultaPaquete = new JMenuItem("Consulta de Paquete de Tipos de Publicación");
		menuOfertasLaborales.add(mItemConsultaPaquete);
		
		mItemConsultaPaquete.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 if (currentInternalFrame != null) {
			            currentInternalFrame.setVisible(false);
				 }
				 consultaPaqueteInternalFrame.llenar_listaPaquetes();
				 consultaPaqueteInternalFrame.setVisible(true);
				 currentInternalFrame = consultaPaqueteInternalFrame;
	            }
		});	
		
		JMenuItem mItemAceptar = new JMenuItem("Aceptar/Rechazar Oferta Laboral");
		menuOfertasLaborales.add(mItemAceptar);
		mItemAceptar.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 if (currentInternalFrame != null) {
			            currentInternalFrame.setVisible(false);
				 }
				 aceptarRechazarInternalFrame.llenar_comboListaEmpresa();
				 aceptarRechazarInternalFrame.setVisible(true);
				 currentInternalFrame = aceptarRechazarInternalFrame;
	            }
		});	
		

		JMenuItem mntmNewMenuItem = new JMenuItem("Cargar Datos");
		mntmNewMenuItem.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	try {
		    		String currentDirectory = System.getProperty("user.dir");
		    		
		            String csvFilePostulantes = currentDirectory + File.separator + "Datos" + File.separator + "Postulantes.csv";
					cargarDatosPostulantes(csvFilePostulantes);
					
					
		            String csvFileEmpresas = currentDirectory + File.separator + "Datos" + File.separator + "Empresas.csv";
					cargarDatosEmpresas(csvFileEmpresas);
					
					String csvFileTiposPublicacion = currentDirectory + File.separator + "Datos" + File.separator + "TiposPublicacion.csv";
					cargarDatosTipoPublicacion(csvFileTiposPublicacion);
					
					String csvFileKeywords = currentDirectory + File.separator + "Datos" + File.separator + "Keywords.csv";
					cargarDatosKeywords(csvFileKeywords);
					
					String csvFileOfertaLaboral = currentDirectory + File.separator + "Datos" + File.separator + "OfertasLaborales.csv";
					cargarDatosOfertasLaborales(csvFileOfertaLaboral);
					
					String csvFilePostulaciones = currentDirectory + File.separator + "Datos" + File.separator + "Postulaciones.csv";
					cargarDatosPostulaciones(csvFilePostulaciones);
					
					String csvFilePaquetes = currentDirectory + File.separator + "Datos" + File.separator + "Paquetes.csv";
					cargarDatosPaquetes(csvFilePaquetes);
					String csvFileTiposPublicacionPaquetes = currentDirectory + File.separator + "Datos" + File.separator + "TiposPublicacionPaquetes.csv";
					cargarDatosTiposPublicacionPaquetes(csvFileTiposPublicacionPaquetes);
					
					
				} catch (UsuarioRepetidoException e1) {
					e1.printStackTrace();
				} catch (TipoPublicExisteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (KeywordExisteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NombreExisteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NicknameNoExisteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (UsuarioNoEsPostulanteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (OfertaNoExisteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (CorreoRepetidoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (PaqueteExisteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    }
		});
		menuPrincipal.add(mntmNewMenuItem);
		
		JMenuItem mItemSalir= new JMenuItem("Salir");
		mItemSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
		menuPrincipal.add(mItemSalir);
		
	}

		private void cargarDatosPostulantes(String csvFile) throws UsuarioRepetidoException, CorreoRepetidoException {	
		    String line = "";
		    String cvsSplitBy = ";";
		    try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
		        while ((line = br.readLine()) != null) {
		            String[] postulanteData = line.split(cvsSplitBy);
		            String nickname = "";
		            String nombre = "";
		            String apellido = "";
		            String correo = "";
		            Date fecha = null;
		            String nacionalidad = "";
		            if(postulanteData.length > 0) {
		            	 nickname = postulanteData[0];
		            	 nombre = postulanteData[1];
		            	 apellido = postulanteData[2];
		            	 correo = postulanteData[3];
		            	 fecha = parseDate(postulanteData[4].trim());
		            	 nacionalidad = postulanteData[5];
		            	 ICU.altaPostulante(nickname, nombre, apellido, correo, " " ,fecha, nacionalidad);
		            }
		            
		        }
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		   
		}

		private Date parseDate(String dateString) {
		    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		    try {
		        return formatter.parse(dateString);
		    } catch (ParseException e) {
		        e.printStackTrace();
		        return null;
		    }
		}
		
		private void cargarDatosEmpresas(String csvFile) throws UsuarioRepetidoException, CorreoRepetidoException {	
		    String line = "";
		    String cvsSplitBy = ";";
		    try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
		        while ((line = br.readLine()) != null) {
		            String[] empresaData = line.split(cvsSplitBy);
		            String nickname = "";
		            String nombre = "";
		            String apellido = "";
		            String correo = "";
		            String descripcion = "";
		            String link = "";
		            
		            if(empresaData.length > 0) {
		            	 nickname = empresaData[0];
		            	 nombre = empresaData[1];
		            	 apellido = empresaData[2];
		            	 correo = empresaData[3];
		            	 descripcion = empresaData[4];
				         link = empresaData[5]; 
		            	 ICU.altaEmpresa(nickname, nombre, apellido, correo, " ",nickname, descripcion, link);
		            }
		            
		        }
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		   
		}
		
		private void cargarDatosTipoPublicacion(String csvFile) throws TipoPublicExisteException{	
		    String line = "";
		    String cvsSplitBy = ";";
		    try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
		        while ((line = br.readLine()) != null) {
		            String[] tiposPublicaionData = line.split(cvsSplitBy);
		            String nombre = "";
		            String desc = "";
		            int exp = 0;
		            Integer duracion = 0;
		            Integer costo = 0;
		           LocalDate alta = null;
		            
		            if(tiposPublicaionData.length > 0) {
		            	 nombre = tiposPublicaionData[0];
		            	 desc = tiposPublicaionData[1];
		            	 exp = Integer.parseInt(tiposPublicaionData[2]) ;
		            	 duracion = Integer.parseInt(tiposPublicaionData[3]) ;
		            	 costo = Integer.parseInt(tiposPublicaionData[4]);
		            	 alta = parseToLocalDate(tiposPublicaionData[5].trim());
		            	 ICP.altaTipoPublicacionOL(nombre, desc, exp, duracion, costo, alta);
		            }
		            
		        }
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		   
		}
		
		private void cargarDatosKeywords(String csvFile) throws KeywordExisteException{	
		    String line = "";
		    String cvsSplitBy = ";";
		    try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
		        while ((line = br.readLine()) != null) {
		            String[] tiposPublicaionData = line.split(cvsSplitBy);
		            String nombre = "";         
		            if(tiposPublicaionData.length > 0) {
		            	 nombre = tiposPublicaionData[0];
		            	 ICO.altaKeyword(nombre);
		            }      
		        }
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		   
		}
		
		private void cargarDatosOfertasLaborales(String csvFile) throws NombreExisteException, KeywordExisteException, NicknameNoExisteException{	
		    String line = "";
		    String cvsSplitBy = ";";
		    try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
		        while ((line = br.readLine()) != null) {
		            String[] ofertasLaboralesData = line.split(cvsSplitBy);
		            String nombre = "";    
		            String desc = ""; 
		            String rem = ""; 
		            String horario = ""; 
		            List<String> keys = new ArrayList<>();
		            String ciudad = ""; 
		            String depa = ""; 
		            String tipo = "";
		            String empresa = ""; 
		            
		            
		            if(ofertasLaboralesData.length > 0) {
		            	
		            	 nombre = ofertasLaboralesData[0];
		            	 desc = ofertasLaboralesData[1];
		            	 rem = ofertasLaboralesData[5];
		            	 horario = ofertasLaboralesData[4];
		            	 ciudad = ofertasLaboralesData[3];
		            	 depa = ofertasLaboralesData[2];
		            	 tipo = ofertasLaboralesData[7];
		            	 empresa = ofertasLaboralesData[6];
		            	 if(ofertasLaboralesData.length > 9) {
			            	 keys = Arrays.asList(ofertasLaboralesData[9].split("/"));
		            	 }
		            	 ICO.altaOferta(nombre, desc, rem, horario, keys, ciudad, depa, tipo, empresa);
		            }      
		        }
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		   
		}
		
		private void cargarDatosPostulaciones(String csvFile) throws NicknameNoExisteException, UsuarioNoEsPostulanteException, OfertaNoExisteException{	
		    String line = "";
		    String cvsSplitBy = ";";
		    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		    try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
		        while ((line = br.readLine()) != null) {
		            String[] postulacionesData = line.split(cvsSplitBy);
		            String nicknamePost = "";    
		            String nombreOL = ""; 
		            String cv = ""; 
		            String motivacion = ""; 
		            LocalDate fechaPostulacion = null; 
		            
		            if(postulacionesData.length > 0) {
		            	nicknamePost = postulacionesData[0];
		            	cv = postulacionesData[1];
		            	nombreOL = postulacionesData[4];
		            	motivacion = postulacionesData[2];
		            	String fechaStr = postulacionesData[3];
		            	fechaPostulacion = LocalDate.parse(fechaStr, formatter);
		            	LocalDateTime fechaConTiempo = fechaPostulacion.atTime(00, 00, 0, 0);
		            	ICO.postularAOferta(nombreOL, nicknamePost, cv, motivacion, fechaConTiempo);
		            }      
		        }
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		   
		}
		
		private void cargarDatosPaquetes(String csvFile) throws KeywordExisteException, PaqueteExisteException{	
		    String line = "";
		    String cvsSplitBy = ";";
		    try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
		        while ((line = br.readLine()) != null) {
		            String[] paquetesData = line.split(cvsSplitBy);
		            String nombreTipo = "";
		            String descripcionTipo = "";
		            int validez = 0;
		            int descuento = 0;
		            String fechaAlta = "00/00/0000";
		            if(paquetesData.length > 0) {
		            	nombreTipo = paquetesData[0];
		            	descripcionTipo = paquetesData[1];
		            	validez = Integer.parseInt(paquetesData[2]);
		            	descuento = Integer.parseInt(paquetesData[3]);
		            	fechaAlta = paquetesData[4];
		            	ICP.altaPaqueteTipoPublicacion(nombreTipo, descripcionTipo, validez, descuento,fechaAlta);
		            }      
		        }
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		   
		}
		
		private void cargarDatosTiposPublicacionPaquetes(String csvFile){	
		    String line = "";
		    String cvsSplitBy = ";";
		    try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
		        while ((line = br.readLine()) != null) {
		            String[] tiposPublicaionPaquetesData = line.split(cvsSplitBy);
		            String nombrePaquete = "";
		            Integer cantidad = 0;
		            String nombreTipoPublicacion = "";
		            if(tiposPublicaionPaquetesData.length > 0) {
		            	nombrePaquete = tiposPublicaionPaquetesData[0];
		            	cantidad = Integer.parseInt(tiposPublicaionPaquetesData[2]);
		            	nombreTipoPublicacion = tiposPublicaionPaquetesData[1];
		            	 ICP.agregarTipoPublicacion(nombrePaquete,cantidad,nombreTipoPublicacion);
		            }
		            
		        }
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		   
		}
		
		

		private LocalDate parseToLocalDate(String dateString) {
		    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		    try {
		        return LocalDate.parse(dateString, formatter);
		    } catch (DateTimeParseException e) {
		        e.printStackTrace();
		        return null;
		    }
		}
}