package org.fusioproject.worker.generated;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
public class ExecuteContextApp {
    private Boolean anonymous;
    private Integer id;
    private String name;
    @JsonSetter("anonymous")
    public void setAnonymous(Boolean anonymous) {
        this.anonymous = anonymous;
    }
    @JsonGetter("anonymous")
    public Boolean getAnonymous() {
        return this.anonymous;
    }
    @JsonSetter("id")
    public void setId(Integer id) {
        this.id = id;
    }
    @JsonGetter("id")
    public Integer getId() {
        return this.id;
    }
    @JsonSetter("name")
    public void setName(String name) {
        this.name = name;
    }
    @JsonGetter("name")
    public String getName() {
        return this.name;
    }
}
