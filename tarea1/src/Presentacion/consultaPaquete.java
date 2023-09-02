package Presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;

import logica.IControladorPublicaciones;
import utils.DTPaquete;
import utils.DTTupla_Cantidad_TipoPublicacion;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class consultaPaquete extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	private IControladorPublicaciones controlPub;
	private JComboBox<DTPaquete> listaPaquetes;
	private JPanel panelPaquete;
	private JTextField nombreField;
	private JTextArea descripcionField;
	private JTextField validezField;
	private JTextField descuentoField;
	private JTextField fechaAltaField;
	private JTextField costoAsociadoField;
	private JTable tablePaquetes;

	public consultaPaquete(IControladorPublicaciones icp) {
		controlPub = icp;
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
		setClosable(true);
		setResizable(true);
		setTitle("Consulta de Paquete de Tipos de publicación de Ofertas Laborales");
		setBounds(100, 100, 1030, 708);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Seleccione un Paquete:");
		lblNewLabel.setBounds(10, 11, 729, 14);
		getContentPane().add(lblNewLabel);
		
		listaPaquetes = new JComboBox<DTPaquete>();
		listaPaquetes.setBounds(10, 36, 586, 22);
		getContentPane().add(listaPaquetes);
		listaPaquetes.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 DefaultTableModel tablePaquetesModel = (DefaultTableModel) tablePaquetes.getModel();
				 tablePaquetesModel.setRowCount(0); 
				 DTPaquete p = (DTPaquete) listaPaquetes.getSelectedItem();
				 if(p!=null) {
					 nombreField.setText(p.getNombre());
					 descripcionField.setText(p.getDescripcion());
					 validezField.setText(p.getValidez().toString());
					 descuentoField.setText(p.getDescuento().toString());
					 fechaAltaField.setText(p.getFechaAlta().format(formatter));
					 
					 List<DTTupla_Cantidad_TipoPublicacion> datosTabla = p.getListaDeTuplas();
					 for(DTTupla_Cantidad_TipoPublicacion d : datosTabla) {
						 String nombre = d.getTipoPublicacion();
						 String cantidad = d.getCantidad().toString();
						 tablePaquetesModel.addRow(new Object[] {nombre, cantidad});
					 }				 
				 }
			}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(616, 36, 89, 23);
		getContentPane().add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 dispose();
	            }
		});
		
		panelPaquete = new JPanel();
		panelPaquete.setBounds(10, 71, 994, 596);
		getContentPane().add(panelPaquete);
		panelPaquete.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setBounds(10, 11, 160, 14);
		panelPaquete.add(lblNewLabel_1);
		
		nombreField = new JTextField();
		nombreField.setEditable(false);
		nombreField.setBounds(10, 27, 160, 20);
		panelPaquete.add(nombreField);
		nombreField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Validez:");
		lblNewLabel_1_1.setBounds(183, 11, 109, 14);
		panelPaquete.add(lblNewLabel_1_1);
		
		validezField = new JTextField();
		validezField.setEditable(false);
		validezField.setColumns(10);
		validezField.setBounds(180, 27, 112, 20);
		panelPaquete.add(validezField);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Descuento:");
		lblNewLabel_1_1_1.setBounds(305, 11, 109, 14);
		panelPaquete.add(lblNewLabel_1_1_1);
		
		descuentoField = new JTextField();
		descuentoField.setEditable(false);
		descuentoField.setColumns(10);
		descuentoField.setBounds(302, 27, 112, 20);
		panelPaquete.add(descuentoField);
		
		JLabel lblNewLabel_2 = new JLabel("Descripción:");
		lblNewLabel_2.setBounds(10, 58, 404, 14);
		panelPaquete.add(lblNewLabel_2);
		
		descripcionField = new JTextArea();
		descripcionField.setLineWrap(true);
		descripcionField.setWrapStyleWord(true);
		descripcionField.setEnabled(true);
		descripcionField.setEditable(false);
		descripcionField.setText("");
		descripcionField.setBounds(10, 75, 404, 156);
		panelPaquete.add(descripcionField);
		
		fechaAltaField = new JTextField();
		fechaAltaField.setEditable(false);
		fechaAltaField.setColumns(10);
		fechaAltaField.setBounds(424, 27, 187, 20);
		panelPaquete.add(fechaAltaField);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Fecha de Alta:");
		lblNewLabel_1_1_1_1.setBounds(424, 11, 109, 14);
		panelPaquete.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Costo Asociado:");
		lblNewLabel_1_1_1_1_1.setBounds(424, 58, 109, 14);
		panelPaquete.add(lblNewLabel_1_1_1_1_1);
		
		costoAsociadoField = new JTextField();
		costoAsociadoField.setEditable(false);
		costoAsociadoField.setColumns(10);
		costoAsociadoField.setBounds(424, 77, 187, 20);
		panelPaquete.add(costoAsociadoField);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 277, 946, 308);
		panelPaquete.add(scrollPane);
		
		tablePaquetes = new JTable();
		tablePaquetes.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Tipo de Publicaci\u00F3n ", "Cantidad de Publicaciones", "Detalle"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tablePaquetes.getColumnModel().getColumn(0).setPreferredWidth(239);
		tablePaquetes.getColumnModel().getColumn(1).setPreferredWidth(161);
		tablePaquetes.getColumnModel().getColumn(2).setPreferredWidth(207);
		scrollPane.setViewportView(tablePaquetes);
		
		JLabel lblNewLabel_3 = new JLabel("Especificación Paquete:");
		lblNewLabel_3.setBounds(10, 252, 428, 14);
		panelPaquete.add(lblNewLabel_3);
	}
	
	public void llenar_listaPaquetes() {
		listaPaquetes.removeAllItems();
		List<DTPaquete> datos = new ArrayList<>();
		datos = controlPub.listarPaquetes();
		for (DTPaquete p : datos) {
			listaPaquetes.addItem(p);
		}
	}
	
	public void renderizarComponentesPaquete(Boolean b) {
		panelPaquete.setVisible(b);
	}
	
}
