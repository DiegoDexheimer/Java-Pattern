import java.util.ArrayList;
import java.util.List;

interface Bar {
    void atualizar(String mensagem);
}

class Foo {
    private List<Bar> algumaCoisa = new ArrayList<>();

    public void adicionar(Bar algo3) {
        algumaCoisa.add(algo3);
    }

    public void remover(Bar algo2) {
        algumaCoisa.remove(algo2);
    }

    public void notificar(String mensagem) {
        for (Bar algumaOutraCoisa : algumaCoisa) {
            algumaOutraCoisa.atualizar(mensagem);
        }
    }

    public void mudarAlgo(String novoEstado) {
        System.out.println("Algo rolou" + novoEstado);
        notificar(novoEstado);
    }
}

class AlgoConcreto implements Bar {
    private String nome;

    public AlgoConcreto(String nome) {
        this.nome = nome;
    }

    @Override
    public void atualizar(String mensagem) {
        System.out.println(nome + " recebeu a atualização: " + mensagem);
    }
}

public class Padrao03 {
    public static void main(String[] args) {
        Foo foo = new Foo();
        Bar aaaaaa = new AlgoConcreto("aaaaaaaaa");
        Bar bbbbbbbbb = new AlgoConcreto("bbbbbbbbbbb");

        foo.adicionar(aaaaaa);
        foo.adicionar(bbbbbbbbb);

        foo.notificar("Estado Inicial");

        foo.mudarAlgo("Novo Estado 1");
        foo.mudarAlgo("Novo Estado 2");
    }
}
