/**
 * Controlador para el control de productos
 * Contiene uso de constructores  y modelos para realizar la conexion con la base de datos
 *
 * @author JULIAN BARON
 */

package controllers;

import Constructor.Con_productos;
import Modelos.Modelo_Productos;


/**
 * Clase general
 * 
 */
public class ControladorProducto {
    
    public String getProductos(){
        //Llamado de instancia
        Modelos.Modelo_Productos mp=new Modelo_Productos();
        /**
         * @param htmlcode guarda lo que va dentro del java web
         */
        String  htmlcode ="";
        
        for(Con_productos con: mp.consultarProductos()){
            htmlcode  +="<div class=\"col-xl-4\">"
                    + "<div class=\"card\" style=\"\">\n" +
"                                <img src=\""+con.getImg()+"\" class=\"card-img-top rounded mx-auto d-block\" alt=\"...\" style=\"width: 350px;height: 250px;\">\n" +
"                                <h1 class=\"card-header\" style=\"color:black;\">"+con.getNombre_pro()+"</h1>\n" +
"                                    <div class=\"card-body text-center\">\n"+
"                                      <p class=\"card-text\">Precio <b>"+con.getPrecio()+"</b></p>\n" +
"                                      <p class=\"card-footer\" style=\"color:black;\">"+con.getDescripcion()+"</p>\n" +
"                                      <div>\n" +
"                                          <a href=\"producto-detalles.jsp?id="+con.getCod_pro()+"\" class=\"btn btn-outline-info\">Ver detalles</a>\n" +

"                                      </div>\n" +
"                                      \n" +
"                         </div>\n"
                    + "</div>\n" +
"                    \n"      
                    
             + "</div>";                                                          
        }
        
        return htmlcode;
    }
    
    /**
     * 
     * @param id obtiene el producto a mostrar
     * @return el producto a enlistar
     */
    
    public Con_productos getproducto(String id){
        
        return new Modelos.Modelo_Productos().listar(id);
        
    }
}
