package Server.Connection;
import Server.HttpServer.HandlingCurlsRequest.AcquirePackage;
import com.example.cardgame.Card;
import com.example.cardgame.User;

import java.sql.*;
import java.util.Scanner;

public class DriverMangerConnection {
    static Connection connection;
    public static Connection Connection /*connection*/()
    {

        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","");
            System.out.println("The connection is succesfull");
        /*    PreparedStatement statement = connection.prepareStatement("INSERT INTO account (id,username, password) VALUES (?,?,?); ");
/
            User data = new User("admin","admin");
            statement.setInt(1, 1);
            statement.setString(2,data.getUsername());
            statement.setString(3, data.getPassword());
            statement.execute();
            */

        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        
        ///Funktioniert
        /*
        Connection conn = null;
        try{
           // jdbc:sqlserver://mssql_2:1433;DatabaseName=gls
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/CardGame","postgres","");
            System.out.println("Connection was succesfully");
        }catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return conn; 
        
    */

        return connection;
    }
    
     public String add(Connection connection,String username, String password, int token){
       try{

           PreparedStatement statement = connection.prepareStatement("INSERT INTO accounts (username, password,token) VALUES (?,?,?); ");

           statement.setString(1,username);
           statement.setString(2, password);
           statement.setInt(3,token);
           statement.execute();
           System.out.println(username + "-----" + password  + "-----");

       }catch (SQLException exception)
       {
           exception.printStackTrace();
       }
         return "User " + username + " was created!";
     }
     /*
    public static void main(String[] args)
    {
        DriverMangerConnection.Connection();
        //DriverMangerConnection.connection();
    }*/

    public String LogIn(Connection connection,String username, String password)
    {
        try{
            ResultSet rs;
            PreparedStatement statement = connection.prepareStatement("select username, password from accounts where username = ? AND password = ?");
            //    statement.setInt(1, 1);
            statement.setString(1,username);
            statement.setString(2, password);
            //statement.execute();
            System.out.println(username + "-----" + password  + "-----");

            rs = statement.executeQuery();
            if (rs.next())
            {
                System.out.println("USER LOGGED IN ");
                return "User " + username + " was logged in!----";
            }
            else {
                System.out.println("WRONG USER");
                return "User " + username + " was not WRONG in!----";
            }
        }catch (SQLException exception)
        {
            exception.printStackTrace();
        }
        return "WARUM!";
    }

    public String createPackage(Connection connection , String packedid)
    {
        try{
            PreparedStatement statement = connection.prepareStatement("INSERT INTO packages (cardID) VALUES (?); ");
            statement.setString(1,packedid);
         //   statement.setString(2,ad);
            statement.execute();
            System.out.println("PackageID"  + packedid + "-----" );
        }catch (SQLException exception)
        {
            exception.printStackTrace();
        }
        return  packedid+" WITH PACKED was created!";
    }

    public int getNewId() {
        return newId;
    }

    public void setNewId(int newId) {
        this.newId = newId;
    }

    int newId;
    public String createCard(Connection connection,String cardId,double damage, String ctype, String etype, String name, String owner, int myId)
    {
        //TODO BEIM UEBERGEBEN IST IMMER AM ANFANG 0  muss gefixt werden.
        try{
            /*
            ResultSet rs;
            Statement stmt;
            stmt =connection.createStatement();
            rs = stmt.executeQuery("SELECT packagesid from packages;");
           // newId++;
            while (rs.next()) {
               setNewId(rs.getInt("packagesid"));
            }
                System.out.println("Package Number : " + newId);
             */
            PreparedStatement takeIP = connection.prepareStatement("SELECT id from packages;");
            ResultSet resultSet = takeIP.executeQuery();
            while(resultSet.next()) {
                setNewId(resultSet.getInt(1));
            }
            takeIP = connection.prepareStatement("INSERT INTO cards (cardId,damage, ctype,etype,monsterSpellName,owner,id) VALUES (?,?,?,?,?,?,?); ");
            takeIP.setString(1, cardId);
            takeIP.setDouble(2, damage);
            takeIP.setString(3, ctype);
            takeIP.setString(4, etype);
            takeIP.setString(5, name);
            takeIP.setString(6, owner);
            takeIP.setInt(7, getNewId()+1);
            takeIP.execute();

            System.out.println("Package"  + damage + " ----- " + ctype  + "-----" + damage+ "------"+ name+ "owner of the cards: " +owner + "THE ID of the card is " );

            takeIP.close();
            resultSet.close();
        }catch (SQLException exception)
        {
            exception.printStackTrace();
        }
        return  damage+" WITH " + name + "and" +damage+" was created "+ ctype +"-------" + etype;
    }
    public String createAdmin(Connection connection, String admin)
    {
        try{

            PreparedStatement statement = connection.prepareStatement("INSERT INTO admin (ad) VALUES (?); ");

            statement.setString(1,admin);
            //   statement.setString(2,ad);
            statement.execute();
            System.out.println(admin +" + ad + " );

        }catch (SQLException exception)
        {
            exception.printStackTrace();
        }
        return  admin+" WITH PACKED was created!";
    }

    public String AcquirePackageK(Connection connection)
    {
        //AcquirePackage acquirePackage = new AcquirePackage();
       // System.out.println("THE NAME IS !!!!!!!!!   "+acquirePackage.getName());

        int token = 0;
        try{
            ResultSet rs;
            Statement stmt;
            stmt =connection.createStatement();
            rs = stmt.executeQuery("SELECT token from accounts where username = 'kienboec'");
                while (rs.next()) {
                    token = rs.getInt(1);
                    System.out.println(token + "THIS IS MY TOKEN its kienboc");
                    //rs = stmt.executeQuery("UPDATE accounts set token = ? where username = 'kienboec'");

                    PreparedStatement statement = connection.prepareStatement("UPDATE accounts set token = ? where username = 'kienboec'");
                    token -= 5;
                    statement.setInt(1,token);
                    statement.executeUpdate();
                    System.out.println("This is the round to set the token down: " + token);

                    //GET THE PACAKGE ID From PACKAGE



/////               TODO:
                    /*
                    //To update the table for inserting the player
                    PreparedStatement statementUpdate = connection.prepareStatement("UPDATE cards set owner = ? where id = ?");
                    String user = "kienboec";
                    statementUpdate.setString(1, user);
                    statementUpdate.setInt(2,newId);
                    System.out.println("OWNER TESSSSST: " + newId);
                    statementUpdate.executeUpdate();
                     */
                }
                if(token < 0 )
                {
                    System.out.println("NO MONEY!");
                    return "NO MONEY!";
                }

                else{
                    ResultSet rsMinimum;
                    int miniumID;
                    Statement stmtMinimum;
                    stmtMinimum =connection.createStatement();
                    rsMinimum = stmtMinimum.executeQuery("SELECT MIN(id) from packages");
                    while(rsMinimum.next()) {
                        miniumID = rsMinimum.getInt(1);

                        PreparedStatement statementUpdate = connection.prepareStatement("UPDATE cards set owner = ? where id = ?");
                        String user = "kienboec";
                        name(connection, miniumID, statementUpdate, user);

                    }
               //     return "Kienboc GOT  PACKGED " + miniumID ;
                }
           // }
            rs.close();
            stmt.close();


        }catch (SQLException exception)
        {
            exception.printStackTrace();
        }
        return  " KIENBOC ";

    }
    public String AcquirePackageA(Connection connection)
    {
        // TODO: 11.01.2023 ALTENHOF MUSS NOCH RICHTIG GESTELLT WERDEN
        int token = 0;
        try{
            ResultSet rs;
            Statement stmt;
            stmt =connection.createStatement();
            rs = stmt.executeQuery("SELECT token from accounts where username = 'altenhof'");
            while (rs.next()) {
                token = rs.getInt(1);
                System.out.println(token + "THIS IS MY TOKEN its kienboc");
                //rs = stmt.executeQuery("UPDATE accounts set token = ? where username = 'kienboec'");

                PreparedStatement statement = connection.prepareStatement("UPDATE accounts set token = ? where username = 'altenhof'");
                token -= 5; // kein minus
                statement.setInt(1,token);
                statement.executeUpdate();
                System.out.println("This is the round to set the token down: " + token);

                //GET THE PACAKGE ID From PACKAGE



/////               TODO:
                    /*
                    //To update the table for inserting the player
                    PreparedStatement statementUpdate = connection.prepareStatement("UPDATE cards set owner = ? where id = ?");
                    String user = "kienboec";
                    statementUpdate.setString(1, user);
                    statementUpdate.setInt(2,newId);
                    System.out.println("OWNER TESSSSST: " + newId);
                    statementUpdate.executeUpdate();
                     */
            }
            if(token < 0 )
            {
                System.out.println("NO MONEY!");
                return "NO MONEY!";
            }
           // else if()
            else{
                ResultSet rsMinimum;
                int miniumID;
                Statement stmtMinimum;
                stmtMinimum =connection.createStatement();
                rsMinimum = stmtMinimum.executeQuery("SELECT MIN(id) from packages");
                while(rsMinimum.next()) {
                    miniumID = rsMinimum.getInt(1);

                    PreparedStatement statementUpdate = connection.prepareStatement("UPDATE cards set owner = ? where id = ?");
                    String user = "altenhof";
                    name(connection, miniumID, statementUpdate, user);
                }
            }
            // }
            rs.close();
            stmt.close();
           // return "altenhof";
        }catch (SQLException exception)
        {
            exception.printStackTrace();
        }
        return  " ALTENHOG ";


/*
        int token = 0;
        try{
            ResultSet rs;
            Statement stmt;
            stmt =connection.createStatement();
            rs = stmt.executeQuery("SELECT token from accounts where username = 'altenhof'");
            while (rs.next()) {
                token = rs.getInt(1);
                System.out.println(token + "THIS IS MY TOKEN its altenhof");
                //rs = stmt.executeQuery("UPDATE accounts set token = ? where username = 'kienboec'");

                //TO SET THE TOKEN -5
                PreparedStatement statement = connection.prepareStatement("UPDATE accounts set token = ? where username = 'altenhof'");

                token -= 5;
                statement.setInt(1,token);
                statement.executeUpdate();

                //TO GET THE PACKAGES AND STORE IT IN TO THE DATABASE

                /*tring packageId;
                PreparedStatement getPackage = connection.prepareStatement("SELECT cardid where FIRST_VALUE(id) FROM packages");
                getPackage.next();

                 */

/*

                System.out.println("This is the round to set the token down: " + token);
            }
            if(token < 0 )
            {
                System.out.println("NO MONEY!");
                return "NO MONEY!";
            }

            // }
            rs.close();
            stmt.close();


        }catch (SQLException exception)
        {
            exception.printStackTrace();
        }
        return  token+" : return value of token ";
 */

    }

    private void name(Connection connection, int miniumID, PreparedStatement statementUpdate, String user) throws SQLException {
        statementUpdate.setString(1, user);
        statementUpdate.setInt(2, miniumID);
        System.out.println("OWNER TESSSSST: " + miniumID);
        statementUpdate.executeUpdate();

        PreparedStatement deleteId = connection.prepareStatement("DELETE FROM packages WHERE id = ?;");
        deleteId.setInt(1,miniumID);
        deleteId.execute();
    }
    String element;
    String card;
    String MonsterSpell;
    public String ShowK(Connection connection)
    {
        try{
            ResultSet rs;
            Statement stmt;
            stmt =connection.createStatement();
            rs = stmt.executeQuery("SELECT ctype, etype,monsterspellname from cards where owner = 'kienboec'; ");
            while(rs.next()) {
                while(rs.next()) {
                    element = rs.getString(1);
                    card = rs.getString(2);
                    MonsterSpell = rs.getString(3);
                }
            }
        }catch (SQLException exception)
        {
            exception.printStackTrace();
        }
        return  "Kienboec :The element Type is "+ element +" card type is " + card + " Monster/Spell tpye:" + MonsterSpell;
    }
    public String ShowA(Connection connection)
    {
        try{
            ResultSet rs;
            Statement stmt;
            stmt =connection.createStatement();
            rs = stmt.executeQuery("SELECT ctype, etype,monsterspellname from cards where owner = 'altenhof'; ");

            while(rs.next()) {
                element = rs.getString(1);
                card = rs.getString(2);
                MonsterSpell = rs.getString(3);
            }
        }catch (SQLException exception)
        {
            exception.printStackTrace();
        }
        return  "The element Type is "+ element +" card type is " + card + " Monster/Spell tpye:" + MonsterSpell;
    }


    //Show unconfirgemdDeck
    String UsernameR;
    public String createDeck(Connection connection, String testIdFirst, String testIdSecond, String testIdThree, String testIdFour, String Username)
    {
        try{
/*
            ResultSet rs;
            Statement stmt;
            //PreparedStatement statement;
            stmt =connection.createStatement();
            rs = stmt.executeQuery("SELECT cardId from cards where owner = 'kienboec'; ");
            while(rs.next()) {
                UsernameR = rs.getString(1);
                ///card = rs.getString(2);
                //MonsterSpell = rs.getString(3);

 */
                // if(UsernameR == "kienboec") {
               PreparedStatement statement = connection.prepareStatement("INSERT INTO deck (cardIdFirst,cardIdSecond,cardIdThree,cardIdFour,username) VALUES (?,?,?,?,?); ");
                statement.setString(1, testIdFirst);
                statement.setString(2, testIdSecond);
                statement.setString(3, testIdThree);
                statement.setString(4, testIdFour);
                statement.setString(5, Username);
                statement.execute();
            //}
            /*
            rs = stmt.executeQuery("SELECT cardId from cards where owner = 'altenhof'; ");
            while(rs.next()) {
                UsernameR = rs.getString(1);
                ///card = rs.getString(2);
                //MonsterSpell = rs.getString(3);


                // if(UsernameR == "kienboec") {
                statement = connection.prepareStatement("INSERT INTO deck (cardIdFirst,cardIdSecond,cardIdThree,cardIdFour,cardFive,username) VALUES (?,?,?,?,?,?); ");
                statement.setString(1, UsernameR);
                statement.setString(2, UsernameR);
                statement.setString(3, UsernameR);
                statement.setString(4, UsernameR);
                statement.setString(5, UsernameR);
                statement.setString(6, "altenhof");
                statement.execute();
            }

             */

                //   statement.setString(2,ad);

           // }
        //    System.out.println(testIdFirst +" + ad + " );

        }catch (SQLException exception)
        {
            exception.printStackTrace();
        }
        return  " WITH PACKED was created!";
    }
    /*
    public String ShowUDeck(Connection connection)
    {

    }
     */
    String showCardId;
    public String showDecksK(Connection connection)
    {
        try{
            ResultSet rs;
            Statement stmt;
            stmt =connection.createStatement();
            rs = stmt.executeQuery("SELECT cardIdFirst from deck where username = 'kienboec'; ");

            while(rs.next()) {
                showCardId = rs.getString(1);
            }
        }catch (SQLException exception)
        {
            exception.printStackTrace();
        }
        return  "KIENBOEC CardID is: " + showCardId;
    }

    public String showDecksA(Connection connection)
    {
        try{
            ResultSet rs;
            Statement stmt;
            stmt =connection.createStatement();
            rs = stmt.executeQuery("SELECT cardIdFirst from deck where username = 'altenhof'; ");

            while(rs.next()) {
                showCardId = rs.getString(1);
            }
        }catch (SQLException exception)
        {
            exception.printStackTrace();
        }
        return  "ALTENHOF CardID is: " + showCardId;
    }

    String sname;
    String bio;
    String image;
    public String showEditsK(Connection connection)
    {
        try{
            ResultSet rs;
            Statement stmt;
            stmt =connection.createStatement();
            rs = stmt.executeQuery("SELECT uname,bio,image from data where username = 'kienboec'; ");

            while(rs.next()) {
                sname = rs.getString(1);
                bio = rs.getString(2);
                image = rs.getString(3);
            }
        }catch (SQLException exception)
        {
            exception.printStackTrace();
        }
        return  "Kienboec Name is: " + sname + " Bio: " +bio + " Image: " +image;
    }

    public String showEditsA(Connection connection)
    {
        try{
            ResultSet rs;
            Statement stmt;
            stmt =connection.createStatement();
            rs = stmt.executeQuery("SELECT uname,bio,image from data where username = 'altenhof'; ");

            while(rs.next()) {
                sname = rs.getString(1);
                bio = rs.getString(2);
                image = rs.getString(3);
            }
        }catch (SQLException exception)
        {
            exception.printStackTrace();
        }
        return  "Altenhof Name is: " + sname + " Bio: " +bio + " Image: " +image;
    }

}
