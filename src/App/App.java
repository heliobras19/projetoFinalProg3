package App;

import Models.Caixa;
import Models.Cliente;
import java.util.ArrayList;
import java.util.Random;

public class App {
    public int gerarNumeroAleatorio (){
        Random rand = new Random();
        return rand.nextInt(119)+2;
    }
    
    public int caixaComMenosClientes(ArrayList<Caixa> listaCaixas){
        if (listaCaixas.isEmpty()) {
            return -2;
        }
        int menor = listaCaixas.get(0).getClientesNaFila().size();
        int i = 0;
        int menorIndice = -1;
        for(Caixa caixa: listaCaixas ){
            if(menor > caixa.getClientesNaFila().size()){
               menor = caixa.getClientesNaFila().size();
               menorIndice = i;
            }
            i++;
        }
        return menorIndice;
    }
    
    public int CaixaVazio (ArrayList<Caixa> caixas) {
        for (int i = 0; i < caixas.size(); i++) {
            if (caixas.get(i).getClientesNaFila().isEmpty()) {
                return i;
            }
        }
        return -1;
    }
    
    public void printCaixa (Caixa caixa, int numCaixa){
        System.out.println("\n \n Caixa "+ numCaixa);
        System.out.print("clientes na fila: "+ caixa.qtdClientesNaFila());
        if (caixa.getClientesNaFila().isEmpty()) {
            System.out.print(" <--------- ");
            System.out.println(" VAZIO ");
        }else{
            int i = 1;
        for(Cliente cliente : caixa.getClientesNaFila()){
             System.out.print(" <--------- ");
            System.out.print("Cliente "+ i+ 
                    " (produtos: " + cliente.getQtdProdutos()+ ")");
             i++;
        }
        System.out.print("\n");
        }
        System.out.println("Tempo restante para antender o cliente do topo: " 
                + caixa.getTempoDeAtendimentoClienteTopo() );
        System.out.println("Clientes atendidos :" + caixa.getClientesAtendidosDesdeAbertura());
        System.out.println("Tempo total de atendimento :"+ caixa.getTempoTotalDeAtendimentos());
        System.out.println("tempo medio de atendimento :"+ caixa.getTempoMedioDeAtendimento());
    }
    
    public void imprimirVetor (String [] v){
        System.out.println("\n");
        for (String op : v){
            System.out.println("|"+op+" | ");
        }
    }
    
    public void atenderCaixa(Caixa caixa, int tempo){
        int tempoAtendimento =  caixa.getTempoDeAtendimentoClienteTopo();
        if (tempoAtendimento == 0 || tempo <= 0 || caixa.getClientesNaFila().isEmpty()) {
            return;
        }
        if (tempo < tempoAtendimento) {
            caixa.setTempoDeAtendimentoClienteTopo(tempoAtendimento-tempo);
        }else if (tempo == tempoAtendimento){
            caixa.AtenderCliente(tempoAtendimento);
        }else if (tempo > tempoAtendimento){
            caixa.AtenderCliente(tempoAtendimento);
            int tempoAtualizado = tempo - tempoAtendimento;
            atenderCaixa(caixa, tempoAtualizado);
        }
    }
}
