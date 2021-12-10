/**
 * Controlador para eliminar articulos al carrito de compras
 * Contiene uso de constructores  y modelos para realizar la conexion con la base de datos
 *
 * @author JULIAN BARON
 */
package ServeletControlador;

import Constructor.Articulo;
import Constructor.Con_productos;
import controllers.ControladorProducto;
import java.io.IOException;
/*

import java.io.PrintWriter;


 */
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "DeleteItem", urlPatterns = {"/borraritem"})
public class DeleteItem extends HttpServlet {

    //borraritem
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
        /**
         * @param idproducto recepciona el id del producto que se va a eliminar
         * @param sesion recepciona la sesion que se encuentra actualmente
         * activa
         * @param articulos crea una instancia para llamar la clase Articulos y
         * recepcionar la cantidad total de articulos que existen en el carrito
         * @param total recepciona nuevamente la cantidad total del precio de
         * los articulos sumados
         */

        String idproducto = request.getParameter("idproducto");
        HttpSession sesion = request.getSession(true);
        ArrayList<Articulo> articulos = sesion.getAttribute("carrito") == null ? null : (ArrayList) sesion.getAttribute("carrito");

        /**
         * Si la cantidad de articulos en mayor a vacia que me elimine el
         * articulo seleccionado del carro de compras
         */
        if (articulos != null) {
            for (Articulo a : articulos) {//selecciona el articulo que esta en el carro de compras para eliminar
                if (a.getIdProducto().equalsIgnoreCase(idproducto)) {
                    articulos.remove(a); // Remueve el articulo seleccionado
                    break;
                }
            }
        }

        double total = 0;

        /**
         * Llama al controlador de los productos a mostrar en el carro para
         * mostrar la cantidad total de las compras
         */
        controllers.ControladorProducto cp = new ControladorProducto();
        for (Articulo a : articulos) {
            Con_productos producto = cp.getproducto(a.getIdProducto());
            total += a.getCantidad() * producto.getPrecio();

        }

        /**
         * Muestra la cantidad total del precio de las compras en decimales
         */
        response.getWriter().print(Math.round(total * 100.0) / 100.0);

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
