/*
 * Clases que me recibiran y enviaran los datos o las consultas generadas de los usuario del aplicativo
 * Realizara la extraccion y envio de resultados de base de datos para mostrar en la aplicacion
 * @author JULIAN BARON
 */
package Constructor;

//Clase que me almacenara los constructores de datos 
public class Con_usuarios {

    /*
     * @param Cedula recolecta la cedula del usuario
     * @param Nombre_usu recolecta el nombre de usuario
     * @param Contraseña recolecta la contraseña del usuario
     * @param Rol recolecta el rol del usuario
     * @param Sexo recolecta el sexo del usuario
     */
    private String Cedula;
    private String Nombre_usu;
    private String Contraseña;
    private String Rol;
    private String Sexo;

    /*
     * Clase vacia para crear una instancia entre modelos
     */
    public Con_usuarios() {
    }
    
    /*
     * Crea una clase donde se estableceran todas las variables necesarias para la recolecion de datos 
     */
    
    public Con_usuarios(String Cedula, String Nombre_usu, String Contraseña, String Rol, String Sexo) {
        this.Cedula = Cedula;
        this.Nombre_usu = Nombre_usu;
        this.Contraseña = Contraseña;
        this.Rol = Rol;
        this.Sexo = Sexo;
    }

    /*
     * Recolecta el dato de el parametro asignado 
     */
    
    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }

    /*
     * Recolecta el dato de el parametro asignado 
     */
    
    public String getNombre_usu() {
        return Nombre_usu;
    }

    /*
     * Devuelve el dato de el parametro asignado 
     */
    
    public void setNombre_usu(String Nombre_usu) {
        this.Nombre_usu = Nombre_usu;
    }

    /*
     * Recolecta el dato de el parametro asignado 
     */
    
    public String getContraseña() {
        return Contraseña;
    }

    /*
     * Devuelve el dato de el parametro asignado 
     */
    
    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

    /*
     * Recolecta el dato de el parametro asignado 
     */
    
    public String getRol() {
        return Rol;
    }

    /*
     * Devuelve el dato de el parametro asignado 
     */
    
    public void setRol(String Rol) {
        this.Rol = Rol;
    }

    /*
     * Recolecta el dato de el parametro asignado 
     */
    
    public String getSexo() {
        return Sexo;
    }

    /*
     * Devuelve el dato de el parametro asignado 
     */
    
    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

}
