/*
 * Modelo controlador de usuarios para resultados de CRUD con respecto a los usuairios y clientes en el aplicativo
 * Realizara la extraccion de resultados de base de datos para mostrar en la aplicacion
 * @author JULIAN BARON
*/

package Modelos;
import Conexion.Conexion;
import Constructor.Con_actualizarDatos;
import Constructor.Con_login;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


/*
 * Clase principal que me realizara el logeo de el aplicativo
*/

public class Mod_login {
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
     * Clase que me va a generar un cifrado en la contraseña
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
            return encString;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    /*
     * Consulta donde me generara si la persona se encuentra en el aplicativo
     * @param datos recibira la cantidad total de usuaios que conincidan con la clave y el nombre de usuario
     * @param password recibira la contraseña cifrada para colocar en el aplicativo
     * @param datos enviara los resultados de la consulta de verificacion del usuario
     */
    public ArrayList<Constructor.Con_login> loginusu (Con_login log){
      ArrayList<Con_login> datos=new ArrayList<>();
      
      String password=log.getContraseña();
      
        try {
            ps=cnn.prepareStatement("SELECT usuarios.cedula, usuarios.nombre_usu, usuarios.contraseña, usuarios.rol, usuarios.sexo, clientes.nombre_cli "
                    + "FROM usuarios inner join clientes on usuarios.cedula=clientes.cedula "
                    + "WHERE (nombre_usu='"+log.getNombre_usu()+"' AND contraseña='"+getMD5(password)+"');");
            rs=ps.executeQuery();
            while(rs.next()){
                Con_login logusu=new Con_login(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                datos.add(logusu);        
            }      
        }
        catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, ex);      
        }   
      return datos;   
    }
    /*
      * Ingresa al usuario y los datos personales en el aplicativo
      * @param dat devolvera un dato para saber si la sentencia se realizo correctamente
      * @param x devolver valor mayor a 0 para saber si se realizo la sentencia correctamente
    */
    public boolean insertar_usuarioCli(Con_actualizarDatos us){
        boolean dat=false;
        int x;
        try {
            String slq="INSERT INTO `clientes`(`cedula`, `nombre_cli`, `apellido_cli`, `correo_cli`, `direccion_cli`, `telefono_cli`) VALUES (?,?,?,?,?,?)";
            ps=cnn.prepareStatement(slq);
            ps.setInt(1, us.getCedula());
            ps.setString(2, us.getNombres());
            ps.setString(3, us.getApellidos());
            ps.setString(4, us.getCorreo());
            ps.setString(5, us.getDireccion());
            ps.setString(6, us.getTelefonoo());
            x=ps.executeUpdate();
            if(x>0){
                dat=true;
            }
        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error al insertar el cliente en el registro"+ e);
        }
        
        return dat;
    }
    
    
    /*
      * Ingresa al usuario y los datos de inicio de sesion correspondientes en el aplicativo
      * @param dat devolvera un dato para saber si la sentencia se realizo correctamente
      * @param x devolver valor mayor a 0 para saber si se realizo la sentencia correctamente
    */
    
    public boolean insertar_usuarioUsu(Con_actualizarDatos us){
        boolean dat=false;
        int x;
        try {
            String slq="INSERT INTO `usuarios`(`cedula`, `nombre_usu`, `contraseña`, `rol`, `sexo`) VALUES (?,?,?,'Cliente',?)";
            ps=cnn.prepareStatement(slq);
            ps.setInt(1, us.getCedula());
            ps.setString(2, us.getNombre_usu());
            ps.setString(3, us.getPassword());
            ps.setString(4, us.getSexo());
            x=ps.executeUpdate();
            if(x>0){
                dat=true;
            }
        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error al insertar el cliente en el registro"+ e);
        }
        
        return dat;
    }
}
