
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This is the GUI Driver given to students, students should not modify this
 * file
 * 
 * @author Farnaz Eivazi
 * @version 2/1/2024
 *
 */
public class MorseCodeDriverFX extends Application {

    public static void main(String[] args) {
	launch(args);
    }

    public void start(Stage stage) {

	// call the main scene which is a BorderPane
	MorseCodeMain mainPane = new MorseCodeMain();
	Scene scene = new Scene(mainPane, 550, 350);
	stage.setScene(scene);
	stage.setTitle("Morse Code Converter Driver");
	stage.show();
    }

}
