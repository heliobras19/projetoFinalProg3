
package Models;
import java.util.UUID;
public class Cliente {
    private String idCliente;
    private int qtdProdutos;

    public Cliente( int qtdProdutos) {
        UUID geradorDeID = UUID.randomUUID();
        this.idCliente = geradorDeID.toString();
        this.qtdProdutos = qtdProdutos;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public int getQtdProdutos() {
        return qtdProdutos;
    }
    
    
}
