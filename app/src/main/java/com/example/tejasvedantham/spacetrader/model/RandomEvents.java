package com.example.tejasvedantham.spacetrader.model;

public enum RandomEvents {
    INCREASED_CREDITS("The galactic stock exchange paid you 100 credits!"),
    INCREASED_PRICES("The prices of all goods on this planet increased by 50%!");

    private final String message;

    /**
     * Initializes a random event
     * @param message a message representing the random event
     */
    RandomEvents(String message) {
        this.message = message;
    }

    public static RandomEvents getEventForKey(int key) {
        if (key < 0 || key >= RandomEvents.values().length) {
            return null;
        }
        return RandomEvents.values()[key];
    }

    public String getMessage() {
        return message;
    }
}
