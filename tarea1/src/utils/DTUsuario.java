package utils;

/**
 * Datatype para transportar la información de un usuario entre capa lógica y de presentación.
 * Clase padre de DTEmpresa y DTPostulante.
 *
 */
public class DTUsuario {

	private String nickname;
    private String nombre;
    private String apellido;
    private String correo;
    private String contraseña;

    // constructores
    public DTUsuario() {
    	this.setNickname(new String());
        this.setNombre(new String());
        this.setApellido(new String());
        this.setCorreo(new String());
        this.setContraseña(new String());
    }

    public DTUsuario(String nickname, String nombre, String apellido, String correo, String contraseña) {
    	this.setNickname(nickname);
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setCorreo(correo);
        this.setContraseña(contraseña);
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
    
    public String getContraseña() {
        return contraseña;
    }

    public String toString(){
        return nombre + " " + apellido;
    }

    // setters
    private void setNickname(String nickname) {
        this.nickname = nickname;
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
