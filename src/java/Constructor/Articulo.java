/*
 * clases que me recibiran y enviaran los datos o las consultas generadas de los articulos del aplicativo
 * Realizara la extraccion y envio de resultados de base de datos para mostrar en la aplicacion
 * @author JULIAN BARON
 */

package Constructor;

//Clase principal del articulo
public class Articulo {
    
    
    /*
     * @param idProducto Recolecta y envia el id del producto
     * @param name Recolecta y envia el nombre del producto
     * @param cantidad Recolecta la cantidad de existencia del producto
     * @param precio  Recolecta y envia el precio delos productos
    */
    
    private String idProducto;
    private String name;
    private int cantidad;
    private int precio;
    
    /*
     * Clase vacia para crear una instancia entre modelos
    */
    public Articulo() {
    }
    
    /*
     * Recibe los parametros enviados desde el servelet de artiuclos a procesar
    */
    public Articulo(String idProducto, int cantidad) {
        this.idProducto = idProducto;
        this.cantidad = cantidad;
    }
    
    /*
     * Recibe los parametros enviados desde el servelet de artiuclos a procesar
    */
    
    public Articulo(String idProducto, String name, int cantidad, int precio) {
        this.idProducto = idProducto;
        this.name = name;
        this.cantidad = cantidad;
        this.precio = precio;
    }
    
    /*
     * obtiene el dato enviado del id del producto
    */
    
    public String getIdProducto() {
        return idProducto;
    }

    /*
     * Envia  el dato recibido del id del producto
    */
    
    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }
    
     /*
      * obtiene el dato enviado del nombre del producto
      */
    
    public String getName() {
        return name;
    }
    
    /*
     * Envia  el dato recibido del nombre del producto
     */    
    
    public void setName(String name) {
        this.name = name;
    }
    
     /*
      * obtiene el dato enviado del nombre del producto
      */
    
    public int getCantidad() {
        return cantidad;
    }
    
    /*
     * Envia  el dato recibido del nombre del producto
     */ 
    
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    /*
     * obtiene el dato enviado del precio del producto
     */
    public int getPrecio() {
        return precio;
    }
    
    /*
     * Envia  el dato recibido del precio del producto
     */
    
    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
    
}
