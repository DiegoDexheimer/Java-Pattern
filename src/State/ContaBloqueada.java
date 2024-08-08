package State;

public class ContaBloqueada implements StatusConta {
    
    public ContaBloqueada() {
        System.out.println("Conta bloqueada.");
    }

    @Override
    public void depositar(double valor) {
        System.out.println("Conta bloqueada. Nao é possível realizar depósito.");
    }

    @Override
    public void sacar(double valor) {
        System.out.println("Conta bloqueada. Nao é possível realizar saque.");
    }

    @Override
    public void bloquear() {
        System.out.println("Conta já está bloqueada.");
    }
}