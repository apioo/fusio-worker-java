package org.fusioproject.worker;

import org.fusioproject.worker.incoming.Context;
import org.fusioproject.worker.incoming.Request;
import org.fusioproject.worker.outgoing.Response;

public interface ActionInterface {

    public Response request(Request request, Context context);

}
