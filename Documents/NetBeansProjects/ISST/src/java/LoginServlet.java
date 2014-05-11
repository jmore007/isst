/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author coki1306
 */
@WebServlet(urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    private final String USER_ID = "gestor";
    private final String PASS = "1234";

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
        //processRequest(request, response);
        
        // get request parameters for userID and password
        String usuario = request.getParameter("login");
        String pass = request.getParameter("password");
         if(USER_ID.equals(usuario) && PASS.equals(pass)){
            HttpSession session = request.getSession();
            session.setAttribute("user", "gestor");
            //setting session to expiry in 2 mins
            session.setMaxInactiveInterval(2*60);
            response.sendRedirect("index.jsp");
         }else{
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/formulario.jsp");
            PrintWriter out= response.getWriter();
            out.println("<font color=red>Usuario o clave incorrectos, por favor pruebe de nuevo.</font>");
            rd.include(request, response);
        }
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
