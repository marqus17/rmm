package fr.marqus.rmm.data.api;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import fr.marqus.rmm.domain.model.QueueConfig;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * RabbitMQ API.
 */
public final class RabbitMQAPI {

    /**
     * Send message.
     *
     * @param config  queue config
     * @param message message to send
     */
    public void sendMessage(QueueConfig config, String message) {
        try (Connection conn = getConnection(config); Channel channel = conn.createChannel()) {
            channel.queueDeclare(config.queueName(), true, false, false, config.getArguments());
            channel.basicPublish("", config.queueName(), null, message.getBytes());
        } catch (IOException | TimeoutException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Send messages.
     *
     * @param config  queue config
     * @param fichier file who contain messages (one per line)
     */
    public void sendMessages(QueueConfig config, File fichier) {
        try (Connection conn = getConnection(config); Channel channel = conn.createChannel()) {
            channel.queueDeclare(config.queueName(), true, false, false, config.getArguments());
            try (FileReader fr = new FileReader(fichier); BufferedReader br = new BufferedReader(fr)) {
                br.lines()
                        .forEach(message -> {
                            try {
                                channel.basicPublish("", config.queueName(), null, message.getBytes());
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        });
            }
        } catch (IOException | TimeoutException e) {
            throw new RuntimeException(e);
        }
    }

    private Connection getConnection(QueueConfig config) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(config.rabbitServerPath());
        factory.setPort(config.rabbitServerPort());
        factory.setUsername(config.rabbitLogin());
        factory.setPassword(config.rabbitPassword());
        return factory.newConnection();
    }
}
