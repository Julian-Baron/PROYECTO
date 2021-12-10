/*
 * clases que me recibiran y enviaran los datos o las consultas generadas de las compras  del aplicativo
 * Realizara la extraccion y envio de resultados de base de datos para mostrar en la aplicacion
 * @author JULIAN BARON
 */
package Constructor;

public class Con_Domicilios {
    /*
     * @param cedula Recibira la cedula de la persona que realizara el domicilio
     * @param Cod_domicilio Recibira el codigo de el domicilio
     * @oaram FechaPedido Verificara la frec
     * @param id_compra recibira la compra asignada al domicilio
    */
      
    private String Cedula;
    private String Cod_domicilio;
    private String FechaPedido;
    private String id_compra;
    
    /*
     * Clase vacia para crear una instancia entre modelos con la clase Con_compra
     */
    
    public Con_Domicilios() {
    }
    
    /*
     * Crea una clase donde se estableceran todas las variables necesarias para la recolecion de datos 
     */
    
    public Con_Domicilios(String Cedula, String id_compra) {
        this.Cedula = Cedula;
        this.id_compra = id_compra;
    }
    
    /*
     * Crea una clase donde se estableceran todas las variables necesarias para la recolecion de datos 
     */   
    
    public Con_Domicilios(String Cedula, String Cod_domicilio, String FechaPedido, String id_compra) {
        this.Cedula = Cedula;
        this.Cod_domicilio = Cod_domicilio;
        this.FechaPedido = FechaPedido;
        this.id_compra = id_compra;
    }
    /*
     * Recibe los daots de la cedula del empleado que generara el domicilio
    */
    public String getCedula() {
        return Cedula;
    }
    /*
     * Envia los daots de la cedula del empleado que generara el domicilio
    */
    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }
    /*
     * Recibe el Codigo generado  del domicilio
    */
    public String getCod_domicilio() {
        return Cod_domicilio;
    }
    /*
     * Envia el Codigo generado  del domicilio
    */
    
    public void setCod_domicilio(String Cod_domicilio) {
        this.Cod_domicilio = Cod_domicilio;
    }
    
    /*
     * Recibe la fecha de generacion  del domicilio
    */

    public String getFechaPedido() {
        return FechaPedido;
    }
    
    /*
     * Envia la fecha de generacion  del domicilio
    */
    public void setFechaPedido(String FechaPedido) {
        this.FechaPedido = FechaPedido;
    }

/*
     * Recibe el id de la compra   del domicilio
    */
        
    public String getId_compra() {
        return id_compra;
    }
    
    /*
     * Envia el id de la compra   del domicilio
    */
    
    public void setId_compra(String id_compra) {
        this.id_compra = id_compra;
    }
    
    
}
