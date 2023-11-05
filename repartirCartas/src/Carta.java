public class Carta {
    private final String valor;
    private final String palo;

    public Carta(String valor, String palo) {
        this.valor = valor;
        this.palo = palo;
    }

    @Override
    public String toString() {
        return  valor + " de " + palo;
    }
}
