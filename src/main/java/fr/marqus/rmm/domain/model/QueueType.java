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
     * Queue type label.
     */
    public final String label;

    QueueType(final String pLabel) {
        this.label = pLabel;
    }
}
