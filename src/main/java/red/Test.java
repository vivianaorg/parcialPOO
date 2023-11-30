/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package red;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author ASUS
 */
public class Test {

    public static void main(String[] args) {
        
        try {
            BaseDatos bd = BaseDatos.getInstance();
            Connection connection = bd.getConection();
            String sql = "SELECT * FROM gasto";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()){
                System.out.println("id: " + rs.getString("id"));        
                System.out.println("monto: " + rs.getString("monto"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }


}
