
package servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet ("/lista")
public class Carrito extends HttpServlet{
    
 @Override
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
     
     response.setContentType("text/html;charset=UTF-8");
     
     HttpSession sesion= request.getSession();
     
     List<String>articulos= (List<String>) sesion.getAttribute("articulos");
     
     if(articulos==null){
         articulos= new ArrayList<>();
         sesion.setAttribute("articulos", articulos);
     }
     
     String articulo= request.getParameter("producto");
     
     if(articulo != null && !articulo.trim().equals("")){
         articulos.add(articulo);
     }
     
     PrintWriter out=response.getWriter();
     out.print("<h1>Lista de articulos<h1>");
     out.print("<br>");
     out.print("<ol>");
     for(String articuloss: articulos){
         out.print("<li>"+articuloss+"</li>");
                       
     }
     out.print("</ol>");
     out.print("<br>");
     out.print("<a href='/CarritoCompras'>Sigue cargando</a>");
     out.close();
    
     
 }
    
}
