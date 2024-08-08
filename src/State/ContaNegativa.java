package State;

public class ContaNegativa implements StatusConta{
    private double saldo;

    public ContaNegativa(double saldo){
        this.saldo = saldo;
        System.out.println("Saldo negativo: " + saldo);
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
        if (saldo >= 0) {
            System.out.println("Depósito de " + valor + " realizado. Novo saldo: " + saldo);
        } else {
            System.out.println("Saldo Negativo. Novo saldo: " + saldo);
        }
    
    }

    @Override
    public void sacar(double valor) {
        System.out.println("Conta bloqueada devido a saldo negativo.");
    }

    @Override
    public void bloquear() {
        System.out.println("Conta bloqueada.");
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}