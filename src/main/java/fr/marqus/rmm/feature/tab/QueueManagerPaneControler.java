package fr.marqus.rmm.feature.tab;

import fr.marqus.rmm.domain.model.QueueConfig;
import fr.marqus.rmm.domain.model.QueueType;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Queue manager pane controler.
 */
public final class QueueManagerPaneControler implements Initializable {

    @FXML
    private TableColumn<QueueConfig, String> labelTableColumn;

    @FXML
    private TableColumn<QueueConfig, String> hostTableColumn;

    @FXML
    private TableColumn<QueueConfig, Integer> portTableColumn;

    @FXML
    private TableColumn<QueueConfig, String> loginTableColumn;

    @FXML
    private TableColumn<QueueConfig, String> passwordTableColumn;

    @FXML
    private TableColumn<QueueConfig, String> queueNameTableColumn;

    @FXML
    private TableColumn<QueueConfig, QueueType> queueTypeTableColumn;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initTableColumns();
    }

    private void initTableColumns() {
        labelTableColumn.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getQueueLabel()));
        hostTableColumn.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getRabbitServerPath()));
        portTableColumn.setCellValueFactory(cell -> new SimpleObjectProperty<>(cell.getValue().getRabbitServerPort()));
        loginTableColumn.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getRabbitLogin()));
        passwordTableColumn.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getRabbitPassword()));
        queueNameTableColumn.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getQueueName()));
        queueTypeTableColumn.setCellValueFactory(cell -> new SimpleObjectProperty<>(cell.getValue().getQueueType()));
    }
}
