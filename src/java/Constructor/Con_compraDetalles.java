/*
 * clases que me recibiran y enviaran los datos o las consultas generadas de los articulos del aplicativo
 * Realizara la extraccion y envio de resultados de base de datos para mostrar en la aplicacion
 * @author JULIAN BARON
 */
package Constructor;

//Clase que me almacenara los constructores de datos 
public class Con_compraDetalles {

    /*
    * @param id_compra almacenara la compra que se realizara
    * @param cod_pro almacenara cuales son los productos en la compra generada
    * @param cantidad almacenara la cantidad de los productos que se desean adquirir
    * @param cedula almacena la cedula del usuario.
    * @param token recolecta la informacion de el token para relacionarla con el domicilio que se generara
    * @param total recolecta la cantidad total de cada producto segun su cantidad.
    * @param suttotal recolecta la cantidad total del precio a pagar.
    * @param nombre recolecta el nombre de la persona que se va a pagar
     */
    private int id_compra;
    private String cod_pro;
    private int cantidad;
    private String cedula;
    private String token;
    private double subtotal;
    private double total;
    private String nombre;

    /*
     * Clase vacia para crear una instancia entre modelos
     */
    public Con_compraDetalles() {
    }

    /*
     * Crea una clase donde se estableceran todas las variables necesarias para la recolecion de datos 
     */
    public Con_compraDetalles(int id_compra, String token) {
        this.id_compra = id_compra;
        this.token = token;
    }

    /*
     * Crea una clase donde se estableceran todas las variables necesarias para la recolecion de datos 
     */
    public Con_compraDetalles(int id_compra, String cod_pro, int cantidad, String cedula, String token, double subtotal, double total) {
        this.id_compra = id_compra;
        this.cod_pro = cod_pro;
        this.cantidad = cantidad;
        this.cedula = cedula;
        this.token = token;
        this.subtotal = subtotal;
        this.total = total;
    }

    /*
     * Crea una clase donde se estableceran todas las variables necesarias para la recolecion de datos 
     */
    public Con_compraDetalles(int id_compra, String cod_pro, int cantidad, String cedula, String token, double subtotal, double total, String nombre) {
        this.id_compra = id_compra;
        this.cod_pro = cod_pro;
        this.cantidad = cantidad;
        this.cedula = cedula;
        this.token = token;
        this.subtotal = subtotal;
        this.total = total;
        this.nombre = nombre;
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
    public int getId_compra() {
        return id_compra;
    }

    /*
     * Devuelve el dato de el parametro asignado 
     */
    public void setId_compra(int id_compra) {
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

    /*
     * Recolecta el dato de el parametro asignado 
     */
    public String getToken() {
        return token;
    }

    /*
     * Devuelve el dato de el parametro asignado 
     */
    public void setToken(String token) {
        this.token = token;
    }

    /*
     * Recolecta el dato de el parametro asignado 
     */
    public double getSubtotal() {
        return subtotal;
    }

    /*
     * Devuelve el dato de el parametro asignado 
     */
    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    /*
     * Recolecta el dato de el parametro asignado 
     */
    public double getTotal() {
        return total;
    }

    /*
     * Devuelve el dato de el parametro asignado 
     */
    public void setTotal(double total) {
        this.total = total;
    }

}
