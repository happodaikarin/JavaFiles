import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Juego {

    private final Baraja baraja = new Baraja();
    private final List<Casilla> casillas;

    public Juego() {
        casillas = IntStream.rangeClosed(1, 7)
                .mapToObj(this::crearCasillaConCartas)
                .collect(Collectors.toList());
    }

    private Casilla crearCasillaConCartas(int numCartas) {
        Casilla casilla = new Casilla();
        IntStream.range(0, numCartas)
                .forEach(j -> casilla.agregarCarta(baraja.repartirCarta()));
        return casilla;
    }

    public void mostrarCasillas() {
        IntStream.range(0, casillas.size())
                .forEach(i -> System.out.println("Casilla " + (i + 1) + ": " + casillas.get(i)));
    }
}
