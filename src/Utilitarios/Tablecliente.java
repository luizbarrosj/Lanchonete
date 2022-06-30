/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitarios;

//import BEAN.BEANcliente;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author luiz
 */
public class Tablecliente extends AbstractTableModel{
          private ArrayList linhas = null;
  private String[] colunas = null;
  //seta linhas e coluna na tabela
  public Tablecliente(ArrayList lin,String[] col){
      setLinhas(lin);
      setColunas(col);
     
  }
       
   public ArrayList getLinhas(){
       return linhas;
       
   }
   //seta os dados informados acima
   public void setLinhas(ArrayList dados){
        linhas = dados;
       
   }
      public String[/*vetor*/] getColunas(){
          return colunas;
          
      }
      public void setColunas(String[] nome){
          colunas = nome;
          
      }
     //seta o numero de colunas 
      public int getColumnCount(){
         return colunas.length/*<-faz a contagem de colunas*/;
     }
      //numero de linhas
      public int getRowCount(){
          return linhas.size();
           

      }
      public String getColumnName(int numCol){
          return colunas[numCol];
      }
      public  Object getValueAt( int numLin, int numCol){
         //  this.fireTableDataChanged();
          Object[] linha =(Object[])getLinhas().get(numLin);
         
          return linha[numCol];
          
      }
     
  
      
}

