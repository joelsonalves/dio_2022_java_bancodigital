public class ContaPoupanca extends Conta {

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimirSaldo() {
        System.out.println("\n### SALDO DA CONTA POUPANÇA ###");
        super.imprimirDados();
    }

    @Override
    public void imprimirResumo() {
        System.out.println(String.format("Agencia: %d | Conta Poupança nº: %d | Titular: %s", getAgencia(), getNumero(), getCliente().getNome()));
    }

}
