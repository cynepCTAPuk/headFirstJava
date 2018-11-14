import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JavaFxHelloWorld extends Application {
    public JavaFxHelloWorld() {
    } //Optional constructor

    @Override
    public void init() {
        //By default this does nothing, but it can carry out code to set up your app.
        //It runs once before the start method, and after the constructor.
    }

    @Override
    public void start(Stage primaryStage) {
        final Button button = new Button();
        button.setText("type \"Hello World\" to console");
        // Registering a handler for button
        button.setOnAction((ActionEvent event) -> System.out.println("Hello World!"));

        final StackPane root = new StackPane(); // Initializing the StackPane class
        root.getChildren().add(button); // Adding all the nodes to the StackPane

        final Scene scene = new Scene(root, 250, 50);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show(); // Show the window(primaryStage)
    }

    @Override
    public void stop() {
        //By default this does nothing. It runs if the user clicks the go-away button
        //closing the window or if Platform.exit() is called.
        //Use Platform.exit() instead of System.exit(0).
        //This is where you should offer to save any unsaved stuff
        //that the user may have generated.
    }

    public static void main(final String[] args) {
        launch(args);
    }
}