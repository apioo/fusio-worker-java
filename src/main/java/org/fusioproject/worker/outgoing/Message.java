package org.fusioproject.worker.outgoing;

public class Message {
    private final boolean success;
    private final String message;

    public Message(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
