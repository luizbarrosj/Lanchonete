/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import BEAN.BEANcliente;
import CONNECT.Myconnect;
import java.sql.Connection;
import BEAN.BEANcaixa;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import BEAN.BEANproduto;
//import BEAN.BEANvenda;

/**
 *
 * @author luizb
 */
public class DAOcaixa {
    
    
    
    private Connection conecta;
     public DAOcaixa(){
        this.conecta= new Myconnect().conecta();
    }
    public void save(BEANcaixa obj) {
        try {
         String cmdsql;
       cmdsql ="insert into venda (tipopag,valor,valortotal,vendaqtd,idcliente,idproduto) values (?,?,?,?,?,?) ";
        PreparedStatement stmt =  conecta.prepareStatement(cmdsql);
        
        stmt.setString(1, obj.getTipopag());
        stmt.setString(2, obj.getValor());
        stmt.setString(3, obj.getValortotal());
        stmt.setInt(4,obj.getVendaqtd());
        stmt.setInt(5,obj.getIdcliente());
        stmt.setInt(6,obj.getIdproduto());
       
        } catch (Exception e) {
        }
        
    }
      public boolean fazerpedido(BEANcliente obj){
        try {
              String cmdsql;
        cmdsql ="select * from cliente  where idcliente=?,nome=?,bairro=?,endereco=?,numero=?,telefone=?";
        PreparedStatement stmt = conecta.prepareStatement(cmdsql);
         stmt.setInt(1, obj.getIdcliente());
         stmt.setString(2,obj.getNome());
         stmt.setString(3, obj.getBairro());
         stmt.setString(4, obj.getEndereco());
         stmt.setInt(5,obj.getNumero());
         stmt.setString(6,obj.getTelefone());
        ResultSet rs = stmt.executeQuery();
        if(rs.first()){
            return true;
        }
        else{
        }
        } catch (Exception e) {
        }
      return false;
        
                }
    
   
}
