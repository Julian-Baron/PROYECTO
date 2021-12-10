/**
 * Controlador para el control de actualizacion de datos
 * Contiene uso de constructores  y modelos para realizar la conexion con la base de datos
 *
 * @author JULIAN BARON
 */
package ServeletControlador;

import Constructor.Con_actualizarDatos;
import Modelos.Mod_actualizarDatos;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "actualizar_datos", urlPatterns = {"/actualizar_datos"})
public class actualizar_datos extends HttpServlet {

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
         * REGISTRO DE DATOS DE USUARIOS 
         * @param nom nombre de usuario
         * @param apellido apellido de usuario
         * @param correo correo de usuario
         * @param direccion direccion del usuario
         * @param nombreusu nombre de usuario  
         * @param password contraseña del usario
         * @param sexo sexo de usuario
         * @param telefono de usuario
         * @param mod realiza la instancia con el modelo Mod_login
         * El parametro password realiza la codificacion de la contraseña con encriptacion MD5
         * @param con realiza la instancia del constructor Con_actualizarDatos
         * @param in realiza la sentencua de insertar en  tabla cliente
         */
        
             if(request.getParameter("aceptar")!=null){
                String nom,apellido,correo,direccion,nombreusu,password,sexo;
                int cedula;
                boolean in;
                nom=request.getParameter("nombre");
                apellido=request.getParameter("apellidos");
                correo=request.getParameter("correo");
                direccion=request.getParameter("direccion");
                String telefono=request.getParameter("telefono");
                nombreusu=request.getParameter("nombre_usu");
                password=request.getParameter("contrasena");
                sexo=request.getParameter("sexo");
                cedula=Integer.parseInt(request.getParameter("cedula"));

                Mod_actualizarDatos mod=new Mod_actualizarDatos();
                password=mod.getMD5(password);
                Con_actualizarDatos con=new Con_actualizarDatos(nom, apellido, correo, direccion, telefono, nombreusu, password, sexo, cedula);
                
                in=mod.insertar_datos(con);

                if(in){
                    JOptionPane.showMessageDialog(null, "Datos Guardados");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Datos NO Guardados");
                }
                
                response.sendRedirect("datos_actualizar.jsp");
                
            }
             else{
                 response.sendRedirect("index.jsp"); //redirecciona
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
