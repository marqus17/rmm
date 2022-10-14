package fr.marqus.rmm.feature.queueconfig;

import fr.marqus.rmm.domain.model.QueueConfig;
import fr.marqus.rmm.domain.model.QueueType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public final class QueueConfigEditorPaneControler implements Initializable {

    private static final int MIN_PORT = 1;

    private static final int MAX_PORT = 65536;

    private static final int DEFAULT_PORT = 666;

    @FXML
    private TextField labelTextField;

    @FXML
    private TextField hostTextField;

    @FXML
    private TextField queueNameTextField;

    @FXML
    private TextField loginTextField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private ComboBox<QueueType> queueTypeComboBox;

    @FXML
    private Spinner<Integer> portSpinner;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        queueTypeComboBox.getItems().addAll(QueueType.values());
        portSpinner.setValueFactory(
                new SpinnerValueFactory.IntegerSpinnerValueFactory(MIN_PORT, MAX_PORT, DEFAULT_PORT)
        );
    }

    public QueueConfig getQueueConfig() {
        return new QueueConfig(
                labelTextField.getText(),
                hostTextField.getText(),
                portSpinner.getValue(),
                loginTextField.getText(),
                passwordField.getText(),
                queueNameTextField.getText(),
                queueTypeComboBox.getValue()
        );
    }

    public void setQueueConfig(final QueueConfig queueConfig) {
        labelTextField.setText(queueConfig.queueLabel());
        labelTextField.setDisable(true);
        hostTextField.setText(queueConfig.rabbitServerPath());
        queueNameTextField.setText(queueConfig.queueName());
        loginTextField.setText(queueConfig.rabbitLogin());
        passwordField.setText(queueConfig.rabbitPassword());
        portSpinner.getValueFactory().setValue(queueConfig.rabbitServerPort());
        queueTypeComboBox.getSelectionModel().select(queueConfig.queueType());
    }
}
