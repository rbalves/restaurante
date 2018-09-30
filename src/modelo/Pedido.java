package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import modelo.Prato;

public class Pedido {
    
    private int mesa;
    private ArrayList<Prato> pratos;
    
    public Pedido(int mesa, ArrayList<Prato> pratos){
        this.mesa = mesa;
        this.pratos = pratos;
    }
    
    public Pedido(){
        pratos = new ArrayList();
    }
    
    public void incluirPrato(Prato prato){
        this.pratos.add(prato);
    }
    
    public void removerPrato(Prato prato){
        this.pratos.remove(prato);
    }
    
    public int getMesa() {
        return mesa;
    }

    public void setMesa(int mesa) {
        this.mesa = mesa;
    }

    public ArrayList<Prato> getPratos() {
        return pratos;
    }

    public void setPratos(ArrayList<Prato> pratos) {
        this.pratos = pratos;
    }
}
