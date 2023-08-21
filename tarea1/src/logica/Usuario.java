package logica;

import utils.DTUsuario;

/**
 * Representa al usuario en el sistema.
 * Clase padre de Empresa y Postulante.
 *
 */
public class Usuario {

	private String nickname; //unico
	private String nombre;
    private String apellido;
    private String correo; //unico

    // constructores
    public Usuario(String nickname, String nombre, String apellido, String correo) {
        this.nickname = nickname;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
    }

    // getters
    public String getNickname() {
        return nickname;
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

    // setters
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCedulaIdentidad(String correo) {
        this.correo = correo;
    }
    
    /**
     * Retorna los datos del usuario como un DataType DTUsuario.
     */
    DTUsuario toDataType() {
    	return new DTUsuario(getNickname(), getNombre(), getApellido(), getCorreo());
    }

}
