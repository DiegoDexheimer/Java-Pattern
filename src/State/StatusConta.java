package State;

public interface StatusConta {
    void depositar(double valor);
    void sacar(double valor);
    void bloquear();
}
