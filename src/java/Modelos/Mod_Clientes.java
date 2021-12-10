 /*
  *Modelo controlador clientes para resultados de CRUD.
  *Realizara la extraccion de resultados de base de datos para mostrar en la aplicacion
  */

/*
 *@author Julian Baron
 *@version 1.0.0
 * Clase genereral que realizara las funciones correspondientes para la recoleccion de datos de los clientes 
 */
package Modelos;

/*
 *Importacion de clases 
*/
import Conexion.Conexion;
import Constructor.Con_clientes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 *@author Julian Baron
 *@version 1.0.0
 * Clase general que realizara las funciones correspondientes para la recoleccion de datos de los clientes 
 */
public class Mod_Clientes {

    /*
     * Conexion que me realizara la sintaxis para la busqueda de datoe sen la base de datos
     */
    
    Conexion con = new Conexion();
    Connection cnn = con.conexionbd();
    /*
     *@param ps Prepara la sentencia a enviar en la base de datos
     *@param rs recolecta los datos de la base de datos
    */
    
    PreparedStatement ps = null;
    ResultSet rs = null;

    /*
    *Extrae la cantidad de personas clientes que estan disponibles en el aplicativo.
    @param lista recolectara los datos de los clientes
    
     */
    public ArrayList<Con_clientes> consultar_clientes() {

        ArrayList<Con_clientes> lista = new ArrayList<>();

        try {
            ps = cnn.prepareStatement("SELECT*FROM clientes");
            rs = ps.executeQuery();

            while (rs.next()) {
                Con_clientes us = new Con_clientes(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                lista.add(us);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Productos.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error " + ex);
        }
        return lista;
    }

    /*
     * Consulta clientes por numeros de cedula
     * @param lista recolecta los datos de la personas por numero de cedula
     * @param us envia los datos recolectados al constructor Con_clientes
     */
    public ArrayList<Con_clientes> consultar_clientesCed(Con_clientes uss) {

        ArrayList<Con_clientes> lista = new ArrayList<>();

        try {
            ps = cnn.prepareStatement("SELECT * FROM `clientes` WHERE `cedula`='" + uss.getCedula() + "'");
            rs = ps.executeQuery();

            while (rs.next()) {
                Con_clientes us = new Con_clientes(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));

                lista.add(us);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Productos.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error " + ex);
        }

        return lista;
    }

    /*
    *Extrae la cantidad de personas clientes que estan disponibles en el aplicativo
    @param dat devolvera un dato para saber si la sentencia se realizo correctamente
    @param x devolver valor mayor a 0 para saber si se realizo la sentencia correctamente
     */
    public boolean insertar_Clientes(Con_clientes us) {
        boolean dat = false;
        int x;

        try {
            ps = cnn.prepareStatement("INSERT INTO clientes  VALUES  (?,?,?,?,?,?)");
            ps.setString(1, us.getCedula());
            ps.setString(2, us.getNombre());
            ps.setString(3, us.getApellido());
            ps.setString(4, us.getCorreo());
            ps.setString(5, us.getDireccion());
            ps.setString(6, us.getTelefono());
            x = ps.executeUpdate();

            if (x > 0) {
                dat = true;
            }

        } 
        catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);
        }

        return dat;
    }
     /*
      * Extrae la cantidad de personas clientes modificar en el aplicativo
      * @param dat devolvera un dato para saber si la sentencia se realizo correctamente
      * @param x devolver valor mayor a 0 para saber si se realizo la sentencia correctamente
     */
    public boolean modificar_producto(Con_clientes us) {
        boolean dat = false;
        int x;

        try {
            ps = cnn.prepareStatement("update clientes SET "
                    + "telefono_cli='" + us.getTelefono() + "',"
                    + "nombre_cli='" + us.getNombre() + "',"
                    + "apellido_cli='" + us.getApellido() + "',"
                    + "correo_cli='" + us.getCorreo() + "',"
                    + "direccion_cli='" + us.getDireccion() + "'"
                    + "WHERE cedula='" + us.getCedula() + "'");
            x = ps.executeUpdate();

            if (x > 0) {
                dat = true;
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);
        }

        return dat;
    }
     /*
      * Extrae la cantidad de personas clientes para eliminar en el aplicativo
      * @param dat devolvera un dato para saber si la sentencia se realizo correctamente
      * @param x devolver valor mayor a 0 para saber si se realizo la sentencia correctamente
     */
    public boolean eliminar_producto(Con_clientes us) {
        boolean dat = false;
        int x;

        try {
            ps = cnn.prepareStatement("delete from clientes where cedula='" + us.getCedula() + "'");
            x = ps.executeUpdate();

            if (x > 0) {
                dat = true;
            }

        } 
        catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);
        }

        return dat;
    }
}
