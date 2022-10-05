package fr.marqus.rmm.feature.tab;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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
    private Button sendButton;

    @Override
    public void initialize(final URL location, final ResourceBundle resources) {
        selectFileButton.setOnAction(this::openFile);
    }

    private void openFile(final ActionEvent evt) {
        FileChooser chooser = new FileChooser();
        File file = chooser.showOpenDialog(null);
        if (file != null) {
            fileTextField.setText(file.getAbsolutePath());
        }
    }
}
