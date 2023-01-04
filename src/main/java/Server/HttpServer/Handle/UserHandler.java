package Server.HttpServer.Handle;

import Server.HttpServer.*;
import Server.HttpServer.Http.ContentType;
import Server.HttpServer.Http.HttpStatus;
import Server.HttpServer.Http.Method;
import Server.HttpServer.UtilsServer.HandleRequestService;
import Server.HttpServer.UtilsServer.Request;
import Server.HttpServer.UtilsServer.Response;

public class UserHandler implements HandleRequestService {

    private final createUser userCreate;

    public UserHandler() {
        this.userCreate = new createUser();
    }

    @Override
    public Response requestHandle(Request request) {
        if(request.getMethod()== Method.GET && request.getPathParts().size() > 1)
        {
            return this.userCreate.getUser(request.getPathParts().get(1));
        } else if (request.getMethod() == Method.GET) {
            return this.userCreate.getUser();
        } else if (request.getMethod() == Method.POST) {
            return this.userCreate.createUser(request);
        }
        return new Response(HttpStatus.BAD_REQUEST, ContentType.JSON,"[]");
    }
/*
    public String TestRequest(Request request)
    {
        String input = request.getBody();
        Method method = request.getMethod();
        String path = request.getPathname();
        if(path.equals("/user")  && method == Method.POST)
        {
            input = String.valueOf(new createUser()); // muss implementiert werden
        } else if (path.equals("/sessions") && method == Method.POST) {
            input = String.valueOf(new LoginUser());
        } else if (path.equals("/packages") && method == Method.POST) {
            input = String.valueOf(new createPackage());
        } else if (path.equals("/transactions/packages") && method == Method.POST) {
            input = String.valueOf(new handlePackage());
        }else if ()
        {

        }

  */
}
