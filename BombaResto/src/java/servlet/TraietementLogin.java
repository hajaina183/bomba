/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import classe.Login;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jayks
 */
public class TraietementLogin extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TraietementLogin</title>");            
            out.println("</head>");
            out.println("<body>");
            try {
                String nom = request.getParameter("nom").trim();
                String mdp = request.getParameter("mdp").trim();
                Login l = new Login();
                int r = l.estConnecter(nom, mdp);
                if(r!=0) {
                    Login login = l.getLogin(nom, mdp);
                    HttpSession session = request.getSession(true);
                    session.setAttribute("grade", login.getGrade());
                    if(Integer.parseInt(session.getAttribute("grade").toString()) == 1) {
                        RequestDispatcher dispatch = request.getRequestDispatcher("/TraitementCommande");
                        dispatch.forward(request,response);
                    } else if(Integer.parseInt(session.getAttribute("grade").toString()) == 2) {
                        RequestDispatcher dispatch = request.getRequestDispatcher("/TraitementCuisine");
                        dispatch.forward(request,response);
                    } else if(Integer.parseInt(session.getAttribute("grade").toString()) == 3) {
                        RequestDispatcher dispatch = request.getRequestDispatcher("/TraitementCaisse");
                        dispatch.forward(request,response);
                    } else if(Integer.parseInt(session.getAttribute("grade").toString()) == 4) {
                        RequestDispatcher dispatch = request.getRequestDispatcher("/TraitementCommande");
                        dispatch.forward(request,response);
                    } else if(Integer.parseInt(session.getAttribute("grade").toString()) == 5) {
                        RequestDispatcher dispatch = request.getRequestDispatcher("/TraitementListePayer");
                        dispatch.forward(request,response);
                    }
                }
            } catch (Exception e) {
                out.println("<h1>Erreur : " + e.getMessage() + "</h1>");
                e.printStackTrace();
            }
            out.println("</body>");
            out.println("</html>");
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
