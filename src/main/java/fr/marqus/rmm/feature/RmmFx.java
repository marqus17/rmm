package fr.marqus.rmm.feature;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * JavaFx launcher.
 */
public final class RmmFx extends Application {

    private static final String TITLE = "RabbitMQ Message Manager";

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle(TITLE);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
