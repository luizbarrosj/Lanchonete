/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.time.LocalDate;
import CONNECT.Myconnect;
import BEAN.BEANproduto;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author luizb
 */
public class DAOproduto {
    private Connection conecta;
     public DAOproduto(){
        this.conecta= new Myconnect().conecta();
    }
      public void cadastrproduto (BEANproduto obj){
        try {
            String cmdsql;
            cmdsql ="insert into produto (idproduto,produto,valor)values (?,?,?)";
            PreparedStatement stmt =  conecta.prepareStatement(cmdsql);
            stmt.setInt(1, obj.getIdproduto());
            stmt.setString(2,obj.getProduto());
            stmt.setString(3,obj.getValor().replace(",", "."));
            stmt.execute();
            stmt.close();
            
        } catch (SQLException erro) {
            throw new RuntimeException(erro);
            
        }
    }
       public void alterarproduto (BEANproduto obj){
        try {
            String cmdsql;
            cmdsql ="update produto set produto=?,valor=? where idproduto=?";
            PreparedStatement stmt =  conecta.prepareStatement(cmdsql);
            stmt.setString(1,obj.getProduto());
            stmt.setString(2,obj.getValor());
            stmt.setInt(3, obj.getIdproduto());
            stmt.execute();
            stmt.close();
            
        } catch (SQLException erro) {
            throw new RuntimeException(erro);
            
        }
    }
         public void deletaruser(BEANproduto obj){
            try {
                String cmdsql;
                cmdsql="delete from produto where idproduto=?";
                 PreparedStatement stmt = conecta.prepareStatement(cmdsql);
                 stmt.setInt(1,obj.getIdproduto());
                 stmt.execute();
                 stmt.close();
            } catch (Exception e) {
            }
        }
         

}
