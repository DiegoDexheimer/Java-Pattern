package Observer;

public class Main {
    public static void main(String[] args) {
        Revista revista = new Revista("Revista de Java");

        Inscrito inscrito1 = new Inscrito("Diego");
        Inscrito inscrito2 = new Inscrito("Edu");
        Inscrito inscrito3 = new Inscrito("Joao");

        revista.inscrever(inscrito1);
        revista.inscrever(inscrito2);
        revista.inscrever(inscrito3);

        revista.notificarInscritos();
        /*Output
         * Diego recebeu a nova edicao da revista: Revista de Java
         * Edu recebeu a nova edicao da revista: Revista de Java
         * Joao recebeu a nova edicao da revista: Revista de Java
         */

        revista.cancelarInscricao(inscrito2);
        
        revista.getInscritos().forEach(inscrito -> System.out.println(((Inscrito) inscrito).getNome()));
    }
    /*Output
     * Diego
     * Joao
     */
    
}
