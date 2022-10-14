package fr.marqus.rmm.data.model;

import fr.marqus.rmm.domain.model.QueueConfig;
import fr.marqus.rmm.domain.model.QueueType;

/**
 * RabbitMQ config raw.
 *
 * @param queueLabel       label
 * @param rabbitServerPath RabbitMQ server path
 * @param rabbitServerPort RabbitMQ server port
 * @param rabbitLogin      login
 * @param rabbitPassword   password
 * @param queueName        queue name
 * @param queueType        queue type
 */
public record QueueConfigRaw(String queueLabel,
                             String rabbitServerPath,
                             int rabbitServerPort,
                             String rabbitLogin,
                             String rabbitPassword,
                             String queueName,
                             String queueType) {

    public static QueueConfigRaw map(QueueConfig queueConfig) {
        return new QueueConfigRaw(
                queueConfig.queueLabel(),
                queueConfig.rabbitServerPath(),
                queueConfig.rabbitServerPort(),
                queueConfig.rabbitLogin(),
                queueConfig.rabbitPassword(),
                queueConfig.queueName(),
                queueConfig.queueType().toString()
        );
    }

    public QueueConfig mapToQueueConfig() {
        return new QueueConfig(
                queueLabel,
                rabbitServerPath,
                rabbitServerPort,
                rabbitLogin,
                rabbitPassword,
                queueName,
                QueueType.valueOf(queueType)
                );
    }
}
