package Server.HttpServer.HandlingCurlsRequest;

import Server.Connection.DriverMangerConnection;
import Server.HttpServer.UtilsServer.Request;

import java.sql.Connection;

public class ShowCards {
    String Name;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }


    public String ShowAcquiredCards(Request request)
    {
        //TODO: FIX NULL POINTER EXCEPTION REQUEST IS NULL
        DriverMangerConnection driverMangerConnection = new DriverMangerConnection();
        String authorization = request.getHeaderMap().get("Authorization");
        String Input = null;

for(int i =0; i < 2; i++)
        {
            Name = "kienboec";
            setName("kienboec");
            Connection conn = driverMangerConnection.Connection();
            String storage = driverMangerConnection.ShowK(conn);
            return storage;
        }
        Name="altenhof";
        if (Name.equals("altenhof"))
        {
            setName("altenhof");
            Connection conn = driverMangerConnection.Connection();
            String User = "altenhof";
            String storage = driverMangerConnection.ShowA(conn);
            return storage;
        }

        //else{
          //  return" no user selected"   ;
        //}
        //String userBody = request.getBody();
        //String[] valuePair = userBody.split(",");


          return "Irgendwas";
    }
}
