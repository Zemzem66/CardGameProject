package Server.HttpServer;

import java.io.*;
import java.net.Socket;

public class RequestHandler implements  Runnable{

    private Socket clientConnection;
     private  Route router;
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
            printWriter.write(new Response(HttpStatus.OK, ContentType.PLAIN_TEXT, "Verbindungs Test:Echo-",htmlTitle.getBytes().length + request.getBody()).get()) ;
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
}