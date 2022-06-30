/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import CONNECT.Myconnect;
import BEAN.BEANcliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author luizb
 */
public class DAOcliente {
    private Connection conecta;
    public DAOcliente(){
        this.conecta= new Myconnect().conecta();
    }
      public void cadastrcliente (BEANcliente obj){
        try {
            String cmdsql;
            cmdsql ="insert into cliente (idcliente,nome,bairro,endereco,numero,telefone)values (?,?,?,?,?,?)";
            PreparedStatement stmt =  conecta.prepareStatement(cmdsql);
            stmt.setInt(1, obj.getIdcliente());
            stmt.setString(2,obj.getNome());
            stmt.setString(3, obj.getBairro());
            stmt.setString(4, obj.getEndereco());
            stmt.setInt(5,obj.getNumero());
            stmt.setString(6,obj.getTelefone());
            stmt.execute();
            stmt.close();
            
        } catch (SQLException erro) {
            throw new RuntimeException(erro);
            
        }
    }
    public void alterarcliente (BEANcliente obj){
        try {
            String cmdsql;
            cmdsql ="update cliente set nome=?,bairro=?,endereco=?,numero=?,telefone=? where idcliente=?";
            PreparedStatement stmt =  conecta.prepareStatement(cmdsql);
            stmt.setString(1,obj.getNome());
            stmt.setString(2, obj.getBairro());
            stmt.setString(3, obj.getEndereco());
            stmt.setInt(4,obj.getNumero());
            stmt.setString(5,obj.getTelefone());
            stmt.setInt(6,obj.getIdcliente());
            stmt.execute();
            stmt.close();
            
        } catch (SQLException erro) {
            throw new RuntimeException(erro);
            
        }
    }
      public void deletaruser(BEANcliente obj){
            try {
                String cmdsql;
                cmdsql="delete from cliente where idcliente=?";
                 PreparedStatement stmt = conecta.prepareStatement(cmdsql);
                 stmt.setInt(1,obj.getIdcliente());
                 stmt.execute();
                 stmt.close();
            } catch (Exception e) {
            }
        }
    
}
