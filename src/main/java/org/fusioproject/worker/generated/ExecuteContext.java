package org.fusioproject.worker.generated;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
public class ExecuteContext {
    private Integer operationId;
    private String baseUrl;
    private String tenantId;
    private String action;
    private ExecuteContextApp app;
    private ExecuteContextUser user;
    @JsonSetter("operationId")
    public void setOperationId(Integer operationId) {
        this.operationId = operationId;
    }
    @JsonGetter("operationId")
    public Integer getOperationId() {
        return this.operationId;
    }
    @JsonSetter("baseUrl")
    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }
    @JsonGetter("baseUrl")
    public String getBaseUrl() {
        return this.baseUrl;
    }
    @JsonSetter("tenantId")
    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }
    @JsonGetter("tenantId")
    public String getTenantId() {
        return this.tenantId;
    }
    @JsonSetter("action")
    public void setAction(String action) {
        this.action = action;
    }
    @JsonGetter("action")
    public String getAction() {
        return this.action;
    }
    @JsonSetter("app")
    public void setApp(ExecuteContextApp app) {
        this.app = app;
    }
    @JsonGetter("app")
    public ExecuteContextApp getApp() {
        return this.app;
    }
    @JsonSetter("user")
    public void setUser(ExecuteContextUser user) {
        this.user = user;
    }
    @JsonGetter("user")
    public ExecuteContextUser getUser() {
        return this.user;
    }
}
