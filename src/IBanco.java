public interface IBanco {

    Conta criarConta(int tipo, Cliente cliente);
    void listarClientes();

}
