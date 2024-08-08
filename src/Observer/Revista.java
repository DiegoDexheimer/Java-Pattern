package Observer;

import java.util.ArrayList;
import java.util.List;

public class Revista {
    private String nome;
    private List<Observador> inscritos = new ArrayList<>();

    public Revista(String nome) {
        this.nome = nome;
    }
    public List<Observador> getInscritos() {
        return inscritos;
    }
    public void inscrever(Observador observador) {
        inscritos.add(observador);
    }
    public void cancelarInscricao(Observador observador) {
        inscritos.remove(observador);
    }
    public void notificarInscritos() {
        for (Observador observador : inscritos) {
            observador.atualizar(nome);
        }
    }
    
    
}