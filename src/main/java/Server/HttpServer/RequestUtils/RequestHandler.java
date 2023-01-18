package Server.HttpServer.RequestUtils;

import Server.HttpServer.HandlingCurlsRequest.*;
import Server.HttpServer.Http.ContentType;
import Server.HttpServer.Http.HttpStatus;
import Server.HttpServer.Http.Method;
import Server.HttpServer.UtilsServer.Request;
import Server.HttpServer.UtilsServer.Response;

import java.io.*;
import java.net.Socket;
import java.sql.SQLException;

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
            printWriter.write(
                    new Response(HttpStatus.OK, ContentType.PLAIN_TEXT, "" + HandleRequest(request)).get());
        } catch (IOException exception)
        {
            exception.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
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
    public String HandleRequest(Request request) throws SQLException {
        String input = request.getBody();
        Method method = request.getMethod();
        String path = request.getPathname();
        if(path.equals("/users")  && method == Method.POST)
        {
            input = String.valueOf(new ParseUserCreate().CreateUser(request));
        } else if (path.equals("/sessions") && method == Method.POST) {
            input = String.valueOf(new LoginInUser().UserLogIn(request));//"User Sessions-----";//String.valueOf(new LoginUser(request));
        } else if (path.equals("/packages") && method == Method.POST) {
            input =String.valueOf(new CreatePackages().CreatePackage(request)) ; //"Package created-----"; //String.valueOf(new createPackage(request));
        } else if (path.equals("/transactions/packages") && method == Method.POST) {
            input = String.valueOf(new AcquirePackage().createAcquire(request));//"Transaction and packages-----";//String.valueOf(new handlePackage(request));
        }else if (path.equals("/cards") && method == Method.GET)
        {
            input = String.valueOf(new ShowCards().ShowAcquiredCards(request));//"Getting cards back";//String.valueOf(new getCard(request));
        } else if (path.equals("/deck") && method == Method.GET) {
            input = String.valueOf(new ShowDeck().showDeck(request));// String.valueOf(new getDeck(request));
        }else if (path.equals("/deck") && method == Method.PUT)
        {
            input = String.valueOf(new ConfiguredDeck().confDeck(request)); //"Post decks";//String.valueOf(new addDeck(request));
        }
        else if (path.equals("/users/kienboec") && method == Method.GET) {
            input = String.valueOf(new ShowEditData().showEditData(request));//"Puting users";// String.valueOf(new userUpdate(request));
        } else if (path.equals("/users/altenhof") && method == Method.GET) {
            input = String.valueOf(new ShowEditData().showEditData(request));}

        else if (path.equals("/users/kienboec") && method == Method.PUT) {
            input = String.valueOf(new editPutData().putData(request));//"Puting users";// String.valueOf(new userUpdate(request));
        } else if (path.equals("/users/altenhof") && method == Method.PUT) {
            input = String.valueOf(new editPutData().putData(request));//"Puting users";// String.valueOf(new userUpdate(request));
        }
        else if (path.equals("/users/someGuy") && method == Method.GET) {
            input = String.valueOf(new editPutData().ERROR());//"Puting users";// String.valueOf(new userUpdate(request));
        }
        else if (path.equals("/stats") && method == Method.GET) {
            input = String.valueOf(new showStats().getStats(request));//"get stats";
        } else if (path.equals("/battles") && method == Method.POST) {
            input = String.valueOf(new battles().uBattles(request));//"post battles";
        } else if (path.equals("/score") && method == Method.GET) {
            input = String.valueOf(new scoreboard().showScore(request));// "get score";
        } else if (path.equals("/tradings") && method == Method.GET) {
            input = String.valueOf(new Trading().showTrading(request));//"get trading";
        } else if (path.equals("/tradings") && method == Method.POST) {
            input = String.valueOf(new Trading().createTrading(request));//"create tradings";
        } else if (path.equals("/tradings/6cd85277-4590-49d4-b0cf-ba0a921faad0") && method == Method.DELETE) {
            input =String.valueOf(new Trading().deleteTrading(request)) ;//" delete tradings";
        } else if (path.equals("/tradings/6cd85277-4590-49d4-b0cf-ba0a921faad0") && method == Method.POST) {
            input = String.valueOf(new Trading().tryToTrade(request)) ;//String.valueOf(new Trading().deleteTrading(request)) ;//" delete tradings";
        }
        return input;
    }


    }