package fr.marqus.rmm.feature.tab;

/**
 * Tabs.
 */
public enum Tabs {
    SAVE_MESSAGE("/layout/SaveMessagePane.fxml", "Save message"),
    SEND_MESSAGE("/layout/SendMessagePane.fxml", "Send message"),
    QUEUE_MANAGER("/layout/QueueManagerPane.fxml", "Queue manager");

    /**
     * FXML layout path.
     */
    public final String path;

    /**
     * Tab title.
     */
    public final String title;

    Tabs(String path, String title) {
        this.path = path;
        this.title = title;
    }
}
