/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Diego San Cristobal
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class RestauranteBD {
    public static ArrayList<Producto> getProducto() {
        ArrayList<Producto> productos = new ArrayList<Producto>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/restaurante", "", "");
            String query = "SELECT * FROM products";
            PreparedStatement pst = connection.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                Producto producto = new Producto(
                        rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),rs.getInt(6), rs.getInt(7), rs.getInt(8) );
                productos.add(producto);
            }
            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return productos;
    }
    
}
