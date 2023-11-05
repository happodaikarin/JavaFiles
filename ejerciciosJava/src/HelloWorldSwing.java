import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class HelloWorldSwing extends JFrame {

    public HelloWorldSwing() {
        // Configura el título de la ventana
        setTitle("Hola Mundo Swing");

        // Configura la operación de cierre (terminar la aplicación)
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Añade un JLabel que contiene el texto "Hola, Mundo"
        add(new JLabel("Hola, Mundo", JLabel.CENTER));

        // Configura el tamaño de la ventana
        setSize(300, 200);

        // Centra la ventana en la pantalla
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        // Asegúrate de que la interfaz gráfica se ejecute en el Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Crea una instancia de tu aplicación
                HelloWorldSwing miVentana = new HelloWorldSwing();
                // Hace visible la ventana
                miVentana.setVisible(true);
            }
        });
    }
}
