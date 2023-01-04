package Server.HttpServer.UtilsServer;

import Server.HttpServer.UtilsServer.Request;
import Server.HttpServer.UtilsServer.Response;

public interface HandleRequestService {
    Response requestHandle(Request request);
}
