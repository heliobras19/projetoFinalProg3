
package Models;

import java.util.ArrayList;
import java.util.UUID;
import projetofinalprog.Main;

public class Caixa {
    private String idCaixa;
    private int clientesEmFila;
    private int clientesAtendidosDesdeAbertura;
    private int tempoTotalDeAtendimentos;
    private float tempoMedioDeAtendimento;
    private int tempoDeAtendimentoClienteTopo;
    private ArrayList<Cliente> clientesNaFila = new ArrayList<>();

    public Caixa (){
         UUID geradorDeID = UUID.randomUUID();
        this.idCaixa = geradorDeID.toString();
        this.clientesEmFila = 0;
        this.clientesAtendidosDesdeAbertura = 0;
        this.tempoMedioDeAtendimento = 0;
        this.tempoDeAtendimentoClienteTopo = 0;
    }
    public ArrayList<Cliente> getClientesNaFila() {
        return clientesNaFila;
    }
    
    public int qtdClientesNaFila (){
        return this.clientesEmFila;
    }

    public int getTempoTotalDeAtendimentos() {
        return tempoTotalDeAtendimentos;
    }

    public void setTempoDeAtendimentoClienteTopo(int tempoDeAtendimentoClienteTopo) {
        this.tempoDeAtendimentoClienteTopo = tempoDeAtendimentoClienteTopo;
    }

    public float getTempoMedioDeAtendimento() {
        return tempoMedioDeAtendimento;
    }

    public int getTempoDeAtendimentoClienteTopo() {
        return tempoDeAtendimentoClienteTopo;
    }

    public int getClientesAtendidosDesdeAbertura() {
        return clientesAtendidosDesdeAbertura;
    }
    
    
    public void addCliente (Cliente cliente){
        if(clientesNaFila.isEmpty()){
            this.tempoDeAtendimentoClienteTopo =
                cliente.getQtdProdutos() * Main.tempoDeAtemdimento;
        }
       clientesNaFila.add(cliente);
       this.clientesEmFila += 1;
    }
    
    public void AtenderCliente(int tempoAtendimento){
        if (!clientesNaFila.isEmpty()) {
            clientesNaFila.remove(0);
            this.clientesEmFila-= 1;
            this.clientesAtendidosDesdeAbertura += 1;
            this.tempoTotalDeAtendimentos += tempoAtendimento;
            this.tempoMedioDeAtendimento = 
                    this.tempoTotalDeAtendimentos / this.clientesAtendidosDesdeAbertura;
            if (clientesNaFila.isEmpty()) {
                this.tempoDeAtendimentoClienteTopo = 0;
            }else {
                this.tempoDeAtendimentoClienteTopo = 
                    clientesNaFila.get(0).getQtdProdutos() * Main.tempoDeAtemdimento;
            }
            
        }
    }
}