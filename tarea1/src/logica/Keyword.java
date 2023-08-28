package logica;

public class Keyword {
	private String nombre;
	
	public Keyword() {
		this.setNombre(new String());
	}
	
	public Keyword(String nombre) {
		this.setNombre(nombre);
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String n) {
		this.nombre=n;
	}
}
