package Server;

//import sun.net.www.protocol.file.FileURLConnection;

import java.io.*;
import java.net.Socket;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

public class RequestHandler /*implements Runnable*/ {
    //HTTP parse
    private String method; // alle fetchen
    private String path;
   // private Map<String,String> headers =new HashMap<>();
  //Map von Enpoints
    private Map<String, Endpoint> endpointMap = new HashMap<>();

   // private socket clientConnection;
    public RequestHandler(Socket clientConnection) {

    }

    private String getRequest(){return "Hello"; //READER, BUILDER//
         }

    //  @Override

    public <Request> void run() {
        PrintWriter printWriter = null;//neu
        BufferedReader bufferedReader = null; // neu
        //FileURLConnection clientConnection;
        try{
            //InputStream inputStream clientConnection.getInputStream();
            //InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
             //bufferedReader= new BufferedReader(inputStreamReader);
             //OutputStream outputStream = clientConnection.getOutputStream();
             //printWriter = new PrintWriter(outputStream);

            //Request request = new RequestBuilder().buildRequest(bufferedReader);
            printWriter.write( "http/1.1 200 Ok\r\nContent-Type \r\n");
            printWriter.close();
            bufferedReader.close();


        }catch (IOException exception)
        {
            exception.printStackTrace();
        }

        finally{
            try{


            if(printWriter != null)
            {
                printWriter.close();
            }
            if(bufferedReader != null)
            {
                bufferedReader.close();
               // clientConnection.close();

            }
            }
            catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }


}
/*
void testEchoServer() throws Exception
{
    Url url = new Url("http://localhost8080");
    URLConnection urlConnection = url.openConnection();
    urlConnection =

}
//cLASSE REQUEST BUILDER
public Request buildRequest(BufferedReader bufferedReader) throws IOException
{
    Request request = new Request();
    setParthname(reuqest, splitFirstline)
}

 */