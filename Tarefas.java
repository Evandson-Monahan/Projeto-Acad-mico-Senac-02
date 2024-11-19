package data;

public class Tarefas {
    
    private String titulo;
    private String descricao;
    
    public Tarefas(){}
    
    public String getTitulo(){
        return titulo;
    }
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    
    public String getDescricao(){
        return descricao;
    }
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
}
