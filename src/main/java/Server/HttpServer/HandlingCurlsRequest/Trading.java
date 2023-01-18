package Server.HttpServer.HandlingCurlsRequest;

import Server.Connection.CardDao;
import Server.Connection.DriverMangerConnection;
import Server.HttpServer.UtilsServer.Request;

import java.sql.Connection;

public class Trading {

    String Name;
    String SplitBody[];
    String giveCardID;
    String CardToTrade;
    String Type;
    int minimumDamage;
    public String StringItemStorage;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
    String[] requestStorage;
    String[] cStorage;
    String cutFirst;
    String cutSecond;
    public String showTrading(Request request)
    {
        DriverMangerConnection driverMangerConnection = new DriverMangerConnection();
        System.out.println("ACQUIRE PACKAGES--------------------------- ");
        String authorization = request.getHeaderMap().get("Authorization");
        String Input = null;
        requestStorage = authorization.split(" ");
        cStorage = requestStorage[1].split("-");
        String Name = cStorage[0];
        System.out.println(Name);
        if(Name.equals("kienboec"))
        {
            setName("kienboec");
            Connection conn = driverMangerConnection.Connection();

            String show = driverMangerConnection.showTradingK(conn);

            return show;
        }else if (Name.equals("altenhof"))
        {
            setName("altenhof");
            Connection conn = driverMangerConnection.Connection();
            String show = driverMangerConnection.showTradingA(conn);
            return show;
        }
        else{
            return" CANT SHOW DECK";
        }
    }
    public String createTrading(Request request)
    {
        System.out.println("ACQUIRE PACKAGES--------------------------- ");
        String authorization = request.getHeaderMap().get("Authorization");
        String Input = null;
        requestStorage = authorization.split(" ");
        String requestBody = request.getBody();
        System.out.println(requestBody+" lets see whats inside");
        cStorage = requestStorage[1].split("-");
        String Name = cStorage[0];
        System.out.println(Name);

        if(Name.equals("kienboec"))
        {
            String[] valuePair = requestBody.split(",");
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

                if(cutFirst.equals("\"Id\""))
                {
                    giveCardID = cutSecond;
                    System.out.println("Id: "+giveCardID);
                } else if (cutFirst.equals("\"CardToTrade\"")) {
                    CardToTrade = cutSecond;
                    System.out.println("CardToTrade: "+CardToTrade);
                } else if (cutFirst.equals("\"Type\"")) {
                    Type = cutSecond;
                    System.out.println(Type);
                } else if (cutFirst.equals("\"MinimumDamage\"")) {
                    minimumDamage = 15;
                    System.out.println("Min damage: "+minimumDamage);
                }
            }

            DriverMangerConnection driverMangerConnection = new DriverMangerConnection();
            Connection conn = driverMangerConnection.Connection();
            String testCon =driverMangerConnection.addTrade(conn,giveCardID, CardToTrade, Type,minimumDamage ,Name);

            System.out.println("TEST---");
            return testCon;


        }
        else if (Name.equals("altenhof"))
        {
            return "No Tradings for Altenhof";
        }
        return " No Trades Possible!";
    }

    public String deleteTrading(Request request)
    {
        String reqeustBody = request.getPathname();
        System.out.println("What is inside the pathname " + reqeustBody);
        String finishedPath = reqeustBody.substring(10);
        DriverMangerConnection driverMangerConnection = new DriverMangerConnection();
        Connection conn = driverMangerConnection.Connection();
        String deletedPath = driverMangerConnection.deletePath(conn, finishedPath);
        return deletedPath;
    }

    public String tryToTrade(Request request)
    {
        System.out.println("ACQUIRE PACKAGES--------------------------- ");
        String authorization = request.getHeaderMap().get("Authorization");
        String Input = null;
        requestStorage = authorization.split(" ");
        String requestBody = request.getBody();
        System.out.println(requestBody+" lets see whats inside");
        cStorage = requestStorage[1].split("-");
        String Name = cStorage[0];
        System.out.println(Name);

        if(Name.equals("kienboec"))
        {
            return "YOU CANNOT TRADE WITH YOUR SELF!";
        }else if(Name.equals("altenhof"))
        {
            String rquestBody = request.getBody();
            String atBeginCut = requestBody.substring(1);
            String finalCut = atBeginCut.substring(0,atBeginCut.length()-1);
            DriverMangerConnection driverMangerConnection = new DriverMangerConnection();
            Connection conn = driverMangerConnection.Connection();
            String completedTrade = driverMangerConnection.completeTrade(conn, finalCut, Name);

            return completedTrade;
        }
        else {
            return "Trade Fail!";
        }

    }
}
