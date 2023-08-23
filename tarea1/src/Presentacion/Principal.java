package Presentacion;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JInternalFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.SwingConstants;

public class Principal {

	private JFrame frame;
	private altaPostulante altaPostulanteInternalFrame;
	private altaEmpresa altaEmpresaInternalFrame;
	private consultaUsuario consultaUsuarioInternalFrame;
	private altaOfertaLaboral altaOfertaLaboralInternalFrame;
	private consultaOfertaLaboral consultaOfertaLaboralInternalFrame;
	private altaTipoPublicacionOL altaTipoPublicacionOLInternalFrame;
	private postulacionOfertaLaboral postulacionOfertaLaboralInternalFrame;
	
	
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
		altaPostulanteInternalFrame = new altaPostulante();
		altaPostulanteInternalFrame.setResizable(false);
		altaPostulanteInternalFrame.setBorder(null);
		altaPostulanteInternalFrame.setVisible(false);
		
		altaEmpresaInternalFrame = new altaEmpresa();
		altaEmpresaInternalFrame.setResizable(false);
		altaEmpresaInternalFrame.setBorder(null);
		altaEmpresaInternalFrame.setVisible(false);
		
		
		consultaUsuarioInternalFrame = new consultaUsuario();
		consultaUsuarioInternalFrame.setResizable(false);
		consultaUsuarioInternalFrame.setBorder(null);
		consultaUsuarioInternalFrame.setVisible(false);
		
		altaOfertaLaboralInternalFrame = new altaOfertaLaboral();
		altaOfertaLaboralInternalFrame.setResizable(false);
		altaOfertaLaboralInternalFrame.setBorder(null);
		altaOfertaLaboralInternalFrame.setVisible(false);
		
		consultaOfertaLaboralInternalFrame = new consultaOfertaLaboral();
		consultaOfertaLaboralInternalFrame.setResizable(false);
		consultaOfertaLaboralInternalFrame.setBorder(null);
		consultaOfertaLaboralInternalFrame.setVisible(false);
		
		
		altaTipoPublicacionOLInternalFrame = new altaTipoPublicacionOL();
		altaTipoPublicacionOLInternalFrame.setResizable(false);
		altaTipoPublicacionOLInternalFrame.setBorder(null);
		altaTipoPublicacionOLInternalFrame.setVisible(false);
		
		postulacionOfertaLaboralInternalFrame = new postulacionOfertaLaboral();
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
		                altaPostulanteInternalFrame.setVisible(true);
		            }
			});

			
			JMenuItem mItemAltaEmpresa = new JMenuItem("Alta de Empresa");
			mItemAltaEmpresa.addActionListener(new ActionListener() {
				 public void actionPerformed(ActionEvent e) {
		                altaEmpresaInternalFrame.setVisible(true);
		            }
			});
			
		menuAltaUsuario.add(mItemAltaPostulante);
		menuAltaUsuario.add(mItemAltaEmpresa);
		
		
		JMenuItem mItemConsultaUsuario = new JMenuItem("Consulta de Usuario");
		mItemConsultaUsuario.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
	                consultaUsuarioInternalFrame.setVisible(true);
	            }
		});
		menuCasosDeUso.add(mItemConsultaUsuario);
		
		JMenuItem mItemOfertaLaboral = new JMenuItem("Alta de Oferta Laboral");
		mItemOfertaLaboral.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 altaOfertaLaboralInternalFrame.setVisible(true);
	            }
		});	
		menuCasosDeUso.add(mItemOfertaLaboral);
		
		JMenuItem mItemConsultaOfertaLaboral = new JMenuItem("Consulta de Oferta Laboral");
		mItemConsultaOfertaLaboral.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 consultaOfertaLaboralInternalFrame.setVisible(true);
	            }
		});	
		menuCasosDeUso.add(mItemConsultaOfertaLaboral);
		
		JMenuItem mItemAltaTipoPublicacion = new JMenuItem("Alta de Tipo de Publicación de Oferta Laboral");
		mItemAltaTipoPublicacion.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 altaTipoPublicacionOLInternalFrame.setVisible(true);
	            }
		});	
		menuCasosDeUso.add(mItemAltaTipoPublicacion);
		
		JMenuItem mItemPostulacionOfertaLaboral = new JMenuItem("Postulación a Oferta Laboral");
		mItemPostulacionOfertaLaboral.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 postulacionOfertaLaboralInternalFrame.setVisible(true);
	            }
		});	
		menuCasosDeUso.add(mItemPostulacionOfertaLaboral);
	}

}
