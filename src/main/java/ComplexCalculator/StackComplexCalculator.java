package ComplexCalculator;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/** The StackComplexCalculator is the main class.
 *
 * @author group11
 */
public class StackComplexCalculator extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("ComplexCalculatorView.fxml"));

        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("stylesheet.css").toExternalForm());
        stage.setResizable(false);

        stage.setTitle("Scientific Calculator Beta");
        stage.getIcons().add(new Image(getClass().getResourceAsStream("icon.png")));

        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
