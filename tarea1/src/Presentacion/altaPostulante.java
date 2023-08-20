package Presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import java.awt.Panel;
import javax.swing.JToolBar;

public class altaPostulante extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					altaPostulante frame = new altaPostulante();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public altaPostulante() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Alta de Postulante");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

	}

}
