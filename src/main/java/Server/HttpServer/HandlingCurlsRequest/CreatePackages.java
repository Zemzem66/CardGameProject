package Server.HttpServer.HandlingCurlsRequest;

import Server.Connection.DriverMangerConnection;
import Server.HttpServer.UtilsServer.Request;

import java.sql.Connection;

public class CreatePackages {
    String Id;
    String idStorage;
    String MonsterName;
    String MonsterNameSt;
    String Damage;
    String cutFirst;
    String cutSecond;
    String damageStorage;
    String RequestBody;

    String ItemStorage;
    String StoreValue[];

    String SplitBody[];
    public String CreatePackage(Request request)
    {
        DriverMangerConnection driverMangerConnection = new DriverMangerConnection();
        Connection conn = driverMangerConnection.Connection();
        String Input = null;
        System.out.println("Test Create Package");
        RequestBody = request.getBody();
        StoreValue = RequestBody.split(",");

        for(int i = 0 ; i < StoreValue.length ; i ++)
        {
            ItemStorage = StoreValue[i];

            SplitBody = ItemStorage.split(":");


            cutFirst = SplitBody[0].trim();

            cutSecond = SplitBody[1].trim();

            if(cutFirst.charAt(0) == '{')
            {
                cutFirst = cutFirst.substring(1);
            }
            if(cutSecond.endsWith("}"))
            {
                cutSecond = cutSecond.substring(0,cutSecond.length() -1 );
            }

            if(cutFirst.equals("\"Id\""))
            {
                cutSecond = cutSecond.substring(1,cutSecond.length()-1);
                idStorage = cutSecond;
            } else if (cutFirst.equals("\"Name\"")) {
                cutSecond = cutSecond.substring(1,cutSecond.length()-1);
                MonsterNameSt = cutSecond;
            } else if (cutFirst.equals("\"Damage\"")) {
                cutSecond = cutSecond.substring(0,cutSecond.length()-2);
                damageStorage=cutSecond;
            }
           Input= driverMangerConnection.createPackage(conn,idStorage,MonsterNameSt,damageStorage);

        }
        return Input;
       // return "test";
    }

}
