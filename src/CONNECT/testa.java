/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONNECT;
import javax.swing.JOptionPane;
import CONNECT.Myconnect;
import java.sql.Connection;
import java.sql.SQLException;
/**
 *
 * @author luizb
 */
public class testa {
    public static void main(String[] args) {
        try {
            JOptionPane.showMessageDialog(null,"Tetando conecxão");
            Connection  con=new Myconnect().conecta();
            JOptionPane.showMessageDialog(null,"Esta Conectado");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro ao conctar" +e);
        }
    }
}
