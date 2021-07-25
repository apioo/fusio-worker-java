package org.fusioproject.worker.incoming;

import org.fusioproject.worker.incoming.Context;
import org.fusioproject.worker.incoming.Request;

public class Execute {
    private String action;
    private Request request;
    private Context context;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
