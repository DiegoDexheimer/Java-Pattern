import java.util.Stack;

class EditorTexto {
    private String texto;

    public void definirTexto(String texto) {
        this.texto = texto;
        System.out.println("Texto atual: " + texto);
    }

    public String obterTexto() {
        return texto;
    }

    public EstadoTexto salvarEstado() {
        return new EstadoTexto(texto);
    }

    public void restaurarEstado(EstadoTexto estadoTexto) {
        texto = estadoTexto.obterTextoSalvo();
        System.out.println("Texto restaurado para: " + texto);
    }
}

class EstadoTexto {
    private final String textoSalvo;

    public EstadoTexto(String texto) {
        this.textoSalvo = texto;
    }

    public String obterTextoSalvo() {
        return textoSalvo;
    }
}

class GerenciadorEstados {
    private final Stack<EstadoTexto> pilhaEstados = new Stack<>();

    public void adicionarEstado(EstadoTexto estadoTexto) {
        pilhaEstados.push(estadoTexto);
    }

    public EstadoTexto obterEstadoAnterior() {
        if (!pilhaEstados.isEmpty()) {
            return pilhaEstados.pop();
        }
        return null;
    }
}

public class Padrao01 {
    public static void main(String[] args) {
        EditorTexto editorTexto = new EditorTexto();
        GerenciadorEstados gerenciadorEstados = new GerenciadorEstados();

        editorTexto.definirTexto("Texto Versão 1");
        gerenciadorEstados.adicionarEstado(editorTexto.salvarEstado());

        editorTexto.definirTexto("Texto Versão 2");
        gerenciadorEstados.adicionarEstado(editorTexto.salvarEstado());

        editorTexto.definirTexto("Texto Versão 3");
        gerenciadorEstados.adicionarEstado(editorTexto.salvarEstado());

        editorTexto.definirTexto("Texto Versão 4");

        // Restaurando estados anteriores
        editorTexto.restaurarEstado(gerenciadorEstados.obterEstadoAnterior()); // Texto Versão 3
        editorTexto.restaurarEstado(gerenciadorEstados.obterEstadoAnterior()); // Texto Versão 2
        editorTexto.restaurarEstado(gerenciadorEstados.obterEstadoAnterior()); // Texto Versão 1
    }
}