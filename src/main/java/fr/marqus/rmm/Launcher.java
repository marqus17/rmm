package fr.marqus.rmm;

import fr.marqus.rmm.feature.RmmFx;

/**
 * RabbitMQ Message Manager.
 */
public final class Launcher {

    private Launcher() {
        // Nothing to do
    }

    /**
     * Methode de lancement de l'application.
     * @param args params de lancement
     */
    public static void main(final String[] args) {
        RmmFx.main(args);
    }
}
