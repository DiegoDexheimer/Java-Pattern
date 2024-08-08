package State;

public class Conta {
    private StatusConta statusConta;

    public Conta(double saldo){
        if (saldo >= 0) {
            statusConta = new ContaPositiva(saldo);
        }else{
            statusConta = new ContaNegativa(saldo);
        }
    }

    public void setEstado(StatusConta status){
        this.statusConta = status;
    }

    public StatusConta getEstado(){
        return statusConta;
    }

    public void depositar(double valor){
        if(((ContaNegativa) statusConta).getSaldo() + valor >= 0){
            setEstado(new ContaPositiva(valor + ((ContaNegativa) statusConta).getSaldo()));
        }
        else{
            statusConta.depositar(valor);
        }
    }
    //public void sacar(double valor){
    //    statusConta.sacar(valor);
        
    //}
    public void sacar(double valor){
        if(valor > ((ContaPositiva) statusConta).getSaldo()) {
            System.out.println("Insufficient balance for withdrawal");
            setEstado(new ContaNegativa(((ContaPositiva) statusConta).getSaldo() - valor));
        } else {
            statusConta.sacar(valor);
        }
    }
    public void bloquear(){
        statusConta.bloquear();
        setEstado(new ContaBloqueada());
    }

    public StatusConta getStatusConta() {
        return statusConta;
    }
}