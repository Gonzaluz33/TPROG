package Presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import java.awt.Panel;
import java.beans.PropertyVetoException;

import javax.swing.JToolBar;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import java.awt.ScrollPane;
import java.awt.Scrollbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import logica.ControladorOfertas;
import logica.ControladorPublicaciones;
import logica.IControladorOfertas;
import logica.IControladorPublicaciones;
import utilsPresentacion.CentrarColumnas;

import java.awt.GridLayout;
import java.awt.Button;

public class postulacionOfertaLaboral extends JInternalFrame {
	private JTable tableOfertas;
	private postularAPostulante postularPostulanteInternalFrame;
	private IControladorOfertas controlOL;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IControladorOfertas controlOL = new ControladorOfertas();
					postulacionOfertaLaboral frame = new postulacionOfertaLaboral(controlOL);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws PropertyVetoException 
	 */
	public postulacionOfertaLaboral(IControladorOfertas iol) throws PropertyVetoException {
		
		controlOL = iol;
		
		postularPostulanteInternalFrame = new postularAPostulante();
		postularPostulanteInternalFrame.setResizable(false);
		postularPostulanteInternalFrame.setBorder(null);
		postularPostulanteInternalFrame.setVisible(false);
		getContentPane().add(postularPostulanteInternalFrame);
		
		setMaximum(true);
		setMaximizable(true);
		setResizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Postulacion a Oferta Laboral");
		setBounds(100, 100, 1074, 633);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Seleccione una empresa:");
		lblNewLabel.setBounds(10, 11, 819, 14);
		getContentPane().add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 53, 1028, 2);
		getContentPane().add(separator);
		
		JComboBox comboBoxEmpresa = new JComboBox();
		comboBoxEmpresa.setBounds(10, 25, 438, 22);
		getContentPane().add(comboBoxEmpresa);
		comboMostrarEmpresas(comboBoxEmpresa);
		
		JLabel lblNewLabel_1 = new JLabel("Ofertas Laborales Vigentes:");
		lblNewLabel_1.setBounds(10, 66, 600, 14);
		getContentPane().add(lblNewLabel_1);
		
		JPanel panelHeadersOfertas = new JPanel();
		panelHeadersOfertas.setBounds(10, 91, 1017, 22);
		getContentPane().add(panelHeadersOfertas);
		
		ScrollPane scrollPaneOfertas = new ScrollPane();
		scrollPaneOfertas.setBounds(10, 121, 1017, 405);
		getContentPane().add(scrollPaneOfertas);
		
		Scrollbar scrollbar = new Scrollbar();
		scrollbar.setBounds(722, 119, 9, 407);
		scrollPaneOfertas.add(scrollbar);
		
		tableOfertas = new JTable();
		tableOfertas.setRowHeight(35);
		tableOfertas.setModel(new DefaultTableModel(
			new Object[][] {
				{"Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Postular"},
			},
			new String[] {
				"Nombre", "Descripci\u00F3n", "Ciudad", "Departamento", "Horario", "Remuneraci\u00F3n", "Fecha Alta", "Acciones"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, Object.class, String.class, String.class, String.class, Object.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false, false, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableOfertas.getColumnModel().getColumn(0).setResizable(false);
		tableOfertas.getColumnModel().getColumn(0).setPreferredWidth(110);
		tableOfertas.getColumnModel().getColumn(1).setResizable(false);
		tableOfertas.getColumnModel().getColumn(1).setPreferredWidth(190);
		tableOfertas.getColumnModel().getColumn(2).setResizable(false);
		tableOfertas.getColumnModel().getColumn(2).setPreferredWidth(90);
		tableOfertas.getColumnModel().getColumn(3).setResizable(false);
		tableOfertas.getColumnModel().getColumn(3).setPreferredWidth(114);
		tableOfertas.getColumnModel().getColumn(4).setResizable(false);
		tableOfertas.getColumnModel().getColumn(4).setPreferredWidth(99);
		tableOfertas.getColumnModel().getColumn(5).setResizable(false);
		tableOfertas.getColumnModel().getColumn(5).setPreferredWidth(118);
		tableOfertas.getColumnModel().getColumn(6).setResizable(false);
		tableOfertas.getColumnModel().getColumn(7).setResizable(false);
		tableOfertas.getColumnModel().getColumn(7).setCellRenderer(new buttonRenderer());
		tableOfertas.getColumnModel().getColumn(7).setCellEditor(new ButtonEditor(new JCheckBox(), postularPostulanteInternalFrame));
		tableOfertas.setDefaultRenderer(Object.class, new CentrarColumnas());
		tableOfertas.setBounds(325, 246, 1, 1);
		JTableHeader headerOfertas = tableOfertas.getTableHeader();
		panelHeadersOfertas.add(headerOfertas);
		panelHeadersOfertas.setLayout(new GridLayout(1, 0, 0, 0));
		scrollPaneOfertas.add(tableOfertas);
		
		
		
		
		Button buttonCancelar = new Button("Cancelar");
		buttonCancelar.setBounds(472, 25, 70, 22);
		getContentPane().add(buttonCancelar);
		buttonCancelar.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 dispose();
	            }
		});

	}
	
	public void comboMostrarEmpresas(JComboBox combobox) {
		
	}
}