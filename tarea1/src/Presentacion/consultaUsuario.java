package Presentacion;

import utils.DTUsuario;
import utilsPresentacion.*;

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

import logica.IControladorUsuario;
import utilsPresentacion.CentrarColumnas;

import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.JScrollBar;
import javax.swing.JButton;

public class consultaUsuario extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Controlador de usuarios que se utilizará para las acciones del JFrame
    private IControladorUsuario controlUsr;
    
    //Componentes Swing
	private JTable tablaUsuario;
	private JTable tablaPostulante;
	private JTable tablaEmpresa;
	private JComboBox<DTUsuario> listaUsuariosCombobox;
	/**
	 * Create the frame.
	 * @throws PropertyVetoException 
	 */
	public consultaUsuario(IControladorUsuario icu) throws PropertyVetoException {

		//Inicializacion internal frame con controlador de usuarios.
		controlUsr = icu;
		
		String nickname = "";
		String nombre = "";
		String apellido = "";
		String correo = "";
		
		
		setResizable(false);
		setMaximum(true);
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
		
		
		listaUsuariosCombobox = new JComboBox<DTUsuario>();
		listaUsuariosCombobox.setBounds(20, 36, 544, 22);
		getContentPane().add(listaUsuariosCombobox);
		
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
				{nickname, nombre, apellido, correo},
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
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tablaUsuario.getColumnModel().getColumn(0).setResizable(false);
		tablaUsuario.getColumnModel().getColumn(0).setPreferredWidth(110);
		tablaUsuario.getColumnModel().getColumn(1).setResizable(false);
		tablaUsuario.getColumnModel().getColumn(1).setPreferredWidth(114);
		tablaUsuario.getColumnModel().getColumn(2).setResizable(false);
		tablaUsuario.getColumnModel().getColumn(2).setPreferredWidth(109);
		tablaUsuario.getColumnModel().getColumn(3).setResizable(false);
		tablaUsuario.getColumnModel().getColumn(3).setPreferredWidth(251);
		tablaUsuario.setDefaultRenderer(Object.class, new CentrarColumnas());
		
		JTableHeader headerUsuario = tablaUsuario.getTableHeader();
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
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tablaPostulante.getColumnModel().getColumn(0).setResizable(false);
		tablaPostulante.getColumnModel().getColumn(0).setPreferredWidth(109);
		tablaPostulante.getColumnModel().getColumn(1).setResizable(false);
		tablaPostulante.getColumnModel().getColumn(1).setPreferredWidth(127);
		tablaPostulante.getColumnModel().getColumn(2).setResizable(false);
		tablaPostulante.getColumnModel().getColumn(2).setPreferredWidth(124);
		tablaPostulante.setDefaultRenderer(Object.class, new CentrarColumnas());
		JTableHeader headerPostulante = tablaPostulante.getTableHeader();
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
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tablaEmpresa.getColumnModel().getColumn(0).setResizable(false);
		tablaEmpresa.getColumnModel().getColumn(0).setPreferredWidth(143);
		tablaEmpresa.getColumnModel().getColumn(1).setResizable(false);
		tablaEmpresa.getColumnModel().getColumn(1).setPreferredWidth(240);
		tablaEmpresa.getColumnModel().getColumn(2).setResizable(false);
		tablaEmpresa.getColumnModel().getColumn(2).setPreferredWidth(191);
		tablaEmpresa.setDefaultRenderer(Object.class, new CentrarColumnas());
		JTableHeader headerEmpresa = tablaEmpresa.getTableHeader();
		panelEmpresa.add(headerEmpresa);
		panelEmpresa.add(tablaEmpresa);
		
		JButton buttonCancelar = new JButton("Cancelar");
		buttonCancelar.setBounds(574, 36, 89, 23);
		getContentPane().add(buttonCancelar);
		
		buttonCancelar.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 dispose();
	            }
		});
	}
	
	public void llenar_comboListaUsuario(){
		listaUsuariosCombobox.removeAllItems();
		List<DTUsuario> datos = new ArrayList<>();
		datos = controlUsr.listarUsuarios();
		for (DTUsuario u : datos) {
			listaUsuariosCombobox.addItem(u);
		}
	}
	
}
