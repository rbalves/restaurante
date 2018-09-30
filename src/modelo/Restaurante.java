package modelo;

import java.util.ArrayList;
import java.util.Scanner;

public class Restaurante {
    
    ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
    
    ArrayList<Prato> pratosCadastrados = new ArrayList<Prato>();
     
    public void cadastraPrato(Prato prato){
        pratosCadastrados.add(prato);
    }
    
    ArrayList<Prato> pratosInclusos;
    
    public int menu(){
        Scanner entrada = new Scanner(System.in);
        int opcao;
        System.out.println("NOJENT'S RESTAURANTE");
        System.out.println("1. NOVO PEDIDO");
        System.out.println("2. VER PEDIDO");
        System.out.println("3. SAIR");
        System.out.print("OPÇÃO: ");
        opcao = entrada.nextInt();
        return opcao;
    }
    
    public void novoPedido(){
        pratosInclusos = new ArrayList<Prato>();
        Scanner entrada = new Scanner(System.in);
        int mesa;
        String pratoSolicitado, maisPrato;
        boolean achou= false;
        
        System.out.println("NOJENT'S RESTAURANTE");
        System.out.println("****NOVO  PEDIDO****");
        System.out.print("MESA:");
        mesa = entrada.nextInt();
        for(int i=0;i<pedidos.size();i++){
            if(mesa==pedidos.get(i).getMesa()){
                achou=true;
                break;
            }
        }
        entrada.nextLine();
        if(!achou){
            do{
                System.out.print("PRATO:");
                pratoSolicitado = entrada.nextLine();
                for(int i=0;i<pratosCadastrados.size();i++){
                    if(pratosCadastrados.get(i).getDescricao().equalsIgnoreCase(pratoSolicitado)){
                        pratosInclusos.add(pratosCadastrados.get(i));
                        achou = true;
                        break;
                    }
                }
                if(achou){
                    System.out.print("CADASTRAR MAIS UM PRATO?(S/N): ");
                    maisPrato = entrada.nextLine();
                    if(!maisPrato.contentEquals("S") && !maisPrato.contentEquals("s")){
                        pedidos.add(new Pedido(mesa,pratosInclusos));
                        System.out.println("PEDIDO CADASTRADO COM SUCESSO");
                    }
                }else{
                    System.out.println("PRATO NÃO ENCONTRADO");
                    System.out.print("CADASTRAR OUTRO PRATO?(S/N): ");
                    maisPrato = entrada.nextLine();
                } 
            }while(maisPrato.contentEquals("S") || maisPrato.contentEquals("s"));
        }else{
            System.out.println("PEDIDO JÁ FOI CADASTRADO");
        }        
    }
    
    public void mostrarPedido(){
        
        int opcao,mesa,aux=0;
        double valor; 
        boolean achou=false;
        String pratoSolicitado;
        
        Scanner entrada = new Scanner(System.in);
  
        System.out.println("NOJENT'S RESTAURANTE");
        System.out.println("*******PEDIDO*******");
        System.out.print("INFORME A MESA: ");
        mesa = entrada.nextInt();
        for(int i=0;i<pedidos.size();i++){
            if(mesa==pedidos.get(i).getMesa()){
                aux = i;
                achou=true;
                break;
            }
        }
        if(achou){
            System.out.println("PRATOS INCLUSOS");
            for(int i=0;i<pedidos.get(aux).getPratos().size();i++){
                System.out.println(pedidos.get(aux).getPratos().get(i).getDescricao()+" - "+pedidos.get(aux).getPratos().get(i).getPreco());
            
            }
            do{
                System.out.println();
                System.out.println("1. INCLUIR PRATO");
                System.out.println("2. REMOVER PRATO");
                System.out.println("3. EMITIR CONTA");
                System.out.println("4. FECHAR CONTA");
                System.out.println("5. SAIR");
                System.out.print("OPÇÃO: ");
                opcao = entrada.nextInt();
                switch(opcao){
                    case 1:
                        achou = false;
                        System.out.print("PRATO:");
                        entrada.nextLine();
                        pratoSolicitado = entrada.nextLine();
                        for(int i=0;i<pratosCadastrados.size();i++){
                            if(pratosCadastrados.get(i).getDescricao().equalsIgnoreCase(pratoSolicitado)){
                                pedidos.get(aux).incluirPrato(pratosCadastrados.get(i));
                                achou = true;
                                break;
                            }
                        }
                        if(achou){
                            System.out.println("PRATO INCLUIDO COM SUCESSO");
                        }else{
                            System.out.println("PRATO NÃO ENCONTRADO");
                        }
                        break;
                    case 2:
                        achou = false;
                        System.out.print("PRATO:");
                        entrada.nextLine();
                        pratoSolicitado = entrada.nextLine();
                        for(int i=0;i<pedidos.get(aux).getPratos().size();i++){
                            if(pedidos.get(aux).getPratos().get(i).getDescricao().equalsIgnoreCase(pratoSolicitado)){
                                Prato prato = pedidos.get(aux).getPratos().get(i);
                                pedidos.get(aux).removerPrato(prato);
                                achou = true;
                                break;
                            }
                        }
                        if(achou){
                            System.out.println("PRATO EXCLUIDO COM SUCESSO");
                        }else{
                            System.out.println("PRATO NÃO ENCONTRADO");
                        }
                        break;
                    case 3:     
                        valor = 0;
                        for(int i=0;i<pedidos.get(aux).getPratos().size();i++){
                            valor = valor + pedidos.get(aux).getPratos().get(i).getPreco();
                        }
                        System.out.print("VALOR DA CONTA: R$" + valor);
                        break;
                    case 4:
                        valor = 0;
                        for(int i=0;i<pedidos.get(aux).getPratos().size();i++){
                            valor = valor + pedidos.get(aux).getPratos().get(i).getPreco();
                        }
                        System.out.println("VALOR DA CONTA: R$" + valor);
                        pedidos.remove(aux);
                        System.out.println("PEDIDO FECHADO");
                        opcao=5;
                        break;
                    default:
                        break;
                }
            }while(opcao!= 5);
        }else{
            System.out.println("PEDIDO NÃO ENCONTRADO");
        }  
    }
}