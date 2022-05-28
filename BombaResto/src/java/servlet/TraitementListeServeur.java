/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import classe.PourboireServeur;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class TraitementListeServeur extends HttpServlet {

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
            out.println("<title>Servlet TraitementListeServeur</title>");            
            out.println("</head>");
            out.println("<body>");
            try {
                HttpSession session = request.getSession(true);
                int grade = Integer.parseInt(session.getAttribute("grade").toString());
                if(request.getParameter("date1")!=null && request.getParameter("date2")!=null 
                        || request.getParameter("date1")!=null && request.getParameter("date2")==null 
                        || request.getParameter("date2")!=null && request.getParameter("date1")==null) {
                    Date date1 = new Date();
                    Date date2 = new Date();
                    if(request.getParameter("date2")=="" && request.getParameter("date1")=="") {
                        date1 = new Date();
                        date2 = new Date();
                    } else if(request.getParameter("date1")!="" && request.getParameter("date2")=="") {
                            String d1 = request.getParameter("date1").trim();
                            date1 = new SimpleDateFormat("yyyy-MM-dd").parse(d1);
                            date2 = new Date();
                    } else if(request.getParameter("date2")!="" && request.getParameter("date1")=="") {
                            String d2 = request.getParameter("date2").trim();
                            date2 = new SimpleDateFormat("yyyy-MM-dd").parse(d2);
                            date1 = new Date();
                    } else if(request.getParameter("date2")!=null && request.getParameter("date1")!=null) {
                            String d1 = request.getParameter("date1").trim();
                            date1 = new SimpleDateFormat("yyyy-MM-dd").parse(d1);
                            String d2 = request.getParameter("date2").trim();
                            date2 = new SimpleDateFormat("yyyy-MM-dd").parse(d2);
                    } 
                    PourboireServeur p = new PourboireServeur();
                    PourboireServeur[] liste = p.getPourboires(date1, date2);
                    request.setAttribute("grade", grade);
                    request.setAttribute("liste", liste);
                    RequestDispatcher dispatch = request.getRequestDispatcher("ListeServeur.jsp");
                    dispatch.forward(request,response);
                } else {
                    PourboireServeur p = new PourboireServeur();
                    PourboireServeur[] liste = p.getPourboiresI();
                    request.setAttribute("liste", liste);
                    request.setAttribute("grade", grade);
                    RequestDispatcher dispatch = request.getRequestDispatcher("ListeServeur.jsp");
                    dispatch.forward(request,response);
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
