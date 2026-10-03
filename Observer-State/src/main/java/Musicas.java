public class Musicas {
    private String nome;
    private EstadoMusica estado;
    private List<Observador> observadores = new ArrayList<>();

    public Musicas(String nome) {
        this.nome = nome;
        this.estado = Musica.getInstance();
    }

    public void adicionarObservador(Observador obs) {
        observadores.add(obs);
    }

    private void notificarObservadores() {
        for (Observador obs : observadores) {
            obs.estadoAlterado(this.nome, this.estado.getNomeEstado());
        }
    }

    public void setEstado(EstadoMusica novoEstado) {
        this.estado = novoEstado;
        notificarObservadores();

    public boolean tocar() { return estado.tocar(this); }
    public boolean pausar() { return estado.pausar(this); }
    public boolean deletar() { return estado.deletar(this); }
}