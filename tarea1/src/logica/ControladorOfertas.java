package logica;

public class ControladorOfertas implements IControladorOfertas{
	
	private static ControladorOfertas instancia; 
	
	public static ControladorOfertas getInstance() {
        if (instancia == null) {
            instancia = new ControladorOfertas();
        }
        return instancia;
    }
}
