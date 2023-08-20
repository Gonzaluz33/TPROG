package logica;

import java.util.TreeMap;

public class ManejadorUsuarios {

	private TreeMap<String, Usuario> coleccionUsuarios;
	private static ManejadorUsuarios instancia;
	
	public static ManejadorUsuarios getInstance() {
        if (instancia == null) {
            instancia = new ManejadorUsuarios();
        }
        return instancia;
    }

}
