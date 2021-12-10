/*
 *Modelo controlador domicilios para resultados de CRUD con respecto a las compras realizadas .
 *Realizara la extraccion de resultados de base de datos para mostrar en la aplicacion
 *@author Julian Baron
 *@version 1.0.0
 
 */


package Modelos;
import Conexion.Conexion;
import Constructor.Con_Domicilios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Mod_Domicilios {
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
    *@param lista recolectara los datos de los domicilios
    *@param us envia los datos recolectados al constructor Con_domicilios
    */
    
    public ArrayList<Con_Domicilios> Consultar_Domicilios(){
     ArrayList <Con_Domicilios> lista=new ArrayList<>();
     
    try {
        /*
         *Realiza la sentencia en la base de datos
         */
        ps=cnn.prepareStatement("SELECT*FROM domicilio");
        rs=ps.executeQuery();
        
        /*
         * Recorre la cantidad de resultados que se obtuvieron en la consulta
        */
        
        while(rs.next()){
             Con_Domicilios us=new Con_Domicilios(rs.getString(4), rs.getString(1), rs.getString(2), rs.getString(3));
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
     * Consulta de domicilios asignados por numeros de cedula del empleado
     * @param lista recolecta los datos de los empleados  por asignacion
     * @param us envia los datos recolectados al constructor Con_domicilios
     */
    
    //Consulta de domicilios de generados para cada empleado
    public ArrayList<Con_Domicilios> Consultar_DomiciliosAsignados(Con_Domicilios uss){
     ArrayList <Con_Domicilios> lista=new ArrayList<>();
     
     
    try {
        
        ps=cnn.prepareStatement("SELECT*FROM domicilio WHERE cedulaEmpleado='"+uss.getCedula()+"';");
        
        rs=ps.executeQuery();
        
        while(rs.next()){
             Con_Domicilios us=new Con_Domicilios(rs.getString(4), rs.getString(1), rs.getString(2), rs.getString(3));
            lista.add(us);
        }
    } 
    
    catch (SQLException ex) {
        Logger.getLogger(Modelo_Productos.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(null, "Error al generar la consulta "+ex);
    }
    
    return lista;
    }
    
    /*
      * Ingresa la cantidad de domicilios en el aplicativo
      * @param dat devolvera un dato para saber si la sentencia se realizo correctamente
      * @param x devolver valor mayor a 0 para saber si se realizo la sentencia correctamente
     */
    
    
    public boolean insertar_domicilio(Con_Domicilios us){
    boolean dat=false;
    int x;
    
        
    
        try {
            ps=cnn.prepareStatement("INSERT INTO domicilio  VALUES  (NULL,NOW(),?,?)");            
            ps.setString(1, us.getCedula());
            ps.setString(2,us.getId_compra());
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
     * Extrae la cantidad de domicilios a  modificar en el aplicativo
     * @param dat devolvera un dato para saber si la sentencia se realizo correctamente
     * @param x devolver valor mayor a 0 para saber si se realizo la sentencia correctamente
     */
    
    public boolean modificar_domicilio(Con_Domicilios us){
        boolean dat=false;
        int x;
        
            try {
                ps=cnn.prepareStatement("update domicilio"
                        + " SET id_compra='"+us.getId_compra()+"', fecha_pedido='"+us.getFechaPedido()+"', "
                                        +"cedula='"+us.getCedula()+"'"
                                                + "WHERE cod_domicilio='"+us.getCod_domicilio()+"'");
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
      * Extrae la cantidad de domicilios a eliminar en el aplicativo
      * @param dat devolvera un dato para saber si la sentencia se realizo correctamente
      * @param x devolver valor mayor a 0 para saber si se realizo la sentencia correctamente
     */
    
    public boolean eliminar_domiciliov(Con_Domicilios us){
        boolean dat=false;
        int x;

            try {
                ps=cnn.prepareStatement("DELETE FROM domicilio WHERE cod_domicilio='"+us.getCod_domicilio()+"'");
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
