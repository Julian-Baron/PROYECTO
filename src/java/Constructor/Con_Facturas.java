/*
 * clases que me recibiran y enviaran los datos o las consultas generadas de las Facturas  del aplicativo
 * Realizara la extraccion y envio de resultados de base de datos para mostrar en la aplicacion
 * @author JULIAN BARON
 */

package Constructor;

//Clase principal de las facturas
public class Con_Facturas {
    
    /*
     * @param id_factura recolecta el id de la factura generada en la base de datos
     * @oaram fecha_fac recolecta la fecha generada de la factura
     * @param status recolecta la informacion de la factura, si esta activa o no
     * @param token recolecta la informacion de el token para relacionarla con el domicilio que se generara
     * @param total recolecta la cantidad total del precio a pagar.
     * @param cedula de la persona que se genero la factura
    */
    
    private int id_factura;
    private String fecha_fac;
    private String status;
    private String token;
    private double total;
    private String cedula;
    
    /*
     * Clase vacia para crear una instancia entre modelos con la clase Con_compra
    */
    
    public Con_Facturas() {
    }
    
    /*
     * Recibe los parametros enviados desde el servelet de facturas a procesar
     */
    
    public Con_Facturas(String token) {
        this.token = token;
    }

    /*
     * Crea una clase donde se estableceran todas las variables necesarias para la recolecion de datos 
     */
    
    public Con_Facturas(int id_factura, String fecha_fac,String cedula) {
        this.id_factura = id_factura;
        this.cedula = cedula;      
    
}   
    /*
     * Crea una clase donde se estableceran todas las variables necesarias para la recolecion de datos 
     */
    
    public Con_Facturas(int id_factura, String fecha_fac, String status, String token, double total) {
        this.id_factura = id_factura;
        this.fecha_fac = fecha_fac;
        this.status = status;
        this.token = token;
        this.total = total;
    }
    
    /*
     * Crea una clase donde se estableceran todas las variables necesarias para la recolecion de datos 
     */
    
    public Con_Facturas(int id_factura, String fecha_fac, String status, String token, double total, String cedula) {
        this.id_factura = id_factura;
        this.fecha_fac = fecha_fac;
        this.status = status;
        this.token = token;
        this.total = total;
        this.cedula = cedula;
    }
    
    /*
     * Crea una clase donde se estableceran todas las variables necesarias para la recolecion de datos 
     */
    
    public Con_Facturas(String fecha_fac, int id_factura) {
        this.fecha_fac = fecha_fac;
        this.id_factura = id_factura;
    }
    
    /*
     * obtiene el dato recibido de la cedula de la persona que genera la factura
     *
     */
    
    public String getCedula() {
        return cedula;
    }
    
    /*
     * Envia el dato enviado de la cedula de la persona que genera la factura
     *
     */

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    
    /*
     * Envia el precio total enviado de la persona que genera la factura
     *
     */
    
    public double getTotal() {
        return total;
    }
    /*
    * Recibe el precio total enviado de la persona que genera la factura
    */
    public void setTotal(double total) {
        this.total = total;
    }
    
    
    /*
     * Envia el token generado de la  persona que genera la factura
     *
     */
    public String getToken() {
        return token;
    }
    
    /*
     * Recibe el token generado de la  persona que genera la factura
     *
     */
    
    public void setToken(String token) {
        this.token = token;
    }
    
    /*
     * Envia el estado generado de la factura para realiar verificar si se realiza el domicilio
     *
     */
    
    public String getStatus() {
        return status;
    }
    /*
     * Recibe el estado generado de la factura para realiar verificar si se realiza el domicilio
     *
     */
    public void setStatus(String status) {
        this.status = status;
    }
    /*
     * Envia la fecha generado de la factura
     *
     */

    public String getFecha_fac() {
        return fecha_fac;
    }
    
    /*
     * Recibe la fecha generado de la factura
     *
     */
    
    public void setFecha_fac(String fecha_fac) {
        this.fecha_fac = fecha_fac;
    }
    /*
     * Envia el id de la factura generada
     *
     */
    public int getId_factura() {
        return id_factura;
    }

    /*
     * Recibe el id de la factura generada
     *
     */
    
    public void setId_factura(int id_factura) {
        this.id_factura = id_factura;
    }
    
    
    
    
}
