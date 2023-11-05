package REPARTIRCARTAS2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Baraja {

    List<Carta> cartas = new ArrayList<>();

    public Baraja(){
        for(VALORES valores: VALORES.values()) {
            for(PALOS palos: PALOS.values()) {
                cartas.add(new Carta(valores.toString(), palos.toString()));
            }
        }

        Collections.shuffle(cartas);

        }

    @Override
    public String toString() {
        return "Baraja{" +
                "cartas=" + cartas +
                '}';
    }

    public static void main(String[] args) {
        Baraja baraja = new Baraja();
        System.out.println(baraja.toString());

    }
    }

