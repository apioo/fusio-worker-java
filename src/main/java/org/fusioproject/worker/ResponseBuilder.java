package org.fusioproject.worker;

import org.fusioproject.worker.generated.ResponseHTTP;

import java.util.Map;

public class ResponseBuilder {
    private ResponseHTTP response;

    public void build(int statusCode, Map<String, String> headers, Object body) {
        this.response = new ResponseHTTP();
        this.response.setStatusCode(statusCode);
        this.response.setHeaders(headers);
        this.response.setBody(body);
    }

    public ResponseHTTP getResponse() {
        return this.response;
    }
}
