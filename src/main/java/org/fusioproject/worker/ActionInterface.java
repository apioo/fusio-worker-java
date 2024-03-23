package org.fusioproject.worker;

import org.fusioproject.worker.generated.ExecuteContext;
import org.fusioproject.worker.generated.ExecuteRequest;
import org.fusioproject.worker.generated.ResponseHTTP;

public interface ActionInterface {

    ResponseHTTP handle(ExecuteRequest request, ExecuteContext context) throws Exception;

}
