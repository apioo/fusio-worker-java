package org.fusioproject.worker;

import org.fusioproject.worker.generated.ResponseLog;

import java.util.ArrayList;
import java.util.List;

public class Logger {
    private final List<ResponseLog> logs = new ArrayList<>();

    public void emergency(String message, Object context) {
        this.log("EMERGENCY", message);
    }

    public void alert(String message, Object context) {
        this.log("ALERT", message);
    }

    public void critical(String message, Object context) {
        this.log("CRITICAL", message);
    }

    public void error(String message, Object context) {
        this.log("ERROR", message);
    }

    public void warning(String message, Object context) {
        this.log("WARNING", message);
    }

    public void notice(String message, Object context) {
        this.log("NOTICE", message);
    }

    public void info(String message, Object context) {
        this.log("INFO", message);
    }

    public void debug(String message, Object context) {
        this.log("DEBUG", message);
    }

    private void log(String level, String message) {
        ResponseLog log = new ResponseLog();
        log.setLevel(level);
        log.setMessage(message);

        this.logs.add(log);
    }

    public List<ResponseLog> getLogs() {
        return this.logs;
    }
}
