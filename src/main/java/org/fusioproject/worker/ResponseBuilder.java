package org.fusioproject.worker;

import org.fusioproject.worker.outgoing.Response;

public class ResponseBuilder {
    public Response build(int statusCode, Object headers, Object body)
    {
        return new Response(statusCode, headers, body);
    }
}
