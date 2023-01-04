package Server.HttpServer.Echo;

import Server.HttpServer.Http.ContentType;
import Server.HttpServer.Http.HttpStatus;
import Server.HttpServer.UtilsServer.HandleRequestService;
import Server.HttpServer.UtilsServer.Request;
import Server.HttpServer.UtilsServer.Response;

public class EchoService implements HandleRequestService {
    @Override
    public Response requestHandle(Request request) {
        return new Response(HttpStatus.OK,
                ContentType.PLAIN_TEXT,
                "Echo-" + request.getBody());
    }
}