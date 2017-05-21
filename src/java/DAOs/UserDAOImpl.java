/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import DB.DBConnection;
import java.util.ArrayList;

/**
 *
 * @author Krebons
 */
public class UserDAOImpl implements UserDAO {

    DBConnection dbc = DBConnection.getInstance();

    @Override
    public void addUser(String name, String username, String password, String email, String gender, String telephone, String country, int sub) {
        boolean resp = false;

        Statement instr = null;

        try {
            instr = dbc.getCon().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        String sql = "INSERT INTO users (name, username, password, email, gender, telephone, country, subscribed) VALUES ('" + name + "','" + username + "',MD5('" + password + "'),'" + email + "','" + gender + "','" + telephone + "','" + country + "'," + sub + ");";

        try {
            instr.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public ArrayList<Integer> userExists(String user) {
        int id = 0;
        int admin = 0;

        ArrayList<Integer> userInfo = new ArrayList<>();

        try {
            Statement instr = null;

            instr = dbc.getCon().createStatement();

            String sql = "SELECT * FROM users WHERE username= '" + user + "'";

            ResultSet rs = instr.executeQuery(sql);

            if (rs.next()) {
                id = Integer.parseInt(rs.getString(1));
                admin = Integer.parseInt(rs.getString(10));
                rs.close();
                instr.close();
                userInfo.add(id);
                userInfo.add(admin);

                return userInfo;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return userInfo;
    }

}
