package data;

import data.Tarefas;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class LoginDao {
    
    Connection conn;
    PreparedStatement st;
    ResultSet rs;
    
    public boolean conectar(){
       
       try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gestorsimples", "admin", "04abr1994");
            //JOptionPane.showMessageDialog(null, "Conexão realizada com sucesso!");
            return true;
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "O Driver não está disponível na biblioteca");
            return false;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Sintaxe de comando invalida " + ex.getMessage());
            return false;
        }
    }
    
    public Connection getConnection() {
        return conn;
    }
    
    public int adicionar(Tarefas txt){
        int status;
        try{
            st = conn.prepareStatement("INSERT INTO tarefas (titulo, descricao) VALUES (?, ?)");
            st.setString(1, txt.getTitulo());
            st.setString(2, txt.getDescricao());
            status = st.executeUpdate();
            return status;
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Não foi possível adicionar a tarefa");
            return ex.getErrorCode();
        }
    }
    
    public int atualizar (Tarefas txt){
        int status;
        try{ 
            st = conn.prepareStatement("UPDATE tarefas SET titulo = ?, descricao = ? WHERE id = ?");
            st.setString(1, txt.getTitulo());
            st.setString(2, txt.getDescricao());
            status = st.executeUpdate();
            return status;
        } catch (SQLException ex){
           JOptionPane.showMessageDialog(null, "Não foi possível atualizar a tabela de tarefas" + ex.getErrorCode());
            return ex.getErrorCode();
        }
    }
    
    
    public List<Tarefas> listarTarefas() throws SQLException {
    List<Tarefas> tarefas = new ArrayList<>();
    Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gestorsimples", "admin", "04abr1994");
    String sql = "SELECT * FROM tarefas";
    PreparedStatement stmt = conn.prepareStatement(sql);
    ResultSet rs = stmt.executeQuery();

    while (rs.next()) {
        Tarefas tarefa = new Tarefas();
        tarefa.setTitulo(rs.getString("titulo"));
        tarefa.setDescricao(rs.getString("descricao"));
        tarefas.add(tarefa);
    }

    rs.close();
    stmt.close();
    conn.close();
    return tarefas;
}   
    
    public boolean limpar(String titulo){
        try {
            st = conn.prepareStatement("DELETE FROM tarefas WHERE titulo = ?");
            st.setString(1, titulo);
            st.executeUpdate();
            return true;
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir a tarefa: ");
            return false;
        }
    }
    
    public void desconectar(){
        try{
            conn.close();
        } catch (SQLException ex){
        
        }
    }
    
    public int atualizarStatus(String titulo, String status){
        int resultado;
        try{
            st = conn.prepareStatement("UPDATE tarefas SET status = ? WHERE titulo = ?");
            st.setString(1, status);
            st.setString(2, status);
            resultado = st.executeUpdate();
            return resultado;
        } catch (SQLException ex){
            //JOptionPane.showMessageDialog(null, "Não foi possível atualizar o status da tarefa");
            return ex.getErrorCode();
        }
    }
    
    public String obterDescricao(String titulo) {
    String descricao = null;
    try {
        st = conn.prepareStatement("SELECT descricao FROM tarefas WHERE titulo = ?");
        st.setString(1, titulo);
        rs = st.executeQuery();
        
        if (rs.next()) {
            descricao = rs.getString("descricao");
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Erro ao obter descrição da tarefa: " + ex.getMessage());
    }
    return descricao;
}
    
    public static void main(String[] args){}
}