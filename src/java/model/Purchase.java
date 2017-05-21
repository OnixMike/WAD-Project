/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 *
 * @author Dragoshescu
 */
public class Purchase {
    
    private final String timeStamp;
    private final List<Product> purchasedProducts;
    
    public Purchase(final String timeStamp, final List<Product> purchasedProducts){
        this.timeStamp = timeStamp;
        this.purchasedProducts = purchasedProducts;
    }
}
