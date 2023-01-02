package Server.HttpServer.RequestUtils;

import Server.HttpServer.Http.ContentType;
import Server.HttpServer.Http.HttpStatus;
import Server.HttpServer.Http.Method;
import Server.HttpServer.UtilsServer.Request;
import Server.HttpServer.UtilsServer.Response;
import Server.HttpServer.createUser;

import java.io.*;
import java.net.Socket;

public class RequestHandler implements  Runnable{

    private Socket clientConnection;
     private Route router;
     private  PrintWriter printWriter;
     private  BufferedReader bufferedReader;


    //public Router router;
    public RequestHandler(Socket clientConnection, Route router) throws IOException {
        this.clientConnection = clientConnection;
        this.bufferedReader = new BufferedReader(new InputStreamReader(this.clientConnection.getInputStream())); //
        this.printWriter = new PrintWriter(this.clientConnection.getOutputStream(), true);//
        this.router = router;//
    }

    @Override
    public void run() {
        BufferedReader bufferedReader = null;
        PrintWriter printWriter = null;
        try {
            //Read the request stream from the browser // we take or get it also from our socket/client connection
            InputStream inputStream = clientConnection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(inputStreamReader);
            OutputStream outputStream = clientConnection.getOutputStream();
            printWriter = new PrintWriter(outputStream);
            String htmlTitle = "<html><head><title>CardGame/Mustafa Sahin</title></head><body><h1>Test Test</h1></body></html>";



            int _test;
            while((_test= inputStream.read()) >=0)
            {
                System.out.println((char) _test);
            }
            //String testResponse= ""

            Request request = new RequestBuilder().buildRequest(bufferedReader);
            printWriter.write(new Response(HttpStatus.OK, ContentType.PLAIN_TEXT, "Verbindungs Test:Echo-").get());
            //printWriter.write(new Response(HttpStatus.OK, ContentType.JSON, "Hello wolrd !!!  " + request.getBody()).get());
        } catch (IOException exception)
        {
            exception.printStackTrace();
        }
        finally {
            try {
                if (printWriter != null){
                    printWriter.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                    clientConnection.close();
                }
            }catch (IOException exception)
            {
                exception.printStackTrace();
            }
        }
    }
    public String TestRequest(Request request)
    {
        String input = request.getBody();
        Method method = request.getMethod();
        String path = request.getPathname();
        if(path.equals("/user")  && method == Method.POST)
        {
            input = String.valueOf(new createUser()); // muss implementiert werden
        } else if (path.equals("/sessions") && method == Method.POST) {
            input = String.valueOf(new LoginUser(request));
        } else if (path.equals("/packages") && method == Method.POST) {
            input = String.valueOf(new createPackage(request));
        } else if (path.equals("/transactions/packages") && method == Method.POST) {
            input = String.valueOf(new handlePackage(request));
        }else if (path.equals("/cards") && method == Method.GET)
        {
            input = String.valueOf(new getCard(request));
        } else if (path.equals("/deck") && method == Method.GET) {
            input = String.valueOf(new getDeck(request));
        }else if (path.equals("/deck") && method == Method.POST)
        {
            input = String.valueOf(new addDeck(request));
        } else if (path.equals("/users/") && method == Method.PUT) {
            input = String.valueOf(new userUpdate(request));
        } else if (path.equals("/stats") && method == Method.GET) {
            input = "get stats";
        } else if (path.equals("/battles") && method == Method.POST) {
            input = "post battles";
        } else if (path.equals("/score") && method == Method.GET) {
            input = "get score";
        } else if (path.equals("/tradings") && method == Method.GET) {
            input = "get trading";
        } else if (path.equals("/tradings") && method == Method.POST) {
            input = "create tradings";
        } else if (path.equals("/tradings/") && method == Method.DELETE) {
            input = " delete tradings";
        }
        return input;
    }
}