package fr.marqus.rmm.domain.model;

import java.util.HashMap;
import java.util.Map;

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

    /**
     * Get arguments map.
     *
     * @return the arguments map
     */
    public Map<String, Object> getArguments() {
        Map<String, Object> map = new HashMap<>();
        map.put(QueueType.QUEUE_TYPE_KEY, queueType.label);
        return map;
    }

    @Override
    public String toString() {
        return queueLabel;
    }
}
