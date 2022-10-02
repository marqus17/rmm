package fr.marqus.rmm.feature.tab;

import fr.marqus.rmm.domain.model.QueueConfig;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Save message pane controler.
 */
public final class SaveMessagePaneControler implements Initializable {

    @FXML
    private ComboBox<QueueConfig> sourceQueueComboBox;

    @FXML
    private TextField fileTextField;

    @FXML
    private Button selectFileButton;

    @FXML
    private Button saveMessagesButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        selectFileButton.setOnAction(this::saveFile);
    }

    private void saveFile(ActionEvent evt) {
        FileChooser chooser = new FileChooser();
        File file = chooser.showSaveDialog(null);
        if (file != null) {
            fileTextField.setText(file.getAbsolutePath());
        }
    }
}
