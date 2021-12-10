/**
 * Controlador para el control de facturas
 * Contiene uso de constructores  y modelos para realizar la conexion con la base de datos
 *
 * @author JULIAN BARON
 */
package ServeletControlador;

/*import Constructor.Con_compraDetalles;*/
import Constructor.Con_detalleVenta;
import Modelos.Mod_Facturas;
/*import Modelos.Mod_misCompras;*/
import java.io.IOException;
/*import java.io.PrintWriter;*/
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

/**
 *
 * @author Personal
 */
@WebServlet(name = "verCompra", urlPatterns = {"/verCompra"})
public class Sv_verCompra extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //Mantiene una sesion abierta
        HttpSession obj=request.getSession();
        
        
        /**
         * @param ua obtiene el usuario 
         * @param ced obtiene la cedula del usuario
         * @param nom_cli obtiene nombre del cliente
         * @param ron obtiene el rol del usuario
         * @param dat recibe la sentencia de ingresar, modificar y eliminar
         * @param con instancia la clase con el constructor Con_detalleVenta
         * @param mod instancia Mod_Facturas
         */
        String ua=(String) obj.getAttribute("usuario");
        String ced=(String) obj.getAttribute("cedulaa");
        String nom_cli=(String) obj.getAttribute("nombre_cli");
        String rol=(String) obj.getAttribute("rol");
        
        
        if(request.getParameter("btneli")!=null){
            
            boolean dat=false;
            int id=Integer.parseInt(request.getParameter("id"));
            
            
            Con_detalleVenta con=new Con_detalleVenta(id);
            Mod_Facturas mod=new Mod_Facturas();
            
            dat=mod.eliminar_factura(con);
            if(dat){
                JOptionPane.showMessageDialog(null,"Datos Eliminados");
            }
            else{
                JOptionPane.showMessageDialog(null,"Datos No Eliminados ");
            }
            
        }
        if(request.getParameter("btncan")!=null){
            int id=0;
            id=Integer.parseInt(request.getParameter("id"));
            Con_detalleVenta con=new Con_detalleVenta(id);
            Mod_Facturas mod=new Mod_Facturas();
            
            boolean dat=mod.modificar_factura(con);
            if(dat){
                JOptionPane.showMessageDialog(null,"Factura cancelada");
            }
            else{
                JOptionPane.showMessageDialog(null,"Factura No Cancelada ");
            }
           if(rol.equalsIgnoreCase("empleado")){
            response.sendRedirect("gestion_domicilios.jsp");
            }
        }
        
        if(request.getParameter("btnact")!=null){
            response.sendRedirect("verEmpleado.jsp");
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
