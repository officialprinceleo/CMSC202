import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class FXMainPane extends VBox {

    // Declare five buttons, a label, and a text field
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Label label;
    private TextField textField;
    private HBox hBox1;
    private HBox hBox2;

    // Declare an instance of DataManager
    private DataManager dataManager;

    FXMainPane() {
        // Instantiate the buttons, label, and text field
        button1 = new Button("Hello");
        button2 = new Button("Howdy");
        button3 = new Button("Chinese");
        button4 = new Button("Clear");
        button5 = new Button("Exit");
        label = new Label("Feedback:");
        textField = new TextField();
        hBox1 = new HBox();
        hBox2 = new HBox();

        // Instantiate the DataManager instance
        dataManager = new DataManager();

        // Set margins and alignment of the components
        Insets buttonInsets = new Insets(10);
        Insets labelInsets = new Insets(0, 10, 0, 0);
        Insets textFieldInsets = new Insets(0, 0, 0, 10);

        HBox.setMargin(button1, buttonInsets);
        HBox.setMargin(button2, buttonInsets);
        HBox.setMargin(button3, buttonInsets);
        HBox.setMargin(button4, buttonInsets);
        HBox.setMargin(button5, buttonInsets);
        HBox.setMargin(label, labelInsets);
        HBox.setMargin(textField, textFieldInsets);

        hBox1.setAlignment(Pos.CENTER);
        hBox2.setAlignment(Pos.CENTER);

        // Add the buttons to the first HBox
        hBox1.getChildren().addAll(button1, button2, button3, button4, button5);
        // Add the label and text field to the second HBox
        hBox2.getChildren().addAll(label, textField);

        // Add the HBoxes to this FXMainPanel (a VBox)
        getChildren().addAll(hBox1, hBox2);

        // Create a private inner class to handle the button clicks
        button1.setOnAction(new ButtonHandler());
        button2.setOnAction(new ButtonHandler());
        button3.setOnAction(new ButtonHandler());
        button4.setOnAction(new ButtonHandler());
        button5.setOnAction(new ButtonHandler());
    }

    private class ButtonHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            Object source = event.getTarget();

            if (source == button1) {
                String response = dataManager.getHello();
                textField.setText(response);
            } else if (source == button2) {
                String response = dataManager.getHowdy();
                textField.setText(response);
            } else if (source == button3) {
                String response = dataManager.getChinese();
                textField.setText(response);
            } else if (source == button4) {
                textField.setText("");
            } else if (source == button5) {
                Platform.exit();
                System.exit(0);
            }
        }
    }
}
