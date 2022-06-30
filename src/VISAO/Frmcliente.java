/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VISAO;

import BEAN.BEANcliente;
import CONNECT.Myconnect;
import DAO.DAOcliente;
import Utilitarios.Tablecliente;
import java.awt.Desktop;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author luizb
 */
public class Frmcliente extends javax.swing.JInternalFrame {
private  Connection conecta;
    /**
     * Creates new form cad
     */
    public Frmcliente() {
        initComponents();
         this.conecta=new Myconnect().conecta();
       PreencherTabela("SELECT * from cliente order by idcliente");
        this.cadfun();
    }
 public void cadfun() {
    try {
         String cmdsql;
            cmdsql = "select * from cliente ";
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
             ResultSet rs =stmt.executeQuery();            
             
             while(rs.next()){
               jComboperfil2.addItem("Acácia");
               jComboperfil2.addItem("Acácias");
               jComboperfil2.addItem("Alcídes Rabello");
               jComboperfil2.addItem("Alcídes Rabelo");
               jComboperfil2.addItem("Alice Maia");
               jComboperfil2.addItem("Alterosa");
               jComboperfil2.addItem("Alterosas");
               jComboperfil2.addItem("Alto Boa Vista");
               jComboperfil2.addItem("Alto São João");
               jComboperfil2.addItem("Amazonas");
               jComboperfil2.addItem("Antônio Canela");
               jComboperfil2.addItem("Antônio Pimenta");
               jComboperfil2.addItem("Área Rural de Montes Claros");
               jComboperfil2.addItem("Augusta Mota");
               jComboperfil2.addItem("Barcelona Park");
               jComboperfil2.addItem("Bela Paisagem");
               jComboperfil2.addItem("Bela Vista");
               jComboperfil2.addItem("Brasília");
               jComboperfil2.addItem("Camilo Prates");
               jComboperfil2.addItem("Cândida Câmara");
               jComboperfil2.addItem("Canelas");
               jComboperfil2.addItem("Carmelo");
               jComboperfil2.addItem("Centro");
               jComboperfil2.addItem("Chácara Recanto dos Araçás");
               jComboperfil2.addItem("Chiquinho Guimarães");
               jComboperfil2.addItem("Cidade Cristo Rei");
               jComboperfil2.addItem("Cidade Ind");
               jComboperfil2.addItem("Cidade Industrial");
               jComboperfil2.addItem("Cidade Nova");
               jComboperfil2.addItem("Cidade Santa Maria");
               jComboperfil2.addItem("Cintra");
               jComboperfil2.addItem("Ciro Anjos");
               jComboperfil2.addItem("Clarindo Lopes");
               jComboperfil2.addItem("Conjunto Chiquinho Guimarães");
               jComboperfil2.addItem("Conjunto Ciro dos Anjos");
               jComboperfil2.addItem("Conjunto Clarice Alves Vieira");
               jComboperfil2.addItem("Conjunto Cristo Rei");
               jComboperfil2.addItem("Conjunto Habitacional Joaquim Costa");
               jComboperfil2.addItem("Conjunto Habitacional José C Machad");
               jComboperfil2.addItem("Conjunto Jk II");
               jComboperfil2.addItem("Conjunto Joaquim Costa");
               jComboperfil2.addItem("Conjunto José Carlos Lima");
               jComboperfil2.addItem("Conjunto Residencial Jk");
               jComboperfil2.addItem("Delfino Magalhães");
               jComboperfil2.addItem("Distrito Industrial");
               jComboperfil2.addItem("Dona Gregoria");
               jComboperfil2.addItem("dos Mangues");
               jComboperfil2.addItem("Doutor João Alves");
               jComboperfil2.addItem("Edgar Pereira");
               jComboperfil2.addItem("Eldorado");
               jComboperfil2.addItem("Esplanada");
               jComboperfil2.addItem("Floresta");
               jComboperfil2.addItem("Francisco Peres I");
               jComboperfil2.addItem("Funcionários");
               jComboperfil2.addItem("Guarujá");
               jComboperfil2.addItem("Guilhermina");
               jComboperfil2.addItem("Ibituruna");
               jComboperfil2.addItem("Independência");
               jComboperfil2.addItem("Interlagos");
               jComboperfil2.addItem("Itatiaia");
               jComboperfil2.addItem("Jaraguá");
               jComboperfil2.addItem("Jaraguá I");
               jComboperfil2.addItem("Jaraguá II");
               jComboperfil2.addItem("Jardim Alvorada");
               jComboperfil2.addItem("Jardim Brasil");
               jComboperfil2.addItem("Jardim Eldorado");
               jComboperfil2.addItem("Jardim Europa");
               jComboperfil2.addItem("Jardim Liberdade");
               jComboperfil2.addItem("Jardim Palmeiras");
               jComboperfil2.addItem("Jardim Panorama");
               jComboperfil2.addItem("Jardim Primavera");
               jComboperfil2.addItem("Jardim São Geraldo");
               jComboperfil2.addItem("Jardim São Luís");
               jComboperfil2.addItem("Jardim São Luiz");
               jComboperfil2.addItem("Jk");
               jComboperfil2.addItem("João Alves");
               jComboperfil2.addItem("João Botelho");
               jComboperfil2.addItem("João Gordo");
               jComboperfil2.addItem("José Carlos Vale Lima");
               jComboperfil2.addItem("José Carlos Vale Lima Lima");
               jComboperfil2.addItem("José Correia Machado");
               jComboperfil2.addItem("Lourdes");
               jComboperfil2.addItem("Major Prates");
               jComboperfil2.addItem("Mangues");
               jComboperfil2.addItem("Maracanã");
               jComboperfil2.addItem("Maracanã 2");
               jComboperfil2.addItem("Maria Cândida");
               jComboperfil2.addItem("Melo");
               jComboperfil2.addItem("Monte Alegre");
               jComboperfil2.addItem("Monte Carmelo");
               jComboperfil2.addItem("Montes Claros");
               jComboperfil2.addItem("Morada da Serra");
               jComboperfil2.addItem("Morada do Parque");
               jComboperfil2.addItem("Morada do Sol");
               jComboperfil2.addItem("Morada Parque");
               jComboperfil2.addItem("Morada Serra");
               jComboperfil2.addItem("Morada Sol");
               jComboperfil2.addItem("Morada Suboficial Sol");
               jComboperfil2.addItem("Morrinhos");
               jComboperfil2.addItem("Nossa Senhora Aparecida");
               jComboperfil2.addItem("Nossa Senhora das Graças");
               jComboperfil2.addItem("Nossa Senhora de Fátima");
               jComboperfil2.addItem("Nossa Senhora Graças");
               jComboperfil2.addItem("Nova Morada");
               jComboperfil2.addItem("Novo Delfino");
               jComboperfil2.addItem("Panorama II");
               jComboperfil2.addItem("Parque Ecologista Pampulha");
               jComboperfil2.addItem("Parque Morada Sol");
               jComboperfil2.addItem("Planalto");
               jComboperfil2.addItem("Planalto II");
               jComboperfil2.addItem("Povoação Pau Dom Óleo");
               jComboperfil2.addItem("Prolg Todos Os Santos");
               jComboperfil2.addItem("Recanto Araçás");
               jComboperfil2.addItem("Regina Peres");
               jComboperfil2.addItem("Renascença");
               jComboperfil2.addItem("Residencial Sul Ipês");
               jComboperfil2.addItem("Roxo Verde");
               jComboperfil2.addItem("Sagrada Família");
               jComboperfil2.addItem("Santa Cecília");
               jComboperfil2.addItem("Santa Eugênia");
               jComboperfil2.addItem("Santa Laura");
               jComboperfil2.addItem("Santa Lúcia");
               jComboperfil2.addItem("Santa Lúcia II");
               jComboperfil2.addItem("Santa Maria");
               jComboperfil2.addItem("Santa Rafaela");
               jComboperfil2.addItem("Santa Rita");
               jComboperfil2.addItem("Santa Rita I");
               jComboperfil2.addItem("Santa Rita II");
               jComboperfil2.addItem("Santo Amaro");
               jComboperfil2.addItem("Santo Antônio");
               jComboperfil2.addItem("Santo Antônio II");
               jComboperfil2.addItem("Santo Expedito");
               jComboperfil2.addItem("Santo Inácio");
               jComboperfil2.addItem("Santos Reis");
               jComboperfil2.addItem("São Bento");
               jComboperfil2.addItem("São Francisco Assis");
               jComboperfil2.addItem("São Geraldo");
               jComboperfil2.addItem("São João");
               jComboperfil2.addItem("São José");
               jComboperfil2.addItem("São Judas Tadeu");
               jComboperfil2.addItem("São Judas Tadeu I");
               jComboperfil2.addItem("São Mateus");
               jComboperfil2.addItem("Sion");
               jComboperfil2.addItem("Sion II");
               jComboperfil2.addItem("Sumaré");
               jComboperfil2.addItem("Tancredo Neves");
               jComboperfil2.addItem("Tancredo Neves I");
               jComboperfil2.addItem("Todos Os Santos");
               jComboperfil2.addItem("Todos Santos");
               jComboperfil2.addItem("Universitário");
               jComboperfil2.addItem("Vargem Grande II");
               jComboperfil2.addItem("Vera Cruz");
               jComboperfil2.addItem("Vila Anália");
               jComboperfil2.addItem("Vila Antônio Canela");
               jComboperfil2.addItem("Vila Antônio Narciso");
               jComboperfil2.addItem("Vila Atlântica");
               jComboperfil2.addItem("Vila Atlântica II");
               jComboperfil2.addItem("Vila Atlântida");
               jComboperfil2.addItem("Vila Áurea");
               jComboperfil2.addItem("Vila Brasília");
               jComboperfil2.addItem("Vila Campos");
               jComboperfil2.addItem("Vila Castelo Branco");
               jComboperfil2.addItem("Vila Exposição");
               jComboperfil2.addItem("Vila Greice");
               jComboperfil2.addItem("Vila Guilhermina");
               jComboperfil2.addItem("Vila Ipiranga");
               jComboperfil2.addItem("Vila Luíza");
               jComboperfil2.addItem("Vila Maria Cândida");  
               jComboperfil2.addItem("Vila Mauriceia");
               jComboperfil2.addItem("Vila Nova Morada");
               jComboperfil2.addItem("Vila Oliveira");
               jComboperfil2.addItem("Vila Regina");
               jComboperfil2.addItem("Vila Santa Cruz");
               jComboperfil2.addItem("Vila Santa Maria");
               jComboperfil2.addItem("Vila São Fco Assis");
               jComboperfil2.addItem("Vila São Francisco Assis");
               jComboperfil2.addItem("Vila Setor Bomfim");
               jComboperfil2.addItem("Vila Sion");
               jComboperfil2.addItem("Vila Sion II");
               jComboperfil2.addItem("Vila Sumaré");
               jComboperfil2.addItem("Vila Telma");
               jComboperfil2.addItem("Vila Tiradentes");
               jComboperfil2.addItem("Vila Toncheff");
               jComboperfil2.addItem("Vila Tupã");
               jComboperfil2.addItem("Vilage Lago");
               jComboperfil2.addItem("Vilage Lago II");
               jComboperfil2.addItem("Vilage Lago Popular");
               jComboperfil2.addItem("Village do Lago I");  
               jComboperfil2.addItem("Village do Lago Ii");
               jComboperfil2.addItem("Village Lago I");
           }
    } catch (Exception e) {
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

        jLabel14 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtnome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        codigo = new javax.swing.JLabel();
        txtcodigo = new javax.swing.JTextField();
        txtend = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtnumero = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jComboperfil2 = new javax.swing.JComboBox<>();
        txttelefone = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelafun = new javax.swing.JTable();
        voltar = new javax.swing.JButton();
        Atualizar = new javax.swing.JButton();
        limpar = new javax.swing.JButton();
        editar = new javax.swing.JButton();
        deletar = new javax.swing.JButton();
        cadastrar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setForeground(java.awt.Color.white);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Cadastro De Cliente");
        setAutoscrolls(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setInheritsPopupMenu(true);
        setRequestFocusEnabled(false);
        setVisible(true);

        jLabel14.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Nome:");

        txtnome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnomeActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Telefone:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Endereço:");

        codigo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        codigo.setText("Código:");

        txtcodigo.setEditable(false);
        txtcodigo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtcodigoMouseClicked(evt);
            }
        });
        txtcodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodigoActionPerformed(evt);
            }
        });

        txtend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtendActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Número:");

        txtnumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnumeroActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Bairro:");

        jComboperfil2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar Bairro" }));
        jComboperfil2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboperfil2ActionPerformed(evt);
            }
        });

        try {
            txttelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)9####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtnumero, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(codigo)
                        .addGap(18, 18, 18)
                        .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtnome, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txttelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtend, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboperfil2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtnome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jComboperfil2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtnumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codigo)
                    .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

        voltar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        voltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/back.png"))); // NOI18N
        voltar.setText("Voltar");
        voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarActionPerformed(evt);
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

        limpar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        limpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/wiping-swipe-for-floors.png"))); // NOI18N
        limpar.setText("Limpar");
        limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparActionPerformed(evt);
            }
        });

        editar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/pencil.png"))); // NOI18N
        editar.setText("Editar");
        editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarActionPerformed(evt);
            }
        });

        deletar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        deletar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/cancel.png"))); // NOI18N
        deletar.setText("Deletar");
        deletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletarActionPerformed(evt);
            }
        });

        cadastrar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/user24.png"))); // NOI18N
        cadastrar.setText("Cadastrar");
        cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(244, 244, 244))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cadastrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deletar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(editar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(limpar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Atualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Atualizar)
                        .addComponent(voltar)
                        .addComponent(limpar)
                        .addComponent(editar)
                        .addComponent(deletar))
                    .addComponent(cadastrar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtnomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnomeActionPerformed

    private void txtcodigoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtcodigoMouseClicked

    }//GEN-LAST:event_txtcodigoMouseClicked

    private void txtcodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodigoActionPerformed

    }//GEN-LAST:event_txtcodigoActionPerformed

    private void txtendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtendActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtendActionPerformed

    private void txtnumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnumeroActionPerformed

    private void jComboperfil2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboperfil2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboperfil2ActionPerformed

    private void tabelafunMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelafunMouseClicked
        txtcodigo.setText(tabelafun.getValueAt(tabelafun.getSelectedRow(),0).toString());
        txtnome.setText( tabelafun.getValueAt(tabelafun.getSelectedRow(),1).toString());
        jComboperfil2.setSelectedItem(tabelafun.getValueAt(tabelafun.getSelectedRow(),2).toString());
        txtend.setText(tabelafun.getValueAt(tabelafun.getSelectedRow(),3).toString());
        txtnumero.setText(tabelafun.getValueAt(tabelafun.getSelectedRow(),4).toString());
        txttelefone.setText(tabelafun.getValueAt(tabelafun.getSelectedRow(),5).toString());
    }//GEN-LAST:event_tabelafunMouseClicked

    private void voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_voltarActionPerformed

    private void AtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtualizarActionPerformed
        PreencherTabela("select * from cliente order by idcliente");
    }//GEN-LAST:event_AtualizarActionPerformed

    private void limparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparActionPerformed
        txtcodigo.setText("");
        txtnome.setText("");
        txtend.setText("");
        txtnumero.setText("");
        txttelefone.setText("");
    }//GEN-LAST:event_limparActionPerformed

    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed

        try {
            BEANcliente obj = new BEANcliente();
            obj.setIdcliente(Integer.valueOf(txtcodigo.getText()));
            obj.setNome(txtnome.getText());
            obj.setBairro((String)jComboperfil2.getSelectedItem());
            obj.setEndereco(txtend.getText());
            obj.setNumero(Integer.valueOf( txtnumero.getText()));
            obj.setTelefone(txttelefone.getText());

            DAOcliente dao = new DAOcliente();
            dao.alterarcliente(obj);
            JOptionPane.showMessageDialog(null, "Cadastro Alterado com sucesso!");
            PreencherTabela("SELECT * from cliente order by idcliente");
            //PreencherTabela("select * from cliente order by idcliente");
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "ERRO AO CADASTRAR:"+ erro);

        }
    }//GEN-LAST:event_editarActionPerformed

    private void deletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletarActionPerformed
        try {
            BEANcliente obj = new BEANcliente();
            obj.setIdcliente(Integer.parseInt(txtcodigo.getText()));
            DAOcliente dao = new DAOcliente();
            dao.deletaruser(obj);
            JOptionPane.showMessageDialog(null, "Cadastro Deletado com sucesso!");
            PreencherTabela("SELECT * from cliente order by idcliente");
            //PreencherTabela("select * from cliente order by idcliente");
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "ERRO AO CADASTRAR:"+ erro);

        }
    }//GEN-LAST:event_deletarActionPerformed

    private void cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarActionPerformed

        try {
            BEANcliente obj = new BEANcliente();
            //obj.setIdcliente(Integer.valueOf(txtcodigo.getText()));
            obj.setNome(txtnome.getText());
            obj.setBairro((String)jComboperfil2.getSelectedItem());
            obj.setEndereco(txtend.getText());
            obj.setNumero(Integer.valueOf(txtnumero.getText()));
            obj.setTelefone(txttelefone.getText());

            DAOcliente dao = new DAOcliente();
            dao.cadastrcliente(obj);
            JOptionPane.showMessageDialog(null, "Cadastro Realizado com sucesso!");
            PreencherTabela("SELECT * from cliente order by idcliente");
            //PreencherTabela("select * from cliente order by idcliente");
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "ERRO AO CADASTRAR:"+ erro);

        }
    }//GEN-LAST:event_cadastrarActionPerformed
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



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Atualizar;
    private javax.swing.JButton cadastrar;
    private javax.swing.JLabel codigo;
    private javax.swing.JButton deletar;
    private javax.swing.JButton editar;
    private javax.swing.JComboBox<String> jComboperfil2;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton limpar;
    private javax.swing.JTable tabelafun;
    private javax.swing.JTextField txtcodigo;
    private javax.swing.JTextField txtend;
    private javax.swing.JTextField txtnome;
    private javax.swing.JTextField txtnumero;
    private javax.swing.JFormattedTextField txttelefone;
    private javax.swing.JButton voltar;
    // End of variables declaration//GEN-END:variables
}
