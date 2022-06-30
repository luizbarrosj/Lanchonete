/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONNECT;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author luizb
 */
public class Myconnect {
    
    public Connection conecta(){
        try {
            
            
            return DriverManager.getConnection("jdbc:mysql://191.242.127.36:3306/lanche","admin","LFN75312648");
        } catch (SQLException e) {
             throw new RuntimeException(e);
        }
       
        
    }
    
}
