/**
 * Controlador para el control de compras
 * Contiene uso de constructores  y modelos para realizar la conexion con la base de datos
 *
 * @author JULIAN BARON
 */
package ServeletControlador;

import Constructor.Con_Compras;
/*import Constructor.Con_productos;*/
import Modelos.Mod_Compras;
/*import Modelos.Modelo_Productos;*/
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

@WebServlet(name = "Sv_compras", urlPatterns = {"/Sv_compras"})
public class Sv_compras extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {

            /**
             * @param a obtiene el id de la compra para ingresar, modificar o
             * eliminar una compra
             * @param b obtiene el codigo del producto para ingresar, modificar
             * o eliminar una compra
             * @param c obtiene la cantidad total del producto a realizar para
             * la compra
             * @param e obtiene la cedula de la persona para ingresar, modificar
             * o eliminar una compra
             * @param in recepciona si se realizo la consulta correctamente o si
             * no lo hizo.
             * @param con instancia al constructor Con_compras para enviar los
             * datos del los parametros a,b,c,e
             * @param md llama el modelo de Mod_compras para realizar las
             * sentencias con la base de datos
             */
            if (request.getParameter("enviar") != null) {
                String a, b, e, f;
                int c;
                boolean in;
                int d;
                a = request.getParameter("id_compra");
                b = request.getParameter("Codigo_pro");
                c = Integer.parseInt(request.getParameter("Cantidad re"));
                e = request.getParameter("Cedula");

                Con_Compras con = new Con_Compras(e, b, c, a);
                Modelos.Mod_Compras md = new Mod_Compras();

                in = md.insertar_compra(con);

                if (in) {
                    JOptionPane.showMessageDialog(null, "Datos guardados");

                } else {
                    JOptionPane.showMessageDialog(null, "Datos NO guardados");

                }

            }
            if (request.getParameter("modificar") != null) {
                String a, b, e, f;
                int c;
                boolean in;
                int d;
                a = request.getParameter("id_compra");
                b = request.getParameter("Codigo_pro");
                c = Integer.parseInt(request.getParameter("Cantidad re"));
                e = request.getParameter("Cedula");

                Con_Compras con = new Con_Compras(e, b, c, a);
                Modelos.Mod_Compras md = new Mod_Compras();

                in = md.Modificar_compra(con);

                if (in) {
                    JOptionPane.showMessageDialog(null, "Datos modificados");

                } else {
                    JOptionPane.showMessageDialog(null, "Datos NO nodificados");

                }

            }

            if (request.getParameter("eliminar") != null) {

                String a, b, e, f;
                int c;
                boolean in;
                int d;

                a = request.getParameter("id_compra");

                JOptionPane.showMessageDialog(null, "jajaj" + a);

                Con_Compras con = new Con_Compras(a);
                Modelos.Mod_Compras md = new Mod_Compras();

                in = md.eliminar_compra(con);

                if (in) {
                    JOptionPane.showMessageDialog(null, "Datos eliminados");

                } else {
                    JOptionPane.showMessageDialog(null, "Datos NO eliminados");

                }

            }
            response.sendRedirect("Formulario_Comprador.jsp");   // Redirecciona al formulario comprador      
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
