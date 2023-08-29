package Presentacion;

import utils.DTEmpresa;
import utils.DTOferta;
import utils.DTPostulacion;
import utils.DTPostulante;
import utils.DTUsuario;
import javax.swing.JInternalFrame;
import java.awt.Panel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.JSeparator;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.DefaultCellEditor;

import excepciones.OfertaNoExisteException;
import logica.Empresa;
import logica.IControladorOfertas;
import logica.IControladorUsuario;
import utilsPresentacion.CentrarColumnas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JCheckBox;

import utilsPresentacion.MultiLineCellRenderer;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.Component;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.DefaultCellEditor;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Scrollbar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class consultaUsuario extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Controlador de usuarios que se utilizará para las acciones del JFrame
    private IControladorUsuario controlUsr;
    private IControladorOfertas controlOL;
    
    //Componentes Swing
	private JTable tablaUsuario;
	private JTable tablaPostulante;
	private JTable tablaEmpresa;
	private JComboBox<DTUsuario> listaUsuariosCombobox;
	private String nickname;
	private String nombre;
	private String apellido;
	private String correo;
	private String fecha;
	private String nacion;
	private String desc;
	private String link;
	private String nombreEmp;
	private JTable tablePostulaciones;
	private JTable tableOfertas;
	private informacionOfertaLaboral informacionOfertaLaboralInternalFrame;
	
	//datos postulaciones
	private String nombreOferta;
	
	//datos ofertas
	private String nombreOL;
	private String descripcionOL;
	private String horarioOL;
	private String remuneracionOL;
	
	/**
	 * Create the frame.
	 * @throws PropertyVetoException 
	 */
	public consultaUsuario(IControladorUsuario icu, IControladorOfertas ico) throws PropertyVetoException {

		//Inicializacion internal frame con controlador de usuarios.
		controlUsr = icu;
		controlOL = ico;
		
		informacionOfertaLaboralInternalFrame = new informacionOfertaLaboral(ico);
		informacionOfertaLaboralInternalFrame.setBorder(null);
		informacionOfertaLaboralInternalFrame.setVisible(false);
		getContentPane().add(informacionOfertaLaboralInternalFrame);
		
		setResizable(false);
		setMaximum(true);
		setResizable(true);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Consulta de Usuario");
		setBounds(100, 100, 1401, 784);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Seleccione un usuario:");
		lblNewLabel.setBounds(20, 11, 931, 14);
		getContentPane().add(lblNewLabel);
		
		
		listaUsuariosCombobox = new JComboBox<DTUsuario>();
		listaUsuariosCombobox.setBounds(20, 36, 544, 22);
		getContentPane().add(listaUsuariosCombobox);
		listaUsuariosCombobox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DTUsuario selectedValue = (DTUsuario) listaUsuariosCombobox.getSelectedItem();
                // Limpiar filas existentes
                DefaultTableModel tablePostulacionesModel = (DefaultTableModel) tablePostulaciones.getModel();
            	tablePostulacionesModel.setRowCount(0); 
            	DefaultTableModel tableOfertasModel = (DefaultTableModel) tableOfertas.getModel();
            	tableOfertasModel.setRowCount(0); 
            	
                if (selectedValue != null) {
                    nickname = selectedValue.getNickname();
                    nombre = selectedValue.getNombre();
                    apellido = selectedValue.getApellido();
                    correo = selectedValue.getCorreo(); 
                    DefaultTableModel tableModel = (DefaultTableModel) tablaUsuario.getModel();
                    tableModel.setRowCount(0); // Limpiar filas existentes
                    tableModel.addRow(new Object[] {nickname, nombre, apellido, correo});
                    
                    if(selectedValue instanceof DTEmpresa) {
                    	desc = ((DTEmpresa) selectedValue).getDescripcion();
                    	link = ((DTEmpresa) selectedValue).getLinkWeb();
                    	nombreEmp = ((DTEmpresa) selectedValue).getNombreEmpresa();
                    	((DefaultTableModel) tablaPostulante.getModel()).setRowCount(0);
                    	DefaultTableModel tableEmpresaModel = (DefaultTableModel) tablaEmpresa.getModel();
                        tableEmpresaModel.setRowCount(0); // Limpiar filas existentes
                        tableEmpresaModel.addRow(new Object[] {nombreEmp , desc, link});
                        
                        Set<DTOferta> listadoOfertas = (Set<DTOferta>)((DTEmpresa) selectedValue).getOfertas();
                        for (DTOferta elemento : listadoOfertas) {
                        	nombreOL = elemento.getNombre();
                        	descripcionOL = elemento.getDescripcion();                        	
                        	horarioOL = elemento.getHorario();
                        	remuneracionOL = elemento.getRemuneracion();
                        	tableOfertasModel.addRow(new Object[] {nombreOL,descripcionOL,horarioOL,remuneracionOL});
                        }    
                        
                        
                        
                    } else {
                    	((DefaultTableModel) tablaEmpresa.getModel()).setRowCount(0);
                    	String fechaFormateada = new SimpleDateFormat("dd-MM-yyyy").format(((DTPostulante) selectedValue).getFechaNacimiento());
                    	fecha = fechaFormateada.toString();
                    	nacion = ((DTPostulante) selectedValue).getNacionalidad();
                    	DefaultTableModel tablePostModel = (DefaultTableModel) tablaPostulante.getModel();
                        tablePostModel.setRowCount(0); // Limpiar filas existentes
                        tablePostModel.addRow(new Object[] {"Postulante", fecha, nacion});
                        
                        List<DTPostulacion> listadoPostulaciones = (List<DTPostulacion>) ((DTPostulante) selectedValue).getPostulaciones();
                        for (DTPostulacion elemento : listadoPostulaciones) {
                        	nombreOferta = elemento.getNombreOfertaLaboral();                       	
                        	tablePostulacionesModel.addRow(new Object[] {nombreOferta});
                        }    
                    }
                }               
            }		
		 });
		JSeparator separator = new JSeparator();
		separator.setBounds(20, 67, 1019, 14);
		getContentPane().add(separator);
		
		Panel panelUsuario = new Panel();
		panelUsuario.setBounds(20, 96, 585, 58);
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
		panelPostulante.setBounds(22, 180, 370, 70);
		getContentPane().add(panelPostulante);
		
		tablaPostulante = new JTable();
		tablaPostulante.setModel(new DefaultTableModel(
			new Object[][] {
				{"", "", ""},
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
		panelEmpresa.setBounds(489, 180, 879, 160);
		getContentPane().add(panelEmpresa);
		panelEmpresa.setLayout(new GridLayout(0, 1, 0, 0));
		
		tablaEmpresa = new JTable();
		JTableHeader headerEmpresa = tablaEmpresa.getTableHeader();
		panelEmpresa.add(headerEmpresa);
		
		panelEmpresa.add(tablaEmpresa);
		tablaEmpresa.setModel(new DefaultTableModel(
			new Object[][] {
				{"", "", ""},
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
		tablaEmpresa.getColumnModel().getColumn(0).setCellRenderer(new MultiLineCellRenderer());
		tablaEmpresa.getColumnModel().getColumn(1).setCellRenderer(new MultiLineCellRenderer());
		tablaEmpresa.getColumnModel().getColumn(2).setCellRenderer(new MultiLineCellRenderer());
		tablaEmpresa.setDefaultRenderer(Object.class, new CentrarColumnas());
		tablaEmpresa.setRowHeight(200);

	
		JButton buttonCancelar = new JButton("Cancelar");
		buttonCancelar.setBounds(574, 36, 89, 23);
		getContentPane().add(buttonCancelar);
		
		JLabel lblNewLabel_1 = new JLabel("Datos Usuario:");
		lblNewLabel_1.setBounds(20, 76, 171, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Datos Postulante:");
		lblNewLabel_1_1.setBounds(20, 160, 372, 14);
		getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Datos Empresa:");
		lblNewLabel_1_1_1.setBounds(489, 160, 520, 14);
		getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Postulaciones:");
		lblNewLabel_1_1_2.setBounds(20, 256, 440, 14);
		getContentPane().add(lblNewLabel_1_1_2);
		
		ScrollPane scrollPanePostulaciones = new ScrollPane();
		scrollPanePostulaciones.setBounds(20, 303, 460, 245);
		getContentPane().add(scrollPanePostulaciones);
		
		ScrollPane scrollPaneOfertas = new ScrollPane();
		scrollPaneOfertas.setBounds(489, 403, 879, 290);
		getContentPane().add(scrollPaneOfertas);
		
		JLabel lblNewLabel_2 = new JLabel("Ofertas Laborales:");
		lblNewLabel_2.setBounds(489, 346, 563, 14);
		getContentPane().add(lblNewLabel_2);
		
		Panel panelHeaderOfertas = new Panel();
		panelHeaderOfertas.setBounds(489, 366, 879, 30);
		getContentPane().add(panelHeaderOfertas);
		
		Panel panelHeaderPostulaciones = new Panel();
		panelHeaderPostulaciones.setBounds(20, 276, 460, 22);
		getContentPane().add(panelHeaderPostulaciones);
		
		tablePostulaciones = new JTable();
		JTableHeader headerPostulaciones = tablePostulaciones.getTableHeader();
		panelHeaderPostulaciones.add(headerPostulaciones);
		panelHeaderPostulaciones.setLayout(new GridLayout(1, 0, 0, 0));
		
		tablePostulaciones.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre Oferta Laboral"
			}
		));
		tablePostulaciones.setBounds(218, 419, 1, 1);
		scrollPanePostulaciones.add(tablePostulaciones);
		
		tableOfertas = new JTable();
		tableOfertas.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre", "Descripci\u00F3n", "Horario", "Remuneraci\u00F3n", "Acciones"
			}
		));
		scrollPaneOfertas.add(tableOfertas);
		tableOfertas.setRowHeight(140);
		tableOfertas.getColumnModel().getColumn(0).setCellRenderer(new MultiLineCellRenderer());
		tableOfertas.getColumnModel().getColumn(1).setCellRenderer(new MultiLineCellRenderer());
		tableOfertas.getColumnModel().getColumn(2).setCellRenderer(new MultiLineCellRenderer());
		tableOfertas.getColumnModel().getColumn(3).setCellRenderer(new MultiLineCellRenderer());
		tableOfertas.getColumnModel().getColumn(4).setCellRenderer(new ButtonRenderer());
		tableOfertas.getColumnModel().getColumn(4).setCellEditor(new ButtonEditor(new JCheckBox(), informacionOfertaLaboralInternalFrame));
		JTableHeader headerOfertas = tableOfertas.getTableHeader();
		panelHeaderOfertas.add(headerOfertas);
		panelHeaderOfertas.setLayout(new GridLayout(1, 0, 0, 0));
		panelHeaderPostulaciones.setLayout(new GridLayout(1, 0, 0, 0));
		tableOfertas.setBounds(798, 481, 1, 1);
		
		buttonCancelar.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 DefaultTableModel tableModelOfertas = (DefaultTableModel) tableOfertas.getModel();
				 tableModelOfertas.setRowCount(0); // Limpiar filas existentes
				 DefaultTableModel tableModelPostulaciones = (DefaultTableModel) tablePostulaciones.getModel();
				 tableModelPostulaciones.setRowCount(0); // Limpiar filas existentes
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
	        	if (currentRow >= 0 && currentRow < tableOfertas.getRowCount()) {
		            String nombreOferta = tableOfertas.getValueAt(currentRow, 0).toString();
		            ((informacionOfertaLaboral) informacionOfertaLaboralInternalFrame).recibirNombreOferta(nombreOferta);
		            try {
						((informacionOfertaLaboral) informacionOfertaLaboralInternalFrame).mostrarDatosOferta();
					} catch (OfertaNoExisteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		            informacionOfertaLaboralInternalFrame.setVisible(true);
	        	}
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
	    	if (row >= 0 && row < tableOfertas.getRowCount()) {
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
	    	}

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
