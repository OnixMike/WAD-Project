package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DBConnection {

    static DBConnection instance;
    Connection con = null;

    public DBConnection() {

        String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/ski_shop";

        try {
            con = DriverManager.getConnection(url, "root", "1234");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static DBConnection getInstance() {

        if (instance == null) {
            instance = new DBConnection();
        }
        return instance;

    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

}
