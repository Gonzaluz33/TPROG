package Presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.Panel;
import javax.swing.JSeparator;
import java.awt.ScrollPane;
import java.beans.PropertyVetoException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import excepciones.OfertaNoExisteException;
import logica.IControladorOfertas;
import utils.DTOferta;

import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Scrollbar;

public class informacionOfertaLaboral extends JInternalFrame {
	private static final long serialVersionUID = 1L;

	/**
	 * Create the frame.
	 * @throws PropertyVetoException 
	 */
	public informacionOfertaLaboral() throws PropertyVetoException {
		
		setMaximizable(true);
		setClosable(true);
		setTitle("Información de Oferta Laboral");
		setBounds(100, 100, 877, 618);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Datos:");
		lblNewLabel.setBounds(21, 21, 764, 14);
		getContentPane().add(lblNewLabel);
		
		Panel tablePaneDatosOferta = new Panel();
		tablePaneDatosOferta.setBounds(21, 41, 793, 68);
		getContentPane().add(tablePaneDatosOferta);
		
		JTable tableDatosOferta = new JTable();
		tableDatosOferta.setRowHeight(35);
		JTableHeader headerDatos = tableDatosOferta.getTableHeader();
		tablePaneDatosOferta.add(headerDatos);
		tableDatosOferta.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"Nombre", "Descripcion", "Ciudad", "Departamento", "Horario", "Remuneraci\u00F3n", "Fecha Alta"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, true, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableDatosOferta.getColumnModel().getColumn(0).setResizable(false);
		tableDatosOferta.getColumnModel().getColumn(1).setResizable(false);
		tableDatosOferta.getColumnModel().getColumn(2).setResizable(false);
		tableDatosOferta.getColumnModel().getColumn(3).setResizable(false);
		tableDatosOferta.getColumnModel().getColumn(5).setResizable(false);
		tableDatosOferta.getColumnModel().getColumn(5).setPreferredWidth(91);
		tableDatosOferta.getColumnModel().getColumn(6).setResizable(false);
		tablePaneDatosOferta.setLayout(new GridLayout(0, 1, 0, 0));
		tablePaneDatosOferta.add(tableDatosOferta);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(21, 115, 830, 2);
		getContentPane().add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Postulaciones:");
		lblNewLabel_1.setBounds(21, 130, 764, 14);
		getContentPane().add(lblNewLabel_1);
		
		Panel headersPostulacionesPane = new Panel();
		headersPostulacionesPane.setBounds(21, 150, 764, 26);
		getContentPane().add(headersPostulacionesPane);
		
		ScrollPane tablePanePostulaciones = new ScrollPane();
		tablePanePostulaciones.setBounds(21, 180, 764, 380);
		getContentPane().add(tablePanePostulaciones);
		
		Scrollbar scrollbar = new Scrollbar();
		scrollbar.setBounds(774, 182, 11, 378);
		tablePanePostulaciones.add(scrollbar);
		
		JTable tablePostulaciones = new JTable();
		
		JTableHeader headerPostulaciones = tablePostulaciones.getTableHeader();
		headersPostulacionesPane.add(headerPostulaciones);
		headersPostulacionesPane.setLayout(new GridLayout(1, 0, 0, 0));
		tablePostulaciones.setFillsViewportHeight(true);
		tablePostulaciones.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"Fecha", "CV", "Motivaci\u00F3n"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tablePostulaciones.getColumnModel().getColumn(0).setResizable(false);
		tablePostulaciones.getColumnModel().getColumn(1).setResizable(false);
		tablePostulaciones.getColumnModel().getColumn(2).setResizable(false);
		tablePostulaciones.setBounds(220, 342, 1, 1);
		tablePanePostulaciones.add(tablePostulaciones);
	}
}
