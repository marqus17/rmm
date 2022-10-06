package fr.marqus.rmm.data.repository;

import com.google.inject.Inject;
import com.google.inject.Singleton;
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

    @Inject
    private QueueConfigRepositoryImpl() {
        // Nothing to do.
    }

    @Override
    public ObservableList<QueueConfig> getQueueConfigs() {
        return queueConfigs;
    }

    @Override
    public void addQueueConfig(QueueConfig config) {
        queueConfigs.add(config);
    }

    @Override
    public void removeQueueConfig(QueueConfig config) {
        queueConfigs.removeIf(value -> value.queueName().equals(config.queueName()));
    }

    @Override
    public void updateQueueConfig(QueueConfig config) {
        removeQueueConfig(config);
        queueConfigs.add(config);
    }
}
