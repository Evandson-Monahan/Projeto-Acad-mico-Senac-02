package view;

import data.LoginDao;
import data.Tarefas;
import java.awt.Color;
import java.awt.Component;
import java.sql.SQLException;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.JTable;

public class FazerTarefas extends javax.swing.JFrame {
    
    private final String [] tableColumns = {"Título"};
    DefaultTableModel tableModel = new DefaultTableModel(tableColumns, 0);    
    private List<Tarefas> tarefasList = new ArrayList<>();

    private Map<Integer, String> linhaStatusMap = new HashMap<>();
    
    public FazerTarefas() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnFazendo = new javax.swing.JButton();
        btnFeito = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTarefas = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescricao = new javax.swing.JTextArea();
        btnAtualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(14, 45, 86));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel1.setForeground(new java.awt.Color(76, 126, 173));

        jLabel1.setFont(new java.awt.Font("Poppins ExtraBold", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tarefas");

        jLabel2.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("As tarefas em branco ainda não foram feitas");

        jLabel3.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Escolha a tarefa, leia a descrição");

        jLabel4.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("e sinalizie o status");

        btnFazendo.setBackground(new java.awt.Color(239, 255, 0));
        btnFazendo.setFont(new java.awt.Font("Poppins Medium", 0, 24)); // NOI18N
        btnFazendo.setForeground(new java.awt.Color(0, 0, 0));
        btnFazendo.setText("Fazendo");
        btnFazendo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnFazendo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFazendoActionPerformed(evt);
            }
        });

        btnFeito.setBackground(new java.awt.Color(91, 243, 53));
        btnFeito.setFont(new java.awt.Font("Poppins Medium", 0, 24)); // NOI18N
        btnFeito.setForeground(new java.awt.Color(0, 0, 0));
        btnFeito.setText("Feito");
        btnFeito.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnFeito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFeitoActionPerformed(evt);
            }
        });

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jScrollPane2.setForeground(new java.awt.Color(0, 0, 0));
        jScrollPane2.setFont(new java.awt.Font("Poppins Medium", 0, 18)); // NOI18N

        tblTarefas.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mouseClicked(java.awt.event.MouseEvent evt){
                int selectedRow = tblTarefas.getSelectedRow();
                if (selectedRow !=-1){
                    String titulo = tblTarefas.getValueAt(selectedRow, 0).toString();

                    LoginDao dao = new LoginDao();
                    if (dao.conectar()){
                        String descricao = dao.obterDescricao(titulo);
                        if (descricao != null){
                            txtDescricao.setText(descricao);
                        } else {
                            JOptionPane.showMessageDialog(null, "Descrição não encontrada");
                        }
                        dao.desconectar();
                    } else {
                        JOptionPane.showMessageDialog(null, "Erro de conexão ao tentar obter descrição");
                    }
                }
            }
        });
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
        tblTarefas.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                String status = linhaStatusMap.getOrDefault(row, "branco");
                switch (status) {
                    case "amarelo":
                    cellComponent.setBackground(Color.YELLOW);
                    break;
                    case "verde":
                    cellComponent.setBackground(Color.GREEN);
                    break;
                    default:
                    cellComponent.setBackground(Color.WHITE);
                    break;
                }
                return cellComponent;
            }
        });
        tblTarefas.setGridColor(new java.awt.Color(0, 0, 0));
        tblTarefas.setShowGrid(false);
        tblTarefas.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblTarefas);

        txtDescricao.setEditable(false);
        txtDescricao.setBackground(new java.awt.Color(255, 255, 255));
        txtDescricao.setColumns(20);
        txtDescricao.setForeground(new java.awt.Color(0, 0, 0));
        txtDescricao.setRows(5);
        txtDescricao.setToolTipText("Descrição da tarefa");
        txtDescricao.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txtDescricao.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txtDescricao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtDescricaoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(txtDescricao);

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(168, 168, 168)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(155, 155, 155)
                                .addComponent(jLabel4))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jLabel2)))
                        .addGap(0, 23, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnFazendo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(btnFeito, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2)
                            .addComponent(jScrollPane1))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFazendo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFeito, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
    
    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        LoginDao dao;
        
        Tarefas tarefa = new Tarefas();
        tarefa.setDescricao(txtDescricao.getText());
       
        atualizarTabela();
        carregarTarefas();
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void txtDescricaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDescricaoMouseClicked
        int selectedRow = tblTarefas.getSelectedRow();
        if (selectedRow != -1){
            String descricao = tblTarefas.getValueAt(selectedRow, 1).toString();
            txtDescricao.setText(descricao);
        }
    }//GEN-LAST:event_txtDescricaoMouseClicked

    private void btnFazendoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFazendoActionPerformed
        int selectedRow = tblTarefas.getSelectedRow();
        if (selectedRow >= -1){
        linhaStatusMap.put(selectedRow, "amarelo");
        tblTarefas.repaint();
    } else {
        JOptionPane.showMessageDialog(this, "Selecione uma tarefa para atualizar o status!");
    }
            tblTarefas.setSelectionBackground(Color.YELLOW);
            String titulo = tblTarefas.getValueAt(selectedRow, 0).toString();
            atualizarStatusTarefa(titulo, "fazendo");
        
    }//GEN-LAST:event_btnFazendoActionPerformed

    private void btnFeitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFeitoActionPerformed
        int selectedRow = tblTarefas.getSelectedRow();
        if (selectedRow >= -1){
        linhaStatusMap.put(selectedRow, "verde");
        tblTarefas.repaint();
    } else {
        JOptionPane.showMessageDialog(this, "Selecione uma tarefa para atualizar o status!");
    }
            tblTarefas.setSelectionBackground(Color.GREEN);
            String titulo = tblTarefas.getValueAt(selectedRow, 0).toString();
            atualizarStatusTarefa(titulo, "feito");

    }//GEN-LAST:event_btnFeitoActionPerformed

    
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
        
       java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FazerTarefas().setVisible(true);
            }
        });
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
    
    private void atualizarStatusTarefa(String titulo, String status){
        LoginDao dao = new LoginDao();
        dao.conectar();
        dao.atualizarStatus(titulo, status);
        dao.desconectar();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnFazendo;
    private javax.swing.JButton btnFeito;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblTarefas;
    private javax.swing.JTextArea txtDescricao;
    // End of variables declaration//GEN-END:variables
}