package DSA2;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.Arrays;

public class SearchAndSortGUI extends Application {

    private ComboBox<String> algorithmTypeComboBox;
    private ComboBox<String> algorithmComboBox;
    private TextField arrayInputTextField;
    private TextField keyInputTextField;
    private Label keyInputLabel;
    private TextArea resultTextArea;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Search and Sort Algorithm Analyzer");

        // --- UI Components ---
        Label titleLabel = new Label("Search and Sort Algorithm Analyzer");
        titleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        // Algorithm Selection
        algorithmTypeComboBox = new ComboBox<>();
        algorithmTypeComboBox.getItems().addAll("Searching", "Sorting");
        algorithmTypeComboBox.setValue("Sorting"); // Default value

        algorithmComboBox = new ComboBox<>();

        // Input Fields
        Label arrayInputLabel = new Label("Enter numbers (comma-separated):");
        arrayInputTextField = new TextField();
        arrayInputTextField.setPromptText("e.g., 5, 1, 9, 3, 7");

        keyInputLabel = new Label("Enter key to search for:");
        keyInputTextField = new TextField();

        // Results Area
        resultTextArea = new TextArea();
        resultTextArea.setEditable(false);
        resultTextArea.setWrapText(true);

        // Run Button
        Button runButton = new Button("Run Algorithm");

        // --- Layout ---
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(15));

        // Top: Title
        HBox titleBox = new HBox(titleLabel);
        titleBox.setAlignment(Pos.CENTER);
        root.setTop(titleBox);

        // Center: Controls and Inputs
        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(20, 0, 20, 0));

        grid.add(new Label("Algorithm Type:"), 0, 0);
        grid.add(algorithmTypeComboBox, 1, 0);
        grid.add(new Label("Choose Algorithm:"), 0, 1);
        grid.add(algorithmComboBox, 1, 1);
        grid.add(arrayInputLabel, 0, 2);
        grid.add(arrayInputTextField, 1, 2);
        grid.add(keyInputLabel, 0, 3);
        grid.add(keyInputTextField, 1, 3);

        VBox centerBox = new VBox(15, grid, runButton);
        centerBox.setAlignment(Pos.CENTER);
        root.setCenter(centerBox);

        // Bottom: Results
        VBox resultBox = new VBox(5, new Label("Results:"), resultTextArea);
        root.setBottom(resultBox);

        // --- Event Handlers ---
        algorithmTypeComboBox.setOnAction(e -> updateAlgorithmChoices());
        runButton.setOnAction(e -> runSelectedAlgorithm());

        // --- Initial UI State ---
        updateAlgorithmChoices(); // Set initial algorithm choices
        updateKeyFieldVisibility(); // Set initial field visibility

        // --- Scene Setup ---
        Scene scene = new Scene(root, 600, 550);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void updateAlgorithmChoices() {
        algorithmComboBox.getItems().clear();
        String type = algorithmTypeComboBox.getValue();
        if ("Searching".equals(type)) {
            algorithmComboBox.getItems().addAll("Sequential Search", "Binary Search");
        } else { // Sorting
            algorithmComboBox.getItems().addAll("Bubble Sort", "Insertion Sort", "Merge Sort");
        }
        algorithmComboBox.getSelectionModel().selectFirst();
        updateKeyFieldVisibility();
    }

    private void updateKeyFieldVisibility() {
        boolean isSearching = "Searching".equals(algorithmTypeComboBox.getValue());
        keyInputLabel.setVisible(isSearching);
        keyInputTextField.setVisible(isSearching);
    }

    private void runSelectedAlgorithm() {
        String arrayText = arrayInputTextField.getText();
        if (arrayText.trim().isEmpty()) {
            resultTextArea.setText("Error: Input array cannot be empty.");
            return;
        }

        int[] array;
        try {
            array = Arrays.stream(arrayText.split(","))
                          .map(String::trim)
                          .mapToInt(Integer::parseInt)
                          .toArray();
        } catch (NumberFormatException e) {
            resultTextArea.setText("Error: Invalid input. Please enter only comma-separated integers.");
            return;
        }

        String algorithmName = algorithmComboBox.getValue();
        if (algorithmName == null) {
            resultTextArea.setText("Error: Please select an algorithm.");
            return;
        }

        long startTime = System.nanoTime();

        if ("Searching".equals(algorithmTypeComboBox.getValue())) {
            runSearch(algorithmName, array);
        } else {
            runSort(algorithmName, array);
        }
    }

    private void runSearch(String name, int[] array) {
        int key;
        try {
            key = Integer.parseInt(keyInputTextField.getText().trim());
        } catch (NumberFormatException e) {
            resultTextArea.setText("Error: Invalid search key. Please enter a single integer.");
            return;
        }

        StringBuilder resultText = new StringBuilder();
        int resultIndex = -1;
        String best = "", avg = "", worst = "";

        if ("Binary Search".equals(name)) {
            Arrays.sort(array);
            resultText.append("Note: Array was sorted for Binary Search.\nSorted Array: ")
                      .append(Arrays.toString(array)).append("\n\n");
        }

        long startTime = System.nanoTime();
        switch (name) {
            case "Sequential Search":
                resultIndex = SearchAndSort.sequentialSearch(array, key);
                best = "O(1)"; avg = "O(n)"; worst = "O(n)";
                break;
            case "Binary Search":
                resultIndex = SearchAndSort.binarySearch(array, key);
                best = "O(1)"; avg = "O(log n)"; worst = "O(log n)";
                break;
        }
        long duration = System.nanoTime() - startTime;

        resultText.append("--- ").append(name).append(" Results ---\n");
        if (resultIndex != -1) {
            resultText.append("Value '").append(key).append("' found at index: ").append(resultIndex).append("\n");
        } else {
            resultText.append("Value '").append(key).append("' not found.\n");
        }
        
        appendPerformance(resultText, duration, best, avg, worst);
        resultTextArea.setText(resultText.toString());
    }

    private void runSort(String name, int[] array) {
        long startTime = System.nanoTime();
        String best = "", avg = "", worst = "";

        switch (name) {
            case "Bubble Sort":
                SearchAndSort.bubbleSort(array);
                best = "O(n)"; avg = "O(n^2)"; worst = "O(n^2)";
                break;
            case "Insertion Sort":
                SearchAndSort.insertionSort(array);
                best = "O(n)"; avg = "O(n^2)"; worst = "O(n^2)";
                break;
            case "Merge Sort":
                SearchAndSort.mergeSort(array, 0, array.length - 1);
                best = "O(n log n)"; avg = "O(n log n)"; worst = "O(n log n)";
                break;
        }
        long duration = System.nanoTime() - startTime;

        StringBuilder resultText = new StringBuilder();
        resultText.append("--- ").append(name).append(" Results ---\n");
        resultText.append("Sorted Array: ").append(Arrays.toString(array)).append("\n");
        
        appendPerformance(resultText, duration, best, avg, worst);
        resultTextArea.setText(resultText.toString());
    }

    private void appendPerformance(StringBuilder sb, long duration, String best, String avg, String worst) {
        sb.append("Empirical Running Time: ").append(duration).append(" ns\n");
        sb.append("Theoretical Time Complexity:\n");
        sb.append("  - Best Case: ").append(best).append("\n");
        sb.append("  - Average Case: ").append(avg).append("\n");
        sb.append("  - Worst Case: ").append(worst).append("\n");
    }
}