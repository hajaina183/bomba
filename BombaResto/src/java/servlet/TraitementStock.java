/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import classe.NTable;
import classe.Produit;
import classe.Stock;
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
 * @author Rado
 */
public class TraitementStock extends HttpServlet {

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
            out.println("<title>Servlet TraitementStock</title>");            
            out.println("</head>");
            out.println("<body>");
            try {
                HttpSession session = request.getSession(true);
                int grade = Integer.parseInt(session.getAttribute("grade").toString());
                if(request.getParameter("date1")!=null && request.getParameter("date2")!=null) {
                    String d1 = request.getParameter("date1").trim();
                    String d2 = request.getParameter("date2").trim();
                    Stock s = new Stock();
                    Stock[] listeStock = s.getStockDate(d1, d2);
                    request.setAttribute("listeStock", listeStock);
                } else {
                    Stock s = new Stock();
                    Stock[] listeStock = s.getStock();
                    request.setAttribute("listeStock", listeStock);
                }
                
                Produit p = new Produit();
                if(request.getParameter("categorie")!=null) {
                    int idC = Integer.valueOf(request.getParameter("categorie").trim());
                    Produit[] listeProduitCategorie = p.getProduitsCatgorie(idC);
                    request.setAttribute("listeProduit", listeProduitCategorie);
                } else {
                    Produit[] listeProduit = p.getProduits();
                    request.setAttribute("listeProduit", listeProduit);
                }
                NTable nt = new NTable();
                NTable[] listeNTable = nt.getTables();
                request.setAttribute("listeNTable", listeNTable);
                request.setAttribute("grade", grade);
                RequestDispatcher dispatch = request.getRequestDispatcher("Stock.jsp");
                dispatch.forward(request,response);
            } catch (Exception e) {
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
