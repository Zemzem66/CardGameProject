package Server.HttpServer.HandlingCurlsRequest;

import Server.Connection.DriverMangerConnection;
import Server.HttpServer.UtilsServer.Request;
import com.example.cardgame.Card;

import javax.xml.namespace.QName;
import java.sql.Connection;
import java.sql.SQLOutput;

public class CreatePackages {
    String sId;
    String damageDouble;
    String name;
    String cardType;
    String elementType;
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

    String[] split;

    String SplitBody[];
    public String CreatePackage(Request request) {
        DriverMangerConnection driverMangerConnection = new DriverMangerConnection();
        Connection conn = driverMangerConnection.Connection();
        String authorization = request.getHeaderMap().get("Authorization");
        String Input = null;
        SplitBody = authorization.split(" ");

        StoreValue = SplitBody[1].split("-");
        String Name = StoreValue[0];


        if (Name.equals("admin")) {

            RequestBody = request.getBody();
            split = RequestBody.split("\\{");
            double damage;
            for (int i = 0; i < 5; i++) {
                String s = split[i + 1];
                sId = s.substring(s.indexOf("\"Id\":\"") + 6, s.indexOf("\","));
                s = s.substring(s.indexOf("\",") + 1);
                System.out.println(s+"TEST THE NEW id");
                String element_name = s.substring(s.indexOf("\"Name\":\"") + 8, s.indexOf("\","));
                if ((element_name.length() > 5) && (element_name.substring(0, 5).equals("Water"))) {
                    elementType = "Water";
                    System.out.println("GEHT REIN 1 ");
                    if (element_name.substring(5).equals("Spell")) {
                        cardType = "Spell";
                        name = "Spell";
                        System.out.println("GEHT REIN 2 ");

                    } else {
                        cardType = "Monster";
                        name = element_name.substring(5);
                        System.out.println("GEHT REIN 3 ");

                    }
                } else if (element_name.length() > 4 && (element_name.substring(0, 4).equals("Fire"))) {
                    elementType = "Fire";
                    if (element_name.substring(4).equals("Spell")) {
                        cardType = "Spell";
                        name = "Spell";
                        System.out.println("GEHT REIN 4 ");

                    } else {
                        cardType = "Monster";
                        name = element_name.substring(4);
                        System.out.println("GEHT REIN 5 ");

                    }
                } else {
                    elementType = "Regular";
                    if (element_name.equals("Spell")) {
                        cardType = "Spell";
                        name = "Spell";
                    } else {
                        cardType = "Monster";
                        name = element_name;
                        System.out.println("GEHT REIN 6 ");

                    }
                }
                s = s.substring(s.indexOf("\",") + 1);
                String damageString = s.substring(s.indexOf("\"Damage\": ") + 10, s.indexOf("}"));
                damage = Double.parseDouble(damageString);

                System.out.println("Whats inside the idStorage" + idStorage);
                Input= driverMangerConnection.createCard(conn,sId,damage,cardType,elementType,name);
            }
            driverMangerConnection.createPackage(conn,sId);
            return Input;
        }
////////////////////////////////////////////M
/*
        System.out.println("Test Create Package");

        RequestBody = request.getBody();
        String StoreValueTwo[] = RequestBody.split(",");

        for(int i = 0 ; i < StoreValueTwo.length ; i ++)
        {
            ItemStorage = StoreValueTwo[i];

            SplitBody = ItemStorage.split(":");
            cutFirst = SplitBody[0].trim();
            cutSecond = SplitBody[1].trim();

            //cutSecond = cutSecond.substring(1,cutSecond.length()-1); //TEST

            if(cutFirst.charAt(0) == '{')
            {
                cutFirst = cutFirst.substring(1);
            }
            if(cutSecond.endsWith("}"))
            {
                cutSecond = cutSecond.substring(0,cutSecond.length() -1 );
            }
            cutSecond = cutSecond.substring(1,cutSecond.length() -1);

            System.out.println("ID GEHT REIN "+cutFirst);
            if(cutFirst.equals("\"Id\""))
            {
                System.out.println("ID GEHT REIN "+cutSecond);
               //cutSecond = cutSecond.substring(1,cutSecond.length()-1);
                idStorage = cutSecond;

            } else if (cutFirst.equals("\"Name\"") && cutSecond.startsWith("Fire")) {
                System.out.println("Spell is working!!!");
                if(cutSecond.equals("FireSpell"))
                {
                    cardType = "Spell";
                    elementType = "Fire";
                    name= "Spell";
                } else
                {
                    elementType = "Fire";
                    cardType = "Monster";
                    name = "Monster";
                }
              //  MonsterNameSt = cutSecond;
            }

            else if (cutFirst.equals("\"Damage\"")) {
                cutSecond = cutSecond.substring(0,cutSecond.length()-2);
                damageStorage=cutSecond;
            }
            else{
                System.out.println(cutFirst);
                System.out.println(cutSecond);
            }
            Input= driverMangerConnection.createCard(conn,damageDouble,cardType,elementType,name);
            driverMangerConnection.createPackage(conn,idStorage);
            return Input;
        }
        }

 */

        else{
            System.out.println("Package cannot be created ");
            return "Pack can not be created";
        }
        //return Input;
       // return "test";

    }
      //  return "Hello";
}

