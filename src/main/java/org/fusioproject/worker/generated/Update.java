package org.fusioproject.worker.generated;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
public class Update {
    private String code;
    @JsonSetter("code")
    public void setCode(String code) {
        this.code = code;
    }
    @JsonGetter("code")
    public String getCode() {
        return this.code;
    }
}
