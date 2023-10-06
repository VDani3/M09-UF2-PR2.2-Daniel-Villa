import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        UtilsViews.parentContainer.setStyle("-fx-font: 14 arial;");
        UtilsViews.addView(getClass(), "Normal", "assets/vista0.fxml");

        Scene scene = new Scene(UtilsViews.parentContainer);
        
        // Listen to window width changes
        scene.widthProperty().addListener((ChangeListener<? super Number>) new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldWidth, Number newWidth) {
                _setLayout();
            }
        });

        stage.setScene(scene);
        stage.setTitle("Practica 2"); 
        stage.setResizable(false);
        stage.show();

        // Add icon only if not Mac
        if (!System.getProperty("os.name").contains("Mac")) {
            Image icon = new Image("file:assets/icons/icon.png");
            stage.getIcons().add(icon);
        }
    }

    private void _setLayout() {
        UtilsViews.setView("Normal");
    }
}