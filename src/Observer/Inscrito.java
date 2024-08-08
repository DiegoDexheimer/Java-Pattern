package Observer;

public class Inscrito implements Observador{
    private String nome;


    public Inscrito(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public void atualizar(String revista) {
        System.out.println(nome + " recebeu a nova edicao da revista: "  + revista);
    }
}