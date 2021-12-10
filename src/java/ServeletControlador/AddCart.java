/**
 * Controlador para agregar articulos al carrito de compras
 * Contiene uso de constructores  y modelos para realizar la conexion con la base de datos
 * @author JULIAN BARON
 */
package ServeletControlador;

import Constructor.Articulo;
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

/**
 *
 * @author Julian Baron
 */
@WebServlet(name = "AddCart", urlPatterns = {"/agregarproducto"})
public class AddCart extends HttpServlet {

    //agregarproducto
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
         * @param contador realiza la cantidad de veces que se ingresa un articulo al carrito
         * @param cantidad obtendra la cantidad dada por el usuario de un articulo
         * @param idproducto obtiene en id de el producto para agregar al carrito
         * @param sesion mantendra la sesion del usuario abierta
         * @param articulos guardara los productos totales que se agregaran al carrito
         */
        int contador = 0;
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));
        String idproducto = request.getParameter("id");

        HttpSession sesion = request.getSession(true);
        /**
         *Crea un array list nuevo para agregar productos, si ya cuenta con productos agregados mantendra ese array list
         */
        
        ArrayList<Articulo> articulos = sesion.getAttribute("carrito") == null ? new ArrayList<>() : (ArrayList) sesion.getAttribute("carrito");
        
        // Permite agregar nuevos articulos 
        boolean flag = false;
        // En caso de que se ingrese una cantidad mayo a 0 de un articulo realiza un bucle para ingresar nuevos articulos al carro en la sesion actual
        if (articulos.size() > 0) {
            for (Articulo a : articulos) {
                if (idproducto.equalsIgnoreCase(a.getIdProducto())) {
                    a.setCantidad(a.getCantidad() + cantidad);
                    flag = true;
                    break;
                }
                contador++;
            }
        }
        
        // Agrega articulos al carrito
        if (!flag) {
            articulos.add(new Articulo(idproducto, cantidad));
        }
        
        /**
         * Envia a la sesion actual la cantidad nueva de articulos a agregar al carrito
         */
        sesion.setAttribute("carrito", articulos);
        sesion.setAttribute("contador", contador);
        /**
         * Redirecciona al la pagina de carrito.jsp
         * 
         */
        response.sendRedirect("Carrito.jsp");
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
