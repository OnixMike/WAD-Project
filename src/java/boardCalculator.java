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
@WebServlet(urlPatterns = {"/boardCalculator"})
public class boardCalculator extends HttpServlet {

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
            if(height<147){
                out.print("You suggested snowboard lenght is between 128-136 cm");
            }else if(height>=147 && height<152){
                out.print("You suggested snowboard lenght is between 133-141 cm");
            }else if(height>=152 && height<158){
                out.print("You suggested snowboard lenght is between 139-147 cm");
            }else if(height>=158 && height<163){
                out.print("You suggested snowboard lenght is between 144-152 cm");
            }else if(height>=163 && height<168){
                out.print("You suggested snowboard lenght is between 149-157 cm");
            }else if(height>=168 && height<173){
                out.print("You suggested snowboard lenght is between 154-162 cm");
            }else if(height>=173 && height<178){
                out.print("You suggested snowboard lenght is between 159-167 cm");
            }else if(height>=178){
                out.print("You suggested snowboard lenght is 160+ cm");
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
