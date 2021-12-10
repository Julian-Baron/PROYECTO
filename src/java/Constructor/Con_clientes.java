/*
 * clases que me recibiran y enviaran los datos o las consultas generadas de los articulos del aplicativo
 * Realizara la extraccion y envio de resultados de base de datos para mostrar en la aplicacion
 * @author JULIAN BARON
 */
package Constructor;



//Clase que me almacenara los constructores de datos de los clientes 
public class Con_clientes {
    /*
     * @param nombre Recolecta el nombre del cliente 
     * @param apellido Recolecta el apellido del cliente
     * @param correo Recolecta el correo del cliente
     * @param direccion recolecta la direccion del cliente para hacer el domicilio
     * @param telefono recolecta el telefono de la cliente.
     * @param cedula recolceta la cedula de la cliente
    
    */
    
    private String cedula;
    private String Nombre;
    private String Apellido;
    private String Correo;
    private String Direccion;
    private String Telefono;
    
   /*
    * Clase vacia para crear una instancia o conexion
    */
    
    public Con_clientes() {
    }
    
    /*
     * Crea una clase donde se estableceran todas las variables necesarias para la recolecion de datos solo con la cedula
     */
    
    public Con_clientes(String cedula) {
        this.cedula = cedula;
    }
    
    /*
     * Crea una clase donde se estableceran todas las variables necesarias para la recolecion de datos 
     */
    
    public Con_clientes(String cedula, String Nombre, String Apellido, String Correo, String Direccion, String Telefono) {
        this.cedula = cedula;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Correo = Correo;
        this.Direccion = Direccion;
        this.Telefono = Telefono;
    }

    /*
     * Recolecta el dato de el parametro asignado 
     */
    
    public String getCedula() {
        return cedula;
    }
    
    /*
     * Devuelve el dato de el parametro asignado 
     */
    
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    
    /*
     * Recolecta el dato de el parametro asignado 
     */
    
    public String getNombre() {
        return Nombre;
    }
    
    /*
     * Devuelve el dato de el parametro asignado 
     */
    
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
    /*
     * Recolecta el dato de el parametro asignado 
     */
    
    public String getApellido() {
        return Apellido;
    }
    
    /*
     * Devuelve el dato de el parametro asignado 
     */

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }
    
    /*
     * Recolecta el dato de el parametro asignado 
     */
    
    public String getCorreo() {
        return Correo;
    }
    
    /*
     * Devuelve el dato de el parametro asignado 
     */

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }
    
    /*
     * Recolecta el dato de el parametro asignado 
     */
    
    public String getDireccion() {
        return Direccion;
    }
    
    /*
     * Devuelve el dato de el parametro asignado 
     */

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }
    
    /*
     * Recolecta el dato de el parametro asignado 
     */
    
    public String getTelefono() {
        return Telefono;
    }
    
    /*
     * Devuelve el dato de el parametro asignado 
     */

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }
    
    
}
