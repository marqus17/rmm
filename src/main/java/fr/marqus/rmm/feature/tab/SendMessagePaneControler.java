package fr.marqus.rmm.feature.tab;

import fr.marqus.rmm.domain.model.QueueConfig;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Send message pane controler.
 */
public final class SendMessagePaneControler implements Initializable {

    @FXML
    private TextField fileTextField;

    @FXML
    private Button selectFileButton;

    @FXML
    private TextArea messageTextArea;

    @FXML
    private RadioButton fileRadioButton;

    @FXML
    private RadioButton messageRadioButton;

    @FXML
    private ComboBox<QueueConfig> targetQueueComboBox;

    @FXML
    private Button sendButton;

    private final ToggleGroup messageTypeToggleGroup = new ToggleGroup();

    @Override
    public void initialize(final URL location, final ResourceBundle resources) {
        messageRadioButton.setToggleGroup(messageTypeToggleGroup);
        fileRadioButton.setToggleGroup(messageTypeToggleGroup);
        fileTextField.disableProperty().bind(messageRadioButton.selectedProperty());
        selectFileButton.disableProperty().bind(messageRadioButton.selectedProperty());
        messageTextArea.disableProperty().bind(messageRadioButton.selectedProperty().map(value -> !value));
        selectFileButton.setOnAction(this::openFile);
    }

    private void openFile(final ActionEvent evt) {
        FileChooser chooser = new FileChooser();
        File file = chooser.showOpenDialog(null);
        if (file != null) {
            fileTextField.setText(file.getAbsolutePath());
        }
    }

    private boolean isMessagesEmpty() {
        boolean result;
        if (messageRadioButton.isSelected()) {
            result = messageTextArea.getText().isBlank();
        } else {
            result = fileTextField.getText().isBlank();
        }
        return result;
    }
}
