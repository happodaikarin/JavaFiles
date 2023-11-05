import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class TextEditor extends JFrame {
    private JTextPane textPane;
    private JSpinner fontSizeSpinner;
    private JComboBox<String> fontTypeComboBox;
    private JComboBox<String> fontColorComboBox;
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JScrollPane scrollPane;
    private JMenuItem openItem, saveItem, exitItem;

    public TextEditor() {
        // Initialize text pane
        textPane = new JTextPane();
        scrollPane = new JScrollPane(textPane);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        // Initialize menu bar
        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        openItem = new JMenuItem("Open");
        saveItem = new JMenuItem("Save");
        exitItem = new JMenuItem("Exit");

        openItem.addActionListener(e -> openFile());
        saveItem.addActionListener(e -> saveFile());
        exitItem.addActionListener(e -> System.exit(0));

        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(new JSeparator());
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);

        // Tool Bar for font properties
        JToolBar toolBar = new JToolBar();
        String[] fontTypes = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        fontTypeComboBox = new JComboBox<>(fontTypes);
        toolBar.add(fontTypeComboBox);

        // Font Size Spinner
        fontSizeSpinner = new JSpinner(new SpinnerNumberModel(12, 1, 100, 1));
        toolBar.add(fontSizeSpinner);

        // Font Color ComboBox
        String[] colors = {"Black", "Red", "Blue"};
        fontColorComboBox = new JComboBox<>(colors);
        toolBar.add(fontColorComboBox);

        // Action Listeners for the font properties
        fontTypeComboBox.addActionListener(e -> updateTextStyle());
        fontSizeSpinner.addChangeListener(e -> updateTextStyle());
        fontColorComboBox.addActionListener(e -> updateTextStyle());

        getContentPane().add(toolBar, BorderLayout.NORTH);

        // Configure the frame
        setTitle("Text Editor");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Key Bindings
        Action redAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                applyTextColor(Color.RED);
            }
        };
        Action blueAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                applyTextColor(Color.BLUE);
            }
        };
        Action blackAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                applyTextColor(Color.BLACK);
            }
        };

        textPane.getInputMap().put(KeyStroke.getKeyStroke('B', Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()), "redAction");
        textPane.getActionMap().put("redAction", redAction);

        textPane.getInputMap().put(KeyStroke.getKeyStroke('V', Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()), "blueAction");
        textPane.getActionMap().put("blueAction", blueAction);

        textPane.getInputMap().put(KeyStroke.getKeyStroke('N', Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()), "blackAction");
        textPane.getActionMap().put("blackAction", blackAction);
    }

    // Method to apply text color
    private void applyTextColor(Color color) {
        StyledDocument doc = textPane.getStyledDocument();
        Style style = textPane.addStyle("ColorStyle", null);
        StyleConstants.setForeground(style, color);
        doc.setCharacterAttributes(textPane.getSelectionStart(), textPane.getSelectionEnd() - textPane.getSelectionStart(), style, false);
    }

    // Method to update the text style
    private void updateTextStyle() {
        String fontName = (String) fontTypeComboBox.getSelectedItem();
        int fontSize = (Integer) fontSizeSpinner.getValue();
        String colorName = (String) fontColorComboBox.getSelectedItem();

        Color color;
        switch (colorName) {
            case "Black":
                color = Color.BLACK;
                break;
            case "Red":
                color = Color.RED;
                break;
            case "Blue":
                color = Color.BLUE;
                break;
            default:
                color = Color.BLACK;
        }

        StyledDocument doc = textPane.getStyledDocument();
        Style style = textPane.addStyle("Style", null);

        StyleConstants.setFontFamily(style, fontName);
        StyleConstants.setFontSize(style, fontSize);
        StyleConstants.setForeground(style, color);

        doc.setCharacterAttributes(textPane.getSelectionStart(), textPane.getSelectionEnd() - textPane.getSelectionStart(), style, false);
    }

    // Method to open a file
    private void openFile() {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try {
                textPane.read(new FileReader(file.getAbsolutePath()), null);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "File could not be read", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Method to save a file
    private void saveFile() {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try {
                FileWriter writer = new FileWriter(file.getAbsolutePath());
                textPane.write(writer);
                writer.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "File could not be saved", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Main method to run the editor
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TextEditor().setVisible(true);
        });
    }
}

