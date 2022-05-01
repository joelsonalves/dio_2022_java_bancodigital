public abstract class Conta implements IConta {

    public static final int CORRENTE = 1;
    public static final int POUPANCA = 2;
    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    private int agencia;
    private int numero;
    private double saldo;
    private Cliente cliente;

    public Conta(Cliente cliente) {
        agencia = AGENCIA_PADRAO;
        numero = SEQUENCIAL++;
        saldo = 0.0;
        this.cliente = cliente;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    @Override
    public void sacar(double valor) {
        sacar(valor, true);
    }

    private void sacar(double valor, boolean imprimir) {

        if (imprimir) System.out.print(String.format("\n### SAQUE de R$  %.2f", valor));
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            if (imprimir) System.out.println(String.format(" realizado com sucesso ###"));
        } else {
            if (imprimir) System.out.println(String.format(" não realizado ###"));
        }

    }

    @Override
    public void depositar(double valor) {
        depositar(valor, true);
    }

    private void depositar(double valor, boolean imprimir) {

        if (imprimir) System.out.print(String.format("\n### DEPÓSITO de R$  %.2f", valor));
        if (valor > 0) {
            saldo += valor;
            if (imprimir) System.out.println(String.format(" realizado com sucesso ###"));
        } else {
            if (imprimir) System.out.println(String.format(" não realizado ###"));
        }

    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        transferir(valor, contaDestino, true);
    }

    private void transferir(double valor, Conta contaDestino, boolean imprimir) {

        if (imprimir) System.out.print(String.format("\n### TRANSFERÊNCIA de R$ %.2f", valor));
        if (valor > 0 && saldo >= valor) {
            sacar(valor, false);
            contaDestino.depositar(valor, false);
            if (imprimir) System.out.println(String.format(" realizada com sucesso ###"));
        } else {
            if (imprimir) System.out.println(String.format(" não realizada ###"));
        }

    }

    protected void imprimirDados() {
        System.out.println(String.format("Titular: %s", cliente.getNome()));
        System.out.println(String.format("Agência: %d", agencia));
        System.out.println(String.format("Número: %d", numero));
        System.out.println(String.format("Saldo: %.2f", saldo));

    }

}
