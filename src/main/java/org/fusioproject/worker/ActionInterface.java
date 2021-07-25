package org.fusioproject.worker;

import org.fusioproject.worker.incoming.Context;
import org.fusioproject.worker.incoming.Request;
import org.fusioproject.worker.outgoing.Response;

public interface ActionInterface {

    Response handle(Request request, Context context) throws Exception;

}
