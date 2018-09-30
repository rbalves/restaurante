package execucao;

import modelo.*;

public class Execucao {
    public static void main(String[] args){
        
        Restaurante restaurante = new Restaurante();
        
        Prato[] vetorCadastraPrato = 
        {
            new Prato("PIZZA",15.00),
            new Prato("SORVETE",3.00),
            new Prato("HAMBURGUER",5.00),
            new Prato("REFRIGERANTE",5.00),
            new Prato("SOPA",4.00),
            new Prato("VITAMINA",3.00),
            new Prato("SUCO",2.00)
        };
        
        for(int i=0;i<vetorCadastraPrato.length;i++){
            restaurante.cadastraPrato(vetorCadastraPrato[i]);
        }

        int opcao;
        
        do{
            opcao = restaurante.menu();
            switch(opcao){
                case 1:
                    restaurante.novoPedido();
                    break;
                case 2:
                    restaurante.mostrarPedido();
                    break;
                default:
                    break;
            }
        }while(opcao!= 3);        
    }
}
