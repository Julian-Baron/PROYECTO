/*
 * Clase que me permitira conectar la base de datos con el aplicativo.
 * Realizara la extraccion de resultados de base de datos para mostrar en la aplicacion
 * @author JULIAN BARON
 */



package Conexion;
//importaciones
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Clase general que permitira hacer la conexion con las demas clases para obtener datos de consultas
 * @param cnn instacia que me permitira realizar una conexion con la clase
*/
public class Conexion {
    
    
    Connection cnn;
    
    //Relaizara el llamado para la conexion de la base de datos con el palicativo
    public Connection conexionbd(){
        
        /*
         * Realizara la conexion conexion con la bes de datos en caso de que salga error mostrara cual fue.
        */
        try {
           Class.forName("com.mysql.jdbc.Driver");
            try {
                cnn=DriverManager.getConnection("jdbc:mysql://localhost/proyecto_final","root","");
                System.out.println("Conexion.Conexion.conexionbd() "+cnn);
            } catch (Exception e) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
            }
        } catch (Exception e) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
        }
        
        //Retorna la conexion con la base de datos.
        return cnn;
    }
    
    // Pone en funcionamiento la clase que genera la  conexion de la base de datos.
    public static void main (String[]args){
        Conexion con=new Conexion();
        con.conexionbd();
        
    }
}
