package Presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import java.awt.Panel;
import javax.swing.JToolBar;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import java.awt.ScrollPane;
import java.awt.Scrollbar;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import utilsPresentacion.CentrarColumnas;

public class consultaOfertaLaboral extends JInternalFrame {
	private JTable tablaOfertaLaboral;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					consultaOfertaLaboral frame = new consultaOfertaLaboral();
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
	public consultaOfertaLaboral() {
		setResizable(true);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Consulta de Oferta Laboral");
		setBounds(100, 100, 1027, 687);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Seleccione una empresa:");
		lblNewLabel.setBounds(21, 22, 736, 14);
		getContentPane().add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(21, 38, 483, 22);
		getContentPane().add(comboBox);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(21, 71, 959, 2);
		getContentPane().add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Ofertas Laborales Asociadas:");
		lblNewLabel_1.setBounds(21, 87, 450, 14);
		getContentPane().add(lblNewLabel_1);
		
		ScrollPane panelOfertas = new ScrollPane();
		panelOfertas.setBounds(21, 107, 933, 540);
		getContentPane().add(panelOfertas);
		
		Scrollbar scrollbar = new Scrollbar();
		scrollbar.setBounds(937, 107, 17, 540);
		panelOfertas.add(scrollbar);
		
		tablaOfertaLaboral = new JTable();
		tablaOfertaLaboral.setModel(new DefaultTableModel(
			new Object[][] {
				{"Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo"},
				{"Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo"},
			},
			new String[] {
				"Nombre", "Descripci\u00F3n", "Ciudad", "Departamento", "Horario", "Remuneraci\u00F3n", "Fecha de Alta"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tablaOfertaLaboral.setDefaultRenderer(Object.class, new CentrarColumnas());
		JTableHeader headerOfertas = tablaOfertaLaboral.getTableHeader();
		tablaOfertaLaboral.getColumnModel().getColumn(0).setPreferredWidth(72);
		tablaOfertaLaboral.getColumnModel().getColumn(3).setPreferredWidth(100);
		tablaOfertaLaboral.getColumnModel().getColumn(5).setPreferredWidth(120);
		tablaOfertaLaboral.getColumnModel().getColumn(6).setPreferredWidth(105);
		tablaOfertaLaboral.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tablaOfertaLaboral.setBounds(197, 259, 1, 1);
		panelOfertas.add(headerOfertas);
		panelOfertas.add(tablaOfertaLaboral);

	}
}
