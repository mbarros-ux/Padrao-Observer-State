public class EstadoDeletado extends EstadoMusica{
    private EstadoDeletado(){};
    private static EstadoDeletado instance = new EstadoDeletado();
    private static EstadoDeletado getInstance() {
        return instance;
    }
    public String getNomeEstado() {
        return "Deletando";
    }

}
