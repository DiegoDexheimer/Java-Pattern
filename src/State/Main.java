package State;

public class Main {
    public static void main(String[] args) {
        Conta conta = new Conta(100);

        
        System.out.println(conta.getStatusConta().toString()); //output = Conta positiva
        conta.sacar(50); //output = Saque de 50.0 realizado. Novo saldo: 50.0
        conta.sacar(80); //output = Saldo Negativo. Novo saldo: -30.0
        conta.depositar(200); //output = Depósito de 200.0 realizado. Novo saldo: 170.0
        conta.bloquear(); //output = Conta bloqueada
        conta.depositar(100); //output = Conta bloqueada
        conta.sacar(50); //output = Conta bloqueada
        
    }
} 