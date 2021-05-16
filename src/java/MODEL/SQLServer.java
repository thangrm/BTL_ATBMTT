/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

/**
 *
 * @author Hoàng Thắng <hoangthangrm>
 */
import ENTITY.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQLServer {

    private static String DB_URL = "jdbc:mysql://localhost:3306/webjava";
    private static String USER_NAME = "root";
    private static String PASSWORD = "";

    public static Connection getConnection(String dbURL, String userName,
            String password) {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, userName, password);
            System.out.println("connect successfully!");
        } catch (Exception ex) {
            System.out.println("connect failure!");
            ex.printStackTrace();
        }
        return conn;
    }

    public static User validateLogin(String username, String password) {
        try {
            // connnect to database 'testdb'
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
            // crate statement
            Statement stmt = conn.createStatement();
            // get data from table 'student'
            //username = "' or 1 = 1 -- ";
            //password = "1811";
            ResultSet rs = stmt.executeQuery("select * from users "
                    + "where username = '" + username + " ' and password = '" + password + "'");
            // show data
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String email = rs.getString(4);
                User user = new User(id, name, email);
                conn.close();
                return user;
            }   

            // close connection
            conn.close();
            return null;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
