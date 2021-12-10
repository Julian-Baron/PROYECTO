/*
 * Modelo controlador facturas para resultados de CRUD con respecto a las facturas realizadas .
 * Realizara la extraccion de resultados de base de datos para mostrar en la aplicacion
 * @author Julian Baron
 * @version 1.0.0
 */

package Modelos;

import Conexion.Conexion;
import Constructor.Con_Domicilios;
import Constructor.Con_Facturas;
import Constructor.Con_detalleVenta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Mod_Facturas {
    
    /*
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
     * Extrae la cantidad de facturas que estan disponibles en el aplicativo.
     * @param lista recolectara los datos de las facturas
     * @param uss envia los datos recolectados al constructor Con_facturas.
    */
    public ArrayList<Con_Facturas> consultar_factura(){
     ArrayList <Con_Facturas> lista=new ArrayList<>();
     
    try {
        
        ps=cnn.prepareStatement("SELECT*FROM factura");
        
        rs=ps.executeQuery();
        
        while(rs.next()){
            Con_Facturas uss=new Con_Facturas(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getDouble(5),rs.getString(6));
            lista.add(uss);
        }
    } 
    
    catch (SQLException ex) {
        Logger.getLogger(Modelo_Productos.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    return lista;
    }
    
    /*
     * Consulta facturas por id de factura
     * @param lista recolecta los datos de la factura por asignacion
     * @param us envia los datos recolectados al constructor Con_Facturas
     */
    
    public ArrayList<Con_Facturas> consultar_facturaXnumeroFac(Con_Facturas us){
     ArrayList <Con_Facturas> lista=new ArrayList<>();
     
    try {
        
        ps=cnn.prepareStatement("SELECT*FROM factura where id_factura'"+us.getId_factura()+"'");
        
        rs=ps.executeQuery();
        
        while(rs.next()){
            Con_Facturas uss=new Con_Facturas(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getDouble(5),rs.getString(6));
            lista.add(uss);
        }
    } 
    
    catch (SQLException ex) {
        Logger.getLogger(Modelo_Productos.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    return lista;
    } 
    
    //Consulta de token generado por factura
    
    /*
     * Consulta facturas por token de factura
     * @param lista recolecta los datos de la factura por asignacion
     * @param us envia los datos recolectados al constructor Con_Facturas
     */
    
    public ArrayList<Con_Facturas> consultar_facturaToken(Con_Facturas us){
     ArrayList <Con_Facturas> lista=new ArrayList<>();
     
    try {

        ps=cnn.prepareStatement("SELECT token FROM factura where id_factura='"+us.getId_factura()+"'");
        
        rs=ps.executeQuery();
        
        while(rs.next()){
            Con_Facturas uss=new Con_Facturas(rs.getString(1));
            lista.add(uss);
        }
    } 
    
    catch (SQLException ex) {
        Logger.getLogger(Modelo_Productos.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(null, "Error en el modeloal buscar el token "+ex);
    }
    
    return lista;
    }
    
    
    /*
     * Consulta facturas por fecha de factura
     * @param lista recolecta los datos de la personas por asignacion
     * @param us envia los datos recolectados al constructor Con_Facturas
     */
    
    public ArrayList<Con_Facturas> consultar_facturaXfechaFac(Con_Facturas us){
     ArrayList <Con_Facturas> lista=new ArrayList<>();
     
    try {
        
        ps=cnn.prepareStatement("SELECT*FROM factura where fecha_fac'"+us.getFecha_fac()+"'");
        
        rs=ps.executeQuery();
        
        while(rs.next()){
            Con_Facturas uss=new Con_Facturas(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getDouble(5),rs.getString(6));
            lista.add(uss);
        }
    } 
    
    catch (SQLException ex) {
        Logger.getLogger(Modelo_Productos.class.getName()).log(Level.SEVERE, null, ex);
    }
    
        return lista;
    }
    
    
    /*
      * Ingresa la cantidad de facturas en el aplicativo
      * @param dat devolvera un dato para saber si la sentencia se realizo correctamente
      * @param x devolver valor mayor a 0 para saber si se realizo la sentencia correctamente
     */
    
    public boolean insertar_factura(Con_Facturas us){
        boolean dat=false;
        int x;

            try {
                ps=cnn.prepareStatement("INSERT INTO `factura`(`id_factura`, `fecha_fac`, `status`, `token`, `total`,`cedula`) VALUES (NULL,NOW(),'PENDIENTE',?,?,?)");
                
                ps.setString(1,us.getToken());
                ps.setDouble(2,us.getTotal()); 
                ps.setString(3, us.getCedula());
                x=ps.executeUpdate();
                if(x>0){
                    dat=true;
                }

                }


            catch (Exception e) {

                JOptionPane.showMessageDialog(null,"Error "+e);
            }

        return dat;
    }
    
    //Eliminar facturas de compras
    
     /*
      * elimina la cantidad de facturas en el aplicativo
      * @param dat devolvera un dato para saber si la sentencia se realizo correctamente
      * @param x devolver valor mayor a 0 para saber si se realizo la sentencia correctamente
     */
    
    
    public boolean eliminar_factura(Con_detalleVenta us){
        boolean flag=false;
        int x;
        
        try {
            String sql="DELETE FROM `factura` WHERE "+us.getId_factura()+"";
            ps=cnn.prepareStatement(sql);
            x=ps.executeUpdate();
            
            if(x>0){
                flag=true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error modelo facturas "+e);
        }
        return flag;
    }
    //Modificar Domicilio Cancelar pedido
    
    /*
      * Modifica las facturas por medio del aplicativo y colocarlo en la base de datos
      * @param dat devolvera un dato para saber si la sentencia se realizo correctamente
      * @param x devolver valor mayor a 0 para saber si se realizo la sentencia correctamente
     */
    
    public boolean modificar_factura(Con_detalleVenta us){
        boolean dat=false;
        int x;

            try {
                ps=cnn.prepareStatement("update factura SET status = 'CANCELADO' WHERE id_factura='"+us.getId_factura()+"'");
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
    
    /*Modificar Estado del domicilio*/
    
    /*
      * Modifica las estado de las facturas del domicilio por medio del aplicativo y colocarlo en la base de datos
      * @param dat devolvera un dato para saber si la sentencia se realizo correctamente
      * @param x devolver valor mayor a 0 para saber si se realizo la sentencia correctamente
     */
    
    public boolean modificar_facturaEstado(Con_Facturas us){
        boolean dat=false;
        int x;

            try {
                ps=cnn.prepareStatement("update factura SET status = 'ACTIVO' WHERE id_factura='"+us.getId_factura()+"'");
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
      * inserta cuales facturas van con cada domicilio por medio del aplicativo y colocarlo en la base de datos
      * @param dat devolvera un dato para saber si la sentencia se realizo correctamente
      * @param x devolver valor mayor a 0 para saber si se realizo la sentencia correctamente
     */
    public boolean insertar_domicilio(Con_Domicilios us){
    boolean dat=false;
    int x;
    
        try {
            ps=cnn.prepareStatement("INSERT INTO `factura`(`id_factura`, `fecha_fac`, `status`, `token`, `total`) VALUES (NULL,NOW(),PENDIENTE,?,?)");
            /*
            
            ps.setString(2,us.getFechaPedido());
            ps.setString(4,us.get);
            
            */
            ps.setString(4,us.getId_compra()); 
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
      * modifica el domicilio  por medio del aplicativo y  lo coloca en la base de datos
      * @param dat devolvera un dato para saber si la sentencia se realizo correctamente
      * @param x devolver valor mayor a 0 para saber si se realizo la sentencia correctamente
     */
    
    public boolean modificar_domicilio(Con_Domicilios us){
        boolean dat=false;
        int x;

            try {
                ps=cnn.prepareStatement("update domicilio"
                        + "SET "
                        + " fecha_pedido='"+us.getFechaPedido()+"',"
                                + "id_compra='"+us.getId_compra()+"',"
                                        + "cedula='"+us.getCedula()+"'"
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
      * elimina el domicilio  por medio del aplicativo y  lo ajusta en la base de datos
      * @param dat devolvera un dato para saber si la sentencia se realizo correctamente
      * @param x devolver valor mayor a 0 para saber si se realizo la sentencia correctamente
     */
    
    
    public boolean eliminar_domiciliov(Con_Domicilios us){
        boolean dat=false;
        int x;

            try {
                ps=cnn.prepareStatement("delete domicilio "
                        + "where cod_domicilio='"+us.getCod_domicilio()+"'");
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
