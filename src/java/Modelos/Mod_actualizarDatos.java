/*
 *Modelo controlador actualizacion de datos de usuarios para resultados de CRUD con respecto a las compras realizadas .
 *Realizara la extraccion de resultados de base de datos para mostrar en la aplicacion
 *@author Julian Baron
 *@version 1.0.0
 
 */

package Modelos;
import Conexion.Conexion;
import Constructor.Con_actualizarDatos;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
/*     

 import javax.servlet.http.HttpSession;     


*/
import javax.swing.JOptionPane;


public class Mod_actualizarDatos {
    
    
    /*
     * Conexion que me realizara la sintaxis para la busqueda de datoe sen la base de datos
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
     *Encripta la contraseña con metodo MD5.
     *@param lista recolectara los datos de los domicilios
     *@param uss envia los datos recolectados al constructor Con_facturas.
    */
    
    public String getMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] encBytes = md.digest(input.getBytes());
            BigInteger numero = new BigInteger(1, encBytes);
            String encString = numero.toString(16);
            while (encString.length() < 32) {
                encString = "0" + encString;
            }
            return encString;//Retorna la contraseña cifrada
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    
    /*
     * Consulta los usuarios por numero de cedula
     * @param consuta recolecta los datos de la personas por cedula
     * @param us envia los datos recolectados al constructor Con_actualizarDatos
     */
    
    public ArrayList<Con_actualizarDatos> consultar_actualizacion(Con_actualizarDatos us){
        ArrayList<Con_actualizarDatos> data=new ArrayList<>();
        try {
            String consulta="Select clientes.nombre_cli,clientes.apellido_cli,clientes.correo_cli,clientes.direccion_cli,clientes.telefono_cli,usuarios.nombre_usu,usuarios.contraseña,usuarios.sexo,usuarios.cedula FROM usuarios INNER JOIN clientes ON usuarios.cedula=clientes.cedula WHERE usuarios.cedula="+us.getCedulaa();
            ps=cnn.prepareStatement(consulta);
            
            rs=ps.executeQuery();
            
            while(rs.next()){
                Con_actualizarDatos lista=new Con_actualizarDatos(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9));
                data.add(lista);
            }
        
        } 
        
        catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error al intentar capatar los datos"+ e);
        }
        return data;
    }
    
    
     /*
      * Actualiza los datos de la persona que desaa registrarse en el aplicactivo
      * @param dat devolvera un dato para saber si la sentencia se realizo correctamente
      * @param x devolver valor mayor a 0 para saber si se realizo la sentencia correctamente
     */
      
    public boolean insertar_datos(Con_actualizarDatos us){
        boolean dat=false;
        int x;
        
        try {
            String consulta="UPDATE `clientes` INNER JOIN `usuarios` ON clientes.cedula=usuarios.cedula SET clientes.nombre_cli='"+us.getNombres()+"',clientes.apellido_cli='"+us.getApellidos()+"',"
                    + "clientes.correo_cli='"+us.getCorreo()+"',clientes.direccion_cli='"+us.getDireccion()+"',clientes.telefono_cli="+us.getTelefono()+","
                    + "usuarios.nombre_usu='"+us.getNombre_usu()+"',usuarios.contraseña='"+us.getPassword()+"',usuarios.sexo='"+us.getSexo()+"' WHERE clientes.cedula="+us.getCedula()+"";
                    
            ps=cnn.prepareStatement(consulta);
           
            x=ps.executeUpdate();
            if(x>0){
                dat=true;
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error al actualizar los datos de usuarios"+e);
        }
        
        
       return dat; 
    }
            
}
