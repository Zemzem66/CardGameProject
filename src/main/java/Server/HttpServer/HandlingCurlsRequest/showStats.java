package Server.HttpServer.HandlingCurlsRequest;

import Server.Connection.DriverMangerConnection;
import Server.HttpServer.UtilsServer.Request;

import java.sql.Connection;

public class showStats {
   String Name;

   public String getName() {
      return Name;
   }

   public void setName(String name) {
      Name = name;
   }
   String[] requestStorage;
   String[] cStorage;
   public String getStats(Request request)
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
         String show =driverMangerConnection.getStatK(conn);
         return show;
      }else if (Name.equals("altenhof"))
      {
         setName("altenhof");
         Connection conn = driverMangerConnection.Connection();
         String show = driverMangerConnection.getStatA(conn);
         return show;
      }
      else{
         return" CANT SHOW DECK";
      }

   }
}
