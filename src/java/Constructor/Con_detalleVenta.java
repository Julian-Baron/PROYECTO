/*
 * clases que me recibiran y enviaran los datos o las consultas generadas de los articulos y detalle de venta del aplicativo
 * Realizara la extraccion y envio de resultados de base de datos para mostrar en la aplicacion
 * @author JULIAN BARON
 */

package Constructor;
import java.sql.Timestamp;


//Clase que me almacenara los constructores de datos 
public class Con_detalleVenta {
    
   /*
    * @param id_factura recolecta el id de la factura de la venta asignada por el aplicativo
    * @param fecha_fac fecha de la generacion de la factura
    * @param cedula recolecta la cedula de la persona  que genero el domicilio
    * @param id_compra recolecta el id asignado de la compra que se genero
    * @param cod_domicilio genera el codigo del domicilio
    */
    
    private int id_factura;
    private Timestamp fecha_fac;
    private String cedula;
    private String id_compra;
    private String cod_domicilio;

   /*
    * Clase vacia para crear una instancia entre modelos
    */
    
    public Con_detalleVenta() {
    }
    
    /*
     * Recolecta el dato de el parametro asignado 
     */
    
    public int getId_factura() {
        return id_factura;
    }

    /*
     * Crea una clase donde se estableceran todas las variables necesarias para la recolecion de datos 
     */
    
    public Con_detalleVenta(int id_factura) {
        this.id_factura = id_factura;
    }
    
    /*
     * Crea una clase donde se estableceran todas las variables necesarias para la recolecion de datos 
     */

    public Con_detalleVenta(int id_factura, Timestamp fecha_fac, String cedula, String id_compra, String cod_domicilio) {
        this.id_factura = id_factura;
        this.fecha_fac = fecha_fac;
        this.cedula = cedula;
        this.id_compra = id_compra;
        this.cod_domicilio = cod_domicilio;
    }
    
    /*
     * Devuelve el dato de el parametro asignado 
     */
    
    public void setId_factura(int id_factura) {
        this.id_factura = id_factura;
    }
    
    /*
     * Recolecta el dato de el parametro asignado 
     */
    
    public Timestamp getFecha_fac() {
        return fecha_fac;
    }

    /*
     * Devuelve el dato de el parametro asignado 
     */
    
    public void setFecha_fac(Timestamp fecha_fac) {
        this.fecha_fac = fecha_fac;
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

    public String getId_compra() {
        return id_compra;
    }

    /*
     * Devuelve el dato de el parametro asignado 
     */
    
    public void setId_compra(String id_compra) {
        this.id_compra = id_compra;
    }

    /*
     * Recolecta el dato de el parametro asignado 
     */
    
    public String getCod_domicilio() {
        return cod_domicilio;
    }
    
    /*
     * Devuelve el dato de el parametro asignado 
     */

    public void setCod_domicilio(String cod_domicilio) {
        this.cod_domicilio = cod_domicilio;
    }
    
    
}
