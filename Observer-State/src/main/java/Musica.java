public class Musica extends EstadoMusica {
    private static Musica instance = new Musica();
    private Musica() {}
    public static Musica getInstance() { return instance; }

    public String getNomeEstado() { return "Musica (Parada)"; }

    public boolean tocar(Musicas musicas) {
        musicas.setEstado(EstadoTocando.getInstance());
        return true;
    }

    public boolean deletar(Musicas musicas) {
        musicas.setEstado(EstadoDeletado.getInstance());
        return true;
    }
}