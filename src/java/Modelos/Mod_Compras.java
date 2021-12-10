/*
 *Modelo controlador compras para resultados de CRUD con respecto a las compras realizadas .
 *Realizara la extraccion de resultados de base de datos para mostrar en la aplicacion
 *@author Julian Baron
 *@version 1.0.0
 */

package Modelos;
import Conexion.Conexion;
import Constructor.Con_Compras;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Mod_Compras {
    
    /*
     * Conexion que me realizara la sintaxis para la busqueda de datos en la base de datos
    */
    Conexion con=new Conexion();
    Connection cnn=con.conexionbd();
    /*
     *@param ps Prepara la sentencia a enviar en la base de datos
     *@param rs recolecta los datos de la base de datos
    */
    PreparedStatement ps=null;
    ResultSet rs=null;
    
    
    
    /*
    *Extrae la cantidad de compras que estan disponibles en el aplicativo.
    *@param lista recolectara los datos de las compras
    *@param us envia los datos recolectados al constructor Con_compras
    */
    
    public ArrayList<Con_Compras> consultarcompras(){
     ArrayList <Con_Compras> lista=new ArrayList<>();
     
    try {
       
        /*
         *Realiza la sentencia en la base de datos
         */
        ps=cnn.prepareStatement("SELECT*FROM compra");
        
        rs=ps.executeQuery();
        /*
         * Recorre la cantidad de resultados que se obtuvieron en la consulta
        */
        while(rs.next()){
             Con_Compras us=new Con_Compras(rs.getString(4), rs.getString(2),  rs.getInt(3), rs.getString(1));
            lista.add(us);
        }
    } 
    
    catch (SQLException ex) {
        Logger.getLogger(Modelo_Productos.class.getName()).log(Level.SEVERE, null, ex);
    }
    /*
     *@return retorna la lista del array
     */
    return lista;
    }
    
    /*
     * Consulta clientes por numeros de cedula
     * @param lista recolecta los datos de la personas por numero de cedula
     * @param us envia los datos recolectados al constructor Con_clientes
     */
    
    public ArrayList<Con_Compras> consultarcompras_id(){
    ArrayList <Con_Compras> lista=new ArrayList<>();
     
    try {
       
        
        ps=cnn.prepareStatement("SELECT id_compra FROM compra ORDER BY id_compra ASC");
        rs=ps.executeQuery();
        
        while(rs.next()){
             Con_Compras us=new Con_Compras(rs.getString(1));
            lista.add(us);
        }
    } 
       
    catch (SQLException ex) {
        Logger.getLogger(Modelo_Productos.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    return lista;
    }
    
    /*
      * Ingresa la cantidad de compras en el aplicativo
      * @param dat devolvera un dato para saber si la sentencia se realizo correctamente
      * @param x devolver valor mayor a 0 para saber si se realizo la sentencia correctamente
     */
    
    public boolean insertar_compra(Con_Compras us){
    boolean dat=false;
    int x;
    
        try {
            ps=cnn.prepareStatement("INSERT INTO compra  VALUES  (?,?,?,?)");
            ps.setString(1,us.getId_compra());
            ps.setString(2,us.getCod_pro());
            ps.setInt(3, us.getCantidad());
            ps.setString(4, us.getCedula());
            
            x=ps.executeUpdate();
            
            if(x>0){
                dat=true;
            }
                
            }
       
         
        catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e);
        }
    //retorna los resultados obtenidos
    return dat;
    }
    
    /*
      * Extrae la cantidad de compras a  modificar en el aplicativo
      * @param dat devolvera un dato para saber si la sentencia se realizo correctamente
      * @param x devolver valor mayor a 0 para saber si se realizo la sentencia correctamente
     */
    
    public boolean Modificar_compra(Con_Compras us){
    boolean dat=false;
    int x;
    
        try {
            ps=cnn.prepareStatement("Update compra set "
                    + "cedula='"+us.getCedula()+"',cantidad='"+us.getCantidad()+"', cod_pro='"+us.getCod_pro()+"' where id_compra='"+us.getId_compra()+"'");
           
            
            x=ps.executeUpdate();
            
            if(x>0){
                dat=true;
            }
                
            }
         
         
        catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e);
        }
   
    return dat;
    }
    
    /*
      * Extrae la cantidad de compras a  eliminar en el aplicativo
      * @param dat devolvera un dato para saber si la sentencia se realizo correctamente
      * @param x devolver valor mayor a 0 para saber si se realizo la sentencia correctamente
     */
    
    public boolean eliminar_compra(Con_Compras us){
        boolean dat=false;
        int x;
            JOptionPane.showMessageDialog(null,"entra" );
            try {
                ps=cnn.prepareStatement("delete from compra where id_compra='"+us.getId_compra()+"'");

                x=ps.executeUpdate();

                if(x>0){
                    dat=true;
                }

                }


            catch (Exception e) {

                JOptionPane.showMessageDialog(null, e);
            }

        return dat;
    }
}
