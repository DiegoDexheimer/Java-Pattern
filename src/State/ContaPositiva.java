package State;

public class ContaPositiva implements StatusConta{
    private double saldo;


    public ContaPositiva(double saldo){
        this.saldo = saldo;
        System.out.println("Saldo positivo: " + saldo);
    }

    
    @Override
    public void depositar(double valor) {
       saldo += valor;
       System.out.println("Depósito de " + valor + " realizado. Novo saldo: " + saldo);
    }

    
    @Override
    public void sacar(double valor) {
        saldo -= valor;
        if (saldo < 0) {
            System.out.println("Saldo Negativo. Novo saldo: " + saldo);
        } else {
            System.out.println("Saque de " + valor + " realizado. Novo saldo: " + saldo);
        }
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