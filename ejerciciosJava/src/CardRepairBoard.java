import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class CardRepairBoard extends JFrame {
    private static final int NUM_SPACES = 7;
    private JPanel[] cardSpaces;
    private JButton dealButton;
    private JLabel[] cardLabels;

    public CardRepairBoard() {
        cardSpaces = new JPanel[NUM_SPACES];
        cardLabels = new JLabel[NUM_SPACES];
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Card Repair Board");
        setSize(800, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(1, NUM_SPACES + 1, 10, 0)); // 1 fila, NUM_SPACES+1 columnas, 10px de espacio horizontal

        for (int i = 0; i < NUM_SPACES; i++) {
            cardSpaces[i] = new JPanel();
            cardSpaces[i].setBorder(BorderFactory.createTitledBorder("Space " + (i + 1)));
            cardSpaces[i].setBackground(Color.WHITE);
            add(cardSpaces[i]);

            // Inicializar JLabels para las cartas, pero no añadirlas todavía
            cardLabels[i] = new JLabel("", SwingConstants.CENTER);
            cardLabels[i].setOpaque(true);
        }

        // Botón para repartir cartas
        dealButton = new JButton("Deal Cards");
        dealButton.addActionListener(e -> dealCards());
        add(dealButton);
    }

    private void dealCards() {
        Random rand = new Random();
        for (int i = 0; i < NUM_SPACES; i++) {
            // Asignar un número de carta aleatorio o color para la demostración
            int cardNumber = rand.nextInt(13) + 1; // Número de carta aleatorio del 1 al 13
            cardLabels[i].setText(String.valueOf(cardNumber));
            cardLabels[i].setBackground(new Color(rand.nextFloat(), rand.nextFloat(), rand.nextFloat())); // Color aleatorio

            // Asegurarse de que la carta esté visible en el espacio
            cardSpaces[i].add(cardLabels[i]);
            cardSpaces[i].revalidate();
        }
        repaint(); // Refrescar la interfaz gráfica para mostrar las cartas
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CardRepairBoard board = new CardRepairBoard();
            board.setVisible(true);
        });
    }
}
