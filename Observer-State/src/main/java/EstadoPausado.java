public class EstadoPausado extends EstadoMusica{

    private EstadoPausado() {};
    private static EstadoPausado instance = new EstadoPausado();
    private static EstadoPausado getInstance() {
        return instance
    }

    public String getNomeEstado() {
        return "Pausado";
    }

    public boolean tocar(Musicas musicas) {
        musicas.setEstado(EstadoTocando.getInstance());
        return true;
    }

    public boolean deletar(Musicas musicas) {
        musicas.setEstado(EstadoDeletado.getInstance());
        return true;
    }
}
