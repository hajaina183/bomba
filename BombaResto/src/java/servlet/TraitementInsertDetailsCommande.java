/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import classe.Alls;
import classe.Commande;
import classe.DetailsCommande;
import classe.Produit;
import classe.Recette;
import classe.Reste;
import classe.Serveur;
import classe.Seuil;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Vector;
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
public class TraitementInsertDetailsCommande extends HttpServlet {

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
            out.println("<title>Servlet TraitementInsertDetailsCommande</title>");            
            out.println("</head>");
            out.println("<body>");
            try {
                HttpSession session = request.getSession(true);
                int grade = Integer.parseInt(session.getAttribute("grade").toString());
                int idS = Integer.valueOf(request.getParameter("serveur").trim());
                int idM = Integer.valueOf(request.getParameter("produit").trim());
                int qtt = Integer.valueOf(request.getParameter("qtt").trim());
                Vector<Double> quantite = new Vector<Double>();
                System.out.println("id produit : "+idM);
                DetailsCommande d = new DetailsCommande();
                Recette r = new Recette();
                Recette[] listeRecette = r.getRecette(idM);
                for (int i = 0; i < listeRecette.length; i++) {
                    Recette recette = listeRecette[i];
                    double q = recette.getDose_ingredient() * qtt;
                    quantite.add(q);
                }
                Seuil seuil = new Seuil();
                Seuil[] listeS = seuil.getSeuils();
                int rep = 0;
                Reste res = new Reste();
                Reste[] listeReste = res.getRestes();
                for (int i = 0; i < quantite.size(); i++) {
                    Double elementAt = quantite.elementAt(i);
                    for (int j = 0; j < listeS.length; j++) {
                        if(listeRecette[i].getId_ingredient() == listeS[j].getIdIngredient()) {
                            if(elementAt > listeS[j].getSeuil()) {
                                rep = 1;
                            }
                        }
                    }
                }
                Vector<Double> isa = new Vector<Double>();
                for (int i = 0; i < listeRecette.length; i++) {
                    for (int j = 0; j < listeReste.length; j++) {
                        Reste reste = listeReste[j];
                        if(listeRecette[i].getId_ingredient() == reste.getId_ingredient()) {
                            double nb = reste.getReste() / listeRecette[i].getDose_ingredient();
                            isa.add(nb);
                        }
                    }
                }
                double[] qttPossible = new double[isa.size()];
                for (int i = 0; i < isa.size(); i++) {
                    Double elementAt = isa.elementAt(i);
                    qttPossible[i] = elementAt;
                }
                Arrays.sort(qttPossible);
                Serveur s = new Serveur();
                Serveur[] ss = s.getServeurs();
                Produit p = new Produit();
                Produit[] listeProduit = p.getProduits();
                Commande c = new Commande();
                int idC = c.getMaxId();
                Alls a = new Alls();
                a.setId_commande(idC);
                Alls[] listeAll = a.getAllsCommande();
                request.setAttribute("grade", grade);
                request.setAttribute("listeProduit", listeProduit);
                request.setAttribute("listeServeur", ss);
                request.setAttribute("listeAll", listeAll);
                if(rep == 0) {
                    d.insertDetailsCommande(idS, idM, qtt);
                    RequestDispatcher dispatch = request.getRequestDispatcher("DetailsCommande.jsp");
                    dispatch.forward(request,response);
                } else {
                    request.setAttribute("proposition", qttPossible[0]);
                    System.out.println("proposition : "+qttPossible[0]);
                    RequestDispatcher dispatch = request.getRequestDispatcher("DetailsCommande.jsp");
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
