package fr.marqus.rmm.domain.model;

/**
 * RabbitMQ queue types.
 */
public enum QueueType {
    /**
     * Classic queue.
     */
    CLASSIC("classic"),

    /**
     * Quorum queue.
     */
    QUORUM("quorum");

    /**
     * RabbitMQ queue type key.
     */
    public static final String QUEUE_TYPE_KEY = "s-queue-type";

    /**
     * Queue type label.
     */
    public final String label;

    QueueType(final String pLabel) {
        this.label = pLabel;
    }
}
