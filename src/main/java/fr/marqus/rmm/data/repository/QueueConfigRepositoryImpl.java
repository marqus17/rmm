package fr.marqus.rmm.data.repository;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import fr.marqus.rmm.data.database.QueueConfigDAO;
import fr.marqus.rmm.data.model.QueueConfigRaw;
import fr.marqus.rmm.domain.model.QueueConfig;
import fr.marqus.rmm.domain.repository.QueueConfigRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Queue config repository implementation.
 */
@Singleton
public final class QueueConfigRepositoryImpl implements QueueConfigRepository {

    private final ObservableList<QueueConfig> queueConfigs = FXCollections.observableArrayList();

    private final QueueConfigDAO queueConfigDAO = new QueueConfigDAO();

    @Inject
    private QueueConfigRepositoryImpl() {
        queueConfigDAO.getQueueConfigs()
                .stream()
                .map(QueueConfigRaw::mapToQueueConfig)
                .forEach(queueConfigs::add);
    }

    @Override
    public ObservableList<QueueConfig> getQueueConfigs() {
        return queueConfigs;
    }

    @Override
    public void addQueueConfig(QueueConfig config) {
        queueConfigDAO.addQueueConfig(QueueConfigRaw.map(config));
        queueConfigs.add(config);
    }

    @Override
    public void removeQueueConfig(QueueConfig config) {
        queueConfigDAO.deleteQueueConfig(config.queueLabel());
        queueConfigs.removeIf(value -> value.queueName().equals(config.queueName()));
    }

    @Override
    public void updateQueueConfig(QueueConfig config) {
        queueConfigDAO.updateQueueConfig(QueueConfigRaw.map(config));
        removeQueueConfig(config);
        addQueueConfig(config);
    }
}
