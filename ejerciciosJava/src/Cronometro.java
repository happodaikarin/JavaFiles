import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cronometro extends JFrame implements Runnable, ActionListener {

    private static int horas = 0, minutos = 0, segundos = 0;
    private Thread hilo = null;

    JButton botonIniciar;
    JButton botonParar;
    JButton botonReiniciar;
    JLabel label;
    private boolean corriendo = false;

    public Cronometro() {
        initialize();
        setSize(320, 120); // Ajustado para acomodar el nuevo botón
        getContentPane().setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initialize() {
        label = new JLabel("00:00:00");
        label.setFont(new Font("Traditional Arabic", Font.PLAIN, 30));
        label.setBounds(90, 11, 137, 45);
        getContentPane().add(label);

        botonIniciar = new JButton("Iniciar");
        botonIniciar.setBounds(200, 54, 89, 23);
        botonIniciar.addActionListener(this);
        getContentPane().add(botonIniciar);

        botonParar = new JButton("Parar");
        botonParar.setBounds(120, 54, 80, 23);
        botonParar.addActionListener(this);
        getContentPane().add(botonParar);

        botonReiniciar = new JButton("Reiniciar");
        botonReiniciar.setBounds(20, 54, 100, 23);
        botonReiniciar.addActionListener(this);
        getContentPane().add(botonReiniciar);
    }

    @Override
    public void run() {
        while (corriendo) {
            try {
                Thread.sleep(50);
                segundos++;
                if (segundos > 59) {
                    segundos = 0;
                    minutos++;
                    if (minutos > 59) {
                        minutos = 0;
                        horas++;
                    }
                }
                actualizarLabel();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private void actualizarLabel() {
        String textoHoras = (horas < 10) ? "0" : "";
        String textoMinutos = (minutos < 10) ? "0" : "";
        String textoSegundos = (segundos < 10) ? "0" : "";

        label.setText(textoHoras + horas + ":" + textoMinutos + minutos + ":" + textoSegundos + segundos);
    }

    private void reiniciarCronometro() {
        horas = 0;
        minutos = 0;
        segundos = 0;
        actualizarLabel();
    }

    public static void main(String[] args) {
        Cronometro cronometro = new Cronometro();
        cronometro.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonIniciar) {
            if (!corriendo) {
                corriendo = true;
                if (hilo == null || !hilo.isAlive()) { // Se verifica si el hilo está vivo.
                    hilo = new Thread(this);
                    hilo.start();
                }
            }
        } else if (e.getSource() == botonParar) {
            corriendo = false;
        } else if (e.getSource() == botonReiniciar) {
            corriendo = false; // Detiene el cronómetro antes de reiniciar.
            reiniciarCronometro();
        }
    }
}
