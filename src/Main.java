public class Main {

    public static void main(String[] args) {

        Cliente cliente1 = new Cliente("Nome Cliente 1");
        Cliente cliente2 = new Cliente("Nome Cliente 2");

        Banco banco = new Banco("Meu Banco");

        Conta corrente = banco.criarConta(Conta.CORRENTE, cliente1);
        Conta poupanca = banco.criarConta(Conta.POUPANCA, cliente2);

        banco.listarClientes();

        corrente.imprimirSaldo();
        corrente.depositar(100);
        corrente.imprimirSaldo();
        poupanca.imprimirSaldo();
        corrente.transferir(50, poupanca);
        corrente.imprimirSaldo();
        poupanca.imprimirSaldo();

    }

}
