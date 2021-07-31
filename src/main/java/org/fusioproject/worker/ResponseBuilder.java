package org.fusioproject.worker;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.fusioproject.worker.generated.Response;

import java.util.Map;

public class ResponseBuilder {
    private final ObjectMapper objectMapper;

    public ResponseBuilder() {
        this.objectMapper = new ObjectMapper();
    }

    public Response build(int statusCode, Map<String, String> headers, Object body) throws JsonProcessingException {
        return new Response(statusCode, headers, this.objectMapper.writeValueAsString(body));
    }
}
