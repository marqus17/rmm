package fr.marqus.rmm.data.repository;

import fr.marqus.rmm.domain.model.QueueConfig;
import fr.marqus.rmm.domain.repository.MessageRepository;

import java.io.File;

public final class MessageRepositoryImpl implements MessageRepository {

    @Override
    public void sendMessage(QueueConfig config, String message) {

    }

    @Override
    public void sendMessages(QueueConfig config, File messageFile) {

    }

    @Override
    public void saveMessages(QueueConfig config, File messageFile) {

    }

    @Override
    public void copyMessages(QueueConfig sourceConfig, QueueConfig targetConfig) {

    }

    @Override
    public void moveMessages(QueueConfig sourceConfig, QueueConfig targetConfig) {

    }
}
