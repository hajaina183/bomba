/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import classe.Categorie;
import classe.Marge;
import classe.Produit;
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
public class TraitementPrixRevient extends HttpServlet {

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
            out.println("<title>Servlet TraitementPrixRevient</title>");            
            out.println("</head>");
            out.println("<body>");
            System.out.println("iiiiiiiiiiiiiiiiii");

            try {
                System.out.println("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
                HttpSession session = request.getSession(true);
                System.out.println("grade");
                int grade = Integer.parseInt(session.getAttribute("grade").toString());
               
                Produit p = new Produit();
                if(request.getParameter("categorie")!=null) {
                    int idC = Integer.valueOf(request.getParameter("categorie").trim());
                    Produit[] listeProduitCategorie = p.getProduitsCatgorie(idC);
                    double[] prixRevient = p.getPrixRevient(listeProduitCategorie);
                    Marge m = new Marge();
                    Marge[] listeMarge = m.getMarges();
                    for (int i = 0; i < listeMarge.length; i++) {
                        Marge marge = listeMarge[i];
                        for (int j = 0; j < prixRevient.length; j++) {
                            if(prixRevient[j] >= marge.getMontant_min() && prixRevient[j] <= marge.getMontant_max()) {
                                double mm = (prixRevient[j] * marge.getMarge()) / 100;
                                double pp = prixRevient[j] + mm;
                                listeProduitCategorie[j].setPrix_produit(pp);
                            }
                            
                        }
                    }
                    request.setAttribute("prixRevient", prixRevient);
                    request.setAttribute("listeProduit", listeProduitCategorie);
                } else {
                    Produit[] listeProduit = p.getProduits();
                    double[] prixRevient = p.getPrixRevient(listeProduit);
                    Marge m = new Marge();
                    Marge[] listeMarge = m.getMarges();
                    for (int i = 0; i < listeMarge.length; i++) {
                        Marge marge = listeMarge[i];
                        for (int j = 0; j < prixRevient.length; j++) {
                            if(prixRevient[j] >= marge.getMontant_min() && prixRevient[j] <= marge.getMontant_max()) {
                                double mm = (prixRevient[j] * marge.getMarge()) / 100;
                                double pp = prixRevient[j] + mm;
                                listeProduit[j].setPrix_produit(pp);
                            }
                        }
                    }
                    request.setAttribute("grade", grade);
                    request.setAttribute("prixRevient", prixRevient);
                    request.setAttribute("listeProduit", listeProduit);
                }
                Categorie c = new Categorie();
                Categorie[] listeCategorie = c.getCategories();
                
                request.setAttribute("listeCategorie", listeCategorie);
                RequestDispatcher dispatch = request.getRequestDispatcher("PrixRevient.jsp");
                dispatch.forward(request,response);
            } catch (Exception e) {
                e.getMessage();
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
