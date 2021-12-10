/*
 * Modelo controlador de productos para resultados de CRUD con respecto a los productos en la empresa y el aplicativo.
 * Realizara la extraccion de resultados de base de datos para mostrar en la aplicacion
 * @author JULIAN BARON
 */
package Modelos;

import Conexion.Conexion;
import Constructor.Con_productos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Modelo_Productos {

    /*
     * Conexion que me realizara la sintaxis para la busqueda de datos en la base de datos
     */
    Conexion con = new Conexion();
    Connection cnn = con.conexionbd();
    /*
     * @param ps Prepara la sentencia a enviar en la base de datos
     * @param rs recolecta los datos de la base de datos
     */
    PreparedStatement ps = null;
    ResultSet rs = null;

    /*
     * Selecciona el producto dependiendo de el codigo generado por el aplicativo del productp 
       @param sql recolectara los datos de los empleados y realizara la sentencia
     * @param productos envia los datos recolectados al constructor Con_empleados.
     */
    public Con_productos listar(String id) {

        String sql = "SELECT * FROM `producto` WHERE cod_pro='" + id + "';";
        Con_productos productos = null;

        try {
            ps = cnn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                productos = new Con_productos(rs.getString(1), rs.getString(6), rs.getInt(5), rs.getString(3), rs.getString(2), rs.getInt(4), rs.getString(7));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return productos;
    }

    /*
     * Extrae la cantidad de productos que estan disponibles en el aplicativo.
     * @param lista recolectara los datos de los productos
     * @param us envia los datos recolectados al constructor Con_productos.
     */
    public ArrayList<Con_productos> consultarusuarios() {
        ArrayList<Con_productos> lista = new ArrayList<>();

        try {

            ps = cnn.prepareStatement("SELECT * FROM producto");

            rs = ps.executeQuery();

            while (rs.next()) {
                Con_productos us = new Con_productos(rs.getString(1), rs.getString(6), rs.getInt(5), rs.getString(3), rs.getString(2), rs.getInt(4), rs.getString(7));
                lista.add(us);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Productos.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error con la sentencia: " + ex);
        }

        return lista;
    }

    /*
     * Extrae la cantidad de productos que estan disponibles en el aplicativo donde el precio sea mayor a 0.
     * @param lista recolectara los datos de los productos
     * @param us envia los datos recolectados al constructor Con_productos.
     */
    public ArrayList<Con_productos> consultarProductos() {
        ArrayList<Con_productos> lista = new ArrayList<>();

        try {

            ps = cnn.prepareStatement("SELECT * FROM producto WHERE precio_pro >0");

            rs = ps.executeQuery();

            while (rs.next()) {
                Con_productos us = new Con_productos(rs.getString(1), rs.getString(6), rs.getInt(5), rs.getString(3), rs.getString(2), rs.getInt(4), rs.getString(7));
                lista.add(us);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Productos.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error con la sentencia: " + ex);
        }

        return lista;
    }

    /*
     * Inserta los productos y sus descripciones correspondientes en la base de datos del aplicativo
     * @param dat devolvera un dato para saber si la sentencia se realizo correctamente
     * @param x devolver valor mayor a 0 para saber si se realizo la sentencia correctamente
     */
    
    
    public boolean insertar_producto(Con_productos us) {
        boolean dat = false;
        int x;

        try {
            ps = cnn.prepareStatement("INSERT INTO producto  VALUES  (?,?,?,?,?,?,?)");
            ps.setString(1, us.getCod_pro());
            ps.setString(2, us.getNombre_pro());
            ps.setString(3, us.getMarca());
            ps.setInt(4, us.getDisponibles());
            ps.setInt(5, us.getPrecio());
            ps.setString(6, us.getDescripcion());
            ps.setString(7, us.getImg());
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
     * Modifica los productos y sus descripciones correspondientes en la base de datos del aplicativo por numero de codigo del producto
     * @param dat devolvera un dato para saber si la sentencia se realizo correctamente
     * @param x devolver valor mayor a 0 para saber si se realizo la sentencia correctamente
     */
    
    public boolean modificar_producto(Con_productos us) {
        boolean dat = false;
        int x;

        try {
            ps = cnn.prepareStatement("update producto SET " + "nombre_pro='" + us.getNombre_pro() + "'," + "marca_pro='" + us.getMarca() + "'," + "disponibles='" + us.getDisponibles() + "',"
                    + "precio_pro='" + us.getPrecio() + "'," + "descripcion_pro='" + us.getDescripcion() + "'," + "img='" + us.getImg() + "'" + "WHERE cod_pro='" + us.getCod_pro() + "'");
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
     * elimina los productos y sus descripciones correspondientes en la base de datos del aplicativo por numero de codigo del producto
     * @param dat devolvera un dato para saber si la sentencia se realizo correctamente
     * @param x devolver valor mayor a 0 para saber si se realizo la sentencia correctamente
     */
    
    public boolean eliminar_producto(Con_productos us) {
        boolean dat = false;
        int x;

        try {
            ps = cnn.prepareStatement("delete From producto where cod_pro='" + us.getCod_pro() + "'");
            x = ps.executeUpdate();

            if (x > 0) {
                dat = true;
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);
        }

        return dat;
    }

}
