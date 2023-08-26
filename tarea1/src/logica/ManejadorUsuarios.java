package logica;

import java.util.*;
import java.util.stream.Collectors;

import excepciones.*;
import utils.DTUsuario;
import utils.DTEmpresa;
import utils.DTOferta;

public class ManejadorUsuarios {

	private Map<String, Usuario> coleccionUsuarios = new HashMap<String,Usuario>();
	private static ManejadorUsuarios instancia;
	
	public static ManejadorUsuarios getInstance() {
        if (instancia == null) {
            instancia = new ManejadorUsuarios();
        }
        return instancia;
    }
	
	/**
	 * Crea la empresa y la agrega a coleccionUsuarios.
	 * @throws UsuarioRepetidoException 
	 */
	void altaEmpresa(Empresa e) throws UsuarioRepetidoException {
		if (coleccionUsuarios.containsKey(e.getNickname())){
			throw new UsuarioRepetidoException("Ya existe un usuario con el nickname ingresado.");
		}
		else {
			coleccionUsuarios.put(e.getNickname().toLowerCase(), e);
		}
	}
	
	/**
	 * Crea el postulante y lo agrega a coleccionUsuarios.
	 */
	void altaPostulante(Postulante p) throws UsuarioRepetidoException {
		if (coleccionUsuarios.containsKey(p.getNickname())){
			throw new UsuarioRepetidoException("Ya existe un usuario con el nickname ingresado.");
		}
		else {
			coleccionUsuarios.put(p.getNickname().toLowerCase(), p);
		}
	}

	/**
	 * Devuelve un DTUsuario con los datos del usuario con el nickname dado. Si es una empresa tambien devuelve sus ofertas y si es un postulante tambien devuelve sus postulaciones.
	 * Si el nickname no existe en el sistema tira un NicknameNoExisteException.
	 * Si el nickname es NULL tira una unchecked exception.
	 */
	public DTUsuario obtenerUsuario(String nicknameUsuario) throws NicknameNoExisteException {
		String nicknameLowerCase = nicknameUsuario.toLowerCase();
		if (coleccionUsuarios.containsKey(nicknameLowerCase) ) {
			return coleccionUsuarios.get(nicknameLowerCase).toDataType();
		} else {
			throw new NicknameNoExisteException("El usuario con el nickname " + nicknameUsuario + " no existe.");
		}
	}
	
	/**
	 * Devuelve una lista de DTUsuario con la informacion de todos los usuarios registrados en el sistema ordenados segun su nombre.
	 * Si no hay usuarios registrados devuelve una lista vacia.
	 */
	public List<DTUsuario> obtenerListaUsuarios() {
		List<DTUsuario> listaUsuarios = new ArrayList<DTUsuario>();
		for (Map.Entry<String, Usuario> entry : coleccionUsuarios.entrySet()) {
			System.out.print("llegue a manejador");
			listaUsuarios.add(entry.getValue().toDataType());
		}
		listaUsuarios.sort(Comparator
				.comparing(DTUsuario::getNombre)
				.thenComparing(DTUsuario::getApellido));
		return listaUsuarios;
	}
	
	/**
	 * Devuelve una lista de DTUsuario con la informacion de todas las empresas registradas en el sistema ordenadas segun el nombre de la empresa.
	 * Si no hay empresas registrados devuelve una lista vacia.
	 */
	public List<DTEmpresa> obtenerListaEmpresas() {
		List<DTEmpresa> listaEmpresas = this.coleccionUsuarios.values()
				.stream()
				.filter(usuario -> usuario instanceof Empresa)
				.map(Usuario::toDataType)
				.map(usuarioDT -> (DTEmpresa) usuarioDT)
				.collect(Collectors.toList());
		listaEmpresas.sort(Comparator.comparing(DTEmpresa::getNombreEmpresa));
		return listaEmpresas;
	}
	
	/**
	 * Devuelve un set de tipo DTOferta con todas las ofertas asociadas a la empresa con el nickname "nicknameEmpresa" ordenadas alfabeticamente por el nombre de las ofertas.
	 * Si el nickname no esta asociado a un usuario en el sistema tira una NicknameNoExisteException.
	 * Si existe el usuario con ese nickname pero no es una empresa tira una UsuarioNoEsEmpresaException.
	 * Si no tiene ofertas asociadas devuelve una lista vacia.
	 */
	public Set<DTOferta> obtenerOfertasDeEmpresa(String nicknameEmpresa) throws NicknameNoExisteException, UsuarioNoEsEmpresaException {
		if ( !coleccionUsuarios.containsKey(nicknameEmpresa.toLowerCase()) )
			throw new NicknameNoExisteException("La empresa con el nickname " + nicknameEmpresa + " no existe.");
		if ( !(coleccionUsuarios.get(nicknameEmpresa) instanceof Empresa) )
			throw new UsuarioNoEsEmpresaException("El usuario con el nickname " + nicknameEmpresa + " no es una empresa.");
		return ( (Empresa) coleccionUsuarios.get(nicknameEmpresa) ).getOfertas();
	}

}
