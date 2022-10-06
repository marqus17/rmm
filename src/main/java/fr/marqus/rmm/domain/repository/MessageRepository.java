package fr.marqus.rmm.domain.repository;

import fr.marqus.rmm.domain.model.QueueConfig;

import java.io.File;

/**
 * Message repository.
 */
public interface MessageRepository {

    /**
     * Send a message.
     *
     * @param config  queue config
     * @param message message to send
     */
    void sendMessage(final QueueConfig config, final String message);

    /**
     * Send messages.
     *
     * @param config      queue config
     * @param messageFile file that contains messages
     */
    void sendMessages(final QueueConfig config, final File messageFile);

    /**
     * Save messages on a text file.
     *
     * @param config      queue config
     * @param messageFile file where messages will be saved
     */
    void saveMessages(final QueueConfig config, final File messageFile);

    /**
     * Copy messages from a queue to an other-one.
     *
     * @param sourceConfig source queue config
     * @param targetConfig target queue config
     */
    void copyMessages(final QueueConfig sourceConfig, final QueueConfig targetConfig);

    /**
     * Move messages from a queue to an other queue.
     *
     * @param sourceConfig source queue config
     * @param targetConfig target queue config
     */
    void moveMessages(final QueueConfig sourceConfig, final QueueConfig targetConfig);
}
