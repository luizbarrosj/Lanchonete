/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
//Importa Classe\\
import CONNECT.Myconnect;
import BEAN.BEANvendas;
///////Fim Importação\\\\\\\
///Importação de Bibliotecas\\\\
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
///Fim Da Importação

/**
 *
 * @author luizb
 */
public class DAOvenda {
     private Connection conecta;
     public DAOvenda(){
        this.conecta= new Myconnect().conecta();
    }
     
     public void salvarvenda (BEANvendas obj){
         String cmdsql;
         try {
             cmdsql ="insert into itens_venda (iditens,tipopag,numeropedido,valor,vendaqtd,entregador,idproduto) values (?,?,?,?,?,?,?)";
              PreparedStatement stmt =  conecta.prepareStatement(cmdsql);
              stmt.setInt(1,obj.getIditens());
              stmt.setString(2,obj.getTipopag());
              stmt.setInt(3,obj.getNumeropedido());
              stmt.setDouble(4,obj.getValor());
              stmt.setInt(5,obj.getVendaqtd());
              stmt.setString(6,obj.getEntregador());
              stmt.setInt(7,obj.getIdproduto());
              stmt.execute();
              stmt.close();
         } catch (SQLException erro) {
             JOptionPane.showMessageDialog(null,"Erro ao salvar venda" +erro);
         }
         
     }
     
     
     
     
     
     
}
