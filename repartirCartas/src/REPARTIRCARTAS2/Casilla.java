package REPARTIRCARTAS2;

import java.util.ArrayList;
import java.util.List;

public class Casilla {
    List<Carta> cartas = new ArrayList<>();


    public void agregarCarta(Carta carta) {

        cartas.add(carta);
    }

    @Override
    public String toString() {
        return "Casilla{" +
                "cartas=" + cartas +
                '}';
    }
}
