package Presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.table.DefaultTableModel;

import excepciones.NicknameNoExisteException;
import excepciones.OfertaNoExisteException;
import excepciones.UsuarioNoEsEmpresaException;
import logica.IControladorOfertas;
import logica.IControladorUsuario;
import logica.OfertaLaboral;
import utils.DTEmpresa;
import utils.DTOferta;
import utils.EnumEstadoOferta;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.awt.event.ActionEvent;

public class AceptarRechazarOfertaLaboral extends JInternalFrame {
	
	@SuppressWarnings("unused")
	//Controlador
		private IControladorUsuario controlUsr;
		private IControladorOfertas controlOL;
		
		private JComboBox<DTEmpresa> listaEmpresasCombobox;
		private JComboBox<DTOferta> listaOfertasCombobox;
		private JComboBox<EnumEstadoOferta> listaEstadosCombobox;

	/**
	 * Create the frame.
	 */
	public AceptarRechazarOfertaLaboral(IControladorUsuario icu, IControladorOfertas ico) {
		//Inicializacion internal frame con controlador de usuarios.
		controlUsr = icu;
		controlOL = ico;
		setClosable(true);
		setTitle("Aceptar/Rechazar Oferta Laboral");
		setMaximizable(true);
		setIconifiable(true);
		setBounds(100, 100, 589, 447);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Seleccione una empresa:");
		lblNewLabel.setBounds(10, 11, 237, 14);
		getContentPane().add(lblNewLabel);
		
		listaEmpresasCombobox = new JComboBox<DTEmpresa>();
		listaEmpresasCombobox.setBounds(10, 27, 292, 22);
		getContentPane().add(listaEmpresasCombobox);
		listaEmpresasCombobox.addActionListener(new ActionListener() {
			@Override
            public void actionPerformed(ActionEvent e) {  
				try {
					llenar_comboListaOfertas();
				} catch (NicknameNoExisteException | UsuarioNoEsEmpresaException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 				
            }		
		});
		
			
		JLabel lblNewLabel_1 = new JLabel("Seleccione una oferta laboral:");
		lblNewLabel_1.setBounds(10, 61, 292, 14);
		getContentPane().add(lblNewLabel_1);
		
		listaOfertasCombobox = new JComboBox<DTOferta>();
		listaOfertasCombobox.setBounds(10, 75, 292, 22);
		getContentPane().add(listaOfertasCombobox);
		
		JLabel lblNewLabel_2 = new JLabel("Seleccione un estado:");
		lblNewLabel_2.setBounds(10, 108, 281, 14);
		getContentPane().add(lblNewLabel_2);
		
		listaEstadosCombobox = new JComboBox<EnumEstadoOferta>();
		listaEstadosCombobox.setBounds(10, 129, 292, 22);
		getContentPane().add(listaEstadosCombobox);
		listaEstadosCombobox.addItem(EnumEstadoOferta.CONFIRMADA);
		listaEstadosCombobox.addItem(EnumEstadoOferta.RECHAZADA);
		
		JButton buttonAceptar = new JButton("Aceptar");
		buttonAceptar.setBounds(30, 198, 89, 23);
		getContentPane().add(buttonAceptar);
		buttonAceptar.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {		
				DTOferta selectedOferta = (DTOferta) listaOfertasCombobox.getSelectedItem();
				try {
					OfertaLaboral o = controlOL.getOfertaLaboral(selectedOferta.getNombre());
					EnumEstadoOferta estado = (EnumEstadoOferta) listaEstadosCombobox.getSelectedItem();
					o.setEstado(estado);
				} catch (OfertaNoExisteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
	         }
		});
		
		JButton buttonCancelar = new JButton("Cancelar");
		buttonCancelar.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {				 
				 dispose();
	         }
		});
		buttonCancelar.setBounds(182, 198, 89, 23);
		getContentPane().add(buttonCancelar);
	}
	
	@SuppressWarnings("unchecked")
	public void llenar_comboListaOfertas() throws NicknameNoExisteException, UsuarioNoEsEmpresaException{
		listaOfertasCombobox.removeAllItems();
		List<DTOferta> datos = new ArrayList<>();
		DTEmpresa selectedValue = (DTEmpresa) listaEmpresasCombobox.getSelectedItem();
		datos = (List<DTOferta>) controlOL.obtenerOfertasIngresadasDeEmpresa(selectedValue.getNickname());
		for (DTOferta o : datos) {
			listaOfertasCombobox.addItem(o);
		}
	}
			
	public void llenar_comboListaEmpresa(){
		listaEmpresasCombobox.removeAllItems();
		List<DTEmpresa> datos = new ArrayList<>();
		datos = controlUsr.listarEmpresas();
		for (DTEmpresa u : datos) {
			listaEmpresasCombobox.addItem(u);
		}
	}
}
