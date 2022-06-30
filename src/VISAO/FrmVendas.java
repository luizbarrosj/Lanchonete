/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VISAO;
//Importa Classe\\
import BEAN.BEANvendas;
import BEAN.BEANcliente;
import CONNECT.Myconnect;
import DAO.DAOcaixa;
import DAO.DAOvenda;
import Utilitarios.Tablecliente;
///////Fim Importação\\\\\\\
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.math.BigDecimal;
/**
 *
 * @author luizb
 */
public class FrmVendas extends javax.swing.JInternalFrame {
private  Connection conecta;
    /**
     * Creates new form FrmVendas
     */
    public FrmVendas() {
        initComponents();
        this.conecta=new Myconnect().conecta();
        //Prenche as Tabelas Tela
       PreencherTabelaCliente("SELECT * from cliente order by idcliente");
        //PreencherTabelaVenda("SELECT * from itens_venda order by iditens");
        //PreencherTabelaItens("SELECT * from produto inner join itens_venda on produto.idproduto = itens_venda.idproduto ");
        //JCombobox 
        this.cadpag();
        this.listaitem();
        txtqtd.setText("1");
        //////////////////
          
    }
    //Algoritimos tela Caixa
//o cadpag lista o tipo de pagamento    
public void cadpag() {
   
    try {
         String cmdsql;
            cmdsql = "select * from cliente ";
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
             ResultSet rs =stmt.executeQuery();            
             
             while(rs.next()){
               jComboBoxtippopag.removeAllItems();
               jComboBoxtippopag.addItem("Cartão de crédito");
               jComboBoxtippopag.addItem("Cartão de Debito");
               jComboBoxtippopag.addItem("Dinheiro");
           }
    } catch (Exception e) {
    }
}
//pega i id produto
public void pegaid()  {
   
    try {

         String cmdsql;
         String prodselect = jComboBoxCliente.getSelectedItem().toString();
           cmdsql = "SELECT idproduto,valor " +"FROM produto " +"WHERE " +"(produto ='" + prodselect + "')"; 
//""'"+jComboBoxCliente.getSelectedItem().toString()+"'";
            //cmdsql = "select * from produto order by idproduto";
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
             ResultSet rs =stmt.executeQuery();            
            //rs.first();
            while(rs.next()){
            String idproduto = rs.getString(1);
             txtcodigoprod.setText(idproduto);
             String valorprod = rs.getString(2);
             txtvalorprod.setText(valorprod);
            }
              /*if( rs.getString("produto").equals(jComboBoxCliente.getSelectedItem().toString())){
                 // while(rs.next()){
               txtcodigoprod.setText(rs.getString("idproduto")); 
                  //}
           }else{
                   JOptionPane.showMessageDialog(rootPane,"Erro ao Pegar ID");
              }
              */
              
    } catch (Exception e) {
        JOptionPane.showMessageDialog(rootPane,"Erro ao Pegar ID"+e);
    }
}
//pega id item
public void pegaiditem(){
     try {

         String cmdsql;
         String prodselect =  txtnumerovenda.getText();
           cmdsql = "SELECT iditens " +"FROM itens_venda " +"WHERE " +"(numeropedido ='" + prodselect + "')"; 
//""'"+jComboBoxCliente.getSelectedItem().toString()+"'";
            //cmdsql = "select * from produto order by idproduto";
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
             ResultSet rs =stmt.executeQuery();            
            //rs.first();
            while(rs.next()){
            String iditem = rs.getString(1);
             txtcodigoproditem.setText(iditem);
            }
              /*if( rs.getString("produto").equals(jComboBoxCliente.getSelectedItem().toString())){
                 // while(rs.next()){
               txtcodigoprod.setText(rs.getString("idproduto")); 
                  //}
           }else{
                   JOptionPane.showMessageDialog(rootPane,"Erro ao Pegar ID");
              }
              */
              
    } catch (Exception e) {
        JOptionPane.showMessageDialog(rootPane,"Erro ao Pegar ID"+e);
    }
}
//gera numero de venda
public void nvenda(){
    
    String formatodDate = null;
     Date date = new Date();
     DateFormat formato = new SimpleDateFormat("YYYYMMDDHHmmss");
     formatodDate = formato.format(date);
     
    Random radom  = new Random();
    int numeroTmp = 0;
    for(int i=0;i< 1000; i++) {
        numeroTmp=radom.nextInt(300);
         txtnumerovenda.setText(formatodDate+numeroTmp);
}
}
//lista produto em uma combobox
public void listaitem(){
    try {

         String cmdsql;
            cmdsql = "select produto.produto from produto order by produto";
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
             ResultSet rs =stmt.executeQuery();            
             jComboBoxCliente.removeAllItems();
             while(rs.next()){
               jComboBoxCliente.addItem(rs.getString("produto"));
           }
}catch(Exception e){
    
}
}
//inseri venda
public  void pedido(){ 
 try {
            String cmdsql;
       cmdsql ="insert into itens_venda (idproduto,itemvenda,valor,vendaqtd,numeropedido) values (?,?,?,?,?) ";
        PreparedStatement stmt =  conecta.prepareStatement(cmdsql);
        stmt.setString(1, txtcodigoprod.getText());
        stmt.setString(2, jComboBoxCliente.getSelectedItem().toString());
        stmt.setString(3,txtvalorprod.getText().replace(",","."));
        stmt.setString(4,txtqtd.getText());
        stmt.setString(5, txtnumerovenda.getText());
       
  if((txtcodigoprod.getText().isEmpty() || jComboBoxCliente.getSelectedItem().toString().isEmpty())){
           JOptionPane.showMessageDialog(null,"Preencha todos os campos obrigatorios");
       
          } else{
           int adicionando = stmt.executeUpdate();
           if(adicionando > 0){
               JOptionPane.showMessageDialog(null,"Pedido feito com sucesso");
           }
     
 }     
 } 
 catch (Exception e) {
              JOptionPane.showMessageDialog(null, e);
        }
        }
//faz venda
public  void cadidvenda(){ 
 try {
            String cmdsql;
       cmdsql ="insert into venda (idvenda,idcliente) values (?,?) ";
        PreparedStatement stmt =  conecta.prepareStatement(cmdsql);
        stmt.setString(1, txtnumerovenda.getText());
        stmt.setString(2,txtcodigocliente.getText());
        
  if((txtnumerovenda.getText().isEmpty()||txtcodigocliente.getText().isEmpty())){
           JOptionPane.showMessageDialog(null,"*Preencha todos os campos obrigatorios");
       
          } else{
           int adicionando = stmt.executeUpdate();
           if(adicionando > 0){
               //JOptionPane.showMessageDialog(null,"venda feito com sucesso");
               txtcodigocliente.setEnabled(true);
        txtnome.setEnabled(true);
        txtend.setEnabled(true);
        txtnumero.setEnabled(true);
        txttelefone.setEnabled(true);
        txtcodigoprod.setEnabled(true);
        jComboBoxCliente.setEnabled(true);
        jComboBoxtippopag.setEnabled(true);
        txtvalortotal.setEnabled(true);
        cadastrarpedido.setEnabled(true);
        limpar.setEnabled(true);
        Atualizar.setEnabled(true);
        cadastrarcli.setEnabled(true);
        adicionaritem.setEnabled(true);
        voltar.setEnabled(true);
        txtvalorreceber.setEnabled(true);
        txtvalorprod.setEnabled(true);
        txttroco.setEnabled(true);
        txtvalortotal.setEnabled(true);
        txtnumerovenda.setEnabled(true);
        txtbuscanome.setEnabled(true);
        txtbuscatelefone.setEnabled(true);
        txtqtd.setEnabled(true);
        txtcalcular.setEnabled(true);
        txtcodigoproditem.setEnabled(true);
           }
     
 }     
 } 
 catch (Exception e) {
              JOptionPane.showMessageDialog(null, e);
        }
        }
//retorna valor total
 

public void valortotal(){
   // Scanner teclado = new Scanner(System.in);
    String vp = txtvalorprod.getText().replace(",",".");
    String qtd = txtqtd.getText().replace(",",".");
   // String vt = txtvalortotal.getText().replace(",","."); 
    
    double x = Double.parseDouble(vp);
    int y = Integer.parseInt(qtd);
    //double z = Double.parseDouble(vt);
    double vtp = x * y ; 
    
    if(vtp>0){
        
    txtvalortotal.setText(Double.toString(vtp).replace(".",","));
    
    }else{
        JOptionPane.showInternalMessageDialog(rootPane, "O valor ++e menor que 0");
                
    }/*while(vtp>=x){
        
        double vta = vtp+z;
         txtvalortotal.setText(Double.toString(vta).replace(".",","));
    }*/
   
  
}

//retorna troco
public void valortroco(){
      String vp = txtvalorreceber.getText().replace(",",".");
      String qtd =txtvalortotal.getText().replace(",",".");
      
      
    double x =Double.parseDouble(vp);
    double y = Double.parseDouble(qtd);
    double vt = x - y; 
    
    txttroco.setText(Double.toString(vt).replace(".",","));
   
    }



public void adcionavt(){
    String cmdsql;
    cmdsql =( " UPDATE venda SET valortotal = ? WHERE idvenda  = + '"+txtnumerovenda.getText()+"'");
    try {
        PreparedStatement stmt =  conecta.prepareStatement(cmdsql);
        stmt.setString(1,txtvalortotal.getText());
        
        if((txtvalortotal.getText().isEmpty())){
           JOptionPane.showMessageDialog(null,"*Preencha todos os campos obrigatorios");
       
          } else{
           int adicionando = stmt.executeUpdate();
           if(adicionando > 0){
               JOptionPane.showMessageDialog(null,"venda feito com sucesso");
               
           }
     
    }
    }catch (SQLException ex) {
        Logger.getLogger(FrmVendas.class.getName()).log(Level.SEVERE, null, ex);
    }
}

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtbuscanome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtbuscatelefone = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelafun = new javax.swing.JTable();
        cadastrarcli = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtnome = new javax.swing.JTextField();
        txtnumero = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txttelefone = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        txtend = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        codigo = new javax.swing.JLabel();
        txtcodigocliente = new javax.swing.JTextField();
        txtbairro = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jComboBoxCliente = new javax.swing.JComboBox<>();
        adicionaritem = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        codigo2 = new javax.swing.JLabel();
        txtnumerovenda = new javax.swing.JTextField();
        codigo1 = new javax.swing.JLabel();
        txtcodigoprod = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtvalorreceber = new javax.swing.JTextField();
        txtvalorprod = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txttroco = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jComboBoxtippopag = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtdata = new javax.swing.JFormattedTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelavenda = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        txtqtd = new javax.swing.JTextField();
        txtvalortotal = new javax.swing.JTextField();
        voltar = new javax.swing.JButton();
        Atualizar = new javax.swing.JButton();
        limpar = new javax.swing.JButton();
        cadastrar3 = new javax.swing.JButton();
        cadastrarpedido = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaitens = new javax.swing.JTable();
        txtcalcular = new javax.swing.JButton();
        codigo3 = new javax.swing.JLabel();
        txtcodigoproditem = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Tela  De Vendas");
        setFocusTraversalPolicyProvider(true);
        setFocusable(false);
        setRequestFocusEnabled(false);
        setVisible(true);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar Cliente"));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("*Nome:");

        txtbuscanome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbuscanomeActionPerformed(evt);
            }
        });
        txtbuscanome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscanomeKeyReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("*Telefone:");

        try {
            txtbuscatelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)9####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtbuscatelefone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscatelefoneKeyReleased(evt);
            }
        });

        tabelafun.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabelafun.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelafunMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelafun);

        cadastrarcli.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cadastrarcli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/user24.png"))); // NOI18N
        cadastrarcli.setText("Cadastrar Cliente");
        cadastrarcli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarcliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtbuscanome, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtbuscatelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cadastrarcli))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtbuscanome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtbuscatelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cadastrarcli))
                .addGap(3, 3, 3)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados Cliente"));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Nome:");

        txtnome.setEditable(false);
        txtnome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnomeActionPerformed(evt);
            }
        });

        txtnumero.setEditable(false);
        txtnumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnumeroActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("Número:");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Telefone:");

        txttelefone.setEditable(false);
        try {
            txttelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)9####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Endereço:");

        txtend.setEditable(false);
        txtend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtendActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setText("Bairro:");

        codigo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        codigo.setText("*Código:");

        txtcodigocliente.setEditable(false);
        txtcodigocliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtcodigoclienteMouseClicked(evt);
            }
        });
        txtcodigocliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodigoclienteActionPerformed(evt);
            }
        });
        txtcodigocliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcodigoclienteKeyReleased(evt);
            }
        });

        txtbairro.setEditable(false);
        txtbairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbairroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(codigo)
                .addGap(10, 10, 10)
                .addComponent(txtcodigocliente, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtnome, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txttelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtend, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtbairro, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtnumero, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(codigo)
                        .addComponent(txtcodigocliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(txtnome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(txtnumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(txtbairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(txttelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Pedido"));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Pesquisar Produto"));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setText("Produto:");

        jComboBoxCliente.setEnabled(false);

        adicionaritem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        adicionaritem.setText("Add");
        adicionaritem.setEnabled(false);
        adicionaritem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionaritemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(adicionaritem)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jComboBoxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(adicionaritem)))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Total Pedido"));

        codigo2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        codigo2.setText("Numero da Venda:");

        txtnumerovenda.setEditable(false);
        txtnumerovenda.setEnabled(false);
        txtnumerovenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtnumerovendaMouseClicked(evt);
            }
        });
        txtnumerovenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnumerovendaActionPerformed(evt);
            }
        });
        txtnumerovenda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtnumerovendaKeyReleased(evt);
            }
        });

        codigo1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        codigo1.setText("Código:");

        txtcodigoprod.setEditable(false);
        txtcodigoprod.setEnabled(false);
        txtcodigoprod.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtcodigoprodMouseClicked(evt);
            }
        });
        txtcodigoprod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodigoprodActionPerformed(evt);
            }
        });
        txtcodigoprod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcodigoprodKeyReleased(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12.setText(" Receber:");

        txtvalorreceber.setEnabled(false);
        txtvalorreceber.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtvalorreceberFocusGained(evt);
            }
        });
        txtvalorreceber.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtvalorreceberMouseClicked(evt);
            }
        });
        txtvalorreceber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtvalorreceberActionPerformed(evt);
            }
        });
        txtvalorreceber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtvalorreceberKeyReleased(evt);
            }
        });

        txtvalorprod.setEnabled(false);
        txtvalorprod.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtvalorprodFocusLost(evt);
            }
        });
        txtvalorprod.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtvalorprodMouseClicked(evt);
            }
        });
        txtvalorprod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtvalorprodActionPerformed(evt);
            }
        });
        txtvalorprod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtvalorprodKeyReleased(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel17.setText("Valor :");

        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setText("Valor Total:");

        txttroco.setEditable(false);
        txttroco.setEnabled(false);
        txttroco.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txttrocoFocusGained(evt);
            }
        });
        txttroco.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txttrocoMouseClicked(evt);
            }
        });
        txttroco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttrocoActionPerformed(evt);
            }
        });
        txttroco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txttrocoKeyReleased(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel18.setText("Troco :");

        jComboBoxtippopag.setEnabled(false);

        jLabel16.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel16.setText("Tipo pagamento:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("Data Venda:");

        txtdata.setEditable(false);
        try {
            txtdata.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####    ##:##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtdata.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        tabelavenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabelavenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelavendaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabelavenda);

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setText("QTD:");

        txtqtd.setEnabled(false);
        txtqtd.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtqtdFocusGained(evt);
            }
        });
        txtqtd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtqtdMouseClicked(evt);
            }
        });
        txtqtd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtqtdActionPerformed(evt);
            }
        });
        txtqtd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtqtdKeyReleased(evt);
            }
        });

        txtvalortotal.setEditable(false);
        txtvalortotal.setEnabled(false);
        txtvalortotal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtvalortotalFocusGained(evt);
            }
        });
        txtvalortotal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtvalortotalMouseClicked(evt);
            }
        });
        txtvalortotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtvalortotalActionPerformed(evt);
            }
        });
        txtvalortotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtvalortotalKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtvalorreceber, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtvalorprod, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txttroco, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtvalortotal, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(codigo1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtcodigoprod, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(codigo2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtnumerovenda)))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtdata, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtqtd, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxtippopag, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtqtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtdata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(codigo2)
                        .addComponent(txtnumerovenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(codigo1)
                        .addComponent(txtcodigoprod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16)
                        .addComponent(jComboBoxtippopag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(txtvalorreceber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel17)
                        .addComponent(txtvalorprod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel18)
                        .addComponent(txttroco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)
                        .addComponent(txtvalortotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        voltar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        voltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/back.png"))); // NOI18N
        voltar.setText("Voltar");
        voltar.setEnabled(false);
        voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarActionPerformed(evt);
            }
        });

        Atualizar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Atualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/refresh-button.png"))); // NOI18N
        Atualizar.setText("Atualizar");
        Atualizar.setEnabled(false);
        Atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtualizarActionPerformed(evt);
            }
        });

        limpar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        limpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/wiping-swipe-for-floors.png"))); // NOI18N
        limpar.setText("Limpar");
        limpar.setEnabled(false);
        limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparActionPerformed(evt);
            }
        });

        cadastrar3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cadastrar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/user24.png"))); // NOI18N
        cadastrar3.setText("Novo Pedido");
        cadastrar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrar3ActionPerformed(evt);
            }
        });

        cadastrarpedido.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cadastrarpedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/user24.png"))); // NOI18N
        cadastrarpedido.setText("Fazer Pedido");
        cadastrarpedido.setEnabled(false);
        cadastrarpedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarpedidoActionPerformed(evt);
            }
        });

        tabelaitens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabelaitens.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaitensMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelaitens);

        txtcalcular.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        txtcalcular.setText("Calcular pedido");
        txtcalcular.setEnabled(false);
        txtcalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcalcularActionPerformed(evt);
            }
        });

        codigo3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        codigo3.setText("Código Item:");

        txtcodigoproditem.setEditable(false);
        txtcodigoproditem.setEnabled(false);
        txtcodigoproditem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtcodigoproditemMouseClicked(evt);
            }
        });
        txtcodigoproditem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodigoproditemActionPerformed(evt);
            }
        });
        txtcodigoproditem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcodigoproditemKeyReleased(evt);
            }
        });

        jButton1.setText("Cancelar Pedido");
        jButton1.setEnabled(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(323, 323, 323)
                        .addComponent(cadastrar3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cadastrarpedido, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(limpar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Atualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(codigo3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtcodigoproditem, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(txtcalcular)
                .addGap(850, 850, 850))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(codigo3)
                            .addComponent(txtcodigoproditem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1)
                            .addComponent(txtcalcular)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Atualizar)
                            .addComponent(voltar)
                            .addComponent(limpar)
                            .addComponent(cadastrarpedido)
                            .addComponent(cadastrar3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 4, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtbuscanomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscanomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbuscanomeActionPerformed

    private void txtbuscanomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscanomeKeyReleased

        String nome = txtbuscanome.getText();
        if(nome.equals("")){
            JOptionPane.showMessageDialog(null,"Nome não Encontrado!");
            txtbuscanome.requestFocus();
            PreencherTabelaCliente("SELECT * from cliente order by idcliente");
        }
        else{
            PreencherTabelaCliente("SELECT * FROM cliente WHERE nome LIKE '"+nome+ "%'");
            

        }

    }//GEN-LAST:event_txtbuscanomeKeyReleased

    private void txtbuscatelefoneKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscatelefoneKeyReleased
        String fone = txtbuscatelefone.getText();
        if(fone.equals("")){
            //JOptionPane.showMessageDialog(this,"Digite Um Produto!");
            txtbuscanome.requestFocus();
            PreencherTabelaCliente("SELECT * from cliente order by idcliente");
        }
        else{
            PreencherTabelaCliente("SELECT * FROM cliente WHERE telefone LIKE '"+fone+ "%'");
        }
    }//GEN-LAST:event_txtbuscatelefoneKeyReleased

    private void tabelafunMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelafunMouseClicked
        txtcodigocliente.setText(tabelafun.getValueAt(tabelafun.getSelectedRow(),0).toString());
        txtnome.setText( tabelafun.getValueAt(tabelafun.getSelectedRow(),1).toString());
        txtbairro.setText(tabelafun.getValueAt(tabelafun.getSelectedRow(),2).toString());
        txtend.setText(tabelafun.getValueAt(tabelafun.getSelectedRow(),3).toString());
        txtnumero.setText(tabelafun.getValueAt(tabelafun.getSelectedRow(),4).toString());
        txttelefone.setText(tabelafun.getValueAt(tabelafun.getSelectedRow(),5).toString());
    }//GEN-LAST:event_tabelafunMouseClicked

    private void txtnomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnomeActionPerformed

    private void txtnumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnumeroActionPerformed

    private void txtendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtendActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtendActionPerformed

    private void txtcodigoclienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtcodigoclienteMouseClicked

    }//GEN-LAST:event_txtcodigoclienteMouseClicked

    private void txtcodigoclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodigoclienteActionPerformed

    }//GEN-LAST:event_txtcodigoclienteActionPerformed

    private void txtcodigoclienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcodigoclienteKeyReleased
        String nome = txtcodigocliente.getText();
        if(nome.equals("")){
            //JOptionPane.showMessageDialog(null,"Nome não Encontrado!");
            txtcodigocliente.requestFocus();
            PreencherTabelaCliente("SELECT * from cliente order by idcliente");
        }
        else{
            PreencherTabelaCliente("SELECT * FROM cliente WHERE idcliente LIKE '"+nome+ "%'");

        }

    }//GEN-LAST:event_txtcodigoclienteKeyReleased

    private void txtbairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbairroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbairroActionPerformed

    private void cadastrar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrar3ActionPerformed

        this.nvenda();
        this.cadidvenda();
    }//GEN-LAST:event_cadastrar3ActionPerformed

    private void cadastrarcliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarcliActionPerformed
        Frmclientes cadcliente = new Frmclientes();
        cadcliente.setVisible(true);
    }//GEN-LAST:event_cadastrarcliActionPerformed

    private void limparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparActionPerformed
        txtcodigocliente.setText("");
        txtnome.setText("");
        txtend.setText("");
        txtnumero.setText("");
        txttelefone.setText("");
        txtbairro.setText("");
        txtbuscanome.setText("");
        txtvalorprod.setText("");
        txtqtd.setText("");
   /*     txtcodigoprod.setText("");
        txtproduto.setText("");
        txtprodutovalor.setText("");
        txtvalortotal.setText("");
        txtqtd.setText("");
        txtdata.setText("");
        txtcodigovenda.setText("");*/
    }//GEN-LAST:event_limparActionPerformed

    private void AtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtualizarActionPerformed
 String prodselect = txtnumerovenda.getText();
        if(prodselect.equals("")){
            JOptionPane.showMessageDialog(this,"Digite Um Produto!");
        }
        else{
            
           PreencherTabelaItens("SELECT * from itens_venda where numeropedido like '%"+prodselect+"%'");
        }
    }//GEN-LAST:event_AtualizarActionPerformed

    private void voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_voltarActionPerformed

    private void tabelaitensMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaitensMouseClicked
    txtnumerovenda.setText(tabelaitens.getValueAt(tabelaitens.getSelectedRow(),0).toString());
        //txtprodutovalor.setText( tabelafun.getValueAt(tabelafun.getSelectedRow(),1).toString());
       // txtproduto.setText(tabelaprod.getValueAt(tabelaprod.getSelectedRow(),1).toString());
        //txtprodutovalor.setText(tabelaprod.getValueAt(tabelaprod.getSelectedRow(),2).toString());
      //  txtvalorprod.setText( tabelaitens.getValueAt(tabelaitens.getSelectedRow(),2).toString());

    }//GEN-LAST:event_tabelaitensMouseClicked

    private void txtcodigoprodMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtcodigoprodMouseClicked

    }//GEN-LAST:event_txtcodigoprodMouseClicked

    private void txtcodigoprodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodigoprodActionPerformed

    }//GEN-LAST:event_txtcodigoprodActionPerformed

    private void txtcodigoprodKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcodigoprodKeyReleased
        String prod = txtcodigoprod.getText();
        if(prod.equals("")){
            //JOptionPane.showMessageDialog(null,"Nome não Encontrado!");
            txtcodigoprod.requestFocus();
//            PreencherTabelaProduto("SELECT * from produto order by idproduto");
        }
        else{
           // PreencherTabelaProduto("SELECT * FROM produto WHERE idproduto LIKE '"+prod+ "%'");

        }

    }//GEN-LAST:event_txtcodigoprodKeyReleased

    private void cadastrarpedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarpedidoActionPerformed
     String cdmsql = ("");
       
        PreencherTabelaItens("SELECT * from itens_venda where numeropedido like '0000000'");
//      
    }//GEN-LAST:event_cadastrarpedidoActionPerformed

    private void adicionaritemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adicionaritemActionPerformed
this.pegaid();

//
this.pedido();
this.pegaiditem();


String prodselect = txtnumerovenda.getText();
        if(prodselect.equals("")){
            JOptionPane.showMessageDialog(this,"Digite Um Produto!");
        }
        else{
            
           PreencherTabelaItens("SELECT * from itens_venda where numeropedido like '%"+prodselect+"%'");
           //PreencherTabelaItens("SELECT * from produto where valor");
       
   
        }
    }//GEN-LAST:event_adicionaritemActionPerformed

    private void txtvalorreceberFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtvalorreceberFocusGained
//        valortroco();
    }//GEN-LAST:event_txtvalorreceberFocusGained

    private void txtvalorreceberMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtvalorreceberMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtvalorreceberMouseClicked

    private void txtvalorreceberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtvalorreceberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtvalorreceberActionPerformed

    private void txtvalorreceberKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtvalorreceberKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtvalorreceberKeyReleased

    private void txtvalorprodFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtvalorprodFocusLost

    }//GEN-LAST:event_txtvalorprodFocusLost

    private void txtvalorprodMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtvalorprodMouseClicked

    }//GEN-LAST:event_txtvalorprodMouseClicked

    private void txtvalorprodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtvalorprodActionPerformed

    }//GEN-LAST:event_txtvalorprodActionPerformed

    private void txtvalorprodKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtvalorprodKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtvalorprodKeyReleased

    private void txttrocoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txttrocoFocusGained

    }//GEN-LAST:event_txttrocoFocusGained

    private void txttrocoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txttrocoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txttrocoMouseClicked

    private void txttrocoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttrocoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttrocoActionPerformed

    private void txttrocoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttrocoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txttrocoKeyReleased

    private void tabelavendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelavendaMouseClicked
     txtdata.setText( tabelavenda.getValueAt(tabelavenda.getSelectedRow(),1).toString());
       // txtproduto.setText(tabelaprod.getValueAt(tabelaprod.getSelectedRow(),1).toString());
        //txtprodutovalor.setText(tabelaprod.getValueAt(tabelaprod.getSelectedRow(),2).toString());
      //  txtvalorprod.setText( tabelaitens.getValueAt(tabelaitens.getSelectedRow(),2).toString());
    }//GEN-LAST:event_tabelavendaMouseClicked

    private void txtnumerovendaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnumerovendaKeyReleased
        String prodselect = txtnumerovenda.getText();
        if(prodselect.equals("")){
            JOptionPane.showMessageDialog(this,"Digite Um Produto!");
        }
        else{
            PreencherTabelaItens("SELECT * FROM itens_venda WHERE numeropedido like '"+txtnumerovenda.getText()+"%'");
        }
    }//GEN-LAST:event_txtnumerovendaKeyReleased

    private void txtnumerovendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnumerovendaActionPerformed

    }//GEN-LAST:event_txtnumerovendaActionPerformed

    private void txtnumerovendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtnumerovendaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnumerovendaMouseClicked

    private void txtqtdFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtqtdFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtqtdFocusGained

    private void txtqtdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtqtdMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtqtdMouseClicked

    private void txtqtdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtqtdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtqtdActionPerformed

    private void txtqtdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtqtdKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtqtdKeyReleased

    private void txtcalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcalcularActionPerformed
     this.valortotal();
     this.valortroco();
     this.adcionavt();
    }//GEN-LAST:event_txtcalcularActionPerformed

    private void txtcodigoproditemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtcodigoproditemMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodigoproditemMouseClicked

    private void txtcodigoproditemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodigoproditemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodigoproditemActionPerformed

    private void txtcodigoproditemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcodigoproditemKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodigoproditemKeyReleased

    private void txtvalortotalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtvalortotalFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtvalortotalFocusGained

    private void txtvalortotalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtvalortotalMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtvalortotalMouseClicked

    private void txtvalortotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtvalortotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtvalortotalActionPerformed

    private void txtvalortotalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtvalortotalKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtvalortotalKeyReleased

public void PreencherTabelaCliente(String cmdsql){ 
    ArrayList dados = new ArrayList();
    String[] Colunas = new String[]{
        "Código",
        "Nome",
        "Bairro",
        "Endereço",
        "Número",
        "Telefone",
    };
    try {
       PreparedStatement stmt = conecta.prepareStatement(cmdsql);
        ResultSet rs = stmt.executeQuery();
       while(rs.next()) {
         dados.add(new Object[]{
             rs.getInt("idcliente"),
             rs.getString("nome"),
             rs.getString("bairro"),
             rs.getString("endereco"),
             rs.getString("numero"),
             rs.getString("telefone"),
         });
       
        }
       rs.first();
       // stmt.execute();
      // 
     
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null,"Erro ao preencher a ArrayList ERRO:"+ e);
    }
    
    Tablecliente modelo = new Tablecliente(dados, Colunas);
    
    tabelafun.setModel(modelo);
    tabelafun.getColumnModel().getColumn(0).setPreferredWidth(308);//nome
    tabelafun.getColumnModel().getColumn(0).setResizable(false);//nome
    tabelafun.getColumnModel().getColumn(1).setPreferredWidth(300);//bairro
    tabelafun.getColumnModel().getColumn(1).setResizable(false);//bairro
    tabelafun.getColumnModel().getColumn(2).setPreferredWidth(360);//end
    tabelafun.getColumnModel().getColumn(2).setResizable(false);//end
    tabelafun.getColumnModel().getColumn(3).setPreferredWidth(370);//numero
    tabelafun.getColumnModel().getColumn(3).setResizable(false);//numero
    tabelafun.getColumnModel().getColumn(4).setPreferredWidth(370);//perfil
    tabelafun.getColumnModel().getColumn(4).setResizable(false);//tel
    tabelafun.getColumnModel().getColumn(5).setPreferredWidth(370);//tel
    tabelafun.getColumnModel().getColumn(5).setResizable(false);
    tabelafun.getTableHeader().setResizingAllowed(false);
    
    tabelafun.setAutoResizeMode(tabelafun.AUTO_RESIZE_ALL_COLUMNS);
    tabelafun.setAutoResizeMode(tabelafun.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
    tabelafun.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

}
public void PreencherTabelaVenda(String cmdsql){ 
    ArrayList dados = new ArrayList();
    String[] Colunas = new String[]{
        "Tipo De Pagamento",
        "Data Venda",
        "Quantidade",
        "Código Produto",
    };
    try {
       PreparedStatement stmt = conecta.prepareStatement(cmdsql);
        ResultSet rs = stmt.executeQuery();
       while(rs.next()) {
            Date registro = rs.getTimestamp("datavenda");
           SimpleDateFormat formatacao = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
            String registroLocal = formatacao.format(registro);
         dados.add(new Object[]{
             rs.getString("tipopag"),
             registroLocal,
              rs.getInt("vendaqtd"),
              rs.getInt("idproduto"),
         });
       
        }
       rs.first();
       // stmt.execute();
      // 
     
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null,"Erro ao preencher a ArrayList ERRO:"+ e);
    }
    
    Tablecliente modelo = new Tablecliente(dados, Colunas);
    
    tabelavenda.setModel(modelo);
    tabelavenda.getColumnModel().getColumn(0).setPreferredWidth(380);//nome
    tabelavenda.getColumnModel().getColumn(0).setResizable(false);//nome
    tabelavenda.getColumnModel().getColumn(1).setPreferredWidth(300);//bairro
    tabelavenda.getColumnModel().getColumn(1).setResizable(false);//bairro
    tabelavenda.getColumnModel().getColumn(2).setPreferredWidth(360);//end
    tabelavenda.getColumnModel().getColumn(2).setResizable(false);//end
    tabelavenda.getColumnModel().getColumn(3).setPreferredWidth(370);//numero
    tabelavenda.getColumnModel().getColumn(3).setResizable(false);//numero
    //tabelavenda.getColumnModel().getColumn(4).setPreferredWidth(370);//perfil
    //tabelavenda.getColumnModel().getColumn(4).setResizable(false);//tel
    //tabelavenda.getColumnModel().getColumn(5).setPreferredWidth(370);//tel
    //tabelavenda.getColumnModel().getColumn(5).setResizable(false);
     
    
   tabelavenda.getTableHeader().setResizingAllowed(false);
    
    tabelavenda.setAutoResizeMode(tabelafun.AUTO_RESIZE_ALL_COLUMNS);
    tabelavenda.setAutoResizeMode(tabelafun.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
    tabelavenda.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

}
public void PreencherTabelaItens(String cmdsql){ 
    ArrayList dados = new ArrayList();
    String[] Colunas = new String[]{
        "Nº Pedido",
        "Produtos",
       // "Valor",
    };
    try {
       PreparedStatement stmt = conecta.prepareStatement(cmdsql);
        ResultSet rs = stmt.executeQuery();
       while(rs.next()) {
         dados.add(new Object[]{
             rs.getString("numeropedido"),
             rs.getString("itemvenda"),
            // rs.getString("valor").replace(".", ","),
             
         });
       
        }
       rs.first();
       // stmt.execute();
      // 
     
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null,"Erro ao preencher a ArrayList ERRO:"+ e);
    }
    
    Tablecliente modelo = new Tablecliente(dados, Colunas);
    
    tabelaitens.setModel(modelo);
    tabelaitens.getColumnModel().getColumn(0).setPreferredWidth(300);//nome
    tabelaitens.getColumnModel().getColumn(0).setResizable(false);//nome
    tabelaitens.getColumnModel().getColumn(1).setPreferredWidth(250);//bairro
    tabelaitens.getColumnModel().getColumn(1).setResizable(false);//bairro
    tabelaitens.getColumnModel().getColumn(2).setPreferredWidth(150);//bairro
   //tabelaitens.getColumnModel().getColumn(2).setResizable(false);
   //tabelaitens.getTableHeader().setResizingAllowed(false);
    tabelaitens.setAutoResizeMode(tabelafun.AUTO_RESIZE_ALL_COLUMNS);
    tabelaitens.setAutoResizeMode(tabelafun.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
    tabelaitens.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Atualizar;
    private javax.swing.JButton adicionaritem;
    private javax.swing.JButton cadastrar3;
    private javax.swing.JButton cadastrarcli;
    private javax.swing.JButton cadastrarpedido;
    private javax.swing.JLabel codigo;
    private javax.swing.JLabel codigo1;
    private javax.swing.JLabel codigo2;
    private javax.swing.JLabel codigo3;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBoxCliente;
    private javax.swing.JComboBox<String> jComboBoxtippopag;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton limpar;
    private javax.swing.JTable tabelafun;
    private javax.swing.JTable tabelaitens;
    private javax.swing.JTable tabelavenda;
    private javax.swing.JTextField txtbairro;
    private javax.swing.JTextField txtbuscanome;
    private javax.swing.JFormattedTextField txtbuscatelefone;
    private javax.swing.JButton txtcalcular;
    private javax.swing.JTextField txtcodigocliente;
    private javax.swing.JTextField txtcodigoprod;
    private javax.swing.JTextField txtcodigoproditem;
    private javax.swing.JFormattedTextField txtdata;
    private javax.swing.JTextField txtend;
    private javax.swing.JTextField txtnome;
    private javax.swing.JTextField txtnumero;
    private javax.swing.JTextField txtnumerovenda;
    private javax.swing.JTextField txtqtd;
    private javax.swing.JFormattedTextField txttelefone;
    private javax.swing.JTextField txttroco;
    private javax.swing.JTextField txtvalorprod;
    private javax.swing.JTextField txtvalorreceber;
    private javax.swing.JTextField txtvalortotal;
    private javax.swing.JButton voltar;
    // End of variables declaration//GEN-END:variables
}
