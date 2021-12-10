/**
 * Controlador para el control de registro de datos
 * 
 * Contiene uso de constructores  y modelos para realizar la conexion con la base de datos
 *
 * @author JULIAN BARON
 */
package ServeletControlador;

import Constructor.Con_actualizarDatos;
import Modelos.Mod_login;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

@WebServlet(name = "registrarDatos", urlPatterns = {"/registrarDatos"})
public class Sv_registrarDatos extends HttpServlet {

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
         * REGISTRO DE DATOS DE USUARIOS 
         * @param nom nombre de usuario
         * @param apellido apellido de usuario
         * @param correo correo de usuario
         * @param direccion direccion del usuario
         * @param nombreusu nombre de usuario  
         * @param password contraseña del usario
         * @param sexo sexo de usuario
         * @param telefono de usuario
         * @param a vacio
         * @param b vacion
         * @param mod realiza la instancia con el modelo Mod_login
         * El parametro password realiza la codificacion de la contraseña con encriptacion MD5
         * @param con realiza la instancia del constructor Con_actualizarDatos
         * @param in realiza la sentencua de insertar en  tabla cliente
         * @param in2 realiza la sentencia de insertar en la tabla usuario
         */
        
        if(request.getParameter("aceptar")!=null){
            try {
                String nom,apellido,correo,direccion,nombreusu,password,sexo,telefono,a="",b="";
                int cedula;
                boolean in, in2;
                nom=request.getParameter("nombre");
                apellido=request.getParameter("apellidos");
                correo=request.getParameter("correo");
                direccion=request.getParameter("direccion");
                telefono=request.getParameter("telefono");
                nombreusu=request.getParameter("nombre_usu");
                password=request.getParameter("password");
                sexo=request.getParameter("sexo");
                cedula=Integer.parseInt(request.getParameter("cedula"));
                Mod_login mod=new Mod_login();    
                password=mod.getMD5(password);
                Con_actualizarDatos con=new Con_actualizarDatos(nom, apellido, correo, direccion, telefono, nombreusu, password, sexo, cedula, a, b);
                
                
                
                
                in=mod.insertar_usuarioCli(con);
                in2=mod.insertar_usuarioUsu(con);
                
                if(in==true && in2==true){
                    JOptionPane.showMessageDialog(null,"Datos ingresados");
                    response.sendRedirect("index.jsp");
                }
                else{
                    JOptionPane.showMessageDialog(null,"Datos no ingresados");
                    response.sendRedirect("registrar.jsp");
                }
            } catch (Exception e) {
                
                JOptionPane.showMessageDialog(null,"Error "+e);
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
