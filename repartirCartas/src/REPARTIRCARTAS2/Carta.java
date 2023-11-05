package REPARTIRCARTAS2;

public class Carta {

    public String valor;
    public String palo;

    public Carta(String valor, String palo){
        this.valor = valor;
        this.palo = palo;
    }

    @Override
    public String toString() {
        return valor + " de " + palo;
    }

}
