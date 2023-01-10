package Server.HttpServer.RequestUtils;

import Server.Connection.UserDaoImpl;
import Server.HttpServer.HandlingCurlsRequest.AcquirePackage;
import Server.HttpServer.HandlingCurlsRequest.CreatePackages;
import Server.HttpServer.HandlingCurlsRequest.LoginInUser;
import Server.HttpServer.Http.ContentType;
import Server.HttpServer.Http.HttpStatus;
import Server.HttpServer.Http.Method;
import Server.HttpServer.HandlingCurlsRequest.ParseUserCreate;
import Server.HttpServer.UtilsServer.Request;
import Server.HttpServer.UtilsServer.Response;

import java.io.*;
import java.net.Socket;

import static com.sun.javafx.util.Utils.split;

public class RequestHandler implements  Runnable{

    private Socket clientConnection;
    public RequestHandler(Socket clientConnection) {
        this.clientConnection = clientConnection;
    }

    @Override
    public void run() {
        BufferedReader bufferedReader = null;
        PrintWriter printWriter = null;
        try {
            InputStream inputStream = clientConnection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(inputStreamReader);
            OutputStream outputStream = clientConnection.getOutputStream();
            printWriter = new PrintWriter(outputStream);

            Request request = new RequestBuilder().buildRequest(bufferedReader);
            //TestRequest(request);
            printWriter.write(

                    new Response(HttpStatus.OK, ContentType.PLAIN_TEXT, "Echo-" + TestRequest(request)).get());
                   // TestRequest(request);
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
        if(path.equals("/users")  && method == Method.POST)
        {
            input = /*"CreatedUser--------";///CreateUserTwo(request);/*/String.valueOf(new ParseUserCreate().CreateUser(request)); // muss implementiert werden
        } else if (path.equals("/sessions") && method == Method.POST) {
            input = String.valueOf(new LoginInUser().UserLogIn(request));//"User Sessions-----";//String.valueOf(new LoginUser(request));
        } else if (path.equals("/packages") && method == Method.POST) {
            input =String.valueOf(new CreatePackages().CreatePackage(request)) ; //"Package created-----"; //String.valueOf(new createPackage(request));
        } else if (path.equals("/transactions/packages") && method == Method.POST) {
            input = String.valueOf(new AcquirePackage().createAcquire(request));//"Transaction and packages-----";//String.valueOf(new handlePackage(request));
        }else if (path.equals("/cards") && method == Method.GET)
        {
            input = "Getting cards back";//String.valueOf(new getCard(request));
        } else if (path.equals("/deck") && method == Method.GET) {
            input = "Getting Deck";// String.valueOf(new getDeck(request));
        }else if (path.equals("/deck") && method == Method.POST)
        {
            input = "Post decks";//String.valueOf(new addDeck(request));
        } else if (path.equals("/users/") && method == Method.PUT) {
            input = "Puting users";// String.valueOf(new userUpdate(request));
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



    public String CreateUserTwo(Request request) // to get the request
    {
        UserDaoImpl userDb= new UserDaoImpl();
         String username = null;
         String password = null;
        String StringItemStorage;
         String SplitViaDoublePoint[] = new String[0];
        UserDaoImpl createUserDatabase = new UserDaoImpl();
         String cutFirst;
         String cutSecond;
        System.out.println("TEST---");

        String userBody = request.getBody();
        String[] valuePair =  split(userBody,","); // userbody.split(",);
        System.out.println(userBody);
        for(int i = 0 ; i < valuePair.length; i++)
        {        System.out.println("TEST---");

            StringItemStorage  = valuePair[i];  // itertae through the array and store it every time in key Value
            for (String s : SplitViaDoublePoint) {
                cutFirst = SplitViaDoublePoint[0].trim();
                cutSecond = SplitViaDoublePoint[1].trim();
                if(cutFirst.charAt(0) == '{')
                {
                    cutFirst = cutFirst.substring(1);
                }
                if(cutSecond.endsWith("}"))
                {
                    cutSecond = cutSecond.substring(0,cutSecond.length()-1);
                }
                cutSecond = cutSecond.substring(1, cutSecond.length()-1);

                if(cutFirst.equals("\"Username\""))
                {
                    username = cutSecond;
                    System.out.println(username);
                } else if (cutFirst.equals("\"Password\"")) {
                    password = cutSecond;
                    System.out.println(password);
                }
            }

            // [] = StringItemStorage.split(":");
            // cutFirst = SplitViaDoublePoint

        }

        // String []



        //Server connection and add
        String conn = createUserDatabase.add(username,password);
        //   Connection conn = userDb.add(username,password);
        //_userContent = String.valueOf(conn);
        System.out.println("TEST---");
        return conn;
    }

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
            input = "User Created";//String.valueOf(new LoginUser(request));
        } else if (path.equals("/packages") && method == Method.POST) {
            input ="Package created"; //String.valueOf(new createPackage(request));
        } else if (path.equals("/transactions/packages") && method == Method.POST) {
            input = "Transaction and packages";//String.valueOf(new handlePackage(request));
        }else if (path.equals("/cards") && method == Method.GET)
        {
            input = "Getting cards back";//String.valueOf(new getCard(request));
        } else if (path.equals("/deck") && method == Method.GET) {
            input = "Getting Deck";// String.valueOf(new getDeck(request));
        }else if (path.equals("/deck") && method == Method.POST)
        {
            input = "Post decks";//String.valueOf(new addDeck(request));
        } else if (path.equals("/users/") && method == Method.PUT) {
            input = "Puting users";// String.valueOf(new userUpdate(request));
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
    }*/
