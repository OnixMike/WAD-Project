/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import java.util.ArrayList;
import model.Product;

/**
 *
 * @author Krebons
 */
public interface ProductDAO {
    
    public abstract ArrayList<Product> getProducts();
    public void addProduct(String prodName, String type, String desc, int price, int qty, String imgName, String imgPath);
    
}
