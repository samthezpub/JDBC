package org.example;

public class Message {
    private final String message;
    private final String type;
    private final boolean processed;

    public Message(String message, TypeEnum type, boolean processed) {
        this.message = message;
        this.type = type.toString();
        this.processed = processed;
    }

    public String getMessage() {
        return message;
    }

    public String getType() {
        return type;
    }

    public boolean isProcessed() {
        return processed;
    }
}
