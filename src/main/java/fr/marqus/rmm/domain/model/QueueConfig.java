package fr.marqus.rmm.domain.model;

/**
 * RabbitMQ config.
 *
 * @param queueLabel       label
 * @param rabbitServerPath RabbitMQ server path
 * @param rabbitServerPort RabbitMQ server port
 * @param rabbitLogin      login
 * @param rabbitPassword   password
 * @param queueName        queue name
 * @param queueType        queue type
 */
public record QueueConfig(String queueLabel,
                          String rabbitServerPath,
                          int rabbitServerPort,
                          String rabbitLogin,
                          String rabbitPassword,
                          String queueName,
                          QueueType queueType) {
    @Override
    public String toString() {
        return queueLabel;
    }
}
