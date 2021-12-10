/*
 * clases que me recibiran y enviaran los datos o las consultas generadas de la venta generada por medio  del aplicativo
 * Realizara la extraccion y envio de resultados de base de datos para mostrar en la aplicacion
 * @author JULIAN BARON
 */
package Constructor;

//Clase que me almacenara los constructores de datos 
public class Con_venta {

    /*
     * @param cod_pro recolecta el codigo del producto 
     * @param id_compra recolecta el id de la compra que se haya generado 
     * @param descripcion recolecta como es la descripcion del producto
     * @param cantidad recolecta la cantidad de un producto solicitado
     * @param nombre recolecta el nombre del producto
     * @param precio recolecta el precio del producto
     * @param cedula recolecta como es la cedula de la persona
     */
    private String id_compra;
    private String cod_pro;
    private String nombre;
    private String Descripcion;
    private int cantidad;
    private String cedula;
    private String precio;


    /*
     * Clase vacia para crear una instancia entre modelos
     */
    public Con_venta() {

    }

    /*
     * Crea una clase donde se estableceran todas las variables necesarias para la recolecion de datos 
     */
    public Con_venta(String id_compra, String cod_pro, int cantidad, String cedula) {
        this.id_compra = id_compra;
        this.cod_pro = cod_pro;
        this.cantidad = cantidad;
        this.cedula = cedula;
    }

    /*
     * Crea una clase donde se estableceran todas las variables necesarias para la recolecion de datos 
     */
    public Con_venta(String id_compra, String cod_pro, String nombre, String Descripcion, int cantidad, String cedula, String precio) {
        this.id_compra = id_compra;
        this.cod_pro = cod_pro;
        this.nombre = nombre;
        this.Descripcion = Descripcion;
        this.cantidad = cantidad;
        this.cedula = cedula;
        this.precio = precio;
    }

    /*
     * Recolecta el dato de el parametro asignado 
     */
    public String getNombre() {
        return nombre;
    }

    /*
     * Devuelve el dato de el parametro asignado 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /*
     * Recolecta el dato de el parametro asignado 
     */
    public String getDescripcion() {
        return Descripcion;
    }

    /*
     * Devuelve el dato de el parametro asignado 
     */
    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    /*
     * Recolecta el dato de el parametro asignado 
     */
    public String getPrecio() {
        return precio;
    }

    /*
     * Devuelve el dato de el parametro asignado 
     */
    public void setPrecio(String precio) {
        this.precio = precio;
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
    public String getCod_pro() {
        return cod_pro;
    }

    /*
     * Devuelve el dato de el parametro asignado 
     */
    public void setCod_pro(String cod_pro) {
        this.cod_pro = cod_pro;
    }

    /*
     * Recolecta el dato de el parametro asignado 
     */
    public int getCantidad() {
        return cantidad;
    }

    /*
     * Devuelve el dato de el parametro asignado 
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
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

}
