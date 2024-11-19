package view;

import data.Tarefas;
import data.LoginDao;
import java.awt.Color;

import java.sql.SQLException;
import java.util.*;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AdicionarTarefas extends javax.swing.JFrame {
    
    private final String [] tableColumns = {"Título"};
    DefaultTableModel tableModel = new DefaultTableModel(tableColumns, 0);    
    private List<Tarefas> tarefasList = new ArrayList<>();

    public AdicionarTarefas() {
        initComponents();
    }

   @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnAdicionar = new javax.swing.JButton();
        txtTituloTarefa = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescricao = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTarefas = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        btnSair = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        btnTarefas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(76, 126, 173));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel1.setForeground(new java.awt.Color(76, 126, 173));

        jLabel1.setFont(new java.awt.Font("Poppins ExtraBold", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Adicione Tarefas");

        jLabel2.setFont(new java.awt.Font("Poppins", 0, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Descrição");

        jLabel3.setFont(new java.awt.Font("Poppins", 0, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Título");

        btnAdicionar.setBackground(new java.awt.Color(0, 237, 182));
        btnAdicionar.setFont(new java.awt.Font("Poppins Medium", 0, 24)); // NOI18N
        btnAdicionar.setForeground(new java.awt.Color(0, 0, 0));
        btnAdicionar.setText("Adicionar");
        btnAdicionar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        txtTituloTarefa.setBackground(new java.awt.Color(255, 255, 255));
        txtTituloTarefa.setForeground(new java.awt.Color(0, 0, 0));
        txtTituloTarefa.setToolTipText("Insira o nome da tarefa");
        txtTituloTarefa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        txtDescricao.setBackground(new java.awt.Color(255, 255, 255));
        txtDescricao.setColumns(20);
        txtDescricao.setForeground(new java.awt.Color(0, 0, 0));
        txtDescricao.setRows(5);
        txtDescricao.setToolTipText("Descreva a tarefa");
        txtDescricao.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jScrollPane1.setViewportView(txtDescricao);

        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jScrollPane2.setForeground(new java.awt.Color(0, 0, 0));
        jScrollPane2.setFont(new java.awt.Font("Poppins Medium", 0, 18)); // NOI18N

        tblTarefas.setBackground(new java.awt.Color(255, 255, 255));
        tblTarefas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        tblTarefas.setFont(new java.awt.Font("Poppins SemiBold", 0, 18)); // NOI18N
        tblTarefas.setForeground(new java.awt.Color(0, 0, 0));
        tblTarefas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Título"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTarefas.setToolTipText("Tarefas sendo realizadas");
        tblTarefas.setGridColor(new java.awt.Color(0, 0, 0));
        tblTarefas.setSelectionBackground(new java.awt.Color(255, 255, 255));
        tblTarefas.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tblTarefas.setShowGrid(false);
        tblTarefas.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblTarefas);

        jLabel4.setFont(new java.awt.Font("Poppins ExtraBold", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Tarefas para fazer");

        btnSair.setBackground(new java.awt.Color(204, 204, 204));
        btnSair.setFont(new java.awt.Font("Poppins Medium", 0, 24)); // NOI18N
        btnSair.setForeground(new java.awt.Color(0, 0, 0));
        btnSair.setText("Sair");
        btnSair.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        btnExcluir.setBackground(new java.awt.Color(227, 76, 76));
        btnExcluir.setFont(new java.awt.Font("Poppins Medium", 0, 24)); // NOI18N
        btnExcluir.setForeground(new java.awt.Color(0, 0, 0));
        btnExcluir.setText("Excluir");
        btnExcluir.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnAtualizar.setBackground(new java.awt.Color(239, 151, 89));
        btnAtualizar.setFont(new java.awt.Font("Poppins Medium", 0, 24)); // NOI18N
        btnAtualizar.setForeground(new java.awt.Color(0, 0, 0));
        btnAtualizar.setText("Atualizar");
        btnAtualizar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        btnTarefas.setBackground(new java.awt.Color(14, 45, 86));
        btnTarefas.setFont(new java.awt.Font("Poppins Medium", 0, 24)); // NOI18N
        btnTarefas.setForeground(new java.awt.Color(255, 255, 255));
        btnTarefas.setText("Tarefas");
        btnTarefas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnTarefas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTarefasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(129, 129, 129)
                            .addComponent(jLabel3))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtTituloTarefa, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnTarefas, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jScrollPane1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(jLabel2)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(69, 69, 69)
                                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(jLabel4)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTituloTarefa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTarefas, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void carregarCores(){
        for (int i = 0; i < tblTarefas.getRowCount(); i++) {
            String status = tblTarefas.getValueAt(i, 2).toString();
            if (status.equals("fazendo")){
                tblTarefas.setSelectionBackground(Color.YELLOW);
            } else if (status.equals("feito")){
                tblTarefas.setSelectionBackground(Color.GREEN);
            } else {
                tblTarefas.setSelectionBackground(Color.WHITE);
            }
        }
    }
    
    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
            
            Tarefas tarefa = new Tarefas();
            LoginDao dao;
            boolean status;
            int resposta;
            
            tarefa.setTitulo(txtTituloTarefa.getText());
            tarefa.setDescricao(txtDescricao.getText());
            
            dao = new LoginDao();
            status = dao.conectar();
            if(status == false){
                JOptionPane.showMessageDialog(null, "Erro de conexão. Não é possível adicionar a tarefa.");
            } else {
                resposta = dao.adicionar(tarefa);
                if(resposta == 1){
                    JOptionPane.showMessageDialog(null, "Dados incluidos com suscesso");
                    
                    emptyFields();
                    getTarefas();
        
                    if (!emptyFields()){
                    adicionarTarefa(getTarefas());
                    
                    txtTituloTarefa.setText("");
                    txtDescricao.setText("");
                    
                    txtTituloTarefa.requestFocus();
                } else if (resposta == 1062){
                    JOptionPane.showMessageDialog(null, "Esta tarefa já foi cadastrada");
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao tentar cadastrar tararefas");
                }
                atualizarTabela();
                dao.desconectar();
            }
}
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        LoginDao dao = new LoginDao();
        System.exit(0);
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
            
            LoginDao dao = new LoginDao();
            boolean status = dao.conectar();
            int selectedRow = tblTarefas.getSelectedRow();
    if (selectedRow != -1) {
        String titulo = tblTarefas.getValueAt(selectedRow, 0).toString();
        if (dao.limpar(titulo)) {
            ((DefaultTableModel) tblTarefas.getModel()).removeRow(selectedRow);
            JOptionPane.showMessageDialog(null, "Tarefa excluída com sucesso!");
            txtTituloTarefa.setText("");
            txtDescricao.setText("");
            txtTituloTarefa.requestFocus();
            
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao excluir a tarefa do banco de dados.");
        }
    } else {
        JOptionPane.showMessageDialog(null, "Selecione uma tarefa para excluir.");
    }
                    //getPosicaoTarefa();
                    //excluirTarefa(getPosicaoTarefa());
                    //atualizarTabela();
                    dao.desconectar();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
       
                Tarefas tarefa = new Tarefas();
                LoginDao dao;
                boolean status;
                int resposta;
                
                tarefa.setTitulo(txtTituloTarefa.getText());
                tarefa.setDescricao(txtDescricao.getText());
                dao = new LoginDao();
                status = dao.conectar();
                if (status == false){
                    JOptionPane.showMessageDialog(null, "Erro de conexão. Não é possível atualizar a tabela.");
                } else {
                    resposta = dao.atualizar(tarefa);
                    System.out.println(tarefa.getTitulo());
                    if (resposta == 1){
                        JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso");
                        
                        txtTituloTarefa.setText("");
                        txtDescricao.setText("");
                        
                        txtTituloTarefa.requestFocus();
                    } else if (resposta == 1060) {
                        JOptionPane.showMessageDialog(null, "Tarefa já foi cadastrado");
                    }
                    //atualizarTabela();
                    carregarTarefas();
                    dao.desconectar();
                }
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnTarefasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTarefasActionPerformed
       FazerTarefas fazerTarefas = new FazerTarefas();
        fazerTarefas.setVisible(true);
        //dispose();
    }//GEN-LAST:event_btnTarefasActionPerformed

   private boolean emptyFields(){
    
    boolean empty = false;
    
    if(txtTituloTarefa.getText().trim().isEmpty()){
        JOptionPane.showMessageDialog(null, "ATENÇÃO! Título da tarefa não pode ser vazio.");
        empty = true;
    }
    else if (txtDescricao.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "ATENÇÃO! É recomendado que as tarefas possuam descrição.");
            empty = true;
    }
      return empty;
    }
    
   private Tarefas getTarefas(){
    
        Tarefas tarefa = new Tarefas();
        
        tarefa.setTitulo(txtTituloTarefa.getText().toUpperCase());
        tarefa.setDescricao(txtDescricao.getText().toLowerCase());
        
        return tarefa;
    }
    
    private void adicionarTarefa(Tarefas tarefa){
    
    tarefasList.add(tarefa);
    atualizarTabela();
    }
    
    private void atualizarTabela(){
    
    if(!tarefasList.isEmpty()){
        
        Tarefas tarefa;
        
        tableModel = new DefaultTableModel(tableColumns, 0);
        
        for(int i = 0; i < tarefasList.size(); i++){
        tarefa = tarefasList.get(i);
        
        String[] rowData = {tarefa.getTitulo(), tarefa.getDescricao()};
        
        tableModel.addRow(rowData);
        }
        
        tblTarefas.setModel(tableModel);
    } else {
        
        tableModel = new DefaultTableModel (tableColumns, 0);
        tblTarefas.setModel(tableModel);
    }
  
}
    
    private int getPosicaoTarefa(){
    
    int posTarefa = tblTarefas.getSelectedRow();
    
    if(posTarefa == -1){
        JOptionPane.showMessageDialog(null, "Selecione uma tarefa.");
    }
    return posTarefa;
    }
    
    private void excluirTarefa(int posTarefa){
    
    if(posTarefa >= 0){
        String[] options = {"Sim", "Não"};
        
        int deletar = JOptionPane.showOptionDialog(rootPane, "Tem certeza que deseja excluir?", "Exclusão da tarefa.", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
    
    if(deletar == 0){
        tarefasList.remove(posTarefa);
        
        atualizarTabela();
    } else{
        tblTarefas.clearSelection();
            }
        }
    }
     
    private void carregarTarefas() {
     try {
        List<Tarefas> tarefas = new LoginDao().listarTarefas();
        DefaultTableModel model = (DefaultTableModel) tblTarefas.getModel();
        model.setRowCount(0);

        for (Tarefas tarefa : tarefas) {
            Object[] row = new Object[]{tarefa.getTitulo(), tarefa.getDescricao()};
            model.addRow(row);
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Erro ao carregar tarefas: " + ex.getMessage());
    }
}
    
    
    
    public static void main(String args[]) {
       

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdicionarTarefas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnTarefas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblTarefas;
    private javax.swing.JTextArea txtDescricao;
    private javax.swing.JTextField txtTituloTarefa;
    // End of variables declaration//GEN-END:variables
}