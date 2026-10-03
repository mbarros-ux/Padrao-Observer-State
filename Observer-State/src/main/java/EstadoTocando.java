public class EstadoTocando extends EstadoMusica {
    private static EstadoTocando instance = new EstadoTocando();
    private EstadoTocando() {}
    public static EstadoTocando getInstance() { return instance; }

    public String getNomeEstado() { return "Tocando"; }

    public boolean pausar(Musicas musicas) {
        musicas.setEstado(EstadoPausado.getInstance());
        return true;
    }
    public boolean deletar(Musicas musicas) {
        musicas.setEstado(EstadoDeletado.getInstance());
        return true;
    }
}