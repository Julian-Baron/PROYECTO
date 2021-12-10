/**
 * Controlador para el control de domicilios 
 * Contiene uso de constructores  y modelos para realizar la conexion con la base de datos
 *
 * @author JULIAN BARON
 */
package ServeletControlador;

import Constructor.Con_Domicilios;
/*import Constructor.Con_productos;*/
import Modelos.Mod_Domicilios;
/*import Modelos.Modelo_Productos;*/
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

@WebServlet(name = "Sv_domicilios", urlPatterns = {"/Sv_domicilios"})
public class Sv_domicilios extends HttpServlet {

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
        PrintWriter out = response.getWriter();
            /**
             * @param a guarda el codigo del domicilio a ingresar, modificar o eliminar del domicilio
             
             * @param c guarda el id de la compra a ingresar, modificar o eliminar del domicilio
             
             * @param e guara la fecha del domicilio a ingresar, modificar o eliminar del domicilio
             * @param f guarda la cedula del empleado para realizar el domicilio a ingresar, modificar o eliminar del cliente del domicilio
             * @param con llama al constructor para enviar los datos obtenidos.
             * @param md llama el modelo Mod_cliente para generar la CRUD 
             * 
             * Los JOptionPane.showMessageDialog mostraran mensajes en el aplicativo en caso de que la verificacion haya sido correcto o no lo haya sido
             */
            if (request.getParameter("enviar")!=null) {
                String a,c,e,f;
                boolean in;
                
                a=request.getParameter("codigo");
                c=request.getParameter("idcompra");                
                e=request.getParameter("fecha");
                f=request.getParameter("cedula");
                
                
                Con_Domicilios con=new Con_Domicilios(f, a, e, c);
                Modelos.Mod_Domicilios md=new Mod_Domicilios();
                
                in=md.insertar_domicilio(con);
           
                if(in){
                    JOptionPane.showMessageDialog(null,"Datos guardados");
                   
                }
                else{
                    JOptionPane.showMessageDialog(null,"Datos NO guardados");

                }
                        
                
            }
            
            
            if (request.getParameter("modificar")!=null) {
                String a,c,e,f;
                boolean in;
                
                a=request.getParameter("codigo");
                c=request.getParameter("idcompra");                
                e=request.getParameter("fecha");
                f=request.getParameter("cedula");
                
                
                Con_Domicilios con=new Con_Domicilios(f,a,e,c);
                Modelos.Mod_Domicilios md=new Mod_Domicilios();
                
                 in=md.modificar_domicilio(con);
           
                if(in){
                    JOptionPane.showMessageDialog(null,"Datos guardados");
                   
                }
                else{
                    JOptionPane.showMessageDialog(null,"Datos NO modificados");

                }
                          
                
            }
            if (request.getParameter("eliminar")!=null) {
                String a,c,e,f;
                boolean in;
                
                a=request.getParameter("codigo");
                c=request.getParameter("idcompra");                
                e=request.getParameter("fecha");
                f=request.getParameter("cedula");
                
                Con_Domicilios con=new Con_Domicilios(f,a,e,c);
                Modelos.Mod_Domicilios md=new Mod_Domicilios();
                
                 in=md.eliminar_domiciliov(con);
           
                if(in){
                    JOptionPane.showMessageDialog(null,"Datos eliminados");
                   
                }
                else{
                    JOptionPane.showMessageDialog(null,"Datos NO eliminados");

                }
                     
                
            }
            response.sendRedirect("Formulario_Domicilios.jsp");// Renvia a la pagina jsp

        
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
