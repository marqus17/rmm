package fr.marqus.rmm.feature.tab;

import fr.marqus.rmm.domain.model.QueueConfig;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Copy or move message pane controler.
 */
public final class CopyMoveMessagePaneControler implements Initializable {

    @FXML
    private ComboBox<QueueConfig> sourceQueueComboBox;

    @FXML
    private ComboBox<QueueConfig> targetQueueComboBox;

    @FXML
    private RadioButton copyRadioButton;

    @FXML
    private RadioButton moveRadioButton;

    @FXML
    private Button copyMoveButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO : add code
    }
}
