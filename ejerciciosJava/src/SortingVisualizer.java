import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class SortingVisualizer extends JFrame {

    private static final int NUM_BARS = 50; // Puedes aumentar o disminuir el número de barras
    private int[] numbers;
    private JPanel sortingPanel;
    private JButton bubbleSortButton, selectionSortButton, insertionSortButton, shuffleButton;
    private JButton mergeSortButton;


    private int selectedBar = -1;
    private int comparingBar = -1;

    public SortingVisualizer() {
        numbers = generateRandomArray(NUM_BARS);
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Sorting Algorithms Visualizer");
        setSize(800, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        sortingPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawSortingVisualizer(g);
            }
        };
        add(sortingPanel, BorderLayout.CENTER);

        mergeSortButton = new JButton("Merge Sort");
        mergeSortButton.addActionListener(e -> new Thread(this::mergeSortStart).start());




        bubbleSortButton = new JButton("Bubble Sort");
        bubbleSortButton.addActionListener(e -> new Thread(this::bubbleSort).start());

        selectionSortButton = new JButton("Selection Sort");
        selectionSortButton.addActionListener(e -> new Thread(this::selectionSort).start());

        insertionSortButton = new JButton("Insertion Sort");
        insertionSortButton.addActionListener(e -> new Thread(this::insertionSort).start());

        shuffleButton = new JButton("Shuffle");
        shuffleButton.addActionListener(e -> {
            shuffleArray(numbers);
            selectedBar = -1;
            comparingBar = -1;
            repaint();
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(shuffleButton);
        buttonPanel.add(bubbleSortButton);
        buttonPanel.add(selectionSortButton);
        buttonPanel.add(insertionSortButton);
        buttonPanel.add(mergeSortButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void drawSortingVisualizer(Graphics g) {
        int width = getWidth();
        int barWidth = width / numbers.length;
        for (int i = 0; i < numbers.length; i++) {
            int barHeight = (int) ((getHeight() - 30) * ((double) numbers[i] / numbers.length));
            int x = i * barWidth;
            int y = getHeight() - barHeight;

            if (i == selectedBar || i == comparingBar) {
                g.setColor(Color.RED);
            } else {
                g.setColor(Color.BLUE);
            }
            g.fillRect(x, y, barWidth, barHeight);
        }
    }

    private void bubbleSort() {
        boolean wasSwapped = true;
        while (wasSwapped) {
            wasSwapped = false;
            for (int j = 0; j < numbers.length - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    swap(j, j + 1);
                    wasSwapped = true;
                }
                selectedBar = j;
                repaint();
                sleepForAWhile(20);
            }
        }
        selectedBar = -1;
        comparingBar = -1;
        repaint();
    }

    private void selectionSort() {
        for (int i = 0; i < numbers.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] < numbers[minIndex]) {
                    minIndex = j;
                }
                comparingBar = j;
                repaint();
                sleepForAWhile(20);
            }
            swap(i, minIndex);
            selectedBar = i;
            repaint();
            sleepForAWhile(20);
        }
        selectedBar = -1;
        comparingBar = -1;
        repaint();
    }

    private void insertionSort() {
        for (int i = 1; i < numbers.length; i++) {
            int current = numbers[i];
            int j = i - 1;
            while (j >= 0 && numbers[j] > current) {
                numbers[j + 1] = numbers[j];
                j--;
                comparingBar = j;
                selectedBar = i;
                repaint();
                sleepForAWhile(20);
            }
            numbers[j + 1] = current;
            selectedBar = i;
            repaint();
            sleepForAWhile(20);
        }
        selectedBar = -1;
        comparingBar = -1;
        repaint();
    }

    private void mergeSortStart() {
        mergeSort(0, numbers.length - 1);
        selectedBar = -1;
        comparingBar = -1;
        repaint();
    }

    private void mergeSort(int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;

            mergeSort(left, middle);
            mergeSort(middle + 1, right);

            merge(left, middle, right);
        }
    }

    private void merge(int left, int middle, int right) {
        int[] leftArray = new int[middle - left + 1];
        int[] rightArray = new int[right - middle];

        for (int i = 0; i < leftArray.length; ++i)
            leftArray[i] = numbers[left + i];
        for (int j = 0; j < rightArray.length; ++j)
            rightArray[j] = numbers[middle + 1 + j];

        int i = 0, j = 0;

        int k = left;
        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] <= rightArray[j]) {
                numbers[k] = leftArray[i];
                i++;
            } else {
                numbers[k] = rightArray[j];
                j++;
            }
            comparingBar = k;
            repaint();
            sleepForAWhile(20);
            k++;
        }

        while (i < leftArray.length) {
            numbers[k] = leftArray[i];
            i++;
            k++;
            comparingBar = k;
            repaint();
            sleepForAWhile(20);
        }

        while (j < rightArray.length) {
            numbers[k] = rightArray[j];
            j++;
            k++;
            comparingBar = k;
            repaint();
            sleepForAWhile(20);
        }
    }
    private void swap(int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    private void shuffleArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int index = (int) (Math.random() * array.length);
            int temp = array[i];
            array[i] = array[index];
            array[index] = temp;
        }
    }

    private int[] generateRandomArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i + 1;
        }
        shuffleArray(array);
        return array;
    }

    private void sleepForAWhile(int duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SortingVisualizer visualizer = new SortingVisualizer();
            visualizer.setVisible(true);
        });
    }
}
