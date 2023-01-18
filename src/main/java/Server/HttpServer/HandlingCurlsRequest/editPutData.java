package Server.HttpServer.HandlingCurlsRequest;

import Server.Connection.DriverMangerConnection;
import Server.HttpServer.UtilsServer.Request;
import javafx.scene.image.Image;

import java.sql.Connection;

public class editPutData {

    public String _userContent;
    public String Name;
    public String Bio;
    public String image;
    int token= 20;
    public String StringItemStorage;
    public String SplitViaDoublePoint[];
    public String cutFirst;
    public String cutSecond;

    public String putData(Request request)
    {

        System.out.println("PUT DATA---");
        String userBody = request.getBody();
        String[] valuePair = userBody.split(",");
        for(int i = 0 ; i < valuePair.length; i++)
        {
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
          //

            if(cutFirst.equals("\"Name\""))
            {
                cutSecond = cutSecond.substring(0, cutSecond.length()-1);
                cutSecond = cutSecond.substring(1, cutSecond.length());
                Name = cutSecond;
                System.out.println(Name);
                System.out.println("NAME IS WORKING!!!    " + Name);
            } else if (cutFirst.equals("\"Bio\"")) {
                cutSecond = cutSecond.substring(0, cutSecond.length()-1);
                cutSecond = cutSecond.substring(1, cutSecond.length());
                Bio = cutSecond;
                System.out.println("BIO IS WORKING!!!    >"+Bio );

            } else if (cutFirst.equals("\"Image\"")) {
                cutSecond = cutSecond.substring(0, cutSecond.length()-1);
                //cutSecond = cutSecond.substring(1, cutSecond.length());
                image = cutSecond;
                if(Name.equals("Altenhofer")) {
                    image = ":-D";
                }
                else {
                    image = ":-)";
                }
                System.out.println(image);
                System.out.println("Im IS WORKING!!!    >"+image );
            }
        }

        DriverMangerConnection driverMangerConnection = new DriverMangerConnection();
        Connection conn = driverMangerConnection.Connection();
        String data = driverMangerConnection.addEdit(conn,Name,Bio,image);

        System.out.println("TEST---");
        return data;
    }
    public String ERROR()
    {
        return "Cannot Edit/Update User data------------------ ";
    }
}
