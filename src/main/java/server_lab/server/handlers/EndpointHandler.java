package server_lab.server.handlers;

import server_lab.exception.HandleException;

public interface EndpointHandler {
    String handel(String json) throws HandleException;
}
