package fr.marqus.rmm.feature.tab;

import fr.marqus.rmm.domain.model.QueueConfig;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

/**
 * Copy or move message pane controler.
 */
public final class CopyMoveMessagePaneControler implements Initializable {

    private static final String START = "Start";

    private static final String STOP = "Stop";

    private static final Image START_PICTURE = new Image(Objects.requireNonNull(CopyMoveMessagePaneControler.class.getResourceAsStream("/picture/start.png")));

    private static final Image STOP_PICTURE = new Image(Objects.requireNonNull(CopyMoveMessagePaneControler.class.getResourceAsStream("/picture/stop.png")));

    @FXML
    private ComboBox<QueueConfig> sourceQueueComboBox;

    @FXML
    private ComboBox<QueueConfig> targetQueueComboBox;

    @FXML
    private RadioButton copyRadioButton;

    @FXML
    private RadioButton moveRadioButton;

    @FXML
    private ToggleButton copyMoveButton;

    @FXML
    private ImageView copyMoveImageView;

    @Override
    public void initialize(final URL location, final ResourceBundle resources) {
        ToggleGroup group = new ToggleGroup();
        copyRadioButton.setToggleGroup(group);
        moveRadioButton.setToggleGroup(group);
        sourceQueueComboBox.getSelectionModel()
                .selectedIndexProperty()
                .addListener((obs, oldVal, newVal) -> {
                    boolean result = (newVal.intValue() == -1) || (targetQueueComboBox.getSelectionModel().getSelectedIndex() == -1);
                    copyMoveButton.setDisable(result);
                });
        targetQueueComboBox.getSelectionModel()
                .selectedIndexProperty()
                .addListener((obs, oldVal, newVal) -> {
                    boolean result = (newVal.intValue() == -1) || (sourceQueueComboBox.getSelectionModel().getSelectedIndex() == -1);
                    copyMoveButton.setDisable(result);
                });
        copyMoveImageView.setImage(START_PICTURE);
        copyMoveButton.selectedProperty().addListener((obs, oldVal, newVal) -> {
            if (Boolean.TRUE.equals(newVal)) {
                copyMoveButton.setText(STOP);
                copyMoveImageView.setImage(STOP_PICTURE);
            } else {
                copyMoveButton.setText(START);
                copyMoveImageView.setImage(START_PICTURE);
            }
        });
    }
}
