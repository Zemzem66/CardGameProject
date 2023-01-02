package Server.HttpServer;
import Server.Connection.UserDaoImpl;

import java.sql.Connection;

import static com.sun.javafx.util.Utils.split;

public class ParseUserCreate {

    public String _userContent;
    UserDaoImpl userDb= new UserDaoImpl();
    public String username;
    public String password;
    public String StringItemStorage;
    public String SplitViaDoublePoint[];

    public String cutFirst;
    public String cutSecond;
    public String CreateUser(Request request) // to get the request
    {

        String userBody = request.getBody();
        String[] valuePair =  split(userBody,","); // userbody.split(",);

        for(int i = 0 ; i < valuePair.length; i++)
        {
            StringItemStorage  = valuePair[i];  // itertae through the array and store it every time in key Value
            for (String s : SplitViaDoublePoint) {
                 cutFirst = SplitViaDoublePoint[0].trim();
                 cutSecond = SplitViaDoublePoint[1].trim();
                 if(cutFirst.charAt(0) == '{')
                {
                    cutFirst = cutFirst.substring(1);
                }
                 if(cutSecond.endsWith("}"))
                 {
                    // cutSecond =
                 }
            }

           // [] = StringItemStorage.split(":");
           // cutFirst = SplitViaDoublePoint

        }

       // String []



        //Server connection and add
        Connection conn = userDb.add();
        _userContent = String.valueOf(conn);
        return _userContent;
    }

}
