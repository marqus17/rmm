package fr.marqus.rmm.domain.model;

/**
 * RabbitMQ queue types.
 */
public enum QueueType {
    CLASSIC("classic"),
    QUORUM("quorum");

    public final String label;

    QueueType(String label) {
        this.label = label;
    }
}
