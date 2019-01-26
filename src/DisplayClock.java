
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Project: Clock
 * Task: Creates a working clock that can be paused/restarted
 * @author Justin Mangan
 * Date 19 February 2018
 */

public class DisplayClock extends Application{

    // Overrides the start() method in the Application class
    @Override 
	public void start(Stage primaryStage) {
            
            // Initializes a new ClockPane object named clock
            ClockPane clock = new ClockPane();

            // Creates two buttons
            Button stopBtn = new Button("Stop");
            Button startBtn = new Button("Start");

            // Creates and registers event handlers for buttons
            stopBtn.setOnMouseClicked(e -> clock.stop());
            startBtn.setOnMouseClicked(e -> clock.restart());

            // Creates an hBox 
            HBox hBox = new HBox(5);
            hBox.setAlignment(Pos.CENTER);

            // Places buttons in hBox
            hBox.getChildren().addAll(stopBtn, startBtn);

            // Create a border pane and place the nodes in to it
            BorderPane borderPane = new BorderPane();
            borderPane.setStyle("-fx-background-color: #2F4F4F");
            borderPane.setCenter(clock);
            borderPane.setBottom(hBox);

            // Creates a scene and puts it in the stage
            Scene scene = new Scene(borderPane, 600, 620);
            primaryStage.setTitle("Clock"); 
            primaryStage.setScene(scene); 
            primaryStage.show(); 
	}
        
    public static void main(String[] args) {
        launch(args);
    }
    
}
