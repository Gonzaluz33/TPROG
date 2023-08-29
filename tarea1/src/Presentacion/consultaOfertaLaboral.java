package Presentacion;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import java.awt.Panel;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import java.awt.ScrollPane;
import java.awt.Scrollbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.swing.JTable;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

import excepciones.OfertaNoExisteException;
import logica.IControladorOfertas;
import logica.IControladorUsuario;
import utils.DTEmpresa;
import utils.DTOferta;
import utils.DTPostulante;
import utils.DTUsuario;
import utilsPresentacion.CentrarColumnas;
import utilsPresentacion.MultiLineCellRenderer;

import java.awt.Point;
import javax.swing.JScrollBar;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class consultaOfertaLaboral extends JInternalFrame {
	
	//Controlador
	private IControladorUsuario controlUsr;
	private IControladorOfertas controlOL;
	//Componentes Swing
	private JTable tablaOfertaLaboral;
	private informacionOfertaLaboral informacionOfertaLaboralInternalFrame;
	private JComboBox<DTEmpresa> listaEmpresasCombobox;
	
	//datos ofertas
	private String nombreOferta;
	private String Descripcion;
	private String Ciudad;
	private String Departamento;
	private String Horario;
	private String Remuneracion;
	private String fechaAlta;
	
	/**
	 * Create the frame.
	 * @throws PropertyVetoException 
	 */
	public consultaOfertaLaboral(IControladorUsuario icu, IControladorOfertas ico) throws PropertyVetoException {
		//Inicializacion internal frame con controlador de usuarios.
		controlUsr = icu;
		controlOL = ico;
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
		informacionOfertaLaboralInternalFrame = new informacionOfertaLaboral(ico);
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
		
		listaEmpresasCombobox = new JComboBox<DTEmpresa>();
		listaEmpresasCombobox.setBounds(21, 38, 483, 22);
		getContentPane().add(listaEmpresasCombobox);
		listaEmpresasCombobox.addActionListener(new ActionListener() {
			@Override
            public void actionPerformed(ActionEvent e) {  
				 
                DefaultTableModel tableModel = (DefaultTableModel) tablaOfertaLaboral.getModel();
                tableModel.setRowCount(0); // Limpiar filas existentes
				DTEmpresa selectedValue = (DTEmpresa) listaEmpresasCombobox.getSelectedItem();
				if (selectedValue != null) {
					Set<DTOferta> listadoOfertas = selectedValue.getOfertas();
					if(!listadoOfertas.isEmpty()) {
						for (DTOferta item : listadoOfertas) {
							nombreOferta = item.getNombre();
							Descripcion = item.getDescripcion();
							Ciudad = item.getCiudad();
							Departamento = item.getDepartamento();
							Horario = item.getHorario();
							Remuneracion = item.getRemuneracion();
							fechaAlta = item.getFechaAlta().format(formatter);
							tableModel.addRow(new Object[] {nombreOferta, Descripcion, Ciudad, Departamento,
									Horario,Remuneracion,fechaAlta});
						} 
					}
				}		
            }		
		});
		
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
		tablaOfertaLaboral.setDefaultRenderer(Object.class, new CentrarColumnas());
		tablaOfertaLaboral.setRowHeight(140);
		tablaOfertaLaboral.getColumnModel().getColumn(0).setCellRenderer(new MultiLineCellRenderer());
		tablaOfertaLaboral.getColumnModel().getColumn(1).setCellRenderer(new MultiLineCellRenderer());
		tablaOfertaLaboral.getColumnModel().getColumn(2).setCellRenderer(new MultiLineCellRenderer());
		tablaOfertaLaboral.getColumnModel().getColumn(3).setCellRenderer(new MultiLineCellRenderer());
		tablaOfertaLaboral.getColumnModel().getColumn(4).setCellRenderer(new MultiLineCellRenderer());
		tablaOfertaLaboral.getColumnModel().getColumn(5).setCellRenderer(new MultiLineCellRenderer());
		tablaOfertaLaboral.getColumnModel().getColumn(6).setCellRenderer(new MultiLineCellRenderer());
		tablaOfertaLaboral.getColumnModel().getColumn(7).setCellRenderer(new ButtonRenderer());
		tablaOfertaLaboral.getColumnModel().getColumn(7).setCellEditor(new ButtonEditor(new JCheckBox(), informacionOfertaLaboralInternalFrame));
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
	public void llenar_comboListaEmpresa(){
		listaEmpresasCombobox.removeAllItems();
		List<DTEmpresa> datos = new ArrayList<>();
		datos = controlUsr.listarEmpresas();
		for (DTEmpresa u : datos) {
			listaEmpresasCombobox.addItem(u);
		}
	}
	
	class ButtonRenderer extends JButton implements TableCellRenderer {
	    public ButtonRenderer() {
	        setOpaque(true);
	    }

	    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
	        if (isSelected) {
	            setForeground(table.getSelectionForeground());
	            setBackground(table.getSelectionBackground());
	        } else {
	            setForeground(table.getForeground());
	            setBackground(UIManager.getColor("Button.background"));
	        }
	        setText((value == null) ? "" : value.toString());
	        return this;
	    }
	}
	
	class ButtonEditor extends DefaultCellEditor {
	    protected JButton button;
	    private String label;
	    private boolean isPushed;
	    private MyActionListener myListener;
	    
	    // Nueva clase interna MyActionListener
	    private class MyActionListener implements ActionListener {
	        private int currentRow;
	        @Override
	        public void actionPerformed(ActionEvent e) {	        	
	            String nombreOferta = tablaOfertaLaboral.getValueAt(currentRow, 0).toString();
	            ((informacionOfertaLaboral) informacionOfertaLaboralInternalFrame).recibirNombreOferta(nombreOferta);
	            try {
					((informacionOfertaLaboral) informacionOfertaLaboralInternalFrame).mostrarDatosOferta();
				} catch (OfertaNoExisteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	            informacionOfertaLaboralInternalFrame.setVisible(true);
	        }

	        public void setCurrentRow(int row) {
	            this.currentRow = row;
	        }
	    }
	    
	    public ButtonEditor(JCheckBox checkBox, JInternalFrame postularPostulanteInternalFrame) {
	        super(checkBox);
	        button = new JButton();
	        button.setOpaque(true);
	        myListener = new MyActionListener(); // Inicializamos MyActionListener
	        button.addActionListener(myListener); // Agregamos MyActionListener al botón
	    }

	    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
	        if (isSelected) {
	            button.setForeground(table.getSelectionForeground());
	            button.setBackground(table.getSelectionBackground());
	        } else {
	            button.setForeground(table.getForeground());
	            button.setBackground(table.getBackground());
	        }
	        label = (value == null) ? "" : value.toString();
	        button.setText(label);
	        isPushed = true;
	        
	        // Aquí establecemos la fila actual en MyActionListener
	        myListener.setCurrentRow(row);

	        return button;
	    }

	    public Object getCellEditorValue() {
	        isPushed = false;
	        return label;
	    }

	    public boolean stopCellEditing() {
	        isPushed = false;
	        return super.stopCellEditing();
	    }

	    protected void fireEditingStopped() {
	        super.fireEditingStopped();
	    }
	    
	}

}

