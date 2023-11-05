import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baraja {

    public static final String[] PALOS = {"Corazones", "Diamantes", "Tréboles", "Picas"};
    public static final String[] VALORES = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    private final List<Carta> cartas = new ArrayList<>();

    public Baraja() {
        for(String palo : PALOS){
            for(String valor : VALORES){
                cartas.add(new Carta(valor,palo));
            }
        }

        Collections.shuffle(cartas);

    }

    public Carta repartirCarta(){
        return cartas.remove(0);
    }
}
