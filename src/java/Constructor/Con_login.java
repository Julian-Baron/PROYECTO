/*
 * clases que me recibiran y enviaran los datos o las consultas generadas de los articulos del aplicativo
 * Realizara la extraccion y envio de resultados de base de datos para mostrar en la aplicacion
 * @author JULIAN BARON
 */
package Constructor;


public class Con_login {
    /*
     * @param cedula recolectara la cedula del usuario
     * @param nombre_usu recolectara el nombre de usuario del cliente
     * @param contraseña recolecta la contraseña dada por el usuario
     * @param sexo recolecta el genero de la persona
    */
    
    private String cedula;
    private String nombre_usu;
    private String contraseña;
    private String rol;
    private String sexo;
    
    /*
     *Variables de la tabla usuarios
     */
    private String nombre_cliente;
    /*
     *Constructores
    */
    public Con_login() {
    }
    
    /*
     * Crea una clase donde se estableceran todas las variables necesarias para la recolecion de datos 
     */
    
    public Con_login(String nombre_usu, String contraseña) {
        this.nombre_usu = nombre_usu;
        this.contraseña = contraseña;
    }
    
    /*
     * Crea una clase donde se estableceran todas las variables necesarias para la recolecion de datos 
     */
    
    public Con_login(String Cedula, String nombre_usu, String contraseña, String rol, String sexo, String nombre_cliente) {
        this.cedula = Cedula;
        this.nombre_usu = nombre_usu;
        this.contraseña = contraseña;
        this.rol = rol;
        this.sexo = sexo;
        this.nombre_cliente = nombre_cliente;
    }
    
    
    
    /*
     *Getters an Setters
     */
    
    /*
     * Recolecta el dato de el parametro asignado 
     */
    public String getCedula() {
        return cedula;
    }
    
    /*
     * Devuelve el dato de el parametro asignado 
     */
    
    public void setCedula(String Cedula) {
        this.cedula = Cedula;
    }

    /*
     * Recolecta el dato de el parametro asignado 
     */
    
    public String getNombre_usu() {
        return nombre_usu;
    }

    /*
     * Devuelve el dato de el parametro asignado 
     */
    
    public void setNombre_usu(String nombre_usu) {
        this.nombre_usu = nombre_usu;
    }

    /*
     * Recolecta el dato de el parametro asignado 
     */
    
    public String getContraseña() {
        return contraseña;
    }
    
    /*
     * Devuelve el dato de el parametro asignado 
     */

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    /*
     * Recolecta el dato de el parametro asignado 
     */
    
    public String getRol() {
        return rol;
    }
    
    /*
     * Devuelve el dato de el parametro asignado 
     */

    public void setRol(String rol) {
        this.rol = rol;
    }

    /*
     * Recolecta el dato de el parametro asignado 
     */
    
    public String getSexo() {
        return sexo;
    }

    /*
     * Devuelve el dato de el parametro asignado 
     */
    
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /*
     * Recolecta el dato de el parametro asignado 
     */
    
    public String getNombre_cliente() {
        return nombre_cliente;
    }

    /*
     * Devuelve el dato de el parametro asignado 
     */
    
    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }
    
    
    
    
}
