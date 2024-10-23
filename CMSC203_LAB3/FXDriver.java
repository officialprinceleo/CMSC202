

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class FXDriver extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        FXMainPane root = new FXMainPane();
        
        stage.setScene(new Scene(root, 800, 600));
        
        stage.setTitle("Hello World GUI");
        
       
        
        stage.show();
    }
}