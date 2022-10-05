package fr.marqus.rmm.feature.mainpane;

import fr.marqus.rmm.feature.tab.Tabs;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Main pane controler.
 */
public final class MainPaneControler implements Initializable {

    private static final Logger LOGGER = Logger.getLogger(MainPaneControler.class.getName());

    @FXML
    private TabPane mainTabPane;

    @FXML
    private TextArea logTextArea;

    @Override
    public void initialize(final URL location, final ResourceBundle resources) {
        Arrays.stream(Tabs.values())
                .forEach(this::loadTabs);
    }

    private void loadTabs(final Tabs tab) {
        FXMLLoader loader = new FXMLLoader();
        try {
            AnchorPane pane = loader.load(getClass().getResourceAsStream(tab.path));
            Tab newTab = new Tab(tab.title, pane);
            mainTabPane.getTabs().add(newTab);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, e.getLocalizedMessage(), e);
        }
    }

    @FXML
    private void closeAction() {
        Platform.exit();
    }

    @FXML
    private void aboutAction() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "RabbitMq Message Manager");
        alert.showAndWait();
    }
}
