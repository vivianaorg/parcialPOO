/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package red;
import java.sql.Connection;
import java.sql.SQLException;
import org.apache.commons.dbcp2.BasicDataSource;
/**
 *
 * @author ASUS
 */
public class BaseDatos {
    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

    
    private static final BasicDataSource bs = new BasicDataSource();
    private static BaseDatos instance;
    private final static String URL = "jdbc:mysql://54.147.25.136:3306/gestion_gastos?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private final static String USERNAME = "test";
    private final static String PASSWORD = "test1_*";
    
    private BaseDatos(){
       bs.setUrl(URL);
       bs.setUsername(USERNAME);
       bs.setPassword(PASSWORD);
       bs.setMinIdle(5);
       bs.setMaxIdle(10);
       bs.setMaxOpenPreparedStatements(100);
    }
    
    public static synchronized BaseDatos getInstance(){
        if (instance == null){
            instance = new BaseDatos();
        }
        
        return instance;
    }
    
    public Connection getConection() throws SQLException{
        return bs.getConnection();
    }


}
