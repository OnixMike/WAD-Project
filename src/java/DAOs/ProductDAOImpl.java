/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import DAOs.ProductDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import DB.DBConnection;
import model.Product;

/**
 *
 * @author Krebons
 */
public class ProductDAOImpl implements ProductDAO {

    DBConnection dbc = DBConnection.getInstance();
    ArrayList<Product> products = new ArrayList<>();

    @Override
    public ArrayList<Product> getProducts() {

        try {

            Statement instr = null;

            instr = dbc.getCon().createStatement();

            String sql = "SELECT * FROM products";

            ResultSet rs = instr.executeQuery(sql);

            while (rs.next()) {

                int id = Integer.parseInt(rs.getString(1));
                String name = rs.getString(2);
                System.out.println("name : " + name);
                String type = rs.getString(3);
                System.out.println("type : " + type);
                int size = Integer.parseInt(rs.getString(4));
                double unitPrice = Double.parseDouble(rs.getString(5));
                int qty = Integer.parseInt(rs.getString(6));

                Product p = new Product(id, name, type,size, unitPrice, qty);

                products.add(p);

            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;

    }

    @Override
    public void addProduct(String prodName, String type, String desc, int price, int qty, String imgName, String imgPath) {

        try {
            Statement instr = null;
            
            instr = dbc.getCon().createStatement();
            
            String sql = "INSERT INTO products (name, type, description, unitPrice, quantity, imageName, imageURL ) VALUES ('" + prodName + "','" + type + "','" + desc + "'," + price + "," + qty + ",'" + imgName + "','" + imgPath + "');";
            
            instr.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
