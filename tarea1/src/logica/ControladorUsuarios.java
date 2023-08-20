package logica;

public class ControladorUsuarios implements IControladorUsuario{
	
	private static ControladorUsuarios instancia; 
	
	public static ControladorUsuarios getInstance() {
        if (instancia == null) {
            instancia = new ControladorUsuarios();
        }
        return instancia;
    }
	
}
