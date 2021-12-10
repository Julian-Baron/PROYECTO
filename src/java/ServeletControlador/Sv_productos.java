/**
 * Controlador para el control de productos
 * Contiene uso de constructores  y modelos para realizar la conexion con la base de datos
 *
 * @author JULIAN BARON
 */
package ServeletControlador;

import Constructor.Con_productos;
import Modelos.Modelo_Productos;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.swing.JOptionPane;

@WebServlet(name = "Sv_productos", urlPatterns = {"/Sv_productos"})
@MultipartConfig
public class Sv_productos extends HttpServlet {

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
             * MODIFICAR PARAMETRO
             *
             * @param a guarda el codigo del producto a ingresar, modificar o
             * eliminar del producto
             * @param b guarda el nombre a ingresar, modificar o eliminar del
             * producto
             * @param c guarda la marca a ingresar, modificar o eliminar del
             * producto
             * @param d guarda la cantidad del producto a ingresar, modificar o
             * eliminar del producto
             * @param e guarda el precio del producto a ingresar, modificar o
             * eliminar del producto
             * @param f guarda la descripcion a ingresar, modificar o eliminar
             * del producto
             * @param con llama al constructor para enviar los datos obtenidos.
             * @param md llama el modelo Mod_cliente para generar la CRUD
             * @param in obtiene el resultado de la ejecucion de la sentencia
             *
             * Los JOptionPane.showMessageDialog mostraran mensajes en el
             * aplicativo en caso de que la verificacion haya sido correcto o no
             * lo haya sido
             */
            if (request.getParameter("enviar") != null) {
                String a, b, c, f;
                boolean in;
                int d, e;
                a = request.getParameter("Codigo_pro");
                b = request.getParameter("nombre");
                c = request.getParameter("Marca");
                d = Integer.parseInt(request.getParameter("Cantidad"));
                e = Integer.parseInt(request.getParameter("Precio"));
                f = request.getParameter("Descripcion");
                //Almacenar imagen

                /**
                 * Generacion de codificacion de imagen para guardar en el
                 * proyecto
                 */
                Part part = request.getPart("imga");

                String nomfoto = part.getSubmittedFileName();
                String nombre = b + " " + nomfoto;
                // Se guarda en el proyexto
                String url = "D:\\Personal\\Documents\\NetBeansProjects\\Proyecto\\web\\img\\" + nombre;
                String url2 = "img/" + nombre;

                //Generacion de imagen
                InputStream file = part.getInputStream();
                File fa = new File(url);
                FileOutputStream sal = new FileOutputStream(fa);

                int num = file.read();

                //Confirmacion de generacion de partidura de la imagen
                while (num != -1) {
                    sal.write(num);
                    num = file.read();
                }
                /*fin de almacenar imagen*/
                Con_productos con = new Con_productos(a, f, d, c, b, e, url2);
                Modelo_Productos md = new Modelo_Productos();

                in = md.insertar_producto(con);

                if (in) {
                    JOptionPane.showMessageDialog(null, "Datos guardados");

                } else {
                    JOptionPane.showMessageDialog(null, "Datos NO guardados");

                }
                response.sendRedirect("formulario_Productos.jsp");

            }

            //MODIFICAICON DE PRODUCTOS
            if (request.getParameter("modificar") != null) {
                String a, b, c, f;
                boolean in;
                int d, e;
                a = request.getParameter("Codigo_pro");
                b = request.getParameter("nombre");
                c = request.getParameter("Marca");
                d = Integer.parseInt(request.getParameter("Cantidad"));
                e = Integer.parseInt(request.getParameter("Precio"));
                f = request.getParameter("Descripcion");
                //Almacenar imagen
                /**
                 * FUNCION EXACTAMENTE IGUAL QUE EN LA PARTE SUPERIOR
                 */
                Part part = request.getPart("imga");

                String nomfoto = part.getSubmittedFileName();
                String nombre = b + " " + nomfoto;

                String url = "D:\\Personal\\Documents\\NetBeansProjects\\Proyecto\\web\\img\\" + nombre;
                String url2 = "img/" + nombre;

                InputStream file = part.getInputStream();
                File fa = new File(url);
                FileOutputStream sal = new FileOutputStream(fa);

                int num = file.read();
                while (num != -1) {
                    sal.write(num);
                    num = file.read();
                }
                //fin de almacenar imagen

                Con_productos con = new Con_productos(a, f, d, c, b, e, url2);
                Modelo_Productos md = new Modelo_Productos();

                in = md.modificar_producto(con);

                if (in) {
                    JOptionPane.showMessageDialog(null, "Datos modificados");
                } else {
                    JOptionPane.showMessageDialog(null, "Datos NO modificados");

                }
                response.sendRedirect("formulario_Productos.jsp");

            }

            //ELIMINACION DE PRODUCTOS
            if (request.getParameter("eliminar") != null) {
                String a, b, c, e, f;
                boolean in;
                int d;
                a = request.getParameter("Codigo_pro");

                Con_productos con = new Con_productos(a);
                Modelo_Productos md = new Modelo_Productos();

                in = md.eliminar_producto(con);

                if (in) {
                    JOptionPane.showMessageDialog(null, "Datos eliminados");

                } else {
                    JOptionPane.showMessageDialog(null, "Datos NO eliminados");

                }
                response.sendRedirect("formulario_Productos.jsp");

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
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
