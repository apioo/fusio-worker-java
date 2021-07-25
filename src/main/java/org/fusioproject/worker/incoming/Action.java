package org.fusioproject.worker.incoming;

public class Action {
    private final String name;
    private final String code;

    public Action(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }
}
