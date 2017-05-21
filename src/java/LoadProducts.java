
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import DB.DBConnection;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Web application lifecycle listener.
 *
 * @author Krebons
 */

import model.Product;

public class LoadProducts implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
         List<Product> products=null;
        try {

            DBConnection dbc = DBConnection.getInstance();
            String sql = "SELECT * FROM ROOT.products";
            Statement instr = null;
            instr = dbc.getCon().createStatement();
            ResultSet rs = instr.executeQuery(sql);
            products = new ArrayList<Product>();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name= rs.getString("name");
                String type= rs.getString("type");
                int size = rs.getInt("size");
                double price = rs.getDouble("unit_price");
                Integer qty = rs.getInt("quantity");
                products.add(new Product(id, name, type, size, price, qty));
                System.out.println(id);
            }
            sce.getServletContext().setAttribute("products", products);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
