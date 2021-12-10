/*
 * clases que me recibiran y enviaran los datos o las consultas generadas de los empleados del aplicativo
 * Realizara la extraccion y envio de resultados de base de datos para mostrar en la aplicacion
 * @author JULIAN BARON
 */

package Constructor;

//Clase que me almacenara los constructores de datos 
public class Con_empleados1 {
    
    /*
     * @param Nombre_emp Recolecta el nombre del empleado 
     * @param Apellido_emp Recolecta el apellido del empleado
     * @param Correo_emp Recolecta el correo del empleado
     * @param Telefono_emp recolecta el telefono de la empleado.
     * @param Cedula recolceta la cedula de la empleado
     * @param Cod_emp recolecta el codigo que se le da al empleado
    */
    
    private String Cedula;
    private String Nombre_emp;
    private String Apellido_emp;
    private String Telefono_emp;
    private String Correo_emp;
    private String Cod_emp;

   /*
    * Clase vacia para crear una instancia entre modelos
    */
    
    public Con_empleados1() {
    }
    
    /*
     * Crea una clase donde se estableceran todas las variables necesarias para la recolecion de datos 
     */
    
    public Con_empleados1(String Cedula, String Nombre_emp, String Apellido_emp, String Telefono_emp, String Correo_emp, String Cod_emp) {
        this.Cedula = Cedula;
        this.Nombre_emp = Nombre_emp;
        this.Apellido_emp = Apellido_emp;
        this.Telefono_emp = Telefono_emp;
        this.Correo_emp = Correo_emp;
        this.Cod_emp = Cod_emp;
    }

    /*
     * Crea una clase donde se estableceran todas las variables necesarias para la recolecion de datos 
     */
    
    public Con_empleados1(String Cedula) {
        this.Cedula = Cedula;
    }
    
    /*
     * Recolecta el dato de el parametro asignado 
     */
    
    public String getCedula() {
        return Cedula;
    }

    /*
     * Devuelve el dato de el parametro asignado 
     */
    
    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }

    /*
     * Recolecta el dato de el parametro asignado 
     */
    
    public String getNombre_emp() {
        return Nombre_emp;
    }

    /*
     * Devuelve el dato de el parametro asignado 
     */
    
    public void setNombre_emp(String Nombre_emp) {
        this.Nombre_emp = Nombre_emp;
    }

    /*
     * Recolecta el dato de el parametro asignado 
     */
    
    public String getApellido_emp() {
        return Apellido_emp;
    }

    /*
     * Devuelve el dato de el parametro asignado 
     */
    
    public void setApellido_emp(String Apellido_emp) {
        this.Apellido_emp = Apellido_emp;
    }

    /*
     * Recolecta el dato de el parametro asignado 
     */
    public String getTelefono_emp() {
        return Telefono_emp;
    }
    
    /*
     * Devuelve el dato de el parametro asignado 
     */

    public void setTelefono_emp(String Telefono_emp) {
        this.Telefono_emp = Telefono_emp;
    }
    /*
     * Recolecta el dato de el parametro asignado 
     */
    
    public String getCorreo_emp() {
        return Correo_emp;
    }
    
    /*
     * Devuelve el dato de el parametro asignado 
     */

    public void setCorreo_emp(String Correo_emp) {
        this.Correo_emp = Correo_emp;
    }

    /*
     * Recolecta el dato de el parametro asignado 
     */
    
    public String getCod_emp() {
        return Cod_emp;
    }
    /*
     * Devuelve el dato de el parametro asignado 
     */

    public void setCod_emp(String Cod_emp) {
        this.Cod_emp = Cod_emp;
    }
    
    
}
