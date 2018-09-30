package modelo;

public class Prato {
    
    private String descricao;
    private double preco;
    
    public Prato(String descricao, double preco){
        this.descricao = descricao;
        this.preco = preco;
    }
    
    public Prato(){
        
    }
        
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
