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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DB.DBConnection;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Krebons
 */
@WebServlet(urlPatterns = {"/registrationController"})
public class registrationController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
                                DBConnection db=new DBConnection();
                                Connection con = db.getCon();
                                ResultSet rs = null;
                                String myUname = request.getParameter("uname");
                                String pass = request.getParameter("pass");
                                String lname = request.getParameter("lname");
                                String fname = request.getParameter("fname");
                                String email = request.getParameter("email");
                                String phone = request.getParameter("phone");
                                PreparedStatement instr =  con.prepareStatement("SELECT * from ROOT.USERS WHERE uname = ?");
                                instr.setString(1, myUname);
                                rs = instr.executeQuery();
                                if  (rs.next()) {
                                 request.getSession().setAttribute("uname", myUname);
                                 RequestDispatcher rd = request.getRequestDispatcher("index.html");
                                 rd.forward(request, response);

                                }
                                else {
                                    String  st = "INSERT INTO ROOT.USERS VALUES (?, ?, ?, ?, ?, ?)";
                                    PreparedStatement insert = con.prepareStatement(st);
                                    insert.setString(1, fname);
                                    insert.setString(2, lname);
                                    insert.setString(3, email);
                                    insert.setString(4, phone);
                                    insert.setString(5, myUname);
                                    insert.setString(6, getHash(pass));
                                    insert.executeUpdate();
                                    con.commit();
                                    insert.close();
                                   // redirect as logged in 
                                }

//                                out.print(rs.toString());
                                instr.close();
                                RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
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
             Logger.getLogger(registrationController.class.getName()).log(Level.SEVERE, null, ex);
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
             Logger.getLogger(registrationController.class.getName()).log(Level.SEVERE, null, ex);
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
