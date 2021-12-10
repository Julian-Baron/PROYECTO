/*
 * clases que me recibiran y enviaran los datos o las consultas generadas de los productos del aplicativo
 * Realizara la extraccion y envio de resultados de base de datos para mostrar en la aplicacion
 * @author JULIAN BARON
 */
package Constructor;


/*
 * @param cod_pro recolecta el codigo del producto 
 * @param descripcion recolecta como es la descripcion del producto
 * @param disponibles recolecta cual es la disponibilidad de productos que se encuentrasn el aplicativo
 * @param marca recolecta la marca de los productos
 * @param nombre_pro recolecta el nombre del producto
 * @param precio recolecta el precio del producto
 * @param img recolecta como es la imagen del producto
 */
public class Con_productos {

    /*
     * @param cod_pro recolecta el codigo del producto 
     * @param descripcion recolecta como es la descripcion del producto
     * @param disponibles recolecta cual es la disponibilidad de productos que se encuentrasn el aplicativo
     * @param marca recolecta la marca de los productos
     * @param nombre_pro recolecta el nombre del producto
     * @param precio recolecta el precio del producto
     * @param img recolecta como es la imagen del producto
     */
    private String cod_pro;
    private String descripcion;
    private int disponibles;
    private String marca;
    private String nombre_pro;
    private int precio;
    private String img;

    /*
     * Clase vacia para crear una instancia entre modelos
     */
    public Con_productos() {
    }

    /*
     * Crea una clase donde se estableceran todas las variables necesarias para la recolecion de datos 
     */
    public Con_productos(String cod_pro, String descripcion, int disponibles, String marca, String nombre_pro, int precio) {
        this.cod_pro = cod_pro;
        this.descripcion = descripcion;
        this.disponibles = disponibles;
        this.marca = marca;
        this.nombre_pro = nombre_pro;
        this.precio = precio;
    }

    /*
     * Crea una clase donde se estableceran todas las variables necesarias para la recolecion de datos 
     */
    public Con_productos(String cod_pro, String descripcion, int disponibles, String marca, String nombre_pro, int precio, String img) {
        this.cod_pro = cod_pro;
        this.descripcion = descripcion;
        this.disponibles = disponibles;
        this.marca = marca;
        this.nombre_pro = nombre_pro;
        this.precio = precio;
        this.img = img;
    }

    /*
     * Recolecta el dato de el parametro asignado en este caso la imagen 
     */
    public String getImg() {
        return img;
    }

    /*
     * Devuelve el dato de el parametro asignado 
     */
    public void setImg(String img) {
        this.img = img;
    }

    /*
     * Recolecta el dato de el parametro asignado 
     */
    public Con_productos(String cod_pro) {
        this.cod_pro = cod_pro;
    }

    /*
     * Devuelve el dato de el parametro asignado 
     */
    public String getCod_pro() {
        return cod_pro;
    }

    /*
     * Recolecta el dato de el parametro asignado 
     */
    public void setCod_pro(String cod_pro) {
        this.cod_pro = cod_pro;
    }

    /*
     * Devuelve el dato de el parametro asignado 
     */
    public String getDescripcion() {
        return descripcion;
    }

    /*
     * Recolecta el dato de el parametro asignado 
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /*
     * Devuelve el dato de el parametro asignado 
     */
    public int getDisponibles() {
        return disponibles;
    }

    /*
     * Recolecta el dato de el parametro asignado 
     */
    public void setDisponibles(int disponibles) {
        this.disponibles = disponibles;
    }
    /*
     * Recolecta el dato de el parametro asignado 
     */
    public String getMarca() {
        return marca;
    }

    /*
     * Devuelve el dato de el parametro asignado 
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /*
     * Recolecta el dato de el parametro asignado 
     */
    
    public String getNombre_pro() {
        return nombre_pro;
    }
    /*
     * Devuelve el dato de el parametro asignado 
     */
    
    public void setNombre_pro(String nombre_pro) {
        this.nombre_pro = nombre_pro;
    }

    /*
     * Recolecta el dato de el parametro asignado 
     */

    public int getPrecio() {
        return precio;
    }

        /*
     * Devuelve el dato de el parametro asignado 
     */
    public void setPrecio(int precio) {
        this.precio = precio;
    }

}
