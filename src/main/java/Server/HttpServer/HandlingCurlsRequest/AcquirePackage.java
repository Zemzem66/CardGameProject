package Server.HttpServer.HandlingCurlsRequest;

import Server.Connection.DriverMangerConnection;
import Server.HttpServer.UtilsServer.Request;

import java.sql.Connection;

public class AcquirePackage {
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
    public String createAcquire(Request request)
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
            // TODO: ITS HARD CODED, IF TIME IS LEFT DO IT
            Connection conn = driverMangerConnection.Connection();
            driverMangerConnection.AcquirePackageK(conn);
            //System.out.println("ITS KIENBOC ");
        }else if (Name.equals("altenhof"))
        {
            setName("altenhof");
            Connection conn = driverMangerConnection.Connection();
            driverMangerConnection.AcquirePackageA(conn);
            //System.out.println("ITS altenhof ");
        }

        else{
            System.out.println("NO USER SELECTED");
        }
        //String userBody = request.getBody();
        //String[] valuePair = userBody.split(",");


        return "Irgendwas";
    }
}