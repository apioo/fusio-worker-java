package org.fusioproject.worker.outgoing;

public class Log {
    private final String level;
    private final String message;
    private final Object context;

    public Log(String level, String message, Object context) {
        this.level = level;
        this.message = message;
        this.context = context;
    }

    public String getLevel() {
        return level;
    }

    public String getMessage() {
        return message;
    }

    public Object getContext() {
        return context;
    }
}
