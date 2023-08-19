package Presentacion;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JInternalFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

public class Principal {

	private JFrame frame;
	private altaUsuario altaUsrInternalFrame;

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
	 */
	public Principal() {
		initialize();
		altaUsrInternalFrame = new altaUsuario();
		altaUsrInternalFrame.setResizable(true);
		altaUsrInternalFrame.setBorder(null);
		altaUsrInternalFrame.setVisible(false);
		frame.getContentPane().add(altaUsrInternalFrame);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Menú");
		menuBar.add(mnNewMenu);
		
		JMenuItem menuItemAltaUsuario = new JMenuItem("Alta de Usuario");
		menuItemAltaUsuario.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
	                // Muestro el InternalFrame para ver información de un usuario
	                altaUsrInternalFrame.setVisible(true);
	            }
		});
		mnNewMenu.add(menuItemAltaUsuario);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Consulta de Usuario");
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Alta de Oferta Laboral");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Consulta de Oferta Laboral");
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Alta de Tipo de Publicación de Oferta Laboral");
		mnNewMenu.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Postulación a Oferta Laboral");
		mnNewMenu.add(mntmNewMenuItem_5);
	}

}
