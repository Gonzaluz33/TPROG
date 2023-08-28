package Presentacion;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.SwingConstants;

import excepciones.UsuarioRepetidoException;

//para carga de datos
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

	private IControladorPublicaciones ipu;
	private IControladorOfertas iol;
	
	private JFrame frame;
	private altaPostulante altaPostulanteInternalFrame;
	private altaEmpresa altaEmpresaInternalFrame;
	private consultaUsuario consultaUsuarioInternalFrame;
	private altaOfertaLaboral altaOfertaLaboralInternalFrame;
	private consultaOfertaLaboral consultaOfertaLaboralInternalFrame;
	private altaTipoPublicacionOL altaTipoPublicacionOLInternalFrame;
	private postulacionOfertaLaboral postulacionOfertaLaboralInternalFrame;
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
		
		
		consultaUsuarioInternalFrame = new consultaUsuario(ICU);
		consultaUsuarioInternalFrame.setResizable(false);
		consultaUsuarioInternalFrame.setBorder(null);
		consultaUsuarioInternalFrame.setVisible(false);
		
		altaOfertaLaboralInternalFrame = new altaOfertaLaboral(ICU, ICP, ICO);
		altaOfertaLaboralInternalFrame.setResizable(false);
		altaOfertaLaboralInternalFrame.setBorder(null);
		altaOfertaLaboralInternalFrame.setVisible(false);
		
		consultaOfertaLaboralInternalFrame = new consultaOfertaLaboral(ICU);
		consultaOfertaLaboralInternalFrame.setResizable(false);
		consultaOfertaLaboralInternalFrame.setBorder(null);
		consultaOfertaLaboralInternalFrame.setVisible(false);
		
		
		altaTipoPublicacionOLInternalFrame = new altaTipoPublicacionOL(ICP);
		altaTipoPublicacionOLInternalFrame.setResizable(false);
		altaTipoPublicacionOLInternalFrame.setBorder(null);
		altaTipoPublicacionOLInternalFrame.setVisible(false);
		
		postulacionOfertaLaboralInternalFrame = new postulacionOfertaLaboral(ICO);
		postulacionOfertaLaboralInternalFrame.setResizable(false);
		postulacionOfertaLaboralInternalFrame.setBorder(null);
		postulacionOfertaLaboralInternalFrame.setVisible(false);
		
		
		frame.getContentPane().add(altaPostulanteInternalFrame);
		frame.getContentPane().add(altaEmpresaInternalFrame);
		frame.getContentPane().add(consultaUsuarioInternalFrame);
		frame.getContentPane().add(altaOfertaLaboralInternalFrame);
		frame.getContentPane().add(consultaOfertaLaboralInternalFrame);
		frame.getContentPane().add(altaTipoPublicacionOLInternalFrame);
		frame.getContentPane().add(postulacionOfertaLaboralInternalFrame);
		
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
		
		JMenu menuCasosDeUso = new JMenu("Casos de Uso");
		menuBar.add(menuCasosDeUso);
		
		JMenu menuAltaUsuario = new JMenu("Alta de Usuario");
		menuCasosDeUso.add(menuAltaUsuario);
			JMenuItem mItemAltaPostulante = new JMenuItem("Alta de Postulante");
			mItemAltaPostulante.addActionListener(new ActionListener() {
				 public void actionPerformed(ActionEvent e) {
					 if (currentInternalFrame != null) {
				            currentInternalFrame.setVisible(false);
				        }

					 if (currentInternalFrame != null) {
				            currentInternalFrame.setVisible(false);
				        }

		                altaPostulanteInternalFrame.setVisible(true);
		                currentInternalFrame = altaPostulanteInternalFrame;
		                currentInternalFrame = altaPostulanteInternalFrame;
		            }
			});

			
			JMenuItem mItemAltaEmpresa = new JMenuItem("Alta de Empresa");
			mItemAltaEmpresa.addActionListener(new ActionListener() {
				 public void actionPerformed(ActionEvent e) {
					 if (currentInternalFrame != null) {
				            currentInternalFrame.setVisible(false);
				        }
					 if (currentInternalFrame != null) {
				            currentInternalFrame.setVisible(false);
				        }
		                altaEmpresaInternalFrame.setVisible(true);
		                currentInternalFrame = altaEmpresaInternalFrame;
		                currentInternalFrame = altaEmpresaInternalFrame;
		            }
			});
			
		menuAltaUsuario.add(mItemAltaPostulante);
		menuAltaUsuario.add(mItemAltaEmpresa);
		
		
		JMenuItem mItemConsultaUsuario = new JMenuItem("Consulta de Usuario");
		mItemConsultaUsuario.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 if (currentInternalFrame != null) {
			            currentInternalFrame.setVisible(false);
			        }
				 if (currentInternalFrame != null) {
			            currentInternalFrame.setVisible(false);
			        }
				 	consultaUsuarioInternalFrame.llenar_comboListaUsuario();
	                consultaUsuarioInternalFrame.setVisible(true);
	                currentInternalFrame = consultaUsuarioInternalFrame;
	            }
		});
		menuCasosDeUso.add(mItemConsultaUsuario);
		
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
				 currentInternalFrame = altaOfertaLaboralInternalFrame;
	            }
		});	
		menuCasosDeUso.add(mItemOfertaLaboral);
		
		JMenuItem mItemConsultaOfertaLaboral = new JMenuItem("Consulta de Oferta Laboral");
		mItemConsultaOfertaLaboral.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 if (currentInternalFrame != null) {
			            currentInternalFrame.setVisible(false);
				 }
				 if (currentInternalFrame != null) {
			            currentInternalFrame.setVisible(false);
				 }
				 consultaOfertaLaboralInternalFrame.llenar_comboListaEmpresa();
				 consultaOfertaLaboralInternalFrame.setVisible(true);
				 currentInternalFrame = consultaOfertaLaboralInternalFrame;
	            }
		});	
		menuCasosDeUso.add(mItemConsultaOfertaLaboral);
		
		JMenuItem mItemAltaTipoPublicacion = new JMenuItem("Alta de Tipo de Publicación de Oferta Laboral");
		mItemAltaTipoPublicacion.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 if (currentInternalFrame != null) {
			            currentInternalFrame.setVisible(false);
				 }
				 if (currentInternalFrame != null) {
			            currentInternalFrame.setVisible(false);
				 }
				 altaTipoPublicacionOLInternalFrame.setVisible(true);
				 currentInternalFrame = altaTipoPublicacionOLInternalFrame;
				 currentInternalFrame = altaTipoPublicacionOLInternalFrame;
	            }
		});	
		menuCasosDeUso.add(mItemAltaTipoPublicacion);
		
		JMenuItem mItemPostulacionOfertaLaboral = new JMenuItem("Postulación a Oferta Laboral");
		mItemPostulacionOfertaLaboral.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 if (currentInternalFrame != null) {
			            currentInternalFrame.setVisible(false);
				 }
				 postulacionOfertaLaboralInternalFrame.comboMostrarEmpresas();
				 postulacionOfertaLaboralInternalFrame.setVisible(true);
				 currentInternalFrame = postulacionOfertaLaboralInternalFrame;
				 currentInternalFrame = postulacionOfertaLaboralInternalFrame;
	            }
		});	
		menuCasosDeUso.add(mItemPostulacionOfertaLaboral);


		JMenuItem mntmNewMenuItem = new JMenuItem("Cargar Datos");
		mntmNewMenuItem.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	try {
		    		String currentDirectory = System.getProperty("user.dir");
		    		
		            String csvFilePostulantes = currentDirectory + File.separator + "Datos" + File.separator + "Postulantes.csv";
					cargarDatosPostulantes(csvFilePostulantes);
					
					
		            String csvFileEmpresas = currentDirectory + File.separator + "Datos" + File.separator + "Empresas.csv";
					cargarDatosEmpresas(csvFileEmpresas);
				} catch (UsuarioRepetidoException e1) {
					e1.printStackTrace();
				}
		    }
		});
		menuCasosDeUso.add(mntmNewMenuItem);
	}

		private void cargarDatosPostulantes(String csvFile) throws UsuarioRepetidoException {	
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
		            	 ICU.altaPostulante(nickname, nombre, apellido, correo, fecha, nacionalidad);
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
		
		private void cargarDatosEmpresas(String csvFile) throws UsuarioRepetidoException {	
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
		 
		            	 ICU.altaEmpresa(nickname, nombre, apellido, correo,nickname, descripcion, link);
		            }
		            
		        }
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		   
		}


}
