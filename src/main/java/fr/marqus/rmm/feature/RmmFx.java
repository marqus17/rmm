package fr.marqus.rmm.feature;

import com.gluonhq.ignite.guice.GuiceContext;
import fr.marqus.rmm.domain.repository.RepositoryModule;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * JavaFx launcher.
 */
public final class RmmFx extends Application {

    private static final Logger LOGGER = Logger.getLogger(RmmFx.class.getName());

    private static final String TITLE = "RabbitMQ Message Manager";


    private static GuiceContext context;

    private static void initContext(final Object contextRoot) {
        context = new GuiceContext(contextRoot, () -> List.of(new RepositoryModule()));
        context.init();
    }

    public static <T> T getDIInstance(Class<T> cls) {
        return context.getInstance(cls);
    }

    /**
     * JavaFx start method.
     *
     * @param primaryStage the primary stage for this application, onto which
     *                     the application scene can be set.
     *                     Applications may create other stages, if needed, but they will not be
     *                     primary stages.
     */
    @Override
    public void start(final Stage primaryStage) {
        initContext(this);
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

    /**
     * FX app launch func.
     *
     * @param args app args.
     */
    public static void main(final String[] args) {
        launch(args);
    }
}
