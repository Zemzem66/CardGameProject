package Server.HttpServer.HandlingCurlsRequest;

import Server.Connection.DriverMangerConnection;
import Server.HttpServer.RequestUtils.RequestHandler;
import Server.HttpServer.UtilsServer.Request;
import com.example.cardgame.Card;

import javax.xml.namespace.QName;
import java.sql.Connection;
import java.sql.SQLOutput;
import java.util.ArrayList;

public class CreatePackages {
    ArrayList<String> cardIDs= new ArrayList<String>();
    String sId;

    int myID;
    String name;
    String cardType;
    String elementType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id += id;
    }


    String RequestBody;

    String StoreValue[];

    String[] split;
    String owner;
    int id =1;
int counter;
    String SplitBody[];
    public String CreatePackage(Request request) {

        DriverMangerConnection driverMangerConnection = new DriverMangerConnection();
        Connection conn = driverMangerConnection.Connection();
        String authorization = request.getHeaderMap().get("Authorization");
        String Input = null;
        SplitBody = authorization.split(" ");

        StoreValue = SplitBody[1].split("-");
        String Name = StoreValue[0];

            RequestBody = request.getBody();
            split = RequestBody.split("\\{");
            double damage;
            for (int i = 0; i < 5; i++) {
                String myBody = split[i + 1];
                sId = myBody.substring(myBody.indexOf("\"Id\":\"") + 6, myBody.indexOf("\","));
                myBody = myBody.substring(myBody.indexOf("\",") + 1);
                System.out.println(myBody + "TEST THE NEW id");
                String elementType = myBody.substring(myBody.indexOf("\"Name\":\"") + 8, myBody.indexOf("\","));
                if ((elementType.length() > 5) && (elementType.substring(0, 5).equals("Water"))) {
                    this.elementType = "Water";
                    if (elementType.substring(5).equals("Spell")) {
                        cardType = "Spell";
                        name = "Spell";

                    } else {
                        cardType = "Monster";
                        name = elementType.substring(5);

                    }
                } else if (elementType.length() > 4 && (elementType.substring(0, 4).equals("Fire"))) {
                    this.elementType = "Fire";
                    if (elementType.substring(4).equals("Spell")) {
                        cardType = "Spell";
                        name = "Spell";

                    } else {
                        cardType = "Monster";
                        name = elementType.substring(4);

                    }
                } else {
                    this.elementType = "Regular";
                    if (elementType.equals("Spell")) {
                        cardType = "Spell";
                        name = "Spell";
                    } else {
                        cardType = "Monster";
                        name = elementType;
                    }
                }

                myBody = myBody.substring(myBody.indexOf("\",") + 1);
                String damageString = myBody.substring(myBody.indexOf("\"Damage\": ") + 10, myBody.indexOf("}"));
                damage = Double.parseDouble(damageString);
                cardIDs.add(sId);
                Input = driverMangerConnection.createCard(conn, sId, damage, cardType, this.elementType, name, owner, myID);
                counter++;
            }

        driverMangerConnection.createPackage(conn,sId);
        driverMangerConnection.createAdmin(conn,Name);

            return Input;
    }
}

