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
import javax.swing.table.DefaultTableModel;
import java.awt.ScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollBar;

public class consultaUsuario extends JInternalFrame {
	private JTable table;

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
		setBounds(100, 100, 840, 565);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Seleccione un Usuario:");
		lblNewLabel.setBounds(10, 11, 804, 14);
		getContentPane().add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 36, 427, 22);
		getContentPane().add(comboBox);
		
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setBounds(10, 69, 718, 294);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
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
		table.setBounds(350, 189, 1, 1);
		scrollPane.add(table);

	}
}
