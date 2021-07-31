package org.fusioproject.worker;

import org.fusioproject.worker.generated.Log;

import java.util.ArrayList;
import java.util.List;

public class Logger {
    private final List<Log> logs = new ArrayList<>();

    public void emergency(String message, Object context) {
        this.log("EMERGENCY", message, context);
    }

    public void alert(String message, Object context) {
        this.log("ALERT", message, context);
    }

    public void critical(String message, Object context) {
        this.log("CRITICAL", message, context);
    }

    public void error(String message, Object context) {
        this.log("ERROR", message, context);
    }

    public void warning(String message, Object context) {
        this.log("WARNING", message, context);
    }

    public void notice(String message, Object context) {
        this.log("NOTICE", message, context);
    }

    public void info(String message, Object context) {
        this.log("INFO", message, context);
    }

    public void debug(String message, Object context) {
        this.log("DEBUG", message, context);
    }

    private void log(String level, String message, Object context) {
        this.logs.add(new Log(level, message));
    }

    public List<Log> getLogs() {
        return this.logs;
    }
}
