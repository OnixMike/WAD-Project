/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DB.DBConnection;
import model.User;
/**
 *
 * @author Krebons
 */
@WebServlet(urlPatterns = {"/loginController"})
public class loginController extends HttpServlet {
     public static String getHash(String password) {
        MessageDigest digest=null;
        try {
        digest = MessageDigest.getInstance("SHA-1");
        } catch (Exception ex) {
        ex.printStackTrace();
        }
        digest.reset();
        try {
        digest.update(password.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException ex) {
        ex.printStackTrace();
        }
        return new BigInteger(1, digest.digest()).toString(16);
    }
     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
                    ResultSet result = null; 
                    User user=new User();
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
                                DBConnection db=new DBConnection();
                                Connection con = db.getCon();
                                ResultSet rs = null;
                                String myUname = request.getParameter("uname");
                                String myPass = getHash(request.getParameter("pass"));
                                
                            try{ 
                                PreparedStatement instr = con.prepareStatement("SELECT * from ROOT.USERS WHERE uname = ? AND password = ?");
                                instr.setString(1, myUname);
                                instr.setString(2, myPass);
                                rs = instr.executeQuery();
                                if (rs.next()) {    
                                    request.getSession().setAttribute("user", user);
                                    RequestDispatcher rd = request.getRequestDispatcher("index.html");
                                    rd.forward(request, response);
                                } else {
                                    //redirect to login                                   
                                    RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
                                    rd.forward(request, response);
                                }
                            }catch(Exception e){
                                System.out.println(e.getMessage());
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
         try {
             processRequest(request, response);
         } catch (SQLException ex) {
             Logger.getLogger(loginController.class.getName()).log(Level.SEVERE, null, ex);
         }
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
         try {
             processRequest(request, response);
         } catch (SQLException ex) {
             Logger.getLogger(loginController.class.getName()).log(Level.SEVERE, null, ex);
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
