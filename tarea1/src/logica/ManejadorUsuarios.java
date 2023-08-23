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
	 */
	void altaEmpresa(String nickname, String nombre, String apellido, String email, String nombreEmpresa, String descripcion, String linkWeb) {
		coleccionUsuarios.put(nickname.toLowerCase(), new Empresa(nickname, nombre, apellido, email, nombreEmpresa, descripcion, linkWeb));
	}
	
	/**
	 * Crea el postulante y lo agrega a coleccionUsuarios.
	 */
	void altaPostulante(String nickname, String nombre, String apellido, String email, String fechaNacimiento, String nacionalidad) {
		coleccionUsuarios.put(nickname.toLowerCase(), new Postulante(nickname, nombre, apellido, email, fechaNacimiento, nacionalidad));
	}

	/**
	 * Devuelve un DTUsuario con los datos del usuario con el nickname dado. Si es una empresa tambien devuelve sus ofertas y si es un postulante tambien devuelve sus postulaciones.
	 * Si el nickname no existe en el sistema tira un NicknameNoExisteException.
	 * Si el nickname es NULL tira una unchecked exception.
	 */
	DTUsuario obtenerUsuario(String nickname) throws NicknameNoExisteException {
		String nicknameLowerCase = nickname.toLowerCase();
		if ( coleccionUsuarios.containsKey(nicknameLowerCase) ) {
			return coleccionUsuarios.get(nicknameLowerCase).toDataType();
		} else {
			throw new NicknameNoExisteException("El usuario con el nickname " + nickname + " no existe.");
		}
	}
	
	/**
	 * Devuelve una lista de DTUsuario con la informacion de todos los usuarios registrados en el sistema ordenados segun su cedula.
	 * Si no hay usuarios registrados devuelve una lista vacia.
	 */
	List<DTUsuario> obtenerListaUsuarios() {
		List<DTUsuario> out = new ArrayList<DTUsuario>();
		for (Map.Entry<String, Usuario> entry : coleccionUsuarios.entrySet()) {
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
