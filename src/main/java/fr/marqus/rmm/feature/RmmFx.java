package fr.marqus.rmm.feature;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * JavaFx launcher.
 */
public final class RmmFx extends Application {

    private static final Logger LOGGER = Logger.getLogger(RmmFx.class.getName());

    private static final String TITLE = "RabbitMQ Message Manager";

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle(TITLE);
        try {
            Pane pane = loadMainPane();
            Scene scene = new Scene(pane);
            primaryStage.setScene(scene);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, e.getLocalizedMessage(), e);
        }
        primaryStage.show();
    }

    private Pane loadMainPane() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        return loader.load(getClass().getResourceAsStream("/layout/MainPane.fxml"));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
