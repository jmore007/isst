/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Diego San Cristobal
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/ListaProductos"})
public class ListaProductos extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, Exception {
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
             String nombre = "pepe";
    Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost/restaurante", "isst", "isst");
        String query = "SELECT * FROM products";
        PreparedStatement pst = connection.prepareStatement(query);
        ResultSet rs = pst.executeQuery();
out.println("<html>\n" +
"  <head>\n" +
"	  <title>Restaurante ISST | Galeria</title>\n" +
"	  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
"	  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1\">\n" +
"	  <link href=\"css/style.css\" rel=\"stylesheet\" type=\"text/css\"  media=\"all\" />\n" +
"	  <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>\n" +
" </head>\n" +
"	<body>\n" +
"	<!----start-header----->\n" +
"	 <div class=\"header\">\n" +
"	     <div class=\"wrap\">\n" +
"			<div class=\"top-header\">\n" +
"				<div class=\"logo\">\n" +
"					<a href=\"index.jsp\"><img src=\"images/logo.png\" title=\"logo\" /></a>\n" +
"				</div>\n" +
"				<div class=\"social-icons\">\n" +
"					<ul>\n" +
"						<li><a href=\"#\"><img src=\"images/facebook.png\" title=\"facebook\" /></a></li>\n" +
"						<li><a href=\"#\"><img src=\"images/twitter.png\" title=\"twitter\" /></a></li>\n" +
"						<li><a href=\"#\"><img src=\"images/google.png\" title=\"google pluse\" /></a></li>\n" +
"						<li><a class=\"button1\" href=\"formulario.jsp\">Entrar</a></li>\n" +
"					</ul>\n" +
"				</div>\n" +
"				<div class=\"clear\"> </div>\n" +
"			</div>\n" +
"			<!---start-top-nav---->\n" +
"			<div class=\"top-nav\">\n" +
"				<div class=\"top-nav-left\">\n" +
"					<ul>\n" +
"						<li ><a href=\"index.jsp\">Home</a></li>\n" +
"						<li><a href=\"about.jsp\">Sobre nosotros</a></li>\n" +
"						<li><a href=\"services.jsp\">Servicios</a></li>\n" +
"						<li class=\"active\"><a href=\"gallery.jsp\">Galeria</a></li>\n" +
"						<li><a href=\"contact.jsp\">Contacto</a></li>\n" +
"						<div class=\"clear\"> </div>\n" +
"					</ul>\n" +
"				</div>\n" +
"				\n" +
"				<div class=\"clear\"> </div>\n" +
"			</div>\n" +
"			<!---End-top-nav---->\n" +
"		</div>\n" +
"	</div>\n" +
"   <!----End-header----->\n" +
"		 <!---start-content---->\n" +
"		 <div class=\"content\">\n" +
"		 	<!---start-gallery----->\n" +
"		 	<div class=\"gallerys\">\n" +
"		 		<div class=\"wrap\">\n" +
"					<h3>Galeria</h3>\n" +
"					<div class=\"gallery-grids\">\n" +
" ");
        while(rs.next()) {
            System.out.println(rs.getInt(1)+","+rs.getString(2));
            out.println("<div class=\"gallery-grid\">\n" +
"							<a href=\"#\"><img src=\"images/slider1.jpg\" alt=\"\"><span>$45</span></a>\n" +
"							<h4>"+ rs.getInt(1) +"</h4>\n" +
"							<p> "+rs.getString(2)+ "</p> " +
"							<div class=\"gallery-button\"><a href=\"#\">Más Info</a></div>\n" +
"						</div>");
        }
            
            
            
            
            
            out.println("	<div class=\"clear\"> </div>\n" +
"					</div>\n" +
"					<!--div class=\"gallery-grids\">\n" +
"						<div class=\"gallery-grid\">\n" +
"							<a href=\"#\"><img src=\"images/slider3.jpg\" alt=\"\"><span>$55</span></a>\n" +
"							<h4>Fusce suscipit varius mi. Cum</h4>\n" +
"							<p>Praesent vestibulum molestie lacus. Aenean nonummy hendrerit mauris. Phasellus porta. Fusce suscipit varius mi. Cum sociis natoque penatibus et magnis dis parturient montes.</p>\n" +
"							<div class=\"gallery-button\"><a href=\"#\">Más Info</a></div>\n" +
"						</div>\n" +
"						<div class=\"gallery-grid grid2\">\n" +
"							<a href=\"#\"><img src=\"images/slider1.jpg\" alt=\"\"><span>$75</span></a>\n" +
"							<h4>sociis natoque penatibus et</h4>\n" +
"							<p>Praesent vestibulum molestie lacus. Aenean nonummy hendrerit mauris. Phasellus porta. Fusce suscipit varius mi. Cum sociis natoque penatibus et magnis dis parturient montes.</p>\n" +
"							<div class=\"gallery-button\"><a href=\"#\">Más Info</a></div>\n" +
"						</div>\n" +
"						<div class=\"gallery-grid\">\n" +
"							<a href=\"#\"><img src=\"images/slider2.jpg\" alt=\"\"><span>$42</span></a>\n" +
"							<h4>hendrerit mauris. Phasellus</h4>\n" +
"							<p>Praesent vestibulum molestie lacus. Aenean nonummy hendrerit mauris. Phasellus porta. Fusce suscipit varius mi. Cum sociis natoque penatibus et magnis dis parturient montes.</p>\n" +
"							<div class=\"gallery-button\"><a href=\"#\">Más Info</a></div>\n" +
"						</div>\n" +
"					</div-->					\n" +
"				    <div class=\"clear\"> </div>\n" +
"				    <div class=\"projects-bottom-paination\">\n" +
"						<ul>\n" +
"							<li class=\"active\"><a href=\"#\">1</a></li>\n" +
"							<li><a href=\"#\">2</a></li>\n" +
"						</ul>\n" +
"					</div>\n" +
"				</div>\n" +
"				</div>\n" +
"		 	<!---End-gallery----->\n" +
"		 <!---End-content---->\n" +
"		 <!---start-footer---->\n" +
"		 \n" +
"			</div>\n" +
"			<div class=\"clear\"> </div>\n" +
"		</div>\n" +
"		<div class=\"clear\"> </div>\n" +
"	</div>\n" +
"	\n" +
"		 <!---End-footer---->\n" +
"	</body>\n" +
"</html>\n" +
"\n" +
"");
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
    //@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // processRequest(request, response);
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
    // protected void doPost(HttpServletRequest request, HttpServletResponse response)
         //   throws ServletException, IOException {
       // processRequest(request, response);
    //}

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    //@Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
