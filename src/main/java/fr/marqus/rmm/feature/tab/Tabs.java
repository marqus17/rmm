package fr.marqus.rmm.feature.tab;

/**
 * Tabs.
 */
public enum Tabs {
    /**
     * Copy or move message tab content.
     */
    COPY_MOVE_MESSAGE("/layout/CopyMoveMessagePane.fxml", "Copy or move message"),

    /**
     * Save messages tab content.
     */
    SAVE_MESSAGE("/layout/SaveMessagePane.fxml", "Save message"),

    /**
     * Send messages tab content.
     */
    SEND_MESSAGE("/layout/SendMessagePane.fxml", "Send message"),

    /**
     * Queue manager tab content.
     */
    QUEUE_MANAGER("/layout/QueueManagerPane.fxml", "Queue manager");

    /**
     * FXML layout path.
     */
    public final String path;

    /**
     * Tab title.
     */
    public final String title;

    Tabs(final String pPath, final String pTitle) {
        this.path = pPath;
        this.title = pTitle;
    }
}
