/*
 * Modelo controlador de compra y facturas para resultados de CRUD con respecto a las compras realizadas .
 * Realizara la extraccion de resultados de base de datos para mostrar en la aplicacion
 * @author JULIAN BARON
 */

package Modelos;
import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author JULIAN BARON
 */
public class Mod_compraFactura {
    
    /*
     * ACTUALMENTE VACIO PERO SIN MODIFICACION
     * NO GENERA CLASES NI FUNCIONES
     * NO SE REQUIERE ELIMINACION
     * Conexion que me realizara la sintaxis para la busqueda de datoe sen la base de datos
     */
    
    Conexion con=new Conexion();
    Connection cnn=con.conexionbd();
    
     /*
      * @param ps Prepara la sentencia a enviar en la base de datos
      * @param rs recolecta los datos de la base de datos
     */
    
    PreparedStatement ps=null;
    ResultSet rs=null;
    
    /*
     * Sin uso alguno.
    */
    
    public boolean insertar_compraFActura(){
        boolean flag=false;
        
        
        
        return flag;
    }
    
}
