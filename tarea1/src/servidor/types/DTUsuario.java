package servidor.types;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;


@XmlAccessorType(XmlAccessType.FIELD)
public class DTUsuario {

	private String nickname;
	private String nombre;
	private String apellido;
	private String correo;
	private String contraseña;
	private String url_imagen;

	// constructores
	public DTUsuario() {
		this.setNickname(new String());
		this.setNombre(new String());
		this.setApellido(new String());
		this.setCorreo(new String());
		this.setContraseña(new String());
		this.setUrlImagen(new String());
		;
	}

	public DTUsuario(String nickname, String nombre, String apellido, String correo, String contraseña,
			String url_imagen) {
		this.setNickname(nickname);
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setCorreo(correo);
		this.setContraseña(contraseña);
		this.setUrlImagen(url_imagen);
	}

	// getters
	public String getNickname() {
		return nickname;
	}

	public String getUrlImagen() {
		return url_imagen;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public String getContraseña() {
		return contraseña;
	}

	public String toString() {
		return nombre + " " + apellido;
	}

	// setters
	private void setNickname(String nickname) {
		this.nickname = nickname;
	}

	private void setUrlImagen(String url_imagen) {
		this.url_imagen = url_imagen;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	private void setApellido(String apellido) {
		this.apellido = apellido;
	}

	private void setCorreo(String correo) {
		this.correo = correo;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

}
