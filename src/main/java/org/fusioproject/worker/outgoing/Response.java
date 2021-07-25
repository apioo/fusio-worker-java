package org.fusioproject.worker.outgoing;

public class Response {
    private final int statusCode;
    private final Object headers;
    private final Object body;

    public Response(int statusCode, Object headers, Object body) {
        this.statusCode = statusCode;
        this.headers = headers;
        this.body = body;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public Object getHeaders() {
        return headers;
    }

    public Object getBody() {
        return body;
    }
}
