/*
 * Modelo controlador de compras de usuario para resultados de CRUD con respecto a los usuario en el aplicativo.
 * Realizara la extraccion de resultados de base de datos para mostrar en la aplicacion
 * @author JULIAN BARON
*/
package Modelos;
import Conexion.Conexion;
import Constructor.Con_Facturas;
import Constructor.Con_compraDetalles;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/*

import javax.swing.JOptionPane;

*/

public class Mod_misCompras {
    
    /*
     * Conexion que me realizara la sintaxis para la busqueda de datos en la base de datos
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
     * Extrae la cantidad de facturas generadas que estan disponibles en el aplicativo.
     * @param dat recolectara los datos de las facturas 
     * @param uss envia los datos recolectados al constructor Con_Facturas.
    */
    
    
    public ArrayList<Con_Facturas> ConsultarMisCompras(Con_Facturas us){  
        
        ArrayList<Con_Facturas> dat=new ArrayList<>();
        
        try {
            String sql="SELECT * FROM `factura` WHERE cedula='"+us.getCedula()+"'";
            ps=cnn.prepareStatement(sql);
            rs=ps.executeQuery();

            while(rs.next()){
                Con_Facturas uss=new Con_Facturas(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getDouble(5),rs.getString(6));
                dat.add(uss);
            }
        } 

        catch (SQLException ex) {
           Logger.getLogger(Modelo_Productos.class.getName()).log(Level.SEVERE, null, "Error" +ex);
        }
        
        return dat;
    }
    
    /*
     * Extrae la facturas generadas que estan disponibles en el aplicativo.
     * @param sql recolectara los datos de las facturas 
     * @param uss envia los datos recolectados al constructor Con_Facturas.
    */
    
    public ArrayList<Con_Facturas> consultarFactura(){  
        
        ArrayList<Con_Facturas> dat=new ArrayList<>();
        
        try {
            String sql="SELECT * FROM `factura` ";
            ps=cnn.prepareStatement(sql);
            rs=ps.executeQuery();

            while(rs.next()){
                Con_Facturas uss=new Con_Facturas(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getDouble(5),rs.getString(6));
                dat.add(uss);
            }
        } 

        catch (SQLException ex) {
           Logger.getLogger(Modelo_Productos.class.getName()).log(Level.SEVERE, null, "Error" +ex);
        }
        
        return dat;
    }
    
    
    /*
     * Extrae los detalles de las compras generadas que estan disponibles en el aplicativo.
     * @param sql recolectara los datos de las facturas 
     * @param uss envia los datos recolectados al constructor Con_compraDetalles.
    */
    
    public ArrayList<Con_compraDetalles> consultarCompra(Con_compraDetalles us){
        ArrayList<Con_compraDetalles> flag=new ArrayList<>();
            
        
        try {
            String sql="SELECT * FROM `compra` WHERE token='"+us.getToken()+"'";
            ps=cnn.prepareStatement(sql);
            rs=ps.executeQuery();

            while(rs.next()){
                Con_compraDetalles uss=new Con_compraDetalles(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6),rs.getInt(7),rs.getString(8));
                flag.add(uss);
            }
        } 

        catch (SQLException ex) {
           Logger.getLogger(Modelo_Productos.class.getName()).log(Level.SEVERE, null, "Error " +ex);
        }
        
        return flag;
    }
    
}    
    
