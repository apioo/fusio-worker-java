package org.fusioproject.worker.generated;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
public class ExecuteContextUser {
    private Boolean anonymous;
    private Integer id;
    private String planId;
    private String name;
    private String email;
    private Integer points;
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
    @JsonSetter("planId")
    public void setPlanId(String planId) {
        this.planId = planId;
    }
    @JsonGetter("planId")
    public String getPlanId() {
        return this.planId;
    }
    @JsonSetter("name")
    public void setName(String name) {
        this.name = name;
    }
    @JsonGetter("name")
    public String getName() {
        return this.name;
    }
    @JsonSetter("email")
    public void setEmail(String email) {
        this.email = email;
    }
    @JsonGetter("email")
    public String getEmail() {
        return this.email;
    }
    @JsonSetter("points")
    public void setPoints(Integer points) {
        this.points = points;
    }
    @JsonGetter("points")
    public Integer getPoints() {
        return this.points;
    }
}
