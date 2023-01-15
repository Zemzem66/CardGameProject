package Server.HttpServer.HandlingCurlsRequest;

import Server.Connection.DriverMangerConnection;
import Server.HttpServer.UtilsServer.Request;

import java.sql.Connection;
import java.sql.SQLException;

public class battles {

private String username;
    String battleFirst;
    String battleSecond;
    String[] requestStorage;
    String[] cStorage;
    String userFirst;
    String userSecond;

    public String uBattles(Request request) throws SQLException {
        String getHeader = request.getHeaderMap().get("Authorization");
        requestStorage = getHeader.split(" ");
        cStorage = requestStorage[1].split("-");
        userFirst = cStorage[0];
        DriverMangerConnection driverMangerConnection = new DriverMangerConnection();
        Connection conn = driverMangerConnection.Connection();

        battleFirst = driverMangerConnection.addToBattle(conn,userFirst);

        battleSecond = driverMangerConnection.getBattle(conn,userSecond);
        System.out.println("What is BATTLE SECOND ?" + battleSecond);
        driverMangerConnection.deleteDeck(conn);
        String testTestOne = driverMangerConnection.getdeck(conn,battleFirst);
        String testTestSecond = driverMangerConnection.getdeck(conn,battleSecond);
        if(battleSecond != null)
        {
            String startBattle = driverMangerConnection.battleStart(conn,battleFirst,battleSecond);
            //System.out.println("THE INPUT OF FIRST PLAYER IS " + battleFirst + " the second: "+ battleSecond);
            System.out.println("SEHE ARE THE USERS " + startBattle);
            return startBattle;
        }
        else{
            return "No one to fight!";
        }

      //  return battleFirst + "WAS ADDED TO BATTLE";
        //BATTLE CHECK
        //if(conn.)
        //{
        //}
 //START FIGHT
        //else{
        //}
       // return "THIS IS THE USER WHO WANTS TO BATTLE : " + opponent;


    }
}
