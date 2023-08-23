package Presentacion;

import java.awt.BorderLayout;
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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

import javax.swing.JTable;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import utilsPresentacion.CentrarColumnas;
import java.awt.Point;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class consultaOfertaLaboral extends JInternalFrame {
	private JTable tablaOfertaLaboral;
	private informacionOfertaLaboral informacionOfertaLaboralInternalFrame;

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
	 * @throws PropertyVetoException 
	 */
	public consultaOfertaLaboral() throws PropertyVetoException {
		

		informacionOfertaLaboralInternalFrame = new informacionOfertaLaboral();
		informacionOfertaLaboralInternalFrame.setResizable(false);
		informacionOfertaLaboralInternalFrame.setBorder(null);
		informacionOfertaLaboralInternalFrame.setVisible(false);
		getContentPane().add(informacionOfertaLaboralInternalFrame);
		
		
		setResizable(false);
		setMaximum(true);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Consulta de Oferta Laboral");
		setBounds(100, 100, 1229, 736);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Seleccione una empresa:");
		lblNewLabel.setBounds(21, 22, 736, 14);
		getContentPane().add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(21, 38, 483, 22);
		getContentPane().add(comboBox);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(21, 71, 1086, 2);
		getContentPane().add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Ofertas Laborales Asociadas:");
		lblNewLabel_1.setBounds(21, 84, 450, 14);
		getContentPane().add(lblNewLabel_1);
		
		ScrollPane panelHeaders = new ScrollPane();
		panelHeaders.setBounds(21, 111, 1151, 22);
		getContentPane().add(panelHeaders);
		
		ScrollPane tablePane = new ScrollPane();
		tablePane.setBounds(21, 139, 1151, 529);
		getContentPane().add(tablePane);
		
		JScrollBar scrollBarTabla = new JScrollBar();
		scrollBarTabla.setBounds(963, 139, 17, 508);
		tablePane.add(scrollBarTabla);
	
		tablaOfertaLaboral = new JTable();
		tablaOfertaLaboral.setRowHeight(35);
		tablaOfertaLaboral.setModel(new DefaultTableModel(
			new Object[][] {
				{"Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ver Información"},
				{"Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ver Información"},
				{"Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ver Información"},
				{"Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ver Información"},
				{"Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ver Información"},
				{"Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ver Información"},
				{"Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ver Información"},
				{"Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ver Información"},
				{"Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ver Información"},
				{"Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ver Información"},
				{"Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ver Información"},
				{"Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ver Información"},
				{"Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ver Información"},
				{"Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ver Información"},
				{"Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ver Información"},
				{"Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ver Información"},
				{"Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ver Información"},
				{"Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ver Información"},
				{"Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ver Información"},
				{"Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ver Información"},
				{"Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ver Información"},
				{"Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ver Información"},
				{"Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ver Información"},
				{"Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ver Información"},
				{"Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ver Información"},
				{"Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ver Información"},
				{"Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ver Información"},
				{"Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ver Información"},
				{"Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ver Información"},
				{"Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ver Información"},
				{"Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ver Información"},
				{"Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ver Información"},
				{"Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ver Información"},
				{"Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ejemplo", "Ver Información"},
				
			},
			new String[] {
				"Nombre", "Descripci\u00F3n", "Ciudad", "Departamento", "Horario", "Remuneraci\u00F3n", "Fecha de Alta", "Acciones"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tablePane.add(tablaOfertaLaboral);
		tablaOfertaLaboral.getColumnModel().getColumn(0).setPreferredWidth(72);
		tablaOfertaLaboral.getColumnModel().getColumn(3).setPreferredWidth(100);
		tablaOfertaLaboral.getColumnModel().getColumn(5).setPreferredWidth(120);
		tablaOfertaLaboral.getColumnModel().getColumn(6).setPreferredWidth(105);
		tablaOfertaLaboral.getColumnModel().getColumn(7).setCellRenderer(new buttonRenderer());
		tablaOfertaLaboral.getColumnModel().getColumn(7).setCellEditor(new ButtonEditor(new JCheckBox(), informacionOfertaLaboralInternalFrame));
		tablaOfertaLaboral.setDefaultRenderer(Object.class, new CentrarColumnas());
		JTableHeader headerOfertas = tablaOfertaLaboral.getTableHeader();
		panelHeaders.add(headerOfertas);
		tablaOfertaLaboral.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tablaOfertaLaboral.setBounds(21, 112, 908, 510);
		
		JButton buttonCancelar = new JButton("Cancelar");
		buttonCancelar.setBounds(526, 38, 89, 23);
		getContentPane().add(buttonCancelar);
		
		buttonCancelar.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 dispose();
	            }
		});
		
		
	}
}
