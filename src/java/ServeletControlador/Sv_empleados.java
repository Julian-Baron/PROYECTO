/**
 * Controlador para el control de empleados 
 * Contiene uso de constructores  y modelos para realizar la conexion con la base de datos
 *
 * @author JULIAN BARON
 */
package ServeletControlador;


import Constructor.Con_empleados;

import Modelos.Mod_empleados;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;


@WebServlet(name = "Sv_empleados", urlPatterns = {"/Sv_empleados"})
public class Sv_empleados extends HttpServlet {

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
             * @param a guarda la cedula a ingresar, modificar o eliminar del empleado
             * @param b guarda el nombre a ingresar, modificar o eliminar del empleado
             * @param c guarda el apellido a ingresar, modificar o eliminar del empleado
             * @param d guarda el telefono a ingresar, modificar o eliminar del empleado
             * @param e guarda el correo a ingresar, modificar o eliminar del empleado
             * @param f guarda el codigo a ingresar, modificar o eliminar del cliente del empleado
             * @param con llama al constructor para enviar los datos obtenidos.
             * @param md llama el modelo Mod_cliente para generar la CRUD 
             * 
             * Los JOptionPane.showMessageDialog mostraran mensajes en el aplicativo en caso de que la verificacion haya sido correcto o no lo haya sido
             */
             
            if (request.getParameter("modificar")!=null) {
                String a,b,c,e,f;
                boolean in;
                String d;
                a=request.getParameter("cedula");
                b=request.getParameter("nombre");
                c=request.getParameter("apellido");
                d=request.getParameter("telefono");
                e=request.getParameter("correo");
                f=request.getParameter("codigo");
                
                Con_empleados con=new Con_empleados(a, b, c, d, e, f);
                Modelos.Mod_empleados md=new Mod_empleados();
                
                in=md.modificar_empleados(con);
                
                JOptionPane.showMessageDialog(null, "Dentro del servelet" +a);
                
                if(in){
                    JOptionPane.showMessageDialog(null,"Datos modificados");
                   
                }
                else{
                    JOptionPane.showMessageDialog(null,"Datos NO modificados");

                }         
                
            }
            /*ELIMINAR PARAMETRO*/
            if (request.getParameter("eliminar")!=null) {
                String a,b,c,e,f;
                boolean in;
                String d;
                a=request.getParameter("cedula");
                b=request.getParameter("nombre");
                c=request.getParameter("apellido");
                d=request.getParameter("telefono");
                e=request.getParameter("correo");
                f=request.getParameter("codigo");       
                
                
                
                Con_empleados con=new Con_empleados(a, b, c, d, e, f);
                Modelos.Mod_empleados md=new Mod_empleados();
                
                in=md.eliminar_empleados(con);
           
                if(in){
                    JOptionPane.showMessageDialog(null,"Datos eliminados");
                   
                }
                else{
                    JOptionPane.showMessageDialog(null,"Datos NO eliminados");

                }    
                          
                
            }
            
            /*enviar parametro*/
            if (request.getParameter("enviar")!=null) {
                String a,b,c,e,f;
                boolean in;
                String d;
                a=request.getParameter("cedula");
                b=request.getParameter("nombre");
                c=request.getParameter("apellido");
                d=request.getParameter("telefono");
                e=request.getParameter("correo");
                f=request.getParameter("codigo");
                
                
                
                Con_empleados con=new Con_empleados(a, b, c, d, e, f);
                Modelos.Mod_empleados md=new Mod_empleados();
                
                in=md.insertar_empleados(con);
                
                if(in){
                    JOptionPane.showMessageDialog(null,"Datos guardados");
                }
                else{
                    JOptionPane.showMessageDialog(null,"Datos NO guardados");

                }
                
                
            }
            
            
            response.sendRedirect("Formulario_empleados.jsp"); //reenvia al jsp

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
