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
import ENTITY.Product;
import ENTITY.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class SQLServer {

    private static String DB_URL = "jdbc:mysql://localhost:3306/atbmtt";
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
            // connnect to database
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
            // crate statement
            Statement stmt = conn.createStatement();

            //username = "' or 1 = 1 -- ";
            //password = "1811";
            ResultSet rs = stmt.executeQuery("select * from users "
                    + "where username = '" + username + " ' and password = '" + password + "'");
            
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
    
    public static ArrayList<Product> getProducts(){
        return SQLServer.getProducts(-1,null);
    }
    public static ArrayList<Product> getProducts(String search){
        return SQLServer.getProducts(-1,search);
    }
    public static ArrayList<Product> getProducts(int idFilter){
        return SQLServer.getProducts(idFilter,null);
    }
    
    public static ArrayList<Product> getProducts(int idFilter, String search) {
        ArrayList<Product> listProducts = new ArrayList<>();
        try {
            // connnect to database
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
            // crate statement
            Statement stmt = conn.createStatement();
            ResultSet rs;
            String sql;
            if(search == null || search == ""){
                if(idFilter == -1)
                    sql = "select * from products";
                else
                    sql = "select * from products where idUser = '"+idFilter+"'";
            }
            else{
                if(idFilter == -1)
                    sql = "select * from products where nameProduct like '%"+search+"%'";
                else
                    sql = "select * from products where nameProduct like '%"+search+"%' and idUser = '"+idFilter+"'";
            }

            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt(1);
                int idUser = rs.getInt(2);
                String name = rs.getString(3);
                String image = rs.getString(4);
                Double price = rs.getDouble(5);
                Product product = new Product(id, idUser, name, image, price);
                listProducts.add(product);
            }   
            // close connection
            conn.close();
            return listProducts;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public static boolean addProduct(int idUser, String name, String image, String price) {
        try {
            // connnect to database
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
            // crate statement
            Statement stmt = conn.createStatement();

            String sql = "INSERT INTO products"
                    + " VALUES (NULL, '"+idUser+"', '"+name+"', '"+image+"', '"+price+"')";
            stmt.execute(sql);

            // close connection
            conn.close();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
