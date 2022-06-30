  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import CONNECT.Myconnect;
import BEAN.Beanlogin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author luizbarros
 */
public class DAOlogin {
    
    private Connection conecta;
    public DAOlogin(){
        this.conecta= new Myconnect().conecta();
    }
    
    public boolean fazerlogin(Beanlogin obj){
        try {
              String cmdsql;
        cmdsql ="select usuario, senha, perfil from login where usuario = ? and senha = ?  and perfil = ?";
        PreparedStatement stmt = conecta.prepareStatement(cmdsql);
        stmt.setString(1,obj.getUsuario());
        stmt.setString(2,obj.getSenha());
        stmt.setString(3, obj.getPerfil());
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
    
    public void cadastrarusuario (Beanlogin obj){
        try {
            String cmdsql;
            cmdsql ="insert into login (usuario,senha,perfil)values (?,?,?)";
            PreparedStatement stmt =  conecta.prepareStatement(cmdsql);
            stmt.setString(1,obj.getUsuario());
            stmt.setString(2, obj.getSenha());
            stmt.setString(3, obj.getPerfil());
            stmt.execute();
            stmt.close();
            
        } catch (SQLException erro) {
            throw new RuntimeException(erro);
            
        }
    }
         public void alterarusuario (Beanlogin obj){
           try {
            String cmdsql;
            cmdsql ="update login  set usuario=?, senha=?, perfil=? where idlogin=?";
            PreparedStatement stmt =  conecta.prepareStatement(cmdsql);
            stmt.setString(1,obj.getUsuario());
            stmt.setString(2, obj.getSenha());
            stmt.setString(3, obj.getPerfil());
            stmt.setInt(4, obj.getIdlogin());
            stmt.execute();
            stmt.close();
            
        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }  
             
         }
            public void deletaruser(Beanlogin obj){
            try {
                String cmdsql;
                cmdsql="delete from login where idlogin=?";
                 PreparedStatement stmt = conecta.prepareStatement(cmdsql);
                 stmt.setInt(1,obj.getIdlogin());
                 stmt.execute();
                 stmt.close();
            } catch (Exception e) {
            }
        }
         
    }
    
    
    


