/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import java.util.ArrayList;

public interface UserDAO {

    public abstract void addUser(String name, String username, String password, String email, String gender, String telephone, String country, int sub);

    public abstract ArrayList<Integer> userExists(String user);

}
