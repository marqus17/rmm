package fr.marqus.rmm.feature.tab;

import fr.marqus.rmm.domain.model.QueueConfig;
import fr.marqus.rmm.domain.model.QueueType;
import fr.marqus.rmm.domain.repository.QueueConfigRepository;
import fr.marqus.rmm.feature.RmmFx;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Queue manager pane controler.
 */
public final class QueueManagerPaneControler implements Initializable {

    private final QueueConfigRepository queueConfigRepository = RmmFx.getDIInstance(QueueConfigRepository.class);

    @FXML
    private TableView<QueueConfig> queueConfigTableView;

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

    @FXML
    private Button addButton;

    @FXML
    private Button updateButton;

    @FXML
    private Button deleteButton;

    private FilteredList<QueueConfig> filteredQueueConfigs;


    @Override
    public void initialize(final URL location, final ResourceBundle resources) {
        initTableColumns();
        initData();
        initEvents();
        deleteButton.disableProperty().bind(queueConfigTableView.getSelectionModel().selectedIndexProperty().map(value -> value.intValue() == -1));
        updateButton.disableProperty().bind(queueConfigTableView.getSelectionModel().selectedIndexProperty().map(value -> value.intValue() == -1));
    }

    private void initTableColumns() {
        labelTableColumn.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().queueLabel()));
        hostTableColumn.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().rabbitServerPath()));
        portTableColumn.setCellValueFactory(cell -> new SimpleObjectProperty<>(cell.getValue().rabbitServerPort()));
        loginTableColumn.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().rabbitLogin()));
        passwordTableColumn.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().rabbitPassword()));
        queueNameTableColumn.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().queueName()));
        queueTypeTableColumn.setCellValueFactory(cell -> new SimpleObjectProperty<>(cell.getValue().queueType()));
    }

    private void initData() {
        filteredQueueConfigs = new FilteredList<>(queueConfigRepository.getQueueConfigs());
        SortedList<QueueConfig> sortedQueueConfigs = new SortedList<>(filteredQueueConfigs);
        queueConfigTableView.setItems(sortedQueueConfigs);
        sortedQueueConfigs.comparatorProperty().bind(queueConfigTableView.comparatorProperty());
    }

    private void initEvents() {
        addButton.setOnAction(event -> {

        });

        deleteButton.setOnAction(event -> {

        });

        updateButton.setOnAction(event -> {

        });
    }
}
