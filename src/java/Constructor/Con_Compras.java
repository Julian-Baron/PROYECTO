/*
 * clases que me recibiran y enviaran los datos o las consultas generadas de las compras  del aplicativo
 * Realizara la extraccion y envio de resultados de base de datos para mostrar en la aplicacion
 * @author JULIAN BARON
 */


package Constructor;

//Clase principal de las compras
public class Con_Compras {
    
    /*
     * @param Cedula Recolecta y envia la cedula de quien realizo la compra
     * @param cod_pro Recolecta y envia el codigo de los  productos generados con la compra
     * @param cantidad Recolecta la cantidad de existencia de las compras del producto
     * @param id_compra  Recolecta y envia el codigo de la compra generada 
    */
    
    private String Cedula;
    private String cod_pro;
    private int cantidad;
    private String id_compra;
    
    /*
     * Clase vacia para crear una instancia entre modelos con la clase Con_compra
    */
    public Con_Compras() {
    }
    
    /*
     * Recibe los parametros enviados desde el servelet de compras a procesar
     */
    
    public Con_Compras(String id_compra) {
        this.id_compra = id_compra;
    }
       
    /*
     * Crea una clase donde se estableceran todas las variables necesarias para la recolecion de datos 
     */
    
    public Con_Compras(String Cedula, String cod_pro, int cantidad, String id_compra) {
        this.Cedula = Cedula;
        this.cod_pro = cod_pro;
        this.cantidad = cantidad;
        this.id_compra = id_compra;
    }

    /*
     * obtiene el dato enviado de la compra
     */
    
    public String getCedula() {
        return Cedula;
    }
    
    /*
     * Envia el dato recibido de la cedula
     */
    
    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }
    
    /*
     * obtiene el dato enviado del producto
     */
    public String getCod_pro() {
        return cod_pro;
    }
    
    /*
     * Envia el dato recibido del codigo del producto
     */
    
    public void setCod_pro(String cod_pro) {
        this.cod_pro = cod_pro;
    }
    
    /*
     * Obtiene la cantidad de producto que el cliente ha elegido
     */
    public int getCantidad() {
        return cantidad;
    }
    /*
     * Envia el dato recibido de la cantidad total del pedido del producto
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /*
     * obtiene el id de la compra realizada como dato 
     */
    public String getId_compra() {
        return id_compra;
    }
    /*
     * Envia el dato recibido del id de la compra
    */
    public void setId_compra(String id_compra) {
        this.id_compra = id_compra;
    }
    
    
}
