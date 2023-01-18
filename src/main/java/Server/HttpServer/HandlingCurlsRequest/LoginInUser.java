package Server.HttpServer.HandlingCurlsRequest;

import Server.Connection.DriverMangerConnection;
import Server.HttpServer.UtilsServer.Request;

import java.sql.Connection;

public class LoginInUser {

    public String _userContent;
    public String username;
    public String password;
    public String StringItemStorage;
    public String SplitViaDoublePoint[];
    public String cutFirst;
    public String cutSecond;

    public String UserLogIn(Request request)
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
        String testCon =driverMangerConnection.LogIn(conn,username,password);

        return testCon;
    }
}
