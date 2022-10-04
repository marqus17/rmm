package fr.marqus.rmm.domain.model;

/**
 * RabbitMQ config.
 */
public final class QueueConfig {

    private final String queueLabel;

    private final String rabbitServerPath;

    private final int rabbitServerPort;

    private final String rabbitLogin;

    private final String rabbitPassword;

    private final String queueName;

    private final QueueType queueType;

    /**
     * RabbitMQ queue config constructor.
     *
     * @param queueLabel       label of the queue
     * @param rabbitServerPath path of the rabbitMQ server
     * @param rabbitServerPort port of the rabbitMQ server
     * @param rabbitLogin      rabbitMQ login
     * @param rabbitPassword   rabbitMQ password
     * @param queueName        queue name
     * @param queueType        queue type
     */
    public QueueConfig(String queueLabel, String rabbitServerPath, int rabbitServerPort, String rabbitLogin, String rabbitPassword, String queueName, QueueType queueType) {
        this.queueLabel = queueLabel;
        this.rabbitServerPath = rabbitServerPath;
        this.rabbitServerPort = rabbitServerPort;
        this.rabbitLogin = rabbitLogin;
        this.rabbitPassword = rabbitPassword;
        this.queueName = queueName;
        this.queueType = queueType;
    }

    public String getQueueLabel() {
        return queueLabel;
    }

    public String getRabbitServerPath() {
        return rabbitServerPath;
    }

    public int getRabbitServerPort() {
        return rabbitServerPort;
    }

    public String getRabbitLogin() {
        return rabbitLogin;
    }

    public String getRabbitPassword() {
        return rabbitPassword;
    }

    public String getQueueName() {
        return queueName;
    }

    public QueueType getQueueType() {
        return queueType;
    }

    @Override
    public String toString() {
        return queueLabel;
    }
}
