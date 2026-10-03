
public abstract class EstadoMusica {
    public abstract String getNomeEstado();

    public boolean tocar(Musicas musicas) {
        return false;
    }

    public boolean pausar(Musicas musicas) {
        return false;
    }

    public boolean deletar(Musicas musicas) {
        return false;
    }
}