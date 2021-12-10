/*
 * clases que me recibiran y enviaran los datos o las  generadas de los articulos de la compra del aplicativo
 * Realizara la extraccion y envio de resultados de base de datos para mostrar en la aplicacion
 * @author JULIAN BARON
 */
package Constructor;


//Clase principal de el carrito de compras
public class Con_carrito {
    
    /*
     * @param item recolectara que producto se ha seleccionado
     * @param cod_pro recolecta el codigo del producto para el carrito de compras
     * @param Nombre recolecta el nombre del artiuclo
     * @param descripcion recolecta la descripcion del articulo
     * @param preciodecompra recolecta el precio de compra del articulo
     * @param subtotal recolecta el subotal de la susma de los precios de  todos los articulos
     */
    private int item;
    private String cod_pro;
    private String Nombre;
    private String descripcion;
    private int preciodecompra;
    private int cantidad;
    private double subtotal;
    
    /*
     * Clase vacia para crear una instancia entre modelos
     */
    
    public Con_carrito() {
    }

    /*
     * Crea una clase donde se estableceran todas las variables necesarias para la recolecion de datos 
     */
    
    public Con_carrito(int item, String cod_pro, String Nombre, String descripcion, int preciodecompra, int cantidad, double subtotal) {
        this.item = item;
        this.cod_pro = cod_pro;
        this.Nombre = Nombre;
        this.descripcion = descripcion;
        this.preciodecompra = preciodecompra;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }
    
    
    /*
     * Recolecta la informacion del codigo del producto
    */
    
    public String getCod_pro() {
        return cod_pro;
    }
    
    /*
     * Envia el parametro al constructor establecido
    */

    public void setCod_pro(String cod_pro) {
        this.cod_pro = cod_pro;
    }

    /*
     * Recolecta la informacion del codigo del numero del item
    */

    public int getItem() {
        return item;
    }
    /*
     * Envia el parametro al constructor establecido
    */
    
    public void setItem(int item) {
        this.item = item;
    }
    
    /*
     * Recolecta la informacion del codigo del nombre del articulo
     */
    public String getNombre() {
        return Nombre;
    }
    
    /*
     * Envia el parametro al constructor establecido
    */
    
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
    /*
     * Recolecta la informacion del codigo de la descripcion del articulo
     */
        
    public String getDescripcion() {
        return descripcion;
    }
    
    
    /*
     * Envia el parametro al constructor establecido
     */
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    /*
     * Recolecta la informacion del precio de compra del articulo
     */
    
    public int getPreciodecompra() {
        return preciodecompra;
    }

    
    /*
     * Envia el parametro al constructor establecido
     */
    
    public void setPreciodecompra(int preciodecompra) {
        this.preciodecompra = preciodecompra;
    }
    
    /*
     * Recolecta la informacion de la cantidad total de compras de un articulo articulo
     */
    
    public int getCantidad() {
        return cantidad;
    }
    
    
    /*
     * Envia el parametro al constructor establecido
     */
    
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    /*
     * Recolecta la informacion del subtotal de una compra en el carrito     */
    
    public double getSubtotal() {
        return subtotal;
    }
    
    
    /*
     * Envia el parametro al constructor establecido
     */
    
    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
    
    
    
}
