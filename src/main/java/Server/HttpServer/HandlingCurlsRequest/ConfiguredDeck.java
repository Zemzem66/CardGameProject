package Server.HttpServer.HandlingCurlsRequest;

import Server.Connection.DriverMangerConnection;
import Server.HttpServer.UtilsServer.Request;

import java.sql.Connection;
import java.util.ArrayList;

public class ConfiguredDeck {
    String Name;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
    String[] requestStorage;

    ArrayList<String> cardsK= new ArrayList<String>();
    ArrayList<String> cardsA= new ArrayList<String>();

    String[] cStorage;

    public String StringItemStorage;
    public String cutFirst;
    public String cutSecond;
    public String confDeck(Request request)
    {
        DriverMangerConnection driverMangerConnection = new DriverMangerConnection();
        String authorization = request.getHeaderMap().get("Authorization");
        requestStorage = authorization.split(" ");
        cStorage = requestStorage[1].split("-");
        String Name = cStorage[0];
        if(Name.equals("kienboec"))
        {
            String userBody= request.getBody();
            String[] valuePair = userBody.split(",");
            for(int i = 0 ; i < valuePair.length; i++)
            {
                System.out.println("TEST---");
                StringItemStorage  = valuePair[i];
                String[] SplitViaDoublePoint =  StringItemStorage.split("/");
                cutFirst = SplitViaDoublePoint[0].trim();

                cutSecond = SplitViaDoublePoint[0].trim();

                if(cutFirst.charAt(0) == '[')
                {
                    cutFirst = cutFirst.substring(1);
                    cutSecond = cutSecond.substring(1,cutSecond.length());

                }
                if(cutSecond.endsWith("]"))
                {
                    cutSecond = cutSecond.substring(0,cutSecond.length()-1);
                }
                cutSecond = cutSecond.substring(1, cutSecond.length()-1);
                cardsK.add(cutSecond);
            }

            Connection conn = driverMangerConnection.Connection();
            String testCon =driverMangerConnection.createDeck(conn,cardsK.get(0),cardsK.get(1),cardsK.get(2),cardsK.get(3),"kienboec");
            return  testCon;
        }
        if(Name.equals("altenhof"))
        {
            String userBody= request.getBody();
            String[] valuePair = userBody.split(",");
            for(int i = 0 ; i < valuePair.length; i++)
            {
                System.out.println("TEST---");
                StringItemStorage  = valuePair[i];
                String[] SplitViaDoublePoint =  StringItemStorage.split("/");
                cutFirst = SplitViaDoublePoint[0].trim();

                cutSecond = SplitViaDoublePoint[0].trim();

                if(cutFirst.charAt(0) == '[')
                {
                    cutFirst = cutFirst.substring(1);
                    cutSecond = cutSecond.substring(1,cutSecond.length());

                }
                if(cutSecond.endsWith("]"))
                {
                    cutSecond = cutSecond.substring(0,cutSecond.length()-1);
                }
                cutSecond = cutSecond.substring(1, cutSecond.length()-1);

                cardsA.add(cutSecond);
            }
            Connection conn = driverMangerConnection.Connection();
            String testCon =driverMangerConnection.createDeck(conn,cardsA.get(0),cardsA.get(1),cardsA.get(2),cardsA.get(3),"altenhof");
            return  testCon;
        }
        return "Success!";
    }
}
