package Presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import java.awt.Panel;
import javax.swing.JToolBar;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JSeparator;
import javax.swing.JEditorPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import utilsPresentacion.CentrarColumnas;

import java.awt.ScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.JScrollBar;

public class consultaUsuario extends JInternalFrame {
	private JTable tablaUsuario;
	private JTable tablaPostulante;
	private JTable tablaEmpresa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					consultaUsuario frame = new consultaUsuario();
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
	public consultaUsuario() {
		setResizable(true);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Consulta de Usuario");
		setBounds(100, 100, 1065, 784);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Seleccione un usuario:");
		lblNewLabel.setBounds(20, 11, 931, 14);
		getContentPane().add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(20, 36, 544, 22);
		getContentPane().add(comboBox);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(20, 67, 1019, 14);
		getContentPane().add(separator);
		
		Panel panelUsuario = new Panel();
		panelUsuario.setBounds(20, 83, 585, 70);
		getContentPane().add(panelUsuario);
		
		tablaUsuario = new JTable();
		tablaUsuario.setFillsViewportHeight(true);

		tablaUsuario.setModel(new DefaultTableModel(
			new Object[][] {
				{"Juan52", "Juan", "Rodríguez", "jr@fing.edu.uy"},
			},
			new String[] {
				"Nickname", "Nombre", "Apellido", "Correo"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tablaUsuario.setDefaultRenderer(Object.class, new CentrarColumnas());
		JTableHeader headerUsuario = tablaUsuario.getTableHeader();
		tablaUsuario.getColumnModel().getColumn(0).setPreferredWidth(110);
		tablaUsuario.getColumnModel().getColumn(1).setPreferredWidth(114);
		tablaUsuario.getColumnModel().getColumn(2).setPreferredWidth(109);
		tablaUsuario.getColumnModel().getColumn(3).setPreferredWidth(251);
		panelUsuario.add(headerUsuario);
		panelUsuario.add(tablaUsuario);
		
		Panel panelPostulante = new Panel();
		panelPostulante.setBounds(20, 157, 370, 70);
		getContentPane().add(panelPostulante);
		
		tablaPostulante = new JTable();
		tablaPostulante.setModel(new DefaultTableModel(
			new Object[][] {
				{"Postulante", "25/03/1991", "Uruguayo"},
			},
			new String[] {
				"Tipo de Usuario", "Fecha de Nacimiento", "Nacionalidad"
			}
		));
		tablaPostulante.setDefaultRenderer(Object.class, new CentrarColumnas());
		JTableHeader headerPostulante = tablaPostulante.getTableHeader();
		tablaPostulante.getColumnModel().getColumn(0).setPreferredWidth(109);
		tablaPostulante.getColumnModel().getColumn(1).setPreferredWidth(127);
		tablaPostulante.getColumnModel().getColumn(2).setPreferredWidth(124);
		panelPostulante.add(headerPostulante);
		panelPostulante.add(tablaPostulante);
		
		Panel panelEmpresa = new Panel();
		panelEmpresa.setBounds(20, 233, 585, 59);
		getContentPane().add(panelEmpresa);
		
		tablaEmpresa = new JTable();
		tablaEmpresa.setModel(new DefaultTableModel(
			new Object[][] {
				{"Empresa", "Empresa", "Empresa"},
			},
			new String[] {
				"Nombre de Empresa", "Descripci\u00F3n", "Link Web"
			}
		));
		tablaEmpresa.setDefaultRenderer(Object.class, new CentrarColumnas());
		JTableHeader headerEmpresa = tablaEmpresa.getTableHeader();
		tablaEmpresa.getColumnModel().getColumn(0).setPreferredWidth(143);
		tablaEmpresa.getColumnModel().getColumn(1).setPreferredWidth(240);
		tablaEmpresa.getColumnModel().getColumn(2).setPreferredWidth(191);
		panelEmpresa.add(headerEmpresa);
		panelEmpresa.add(tablaEmpresa);

	}
}
