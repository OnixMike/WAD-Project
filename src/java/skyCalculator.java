/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Krebons
 */
@WebServlet(urlPatterns = {"/skyCalculator"})
public class skyCalculator extends HttpServlet {

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
        int height;
        try (PrintWriter out = response.getWriter()) {
            height=Integer.parseInt(request.getParameter("height"));
            if(height<132){
                out.print("You suggested sky lenght is between 115-130 cm");
            }else if(height>=132 && height<137){
                out.print("You suggested sky lenght is between 125-140 cm");
            }else if(height>=137 && height<142){
                out.print("You suggested sky lenght is between 130-145 cm");
            }else if(height>=142 && height<147){
                out.print("You suggested sky lenght is between 135-150 cm");
            }else if(height>=147 && height<152){
                out.print("You suggested sky lenght is between 135-150 cm");
            }else if(height>=152 && height<158){
                out.print("You suggested sky lenght is between 135-155 cm");
            }else if(height>=158 && height<163){
                out.print("You suggested sky lenght is between 145-165 cm");
            }else if(height>=163 && height<168){
                out.print("You suggested sky lenght is between 145-165 cm");
            }else if(height>=168 && height<173){
                out.print("You suggested sky lenght is between 155-175 cm");
            }else if(height>=173 && height<178){
                out.print("You suggested sky lenght is between 160-180 cm");
            }else if(height>=178 && height<183){
                out.print("You suggested sky lenght is between 165-185 cm");
            }else if(height>=183 && height<188){
                out.print("You suggested sky lenght is between 170-190 cm");
            }else if(height>=188 && height<193){
                out.print("You suggested sky lenght is between 180-189 cm");
            }else if(height>=193){
                out.print("You suggested sky lenght is between 180-200 cm");
            }
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
