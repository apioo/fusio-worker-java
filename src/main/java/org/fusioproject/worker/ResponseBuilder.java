package org.fusioproject.worker;

import org.fusioproject.worker.generated.ResponseHTTP;

import java.util.Map;

public class ResponseBuilder {
    public ResponseHTTP build(int statusCode, Map<String, String> headers, Object body) {
        ResponseHTTP response = new ResponseHTTP();
        response.setStatusCode(statusCode);
        response.setHeaders(headers);
        response.setBody(body);

        return response;
    }
}
