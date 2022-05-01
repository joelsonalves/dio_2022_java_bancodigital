import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Banco implements IBanco{

    private String nome;
    private List<Conta> contas = new ArrayList();

    public String getNome() {
        return nome;
    }

    public Banco(String nome) {
        this.nome = nome;
    }

    @Override
    public Conta criarConta(int tipo, Cliente cliente) {
        Conta conta = (tipo == Conta.CORRENTE) ? new ContaCorrente(cliente) : new ContaPoupanca(cliente);
        contas.add(conta);
        return conta;
    }

    @Override
    public void listarClientes() {
        System.out.println(String.format("\n### %s - LISTA DE CLIENTES ###", nome.toUpperCase()));
        for (Conta conta: contas) {
            conta.imprimirResumo();
        }
    }

}
