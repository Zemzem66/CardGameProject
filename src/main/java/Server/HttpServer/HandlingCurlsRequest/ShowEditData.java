package Server.HttpServer.HandlingCurlsRequest;

import Server.Connection.DriverMangerConnection;
import Server.HttpServer.UtilsServer.Request;

import java.sql.Connection;

public class ShowEditData {
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
    public String showEditData(Request request) {
        DriverMangerConnection driverMangerConnection = new DriverMangerConnection();
        System.out.println("ACQUIRE PACKAGES--------------------------- ");
        String CheckURL = request.getPathname();
        System.out.println("THIS IS MY URL " + CheckURL);
        String authorization = request.getHeaderMap().get("Authorization");
        String Input = null;
        requestStorage = authorization.split(" ");

        cStorage = requestStorage[1].split("-");
        String Name = cStorage[0];
        System.out.println(Name);
        if (CheckURL.equals("/users/kienboec")) {
                setName("kienboec");
                // TODO: ITS HARD CODED, IF TIME IS LEFT DO IT
                Connection conn = driverMangerConnection.Connection();
                String show = driverMangerConnection.showEditsK(conn);
                return show;
        } else if (CheckURL.equals("/users/altenhof")) {
            setName("altenhof");
            Connection conn = driverMangerConnection.Connection();
            String show = driverMangerConnection.showEditsA(conn);
            return show;

        }
        else{
            return "Fail No such User";
        }

    }
}
