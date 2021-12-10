/*
 * clases que me recibiran y enviaran los datos o los datos del aplicativo
 * Realizara la extraccion y envio de resultados de base de datos para mostrar en la aplicacion
 * @author JULIAN BARON
 */
package Constructor;

//Clase principal ppara actualiar los datos
public class Con_actualizarDatos {
    
    /*
     * @param nombre Recolecta el nombre del usuario 
     * @param apellido Recolecta el apellido del usuario
     * @param correo Recolecta el correo del usuario
     * @param direccion recolecta la direccion del usuario para hacer el domicilio
     * @param telefono recolecta el telefono de la persona.
     * @param telefonoo recolecta el telefono de la persona para registrar los datos
     * @param nombre_usu recolecta el nombre de usuario que la persona va a tener
     * @param password recolecta al contraseña de la persona para acceder al aplicativo
     * @param sexo recolecta el sexo de la persona
     * @param cedula recolceta la cedula de la persona
     * @param cedulaa recolecta la cedula para actualizar el usuario
     * @param @rol recolecta que rol va a eercer en el aplicativo    
    */
    

    private String nombres;
    private String apellidos;
    private String correo;
    private String direccion;
    private String telefono;
    private String telefonoo;
    private String nombre_usu;
    private String password;
    private String sexo;
    private int cedula;
    private String Cedulaa;
    private String rol;
    
    
    /*
     * Clase vacia para crear una instancia entre modelos con la clase Con_actualizar
    */
    
    public Con_actualizarDatos() {
    }
     /*
     * Crea una clase donde se estableceran todas las variables necesarias para la recolecion de datos 
     */
    
    public Con_actualizarDatos(String Cedulaa) {
        this.Cedulaa = Cedulaa;
    }
    
    /*
     * Obtiene  el dato del paramaetro del constructor
     */

    public String getCedulaa() {
        return Cedulaa;
    }
   /*
    * Crea una clase donde se estableceran todas las variables necesarias para la recolecion de datos 
    */
    
    public Con_actualizarDatos(String nombres, String apellidos, String correo, String direccion, String telefonoo, String nombre_usu, String password, String sexo, int cedula, String Cedulaa, String rol) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.direccion = direccion;
        this.telefonoo = telefonoo;
        this.nombre_usu = nombre_usu;
        this.password = password;
        this.sexo = sexo;
        this.cedula = cedula;
        this.Cedulaa = Cedulaa;
        this.rol = rol;
    }
    
    /*
     * Crea una clase donde se estableceran todas las variables necesarias para la recolecion de datos 
     */
    
    public Con_actualizarDatos(String nombres, String apellidos, String correo, String direccion, String telefono, String nombre_usu, String password, String sexo, int cedula) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.direccion = direccion;
        this.telefono = telefono;
        this.nombre_usu = nombre_usu;
        this.password = password;
        this.sexo = sexo;
        this.cedula = cedula;
    }
    
   
    
    /*
     * Envia el dato del parametro al constructor
    */

    public void setCedulaa(String Cedulaa) {
        this.Cedulaa = Cedulaa;
    }

    /*
     * Obtiene  el dato del paramaetro del constructor
     */
    
    public String getTelefonoo() {
        return telefonoo;
    }
    
    
    /*
     * Envia el dato del parametro al constructor
     */
    
    public void setTelefonoo(String telefonoo) {
        this.telefonoo = telefonoo;
    }
    
    /*
     * Obtiene  el dato del paramaetro del constructor
     */
    
    public String getRol() {
        return rol;
    }
    
    /*
     * Envia el dato del parametro al constructor
     */
        
    public void setRol(String rol) {
        this.rol = rol;
    }
    
    
    /*
     * Obtiene el dato del parametro del constructor
    */
    
    public String getNombres() {
        return nombres;
    }
    
    /*
     * Envia el dato del parametro al constructor
    */
    
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
   
    /*
     * Obtiene el dato del parametro del constructor
    */
    
    public String getApellidos() {
        return apellidos;
    }
    
     /*
     * Envia el dato del parametro al constructor
    */
    
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    
    /*
     * Obtiene el dato del parametro del constructor
     */
    
    
    public String getCorreo() {
        return correo;
    }

    /*
     * Envia el dato del parametro al constructor
     */
    
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    
    /*
     * Obtiene el dato del parametro del constructor
     */
    
    public String getDireccion() {
        return direccion;
    }

    /*
     * Envia el dato del parametro al constructor
     */
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    /*
     * Obtiene el dato del parametro del constructor
     */
    
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /*
     * Obtiene el dato del parametro del constructor
     */
    
    public String getNombre_usu() {
        return nombre_usu;
    }

    /*
     * Envia el dato del parametro al constructor
     */
    
    public void setNombre_usu(String nombre_usu) {
        this.nombre_usu = nombre_usu;
    }

    /*
     * Obtiene el dato del parametro del constructor
     */
    
    public String getPassword() {
        return password;
    }

    /*
     * Envia el dato del parametro al constructor
     */
    
    public void setPassword(String password) {
        this.password = password;
    }

    /*
     * Obtiene el dato del parametro del constructor
     */
    
    public String getSexo() {
        return sexo;
    }

    /*
     * Envia el dato del parametro al constructor
     */
    
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getCedula() {
        return cedula;
    }

    /*
     * Envia el dato del parametro al constructor
     */
    
    public void setCedula(int cedula) {
        this.cedula = cedula;
    }
    
    
    
    
}
