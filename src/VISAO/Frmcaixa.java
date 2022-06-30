/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VISAO;
import BEAN.BEANcaixa;
import DAO.DAOproduto;
import BEAN.BEANproduto;
import BEAN.BEANcliente;
import CONNECT.Myconnect;
import DAO.DAOcaixa;
import DAO.DAOcliente;
import Utilitarios.Tablecliente;
import Utilitarios.Tableproduto;
import Utilitarios.Tablevenda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author luizb
 */
public class Frmcaixa extends javax.swing.JFrame {
private  Connection conecta;
 int cadvenda;

    /**
     * Creates new form Frmcaixa
     */
    public Frmcaixa() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        this.conecta=new Myconnect().conecta();
        this.cadpag();
        PreencherTabelaProduto("SELECT * from produto order by idproduto");
        PreencherTabela("SELECT * from cliente order by idcliente");
       PreencherTabelavenda("SELECT * from venda order by idvenda");
        
       
    }
     
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
     public void pegaid(){
    try {
         String sql;
         
         //String cmdsql;
       //  sql =;
            PreparedStatement stmt = conecta.prepareStatement("insert into venda (valor) values (?)"); 
            stmt.setFloat(1,0);
           stmt.execute();
         // rs.last();/*
         /* cadvenda = rs.getInt("idvenda");*/
          //rs.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(rootPane,"Erro" +ex);
    }
     }
    public  void pedido(){      
       /* try {
            DAOcaixa dao = new DAOcaixa();
            BEANcaixa obj =new BEANcaixa();
            obj.setTipopag(jComboBoxtippopag.getSelectedItem().toString());
            obj.setValor(txtprodutovalor.getText().replace(",","."));
            obj.setValortotal( txtvalortotal.getText().replace(",","."));
            obj.setVendaqtd(Integer.valueOf( txtqtd.getText()));
            obj.setIdproduto(Integer.valueOf(txtcodigocliente.getText()));
            obj.setIdproduto(Integer.valueOf(txtcodigoprod.getText()));
            dao.save(obj);
        } catch (Exception e) {
        }*/
        try {
            String cmdsql;
       cmdsql ="insert into venda (tipopag,valor,valortotal,vendaqtd,idcliente,idproduto) values (?,?,?,?,?,?) ";
        PreparedStatement stmt =  conecta.prepareStatement(cmdsql);
        stmt.setString(1, jComboBoxtippopag.getSelectedItem().toString());
        stmt.setString(2, txtprodutovalor.getText().replace(",","."));
        stmt.setString(3,txtprodutovalor.getText().replace(",","."));
        stmt.setString(4, txtqtd.getText());
        stmt.setString(5,  txtcodigocliente.getText());
        stmt.setString(6,  txtcodigoprod.getText());
     
       
       if((txtcodigoprod.getText().isEmpty() || txtcodigocliente.getText().isEmpty()||txtprodutovalor.getText().isEmpty() || txtqtd.getText().isEmpty())){
           JOptionPane.showMessageDialog(null,"Preencha todos os campos obrigatorios");
       }
       else{
           int adicionando = stmt.executeUpdate();
           if(adicionando > 0){
               JOptionPane.showMessageDialog(null,"Pedido feito com sucesso");
                      txtcodigocliente.setText("");
       /* txtnome.setText("");
        txtend.setText("");
        txtnumero.setText("");
        txttelefone.setText("");
         txtcodigoprod.setText("");
        txtproduto.setText("");
        txtprodutovalor.setText(""); 
        txtvalortotal.setText("");
        txtqtd.setText("");
         txtdata.setText("");
         txtcodigovenda.setText("");
                      */
           }
           
       }
       
          } catch (Exception e) {
              JOptionPane.showMessageDialog(null, e);
        }
        
    }
public void retornavalor(){
    
        try {
         String cmdsql;
            cmdsql = "select * from produto ";
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
             ResultSet rs =stmt.executeQuery();            
             
             while(rs.next()){
               //jComboBoxtippopag.removeAllItems();
               txtprodutovalor.setText(txtvalorprod.getText());
               /*jComboBoxtippopag.addItem("Cartão de Debito");
               jComboBoxtippopag.addItem("Dinheiro");*/
           }
    } catch (Exception e) {
    }
}
  public void valortotal(){
      String vp = txtprodutovalor.getText().replace(",",".");
      String qtd =txtqtd.getText().replace(",",".");
      
    double x =Double.parseDouble(vp);
    double y = Double.parseDouble(qtd);
    double vt = x * y; 
    
    txtvalortotal.setText(Double.toString(vt).replace(".",","));
   
    }
   public void valortroco(){
      String vp = txtvalorreceber.getText().replace(",",".");
      String qtd =txtvalortotal.getText().replace(",",".");
      
    double x =Double.parseDouble(vp);
    double y = Double.parseDouble(qtd);
    double vt = x - y; 
    
    txttroco.setText(Double.toString(vt).replace(".",","));
   
    }
  
             
       
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtbuscanome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtbuscatelefone = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelafun = new javax.swing.JTable();
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
        cadastrar = new javax.swing.JButton();
        limpar = new javax.swing.JButton();
        Atualizar = new javax.swing.JButton();
        voltar = new javax.swing.JButton();
        cadastrar1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtprodutovalor = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaprod = new javax.swing.JTable();
        codigo1 = new javax.swing.JLabel();
        txtcodigoprod = new javax.swing.JTextField();
        txtproduto = new javax.swing.JTextField();
        cadastrar2 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelavenda = new javax.swing.JTable();
        codigo2 = new javax.swing.JLabel();
        txtcodigovenda = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtqtd = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtdata = new javax.swing.JFormattedTextField();
        jLabel16 = new javax.swing.JLabel();
        jComboBoxtippopag = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        txtvalorreceber = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txttroco = new javax.swing.JTextField();
        txtvalorprod = new javax.swing.JTextField();
        txtvalortotal = new javax.swing.JFormattedTextField();
        cadastrar3 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tela Caixa");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel14.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel14.setText("CAIXA");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar Cliente"));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Nome:");

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
        jLabel3.setText("Telefone:");

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtbuscanome, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtbuscatelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
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
                    .addComponent(txtbuscatelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
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
        codigo.setText("Código:");

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(codigo)
                .addGap(10, 10, 10)
                .addComponent(txtcodigocliente, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtnome, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txttelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtend, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtbairro, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtnumero, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(codigo)
                        .addComponent(txtcodigocliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txtnome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)
                        .addComponent(txttelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtbairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)
                        .addComponent(txtnumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        cadastrar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/user24.png"))); // NOI18N
        cadastrar.setText("Fazer Pedido");
        cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarActionPerformed(evt);
            }
        });

        limpar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        limpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/wiping-swipe-for-floors.png"))); // NOI18N
        limpar.setText("Limpar");
        limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparActionPerformed(evt);
            }
        });

        Atualizar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Atualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/refresh-button.png"))); // NOI18N
        Atualizar.setText("Atualizar");
        Atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtualizarActionPerformed(evt);
            }
        });

        voltar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        voltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/back.png"))); // NOI18N
        voltar.setText("Voltar");
        voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarActionPerformed(evt);
            }
        });

        cadastrar1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cadastrar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/user24.png"))); // NOI18N
        cadastrar1.setText("Cadastrar Cliente");
        cadastrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrar1ActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Pedido"));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setText("Produto:");

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setText("Valor:");

        txtprodutovalor.setEditable(false);
        txtprodutovalor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtprodutovalorActionPerformed(evt);
            }
        });
        txtprodutovalor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtprodutovalorKeyReleased(evt);
            }
        });

        tabelaprod.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabelaprod.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaprodMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelaprod);

        codigo1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        codigo1.setText("Código:");

        txtcodigoprod.setEditable(false);
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

        txtproduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtprodutoActionPerformed(evt);
            }
        });
        txtproduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtprodutoKeyReleased(evt);
            }
        });

        cadastrar2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cadastrar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/user24.png"))); // NOI18N
        cadastrar2.setText("Fazer Pedido");
        cadastrar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrar2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(codigo1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtcodigoprod, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtproduto, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtprodutovalor, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cadastrar2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codigo1)
                    .addComponent(txtcodigoprod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(txtprodutovalor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cadastrar2)
                    .addComponent(txtproduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Total Pedido", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

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

        codigo2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        codigo2.setText("Código:");

        txtcodigovenda.setEditable(false);
        txtcodigovenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtcodigovendaMouseClicked(evt);
            }
        });
        txtcodigovenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodigovendaActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setText("Valor Total:");

        jLabel12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12.setText(" Receber:");

        jLabel13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel13.setText("Quantidade:");

        txtqtd.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtqtdFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtqtdFocusLost(evt);
            }
        });
        txtqtd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtqtdActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("Data Venda:");

        txtdata.setEditable(false);
        try {
            txtdata.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####    ##:##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtdata.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel16.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel16.setText("Tipo agamento:");

        jLabel17.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel17.setText("Valor :");

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

        jLabel18.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel18.setText("Troco :");

        txttroco.setEditable(false);
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

        txtvalorprod.setEditable(false);
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

        txtvalortotal.setEditable(false);
        try {
            txtvalortotal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##,##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtvalortotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtvalortotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtvalortotalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(codigo2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtcodigovenda, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtvalorreceber, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtvalorprod, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtqtd, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtvalortotal, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txttroco, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxtippopag, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtdata))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codigo2)
                    .addComponent(txtcodigovenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel13)
                    .addComponent(txtqtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(txttroco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(jComboBoxtippopag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel17)
                    .addComponent(txtvalorreceber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtvalorprod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtvalortotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        cadastrar3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cadastrar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/user24.png"))); // NOI18N
        cadastrar3.setText("Novo Pedido");
        cadastrar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrar3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(cadastrar3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cadastrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cadastrar1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(limpar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Atualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(258, 258, 258))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(662, 662, 662)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(65, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cadastrar)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Atualizar)
                        .addComponent(voltar)
                        .addComponent(limpar)
                        .addComponent(cadastrar1)
                        .addComponent(cadastrar3)))
                .addContainerGap())
        );

        jMenu1.setText("Consultar");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Consultar Pedido");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Consultar ");
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtbuscanomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscanomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbuscanomeActionPerformed

    private void tabelafunMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelafunMouseClicked
        txtcodigocliente.setText(tabelafun.getValueAt(tabelafun.getSelectedRow(),0).toString());
        txtnome.setText( tabelafun.getValueAt(tabelafun.getSelectedRow(),1).toString());
         txtbairro.setText(tabelafun.getValueAt(tabelafun.getSelectedRow(),2).toString());
        txtend.setText(tabelafun.getValueAt(tabelafun.getSelectedRow(),3).toString());
        txtnumero.setText(tabelafun.getValueAt(tabelafun.getSelectedRow(),4).toString());
        txttelefone.setText(tabelafun.getValueAt(tabelafun.getSelectedRow(),5).toString());
    }//GEN-LAST:event_tabelafunMouseClicked

    private void txtbuscanomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscanomeKeyReleased

        String nome = txtbuscanome.getText();
        if(nome.equals("")){
                 JOptionPane.showMessageDialog(null,"Nome não Encontrado!");
                 txtbuscanome.requestFocus();
               PreencherTabela("SELECT * from cliente order by idcliente");
            }
                else{
                    PreencherTabela("SELECT * FROM cliente WHERE nome LIKE '"+nome+ "%'");
                    
                        }
        
    }//GEN-LAST:event_txtbuscanomeKeyReleased

    private void txtbuscatelefoneKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscatelefoneKeyReleased
   String fone = txtbuscatelefone.getText();
        if(fone.equals("")){
                 //JOptionPane.showMessageDialog(this,"Digite Um Produto!");
                 txtbuscanome.requestFocus();
               PreencherTabela("SELECT * from cliente order by idcliente");
            }
                else{
                    PreencherTabela("SELECT * FROM cliente WHERE telefone LIKE '"+fone+ "%'");
        }
    }//GEN-LAST:event_txtbuscatelefoneKeyReleased

    private void txtnomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnomeActionPerformed

    private void txtcodigoclienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtcodigoclienteMouseClicked

    }//GEN-LAST:event_txtcodigoclienteMouseClicked

    private void txtcodigoclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodigoclienteActionPerformed

    }//GEN-LAST:event_txtcodigoclienteActionPerformed

    private void txtendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtendActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtendActionPerformed

    private void txtnumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnumeroActionPerformed

    private void txtbairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbairroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbairroActionPerformed

    private void cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarActionPerformed
  try {
            //1 passo resseber as variaveis usuario e senha 
           BEANcliente obj = new BEANcliente();
            obj.setIdcliente(Integer.valueOf(txtcodigocliente.getText()));
           obj.setNome(txtnome.getText());
            obj.setBairro(txtbairro.getText());
            obj.setEndereco(txtend.getText());
            obj.setNumero(Integer.valueOf(txtnumero.getText()));
            obj.setTelefone(txttelefone.getText());
            
            DAOcaixa   dao = new DAOcaixa();
  
  if(dao.fazerpedido(obj)){
      //abra a tela de cadastro
   //  Frmfazerpedido telacliente = new Frmfazerpedido(txtcodigocliente.getText());
    // telacliente.setVisible(true);
      
      
      this.dispose();
  }
  else{
       //exibe uma mensagem para o usuario.
       JOptionPane.showMessageDialog(null,"Dados incorretos!");
  }
        } catch (Exception e) {
            
        }
    
    }//GEN-LAST:event_cadastrarActionPerformed

    private void limparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparActionPerformed
        txtcodigocliente.setText("");
        txtnome.setText("");
        txtend.setText("");
        txtnumero.setText("");
        txttelefone.setText("");
         txtcodigoprod.setText("");
        txtproduto.setText("");
        txtprodutovalor.setText(""); 
        txtvalortotal.setText("");
        txtqtd.setText("");
         txtdata.setText("");
         txtcodigovenda.setText("");
    }//GEN-LAST:event_limparActionPerformed

    private void AtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtualizarActionPerformed
        PreencherTabela("select * from cliente order by idcliente");
         PreencherTabelavenda("SELECT * from venda order by idvenda");
         PreencherTabelaProduto("SELECT * from produto order by idproduto");
    }//GEN-LAST:event_AtualizarActionPerformed

    private void voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_voltarActionPerformed

    private void cadastrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrar1ActionPerformed
      Frmclientes cadcliente = new Frmclientes();
      cadcliente.setVisible(true);
    }//GEN-LAST:event_cadastrar1ActionPerformed

    private void txtprodutovalorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtprodutovalorActionPerformed
    
      
    }//GEN-LAST:event_txtprodutovalorActionPerformed

    private void txtprodutovalorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtprodutovalorKeyReleased

    }//GEN-LAST:event_txtprodutovalorKeyReleased

    private void tabelaprodMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaprodMouseClicked
        txtcodigoprod.setText(tabelaprod.getValueAt(tabelaprod.getSelectedRow(),0).toString());
        //txtprodutovalor.setText( tabelafun.getValueAt(tabelafun.getSelectedRow(),1).toString());
       txtproduto.setText(tabelaprod.getValueAt(tabelaprod.getSelectedRow(),1).toString());
        txtprodutovalor.setText(tabelaprod.getValueAt(tabelaprod.getSelectedRow(),2).toString());
             txtvalorprod.setText( tabelaprod.getValueAt(tabelaprod.getSelectedRow(),2).toString());
         
    }//GEN-LAST:event_tabelaprodMouseClicked

    private void txtcodigoprodMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtcodigoprodMouseClicked

    }//GEN-LAST:event_txtcodigoprodMouseClicked

    private void txtcodigoprodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodigoprodActionPerformed

    }//GEN-LAST:event_txtcodigoprodActionPerformed

    private void txtprodutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtprodutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtprodutoActionPerformed

    private void txtprodutoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtprodutoKeyReleased
   String produto = txtproduto.getText();
        if(produto.equals("")){
                 //JOptionPane.showMessageDialog(this,"Digite Um Produto!");
                 txtproduto.requestFocus();
               PreencherTabelaProduto("SELECT * from produto order by idproduto");
            }
                else{
                    PreencherTabelaProduto("SELECT * FROM produto WHERE produto LIKE '"+produto+ "%'");
                        }     
    }//GEN-LAST:event_txtprodutoKeyReleased

    private void tabelavendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelavendaMouseClicked
   
      txtcodigovenda.setText(tabelavenda.getValueAt(tabelavenda.getSelectedRow(),0).toString());
         jComboBoxtippopag.setSelectedItem(tabelavenda.getValueAt(tabelavenda.getSelectedRow(),1).toString());
          txtprodutovalor.setText( tabelavenda.getValueAt(tabelavenda.getSelectedRow(),2).toString());
          txtvalortotal.setText(tabelavenda.getValueAt(tabelavenda.getSelectedRow(),3).toString());
          txtqtd.setText(tabelavenda.getValueAt(tabelavenda.getSelectedRow(),4).toString());
          txtdata.setText(tabelavenda.getValueAt(tabelavenda.getSelectedRow(),5).toString());
        txtcodigocliente.setText(tabelavenda.getValueAt(tabelavenda.getSelectedRow(),6).toString());
        txtcodigoprod.setText(tabelavenda.getValueAt(tabelavenda.getSelectedRow(),7).toString());
        
    
    }//GEN-LAST:event_tabelavendaMouseClicked

    private void txtcodigovendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtcodigovendaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodigovendaMouseClicked

    private void txtcodigovendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodigovendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodigovendaActionPerformed

    private void txtvalorprodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtvalorprodActionPerformed

    }//GEN-LAST:event_txtvalorprodActionPerformed

    private void txtqtdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtqtdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtqtdActionPerformed

    private void cadastrar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrar2ActionPerformed

this.valortotal();
this.valortroco();
this.pedido(); 
/*try {
            DAOcaixa dao = new DAOcaixa();
            BEANcaixa obj =new BEANcaixa();
            obj.setTipopag(jComboBoxtippopag.getSelectedItem().toString());
            obj.setValor(txtprodutovalor.getText().replace(",","."));
            obj.setValortotal( txtvalortotal.getText().replace(",","."));
            obj.setVendaqtd(Integer.valueOf( txtqtd.getText()));
            obj.setIdproduto(Integer.valueOf(txtcodigocliente.getText()));
            obj.setIdproduto(Integer.valueOf(txtcodigoprod.getText()));
            dao.save(obj);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane,"Erro"+ e);
        }

        /*   try {
            BEANcaixa obj = new BEANcaixa();
             obj.setIdcaixa((Integer.valueOf (txtcodigovenda.getText()))); 
             obj.setTipopag((String.valueOf( jComboBoxtippopag.getSelectedItem())));
             obj.setValorvenda(txtprodutovalor.getText());
             obj.setValortotal(txtvalortotal.getText());
             obj.setVendaqtd((Integer.valueOf (txtqtd.getText()))); 
             //cadastrar data!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            String registro = txtdata.getText();
            DateTimeFormatter formatacao = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
            LocalDate registroLocal = LocalDate.parse(registro, formatacao);
             obj.setDatavenda(registroLocal);
             obj.setIdproduto((Integer.valueOf (txtcodigoprod.getText())));
              obj.setIdcliente((Integer.valueOf (txtcodigocliente.getText())));
            //2 passo criar obj para guardar no clienteDAO
          DAOcaixa dao = new DAOcaixa();
          
          dao.save(obj);
      
       
            JOptionPane.showMessageDialog(null, "Cadastro Realizado com sucesso!");
            PreencherTabela("select * from cliente order by idcliente");
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "ERRO AO CADASTRAR:"+ erro);
          
}*/
    }//GEN-LAST:event_cadastrar2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void txtvalorprodKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtvalorprodKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtvalorprodKeyReleased

    private void txtvalorprodMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtvalorprodMouseClicked
       
    }//GEN-LAST:event_txtvalorprodMouseClicked

    private void txtvalorreceberMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtvalorreceberMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtvalorreceberMouseClicked

    private void txtvalorreceberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtvalorreceberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtvalorreceberActionPerformed

    private void txtvalorreceberKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtvalorreceberKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtvalorreceberKeyReleased

    private void txttrocoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txttrocoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txttrocoMouseClicked

    private void txttrocoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttrocoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttrocoActionPerformed

    private void txttrocoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttrocoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txttrocoKeyReleased

    private void txtvalortotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtvalortotalActionPerformed
//      this.valortotal();
    }//GEN-LAST:event_txtvalortotalActionPerformed

    private void cadastrar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrar3ActionPerformed
      this.pegaid();
    }//GEN-LAST:event_cadastrar3ActionPerformed

    private void txttrocoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txttrocoFocusGained

    }//GEN-LAST:event_txttrocoFocusGained

    private void txtcodigoclienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcodigoclienteKeyReleased
   String nome = txtcodigocliente.getText();
        if(nome.equals("")){
                 //JOptionPane.showMessageDialog(null,"Nome não Encontrado!");
                 txtcodigocliente.requestFocus();
               PreencherTabela("SELECT * from cliente order by idcliente");
            }
                else{
                    PreencherTabela("SELECT * FROM cliente WHERE idcliente LIKE '"+nome+ "%'");
                    
                        }
        
    }//GEN-LAST:event_txtcodigoclienteKeyReleased

    private void txtqtdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtqtdFocusLost
  
    }//GEN-LAST:event_txtqtdFocusLost

    private void txtqtdFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtqtdFocusGained

    }//GEN-LAST:event_txtqtdFocusGained

    private void txtvalorprodFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtvalorprodFocusLost

    }//GEN-LAST:event_txtvalorprodFocusLost

    private void txtvalorreceberFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtvalorreceberFocusGained
    valortroco();
    }//GEN-LAST:event_txtvalorreceberFocusGained

    private void txtcodigoprodKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcodigoprodKeyReleased
        String prod = txtcodigoprod.getText();
        if(prod.equals("")){
                 //JOptionPane.showMessageDialog(null,"Nome não Encontrado!");
               txtcodigoprod.requestFocus();
               PreencherTabelaProduto("SELECT * from produto order by idproduto");
            }
                else{
                    PreencherTabelaProduto("SELECT * FROM produto WHERE idproduto LIKE '"+prod+ "%'");
                    
                        }
        
    }//GEN-LAST:event_txtcodigoprodKeyReleased
public void PreencherTabela(String cmdsql){
    
    
    
      
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
public void PreencherTabelaProduto(String cmdsql){
    ArrayList dados = new ArrayList();
    String[] Colunas = new String[]{
        "Código",
        "Produto",
        "Valor",
    };
    try {
       PreparedStatement stmt = conecta.prepareStatement(cmdsql);
        ResultSet rs = stmt.executeQuery();
       while(rs.next()) {
         dados.add(new Object[]{
             rs.getInt("idproduto"),
             rs.getString("produto"),
             rs.getString("valor"),
             });
       
        }
       rs.first();
       // stmt.execute();
      // 
     
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null,"Erro ao preencher Tabela Produto a ArrayList ERRO:"+ e);
    }
      Tableproduto modelo = new Tableproduto(dados, Colunas);
    
    tabelaprod.setModel(modelo);
    tabelaprod.getColumnModel().getColumn(0).setPreferredWidth(308);//id
    tabelaprod.getColumnModel().getColumn(0).setResizable(false);//id
    tabelaprod.getColumnModel().getColumn(1).setPreferredWidth(300);//nome
    tabelaprod.getColumnModel().getColumn(1).setResizable(false);//nome
    tabelaprod.getColumnModel().getColumn(2).setPreferredWidth(360);//nasc
    tabelaprod.getColumnModel().getColumn(2).setResizable(false);//nasc
    //tabelafun.getColumnModel().getColumn(3).setPreferredWidth(370);//perfil
    //tabelafun.getColumnModel().getColumn(3).setResizable(false);//perfil
    //tabelafun.getColumnModel().getColumn(4).setPreferredWidth(100);//rg
    tabelaprod.getTableHeader().setResizingAllowed(false);
    tabelaprod.setAutoResizeMode(tabelafun.AUTO_RESIZE_ALL_COLUMNS);
    tabelaprod.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
   
    
    
  

}
public void PreencherTabelavenda(String cmdsql){
    ArrayList dados = new ArrayList();
    String[] Colunas = new String[]{
        "Código",
        "Tipo Pagamento",
        "Valor",
        "Valor Total",
        "Quantidade",
        "Data da Venda",
        "Cod Cliente", 
        "Cod Produto",
       
    };
    try {
         
       PreparedStatement stmt = conecta.prepareStatement(cmdsql);
        ResultSet rs = stmt.executeQuery();
        
       
       while(rs.next()) {
            Date registro = rs.getTimestamp("datavenda");
           SimpleDateFormat formatacao = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
            String registroLocal = formatacao.format(registro);
         dados.add(new Object[]{
             rs.getInt("idvenda"),
             rs.getString("tipopag"),
             rs.getString("valor").replace(".", ","),
             rs.getString("valortotal").replace(".", ","),
             rs.getInt("vendaqtd"),
             registroLocal,
             rs.getInt("idcliente"),
             rs.getInt("idproduto"),
            
             });
       
        }
       rs.first();
       // stmt.execute();
      // 
     
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null,"Erro ao preencher a ArrayList ERRO:"+ e);
    }
      Tablevenda modelo = new Tablevenda(dados, Colunas);
    
    tabelavenda.setModel(modelo);
    tabelavenda.getColumnModel().getColumn(0).setPreferredWidth(80);//id
    tabelavenda.getColumnModel().getColumn(0).setResizable(false);//id
    tabelavenda.getColumnModel().getColumn(1).setPreferredWidth(100);//tipopag
    tabelavenda.getColumnModel().getColumn(1).setResizable(false);//tipopag
    tabelavenda.getColumnModel().getColumn(2).setPreferredWidth(100);//valorvenda
    tabelavenda.getColumnModel().getColumn(2).setResizable(false);//valorvenda
    tabelavenda.getColumnModel().getColumn(3).setPreferredWidth(100);//valortotal
    tabelavenda.getColumnModel().getColumn(3).setResizable(false);//valortotal
    tabelavenda.getColumnModel().getColumn(4).setPreferredWidth(100);//datavenda
    tabelavenda.getColumnModel().getColumn(4).setResizable(false);//datavenda
    tabelavenda.getColumnModel().getColumn(5).setPreferredWidth(100);//qtdvenda
    tabelavenda.getColumnModel().getColumn(5).setResizable(false);//qtdvenda
    tabelavenda.getColumnModel().getColumn(6).setPreferredWidth(100);//qtdvenda
    tabelavenda.getColumnModel().getColumn(6).setResizable(false);//qtdvenda
    tabelavenda.getColumnModel().getColumn(7).setPreferredWidth(100);//qtdvenda
    tabelavenda.getColumnModel().getColumn(7).setResizable(false);//qtdvenda
    //tabelavenda.getColumnModel().getColumn(8).setPreferredWidth(100);//qtdvenda
    //tabelavenda.getColumnModel().getColumn(8).setResizable(false);//qtdvenda
    tabelavenda.getTableHeader().setResizingAllowed(false);
    tabelavenda.setAutoResizeMode(tabelafun.AUTO_RESIZE_ALL_COLUMNS);
    tabelavenda.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
   
    
    
  

}
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Frmcaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frmcaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frmcaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frmcaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frmcaixa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Atualizar;
    private javax.swing.JButton cadastrar;
    private javax.swing.JButton cadastrar1;
    private javax.swing.JButton cadastrar2;
    private javax.swing.JButton cadastrar3;
    private javax.swing.JLabel codigo;
    private javax.swing.JLabel codigo1;
    private javax.swing.JLabel codigo2;
    private javax.swing.JComboBox<String> jComboBoxtippopag;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
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
    private javax.swing.JTable tabelaprod;
    private javax.swing.JTable tabelavenda;
    private javax.swing.JTextField txtbairro;
    private javax.swing.JTextField txtbuscanome;
    private javax.swing.JFormattedTextField txtbuscatelefone;
    private javax.swing.JTextField txtcodigocliente;
    private javax.swing.JTextField txtcodigoprod;
    private javax.swing.JTextField txtcodigovenda;
    private javax.swing.JFormattedTextField txtdata;
    private javax.swing.JTextField txtend;
    private javax.swing.JTextField txtnome;
    private javax.swing.JTextField txtnumero;
    private javax.swing.JTextField txtproduto;
    private javax.swing.JTextField txtprodutovalor;
    private javax.swing.JTextField txtqtd;
    private javax.swing.JFormattedTextField txttelefone;
    private javax.swing.JTextField txttroco;
    private javax.swing.JTextField txtvalorprod;
    private javax.swing.JTextField txtvalorreceber;
    private javax.swing.JFormattedTextField txtvalortotal;
    private javax.swing.JButton voltar;
    // End of variables declaration//GEN-END:variables
}
