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

    String requestBody;
    String[] requestStorage;
    String[] cStorage;
    public String ShowAcquiredCards(Request request)
    {
        //TODO: FIX NULL POINTER EXCEPTION REQUEST IS NULL
        DriverMangerConnection driverMangerConnection = new DriverMangerConnection();
        System.out.println("ACQUIRE PACKAGES--------------------------- ");
        String authorization = request.getHeaderMap().get("Authorization");
        String Input = null;
        //requestStorage = authorization.split(" ");
for(int i =0; i < 2; i++)
        {
            Name = "kienboec";


      //  cStorage = requestStorage[1].split("-");
       // String Name = cStorage[0];
        System.out.println(Name);
        //if(Name.equals("kienboec"))
        //{
            setName("kienboec");
            // TODO: ITS HARD CODED, IF TIME IS LEFT DO IT
            Connection conn = driverMangerConnection.Connection();
            driverMangerConnection.ShowK(conn);
            return "Shows Kienboec";
            //System.out.println("ITS KIENBOC ");
        //}
        }
        Name="altenhof";
        if (Name.equals("altenhof"))
        {
            setName("altenhof");
            Connection conn = driverMangerConnection.Connection();
            String User = "altenhof";
            driverMangerConnection.ShowA(conn);
            //System.out.println("ITS altenhof ");
            return "Shows altenhof";
        }

        //else{
          //  return" no user selected"   ;
        //}
        //String userBody = request.getBody();
        //String[] valuePair = userBody.split(",");


          return "Irgendwas";
    }
}
