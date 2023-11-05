import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class ColorChanger extends JFrame {

    private JPanel panel;

    public ColorChanger() {
        // Configura el título y la operación de cierre
        setTitle("Cambiador de Color");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Inicializa el panel y configura su color inicial
        panel = new JPanel();
        panel.setBackground(getRandomColor()); // Establece un color de fondo aleatorio

        // Crea el botón y añade el ActionListener
        JButton button = new JButton("Cambiar Color");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cambia el color de fondo del panel
                panel.setBackground(getRandomColor());
            }
        });

        // Añade el panel y el botón a la ventana
        add(panel, BorderLayout.CENTER);
        add(button, BorderLayout.SOUTH);

        // Configura el tamaño de la ventana y su posición
        setSize(400, 400);
        setLocationRelativeTo(null);
    }

    // Función para obtener un color aleatorio
    private Color getRandomColor() {
        Random rand = new Random();
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();
        return new Color(r, g, b);
    }

    public static void main(String[] args) {
        // Asegúrate de que la UI se ejecute en el Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Crea una instancia de la aplicación y la hace visible
                ColorChanger frame = new ColorChanger();
                frame.setVisible(true);
            }
        });
    }
}
