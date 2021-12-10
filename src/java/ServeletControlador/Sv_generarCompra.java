/**
 * Controlador para el control de compras 
 * Contiene uso de constructores  y modelos para realizar la conexion con la base de datos
 *
 * @author JULIAN BARON
 */
package ServeletControlador;

import Conexion.Conexion;
import Constructor.Articulo;
import Constructor.Con_Facturas;
import Constructor.Con_productos;
import Modelos.Mod_Facturas;
import controllers.ControladorProducto;
/*

import java.io.Console;
import java.io.PrintWriter;

*/

/**
     * USO DE COMPRAS
     * @param cllama la conexion
     * @param cnn conecta la base de datos
     * @param ps prepara la sententecia a realizar
     * @param rs obtiene el resultado de la sentencia
    */
import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;


@WebServlet(name = "generar_compra", urlPatterns = {"/generar_compra"}) 
public class Sv_generarCompra extends HttpServlet {
    
    
    Conexion con=new Conexion();
    Connection cnn=con.conexionbd();
  
    PreparedStatement ps=null;
    ResultSet rs=null;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    //generar_compra
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        //Llamado de la sesion que se encuentre activa
        /**
         * @param sesion recibe el valor si la sesion se encuentra activa
         * @param obj para llamar a comenzar una variable de seiron
         * @param req obtiene el usuario de la variable de sesion
         * @param cld obtiene la cedula de la variable de sesion
         * @param articulos llama un array para crear un puente entre el array y poder obtener sus datos
         * @param dat recepciona si la sentencia se realizo correctamente
        */
        
        boolean dat;
        
        //Llamado de la sesion que se encuentre activa
        /**
         * @param sesion recibe el valor si la sesion se encuentra activa
         * @param obj para llamar a comenzar una variable de seiron
         * @param req obtiene el usuario de la variable de sesion
         * @param cld obtiene la cedula de la variable de sesion
         * @param articulos llama un array para crear un puente entre el array y poder obtener sus datos
        */
        HttpSession sesion=request.getSession(true);
        HttpSession obj=request.getSession();
        
        String req=(String) obj.getAttribute("usuario");
        String cdl=(String) obj.getAttribute("cedulaa");
       
        ArrayList<Articulo> articulos = sesion.getAttribute("carrito")== null ? new ArrayList<>(): (ArrayList)sesion.getAttribute("carrito");
        if(req!=null && articulos.size()>0){
            
                /**
                 * @param mod crea un puente entre el modelo Mod_facturas y el controlador actual
                 * @param total recepciona el valor total de la compra generada
                 * @param token recepciona el token de la compra para saber el domicilio que se realizara
                 * @param fac2 envia los parametros asignados para realizar la sentencia
                 */
            
            
                Mod_Facturas mod=new Mod_Facturas();
                double total=0.0;
                String token;

                total=Double.parseDouble(request.getParameter("total"));
                token=request.getParameter("token");


                Con_Facturas fac=new Con_Facturas();
                Con_Facturas fac2=new Con_Facturas(0,"","",token,total,cdl);
                dat=mod.insertar_factura(fac2);


                if(dat){    
                    JOptionPane.showMessageDialog(null,"Datos ingresados");
                }
                else{
                    JOptionPane.showMessageDialog(null,"Datos no ingresados");
                }
                boolean dato;
               
                /**
                 * @param cp crea una instancia del controlador producto
                 * @param x recepciona la cantidad total de resultados de la sentencia si se han realizado
                 * @param totala, multiplica la cantidad total de productos por el precio de cada uno
                 * @param sql prepara la sentencia para la base de datos
                 */
                
                controllers.ControladorProducto cp=new ControladorProducto();
                
                
                
                int x=0;
                 if(articulos.size()>0){
                    for(Articulo a: articulos){
                        
                        
                        Con_productos producto=cp.getproducto(a.getIdProducto());
                        

                        double totala=Math.round(producto.getPrecio()*a.getCantidad());


                            try {
                                String sql="INSERT INTO `compra`(`id_compra`, `cod_pro`, `cantidad`, `cedula`, `token`, `subtotal`, `total`, `nombre`) VALUES (NULL,?,?,?,?,?,?,?)";
                                ps=cnn.prepareStatement(sql);
                                ps.setString(1, a.getIdProducto());
                                ps.setInt(2, a.getCantidad());
                                ps.setString(3,cdl);
                                ps.setString(4, token);
                                ps.setDouble(5, totala);
                                ps.setDouble(6, totala);
                                ps.setString(7, producto.getNombre_pro());
                                x=ps.executeUpdate();
                                if(x>0){
                                    dato=true;
                                }
                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(null, "Error al insertar los carros en la base de datos "+e);
                            }

                        x=0;
                        dato=false;
                        totala=0.0;                
                    }
                    
                    try {
                                String sql="insert into producto_factura select compra.id_compra,factura.id_factura from compra inner JOIN factura ON compra.token=factura.token WHERE compra.token='"+token+"';";
                                ps=cnn.prepareStatement(sql);
                               
                                x=ps.executeUpdate();
                                if(x>0){
                                    dato=true;
                                }
                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(null, "Error al insertar las facturas en la base de datos "+e);
                            }
                 
                }     

                 

                

                response.sendRedirect("Graciasporsucompra.jsp"); // reenvia al usuario a esta direccion
        }
        
        else{
            response.sendRedirect("login.jsp");
        }
            
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
