package fr.marqus.rmm.domain.repository;

import com.google.inject.AbstractModule;
import fr.marqus.rmm.data.repository.MessageRepositoryImpl;
import fr.marqus.rmm.data.repository.QueueConfigRepositoryImpl;

/**
 * Repository module for DI.
 */
public final class RepositoryModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(QueueConfigRepository.class).to(QueueConfigRepositoryImpl.class);
        bind(MessageRepository.class).to(MessageRepositoryImpl.class);
    }
}
