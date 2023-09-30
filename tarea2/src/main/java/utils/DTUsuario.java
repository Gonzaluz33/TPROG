package utils;

/**
 * Datatype para transportar la información de un usuario entre capa lógica y de presentación.
 * Clase padre de DTEmpresa y DTPostulante.
 *
 */
public class DTUsuario {
	private int id;
	private String nickname;
    private String nombre;
    private String apellido;
    private String correo;
    private String password;
    

    // constructores
    public DTUsuario() {
    	this.setNickname(new String());
        this.setNombre(new String());
        this.setApellido(new String());
        this.setCorreo(new String());
        this.setPassword(new String());
    }

    public DTUsuario(String nickname, String nombre, String apellido, String correo, String password) {
    	this.setNickname(nickname);
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setCorreo(correo);
        this.setPassword(password);
    }

    // getters
    public String getNickname() {
        return nickname;
    }
    public int getId() {
        return id;
    }
    public String getPassword() {
        return password;
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
    
    public String toString(){
        return nombre + " " + apellido;
    }

    // setters
    private void setNickname(String nickname) {
        this.nickname = nickname;
    }
    
    private void setId(int id) {
        this.id = id;
    }
    private void setPassword(String password) {
        this.password = password;
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

}
