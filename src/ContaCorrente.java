public class ContaCorrente extends Conta {

    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimirSaldo() {
        System.out.println("\n### SALDO DA CONTA CORRENTE ###");
        super.imprimirDados();
    }

    @Override
    public void imprimirResumo() {
        System.out.println(String.format("Agencia: %d | Conta Corrente nº: %d | Titular: %s", getAgencia(), getNumero(), getCliente().getNome()));
    }
}
