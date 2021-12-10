/*
 * Modelo controlador de empleados para resultados de CRUD con respecto a los empleados en la empresa.
 * Realizara la extraccion de resultados de base de datos para mostrar en la aplicacion
 * @author JULIAN BARON
 */
package Modelos;

import Conexion.Conexion;
/*    
 
import Constructor.Con_clientes;
 
 */
import Constructor.Con_empleados;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Mod_empleados {

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
     * Extrae la cantidad de empleados que estan disponibles en el aplicativo.
     * @param lista recolectara los datos de los empleados
     * @param us envia los datos recolectados al constructor Con_empleados.
     */
    public ArrayList<Con_empleados> consultar_empleados() {

        ArrayList<Con_empleados> lista = new ArrayList<>();

        try {

            ps = cnn.prepareStatement("SELECT*FROM empleado");

            rs = ps.executeQuery();

            while (rs.next()) {
                Con_empleados us = new Con_empleados(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                lista.add(us);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Productos.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error " + ex);
        }

        return lista;
    }

    /*
     * Extrae la cantidad de empleados con numero de cedula que estan disponibles en el aplicativo.
     * @param lista recolectara los datos de los empleados
     * @param us envia los datos recolectados al constructor Con_empleados.
     */
    public ArrayList<Con_empleados> consultar_empleadosCed(Con_empleados uss) {

        ArrayList<Con_empleados> lista = new ArrayList<>();

        try {

            ps = cnn.prepareStatement("SELECT*FROM empleado WHERE cedula='" + uss.getCedula() + "'");

            rs = ps.executeQuery();

            while (rs.next()) {
                Con_empleados us = new Con_empleados(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                lista.add(us);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Productos.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error " + ex);
        }

        return lista;
    }

    /*
      * Ingresa la cantidad de empleados se requieran en el aplicativo
      * @param dat devolvera un dato para saber si la sentencia se realizo correctamente
      * @param x devolver valor mayor a 0 para saber si se realizo la sentencia correctamente
     */
    //Insertar Empleados
    public boolean insertar_empleados(Con_empleados us) {
        boolean dat = false;
        int x;

        try {
            ps = cnn.prepareStatement("INSERT INTO empleado  VALUES  (?,?,?,?,?,?)");
            ps.setString(1, us.getCedula());
            ps.setString(2, us.getNombre_emp());
            ps.setString(3, us.getApellido_emp());
            ps.setString(4, us.getTelefono_emp());
            ps.setString(5, us.getCorreo_emp());
            ps.setString(6, us.getCod_emp());
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
      * modifica los empleados que se requieran en el aplicativo
      * @param dat devolvera un dato para saber si la sentencia se realizo correctamente
      * @param x devolver valor mayor a 0 para saber si se realizo la sentencia correctamente
     */
    public boolean modificar_empleados(Con_empleados us) {
        boolean dat = false;
        int x;
        JOptionPane.showMessageDialog(null, "Cedula " + us.getCedula());
        try {
            ps = cnn.prepareStatement("update empleado SET "
                    + "nombre_emp='" + us.getNombre_emp() + "',"
                    + "apellido_emp='" + us.getApellido_emp() + "',"
                    + "correo_emp='" + us.getCorreo_emp() + "',"
                    + "cod_emp='" + us.getCod_emp() + "'"
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
      * Elimina los empleados que se requieran en el aplicativo
      * @param dat devolvera un dato para saber si la sentencia se realizo correctamente
      * @param x devolver valor mayor a 0 para saber si se realizo la sentencia correctamente
     */
    public boolean eliminar_empleados(Con_empleados us) {
        boolean dat = false;
        int x;

        try {
            ps = cnn.prepareStatement("delete from empleado where cedula='" + us.getCedula() + "'");
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
