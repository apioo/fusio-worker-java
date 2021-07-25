package org.fusioproject.worker;

public abstract class ActionAbstract implements ActionInterface {

    protected Connector connector;
    protected Dispatcher dispatcher;
    protected Logger logger;
    protected ResponseBuilder response;

    public ActionAbstract(Connector connector, Dispatcher dispatcher, Logger logger) {
        this.connector = connector;
        this.dispatcher = dispatcher;
        this.logger = logger;
        this.response = new ResponseBuilder();
    }
}
