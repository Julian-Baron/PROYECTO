/**
 * Controlador para el control de pdf
 * Contiene uso de constructores  y modelos para realizar la conexion con la base de datos
 *
 * @author JULIAN BARON
 */
package ServeletControlador;

import Constructor.Con_Compras;
import Modelos.Mod_Compras;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
/*

import com.itextpdf.text.PageSize;

 */
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;
import java.io.OutputStream;
/*

import java.io.PrintWriter;

 */
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

@WebServlet(name = "Sv_pdf", urlPatterns = {"/Sv_pdf"})
public class Sv_pdf extends HttpServlet {

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
        /**
         * Condicion para realizar el pdf
         */
        if (request.getParameter("btnpdf") != null) {
            this.pdf(request, response);
        }

    }

    protected void pdf(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            response.setContentType("aplicacionpdf.pdf");//nombre del archivo
            OutputStream out = response.getOutputStream();

            /**
             * @param list devolvera los resultados alamcenados en el construcor
             * de Con_compras
             * @param md realizara la consulta del modelo Mod_compras
             * @param us instancia de Con_compras
             */
            ArrayList<Constructor.Con_Compras> list = new ArrayList<>();
            Modelos.Mod_Compras md = new Mod_Compras();
            Con_Compras us = new Con_Compras();

            list = md.consultarcompras();

            Document documento = new Document();// Crea documento

            PdfWriter.getInstance(documento, out);// utilizacion de una libreria

            documento.open();
            Paragraph pq = new Paragraph();
            Font titulo = new Font(Font.FontFamily.ZAPFDINGBATS, 15, Font.BOLD, BaseColor.BLACK);
            pq.add(new Phrase("LISTADO DE PRODUCTOS ", titulo));
            pq.setAlignment(pq.ALIGN_CENTER);
            pq.add(new Phrase(Chunk.NEWLINE));

            /**
             * Convierte los datos almacenados en tablas para generar el pdf
             */
            PdfPTable tabla = new PdfPTable(6);
            tabla.setWidthPercentage(80);
            PdfPCell Id_fact = new PdfPCell(new Paragraph("ID_FACTURA", FontFactory.getFont("Arial", 12, Font.ITALIC, BaseColor.BLACK)));
            PdfPCell Fecha_fac = new PdfPCell(new Paragraph("Fecha_fac", FontFactory.getFont("Arial", 12, Font.ITALIC, BaseColor.BLACK)));
            PdfPCell Cedula = new PdfPCell(new Paragraph("Cedula", FontFactory.getFont("Arial", 12, Font.ITALIC, BaseColor.BLACK)));
            PdfPCell Id_compra = new PdfPCell(new Paragraph("Id_compra", FontFactory.getFont("Arial", 12, Font.ITALIC, BaseColor.BLACK)));
            PdfPCell Cod_domicilio = new PdfPCell(new Paragraph("Cod_domicilio", FontFactory.getFont("Arial", 12, Font.ITALIC, BaseColor.BLACK)));
            PdfPCell Nombre_compra = new PdfPCell(new Paragraph("Nombre_compra", FontFactory.getFont("Arial", 12, Font.ITALIC, BaseColor.BLACK)));

            documento.add(pq);
            tabla.addCell(Id_fact);
            tabla.addCell(Fecha_fac);
            tabla.addCell(Cedula);
            tabla.addCell(Id_compra);
            tabla.addCell(Cod_domicilio);
            tabla.addCell(Nombre_compra);

            for (int i = 0; i < list.size(); i++) {
                us = list.get(i);

                tabla.addCell(us.getCod_pro());
                tabla.addCell(us.getCod_pro());
                tabla.addCell(us.getCod_pro());
                tabla.addCell(us.getCod_pro());
                tabla.addCell(us.getCod_pro());
                tabla.addCell(us.getCod_pro());
            }

            documento.add(tabla);
            documento.close();

            JOptionPane.showMessageDialog(null, "Pdf descargado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Pdf Error verifique el problema");
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
