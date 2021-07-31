package org.fusioproject.worker;

import org.fusioproject.worker.generated.Context;
import org.fusioproject.worker.generated.Request;
import org.fusioproject.worker.generated.Response;

public interface ActionInterface {

    Response handle(Request request, Context context) throws Exception;

}
