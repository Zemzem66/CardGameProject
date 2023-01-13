package Server.HttpServer.HandlingCurlsRequest;
import Server.Connection.DriverMangerConnection;
import Server.Connection.UserDaoImpl;
import Server.HttpServer.UtilsServer.Request;

import java.sql.Connection;

import static com.sun.javafx.util.Utils.split;

public class ParseUserCreate {

    public String _userContent;
    UserDaoImpl userDb= new UserDaoImpl();
    public String username;
    public String password;
    int token= 20;
    int elo = 100;
    int wins = 0;
    int games = 0;
    public String StringItemStorage;
    public String SplitViaDoublePoint[];
    UserDaoImpl createUserDatabase = new UserDaoImpl();
    public String cutFirst;
    public String cutSecond;

    public String CreateUser(Request request) // to get the request
    {
        System.out.println("TEST---");

        String userBody = request.getBody();
        String[] valuePair = userBody.split(",");
        //String[] valuePair =  split(userBody,","); // userbody.split(",);
        System.out.println(valuePair);
        for(int i = 0 ; i < valuePair.length; i++)
        {
            System.out.println("TEST---");
            StringItemStorage  = valuePair[i];
            String[] SplitViaDoublePoint =  StringItemStorage.split(":");
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
        DriverMangerConnection driverMangerConnection = new DriverMangerConnection();
        Connection conn = driverMangerConnection.Connection();
        String testCon =driverMangerConnection.add(conn,username,password, token,elo, wins, games);

        System.out.println("TEST---");
        return testCon;
    }



}
