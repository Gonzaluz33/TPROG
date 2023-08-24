package logica;

import excepciones.KeywordExisteException;

public class ControladorOfertas implements IControladorOfertas{
	
	private static ControladorOfertas instancia; 
	
	public static ControladorOfertas getInstance() {
        if (instancia == null) {
            instancia = new ControladorOfertas();
        }
        return instancia;
    }
	
	public void altaKeyword(String nombre) throws KeywordExisteException {
		Keyword key = new Keyword(nombre);
		ManejadorOfertaLaboral mOL = ManejadorOfertaLaboral.getInstance();
		mOL.addKeyword(key);
	}
}
