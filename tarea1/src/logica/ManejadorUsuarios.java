package logica;

import java.util.*;

import excepciones.*;
import utils.DTUsuario;

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
	public DTUsuario obtenerUsuario(String nickname) throws NicknameNoExisteException {
		String nicknameLowerCase = nickname.toLowerCase();
		if (coleccionUsuarios.containsKey(nicknameLowerCase) ) {
			return coleccionUsuarios.get(nicknameLowerCase).toDataType();
		} else {
			throw new NicknameNoExisteException("El usuario con el nickname " + nickname + " no existe.");
		}
	}
	
	/**
	 * Devuelve una lista de DTUsuario con la informacion de todos los usuarios registrados en el sistema ordenados segun su cedula.
	 * Si no hay usuarios registrados devuelve una lista vacia.
	 */
	public List<DTUsuario> obtenerListaUsuarios() {
		List<DTUsuario> out = new ArrayList<DTUsuario>();
		for (Map.Entry<String, Usuario> entry : coleccionUsuarios.entrySet()) {
			System.out.print("llegue a manejador");
			out.add(entry.getValue().toDataType());
		}
		Collections.sort(out, new Comparator<DTUsuario>() {
			@Override
			public int compare(DTUsuario usuario1, DTUsuario usuario2) {
				int comparacionNombre = usuario1.getNombre().compareTo(usuario2.getNombre());
				if (comparacionNombre == 0) {
					return usuario1.getApellido().compareTo(usuario2.getApellido());
				}
				return comparacionNombre;
			}
		});
		return out;
	}
	

}
