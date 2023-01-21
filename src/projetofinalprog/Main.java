
package projetofinalprog;

import App.App;
import App.Constantes;
import Models.Caixa;
import Models.Cliente;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static int tempoDeAtemdimento;
    static int numeroDeCaixas;
    static  Constantes constantes = new Constantes();
    static ArrayList<Caixa> caixas = new ArrayList<>(); 
   static App app =  new App();
    public static void main(String[] args) {
      menuManual();
    }
    
     static void menuManual () {
        Scanner input = new Scanner (System.in);
        System.out.println(constantes.menuManualPP);
        tempoDeAtemdimento = input.nextInt();
        System.out.println(constantes.menuManualSP);
        numeroDeCaixas = input.nextInt();
         for (int i = 1; i <= numeroDeCaixas; i++) {
             Caixa caixa = new Caixa();
             caixas.add(caixa);
         }
        int sair = 0;
        for(;;){
            if(sair == 1)
                break;
            app.imprimirVetor(constantes.menu);
            int seletor = input.nextInt();
            switch (seletor) {
                case 1 : 
                   criarCliente ();
                   break;
                case 2 :
                    mostrarCaixas();
                    break;
                case 3:
                    adicionarCaixa ();
                    break;
                case 4: 
                    removerCaixasVazio();
                    break;
                case 5:
                    atender();
                    break;
                case 6:
                    sair = 1;
                    break;
            }
        }
    }
     
     static void criarCliente () {
         int qtdProdutos = app.gerarNumeroAleatorio();
         Cliente cliente = new Cliente(qtdProdutos);
         int i = app.caixaComMenosClientes(caixas);
         if (caixas.size() > 0) {
             if ( i  == -1){
                Caixa caixaComMenorFila = caixas.get(0);
                caixaComMenorFila.addCliente(cliente);
             }else {
                Caixa caixaComMenorFila = caixas.get(i);
                caixaComMenorFila.addCliente(cliente);
             }
         } 
     }
     
     static void removerCaixasVazio (){
         int caixaVazio = app.CaixaVazio(caixas);
         if (caixaVazio != -1) {
            caixas.remove(caixaVazio);
            removerCaixasVazio ();
        }
     }
     
     static void adicionarCaixa (){
         Caixa novaCaixa = new Caixa();
         caixas.add(novaCaixa);
     }
     
     static void mostrarCaixas(){ 
         int i = 1;
         for (Caixa caixa : caixas) {
             app.printCaixa(caixa, i);
             i++;
         }
     }
     
     static void atender (){
        Scanner in = new Scanner (System.in);
         System.out.println(constantes.pedirTempo);
         int tempoT = in.nextInt();
         for(Caixa caixa : caixas){
             app.atenderCaixa(caixa, tempoT);
        }
     }
}
