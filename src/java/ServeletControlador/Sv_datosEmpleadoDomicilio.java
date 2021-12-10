/**
 * Controlador para el control de compras carrito
 * Contiene uso de constructores  y modelos para realizar la conexion con la base de datos
 *
 * @author JULIAN BARON
 */
package ServeletControlador;

import Constructor.Con_Domicilios;
import Constructor.Con_Facturas;
/*import Constructor.Con_empleados;*/
import Modelos.Mod_Domicilios;
import Modelos.Mod_Facturas;
/*import Modelos.Mod_empleados;*/
import java.io.IOException;
/*import java.io.PrintWriter;*/
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author Personal
 */
@WebServlet(name = "datosEmpleadoDomicilio", urlPatterns = {"/datosEmpleadoDomicilio"})
public class Sv_datosEmpleadoDomicilio extends HttpServlet {

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
        String empleado=request.getParameter("empleado");//obtiene el empleado 
        
        /**
         * @param factura recibe el codigo de la factura para realizar el domicilio
         * @param cedula recibira la cedula de los empleados que realizaran el domiciio
         * @param facturaa recibira el numero de cedula a enviar al constructor Con_facturas
         * @param can instancia el constructor Con_facturas
         * @param mod instancia el modelo Mod_Domicilios
         * @param con instancia el constructor Con_Domicilios
         * @param flag recolecta el resultado del modelo realizado instertar_domicilio
         * @param flag2 recolecta el resultado de modificar_facturaEstado
         */
        
        if(request.getParameter("btnact")!=null){
            String factura=request.getParameter("factura");
            String cedula=request.getParameter("cedulaaa");
            
            int facturaa=Integer.parseInt(request.getParameter("factura"));
            
            
            Con_Facturas can=new Con_Facturas("",facturaa);
            Con_Domicilios con=new Con_Domicilios(cedula, factura);
            Mod_Domicilios mod=new Mod_Domicilios();
            Mod_Facturas mad=new Mod_Facturas();
            boolean flag=mod.insertar_domicilio(con);
            boolean flag2=mad.modificar_facturaEstado(can);
            
            if(flag&&flag2){
                JOptionPane.showMessageDialog(null, "Datos Guardados");
                response.sendRedirect("gestion_domicilios.jsp");// redirecciona a gestionar los domicilios
            }
            else{
                JOptionPane.showMessageDialog(null, "Datos No Guardados");
                response.sendRedirect("verEmpleados.jsp");// redirecciona a los empleados a asignar el domicilio
            }
            
            
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
