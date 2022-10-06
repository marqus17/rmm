package fr.marqus.rmm.domain.repository;

import fr.marqus.rmm.domain.model.QueueConfig;
import javafx.collections.ObservableList;

/**
 * Queue config repository.
 */
public interface QueueConfigRepository {

    /**
     * Get queue config observable list.
     *
     * @return queue config observable list.
     */
    ObservableList<QueueConfig> getQueueConfigs();

    /**
     * Add a new queue config.
     *
     * @param config new queue config
     */
    void addQueueConfig(QueueConfig config);

    /**
     * Remove a queue config.
     *
     * @param config queue config to remove
     */
    void removeQueueConfig(QueueConfig config);

    /**
     * Update a queue config.
     *
     * @param config queue config to update
     */
    void updateQueueConfig(QueueConfig config);
}
