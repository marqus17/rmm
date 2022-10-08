package fr.marqus.rmm.feature.tab;

import fr.marqus.rmm.domain.model.QueueConfig;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

/**
 * Save message pane controler.
 */
public final class SaveMessagePaneControler implements Initializable {

    private static final String START = "Start";

    private static final String STOP = "Stop";

    private static final Image START_PICTURE = new Image(Objects.requireNonNull(CopyMoveMessagePaneControler.class.getResourceAsStream("/picture/start.png")));

    private static final Image STOP_PICTURE = new Image(Objects.requireNonNull(CopyMoveMessagePaneControler.class.getResourceAsStream("/picture/stop.png")));

    @FXML
    private ComboBox<QueueConfig> sourceQueueComboBox;

    @FXML
    private TextField fileTextField;

    @FXML
    private Button selectFileButton;

    @FXML
    private ToggleButton saveMessagesButton;

    @FXML
    private ImageView saveMessagesImageView;

    @Override
    public void initialize(final URL location, final ResourceBundle resources) {
        sourceQueueComboBox.getSelectionModel()
                .selectedIndexProperty()
                .addListener((obs, oldVal, newVal) -> {
                    boolean result = (newVal.intValue() == -1) || fileTextField.getText().isBlank();
                    saveMessagesButton.setDisable(result);
                });
        fileTextField.textProperty()
                .addListener((obs, oldVal, newVal) -> {
                    boolean result = newVal.isBlank() || sourceQueueComboBox.getSelectionModel().getSelectedIndex() == -1;
                    saveMessagesButton.setDisable(result);
                });
        selectFileButton.setOnAction(this::saveFile);
        saveMessagesImageView.setImage(START_PICTURE);
        saveMessagesButton.selectedProperty().addListener((obs, oldVal, newVal) -> {
            if (Boolean.TRUE.equals(newVal)) {
                saveMessagesButton.setText(STOP);
                saveMessagesImageView.setImage(STOP_PICTURE);
            } else {
                saveMessagesButton.setText(START);
                saveMessagesImageView.setImage(START_PICTURE);
            }
        });
    }

    private void saveFile(final ActionEvent evt) {
        FileChooser chooser = new FileChooser();
        File file = chooser.showSaveDialog(null);
        if (file != null) {
            fileTextField.setText(file.getAbsolutePath());
        }
    }
}
