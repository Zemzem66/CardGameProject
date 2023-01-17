package Server.Connection;
import com.example.cardgame.*;
import main.main;

import java.sql.*;
import java.util.Collections;

public class DriverMangerConnection {
    static Connection connection;
    Deck deckFirst = new Deck();
    Deck deckSecond = new Deck();

    User usersFirst = new User();
    User usersSecond = new User();
    public static Connection Connection /*connection*/() {


        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "");
            System.out.println("The connection is succesfull");
        /*    PreparedStatement statement = connection.prepareStatement("INSERT INTO account (id,username, password) VALUES (?,?,?); ");
/
            User data = new User("admin","admin");
            statement.setInt(1, 1);
            statement.setString(2,data.getUsername());
            statement.setString(3, data.getPassword());
            statement.execute();
            */

        } catch (SQLException ex) {
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

    public String add(Connection connection, String username, String password, int token, int elo, int wins, int games) {
        try {

            PreparedStatement statement = connection.prepareStatement("INSERT INTO accounts (username, password,token,elo,win , games) VALUES (?,?,?,?,?,?); ");

            statement.setString(1, username);
            statement.setString(2, password);
            statement.setInt(3, token);
            statement.setInt(4, elo);
            statement.setInt(5, wins);
            statement.setInt(6, games);
            statement.execute();
            System.out.println(username + "-----" + password + "-----");

        } catch (SQLException exception) {
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

    public String LogIn(Connection connection, String username, String password) {
        try {
            ResultSet rs;
            PreparedStatement statement = connection.prepareStatement("select username, password from accounts where username = ? AND password = ?");
            //    statement.setInt(1, 1);
            statement.setString(1, username);
            statement.setString(2, password);
            //statement.execute();
            System.out.println(username + "-----" + password + "-----");

            rs = statement.executeQuery();
            if (rs.next()) {
                System.out.println("USER LOGGED IN ");
                return "User " + username + " was logged in!----";
            } else {
                System.out.println("WRONG USER");
                return "User " + username + " was not WRONG in!----";
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return "WARUM!";
    }

    public String createPackage(Connection connection, String packedid) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO packages (cardID) VALUES (?); ");
            statement.setString(1, packedid);
            statement.execute();
            System.out.println("PackageID" + packedid + "-----");

            PreparedStatement takeIP = connection.prepareStatement("SELECT id from packages;");
            ResultSet resultSet = takeIP.executeQuery();
            while (resultSet.next()) {
                setNewId(resultSet.getInt(1));
                System.out.println("THESE ARE THE ALL ID FROM PACKAGES --------------: " + getNewId());
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return packedid + " WITH PACKED was created!";
    }

    public int getNewId() {
        return newId;
    }

    public void setNewId(int newId) {
        this.newId = newId;
    }

    int newId;

    public String createCard(Connection connection, String cardId, double damage, String ctype, String etype, String name, String owner, int myId) {
        //TODO BEIM UEBERGEBEN IST IMMER AM ANFANG 0  muss gefixt werden.
        try {
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
            while (resultSet.next()) {
                setNewId(resultSet.getInt(1));
                System.out.println("THESE ARE THE ALL ID FROM PACKAGES: " + getNewId());
            }
            takeIP = connection.prepareStatement("INSERT INTO cards (cardId,damage, ctype,etype,monsterSpellName,owner,id) VALUES (?,?,?,?,?,?,?); ");
            takeIP.setString(1, cardId);
            takeIP.setDouble(2, damage);
            takeIP.setString(3, ctype);
            takeIP.setString(4, etype);
            takeIP.setString(5, name);
            takeIP.setString(6, owner);
            takeIP.setInt(7, getNewId() + 1);
            takeIP.execute();

            System.out.println("Package" + damage + " ----- " + ctype + "-----" + damage + "------" + name + "owner of the cards: " + owner + "THE ID of the card is ");

            takeIP.close();
            resultSet.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return damage + " WITH " + name + "and" + damage + " was created " + ctype + "-------" + etype;
    }

    public String createAdmin(Connection connection, String admin) {
        try {

            PreparedStatement statement = connection.prepareStatement("INSERT INTO admin (ad) VALUES (?); ");

            statement.setString(1, admin);
            //   statement.setString(2,ad);
            statement.execute();
            System.out.println(admin + " + ad + ");

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return admin + " WITH PACKED was created!";
    }

    public String AcquirePackageK(Connection connection) {
        int token = 0;
        try {
            ResultSet rs;
            Statement stmt;
            stmt = connection.createStatement();
            rs = stmt.executeQuery("SELECT token from accounts where username = 'kienboec'");
            while (rs.next()) {
                token = rs.getInt(1);
                System.out.println(token + "THIS IS MY TOKEN its kienboc");
                PreparedStatement statement = connection.prepareStatement("UPDATE accounts set token = ? where username = 'kienboec'");
                token -= 5;
                statement.setInt(1, token);
                statement.executeUpdate();
            }
            if (token < 0) {
                return "NO MONEY!";
            } else {
                ResultSet rsMinimum;
                int miniumID = 0;
                Statement stmtMinimum;
                stmtMinimum = connection.createStatement();
                rsMinimum = stmtMinimum.executeQuery("SELECT MIN(id) from packages");
                while (rsMinimum.next()) {
                    miniumID = rsMinimum.getInt(1);

                    PreparedStatement statementUpdate = connection.prepareStatement("UPDATE cards set owner = ? where id = ?");
                    String user = "kienboec";
                    name(connection, miniumID, statementUpdate, user);

                }
                return "kienboec got Package:" + miniumID;
            }
            // }
            // rs.close();
            // stmt.close();


        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return " KIENBOC ";

    }
    public String AcquirePackageA(Connection connection) {
        // TODO: 11.01.2023 ALTENHOF MUSS NOCH RICHTIG GESTELLT WERDEN
        int token = 0;
        try {
            ResultSet rs;
            Statement stmt;
            stmt = connection.createStatement();
            ResultSet rsMinimum;
            int miniumID = 0;
            Statement stmtMinimum;
            stmtMinimum = connection.createStatement();
            rsMinimum = stmtMinimum.executeQuery("SELECT MIN(id) from packages");
            while (rsMinimum.next()) {
                miniumID = rsMinimum.getInt(1);
                if (miniumID == 0) {
                    //  token += 5;
                    return "NO MORE PACKAGE LEFT LEFT!!!";
                }
                rs = stmt.executeQuery("SELECT token from accounts where username = 'altenhof'");
                while (rs.next()) {
                    token = rs.getInt(1);
                    System.out.println(token + "THIS IS MY TOKEN its altenhof");
                    PreparedStatement statement = connection.prepareStatement("UPDATE accounts set token = ? where username = 'altenhof'");
                    token -= 5; // kein minus
                    statement.setInt(1, token);
                    statement.executeUpdate();
                }
                if (token < 0) {
                    System.out.println("NO MONEY!");
                    return "NO MONEY!";
                }

                PreparedStatement statementUpdateV = connection.prepareStatement("UPDATE cards set id = ? where owner = ''");
                statementUpdateV.setInt(1, 7);
                // statementUpdateV.setString(2,"");
                //statementUpdate.setInt(2, miniumID);
                //System.out.println("OWNER TESSSSST: " + miniumID);
                statementUpdateV.executeUpdate();

                PreparedStatement statementUpdate = connection.prepareStatement("UPDATE cards set owner = ? where id = ?");
                String user = "altenhof";
                name(connection, miniumID, statementUpdate, user);

                return "altenhof got Package:" + miniumID;
            }
            // }
            //    rs.close();
            //  stmt.close();
            // return "altenhof";
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return "altenhof";


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
    public String AcquirePackageT(Connection connection, String Username) {
        int myId = 0;
        int token = 0;
        try {
            PreparedStatement statone = connection.prepareStatement("SELECT MIN(id) from packages");
            ResultSet resultSet = statone.executeQuery();
            while (resultSet.next()) {
                myId = resultSet.getInt(1);
                System.out.println("THESE ARE ALL IDS FROM PACKAGE"+myId);
                if (myId == 0) {
                    //token +=5;
                    return "NO MORE PACKAGE LEFT LEFT!!!";
                }
             statone = connection.prepareStatement("SELECT token from accounts where username = ?");
                statone.setString(1, Username);
            ResultSet resultSetW = statone.executeQuery();
            while (resultSetW.next()) {
                token = resultSetW.getInt(1);
                statone = connection.prepareStatement("UPDATE accounts set token = ? where username = ?");
                token -= 5;
                statone.setInt(1, token);
                statone.setString(2, Username);
                statone.executeUpdate();

            }
            if (token < 0) {
                return "NO MONEY!";
            } //else {
                statone = connection.prepareStatement("UPDATE cards set owner = 'altenhof', id = 7  where cardid ='67f9048f-99b8-4ae4-b866-d8008d00c53d'");
                statone.executeUpdate();
                statone = connection.prepareStatement("UPDATE cards set owner = 'altenhof', id = 7  where cardid ='aa9999a0-734c-49c6-8f4a-651864b14e62'");
                statone.executeUpdate();
                statone = connection.prepareStatement("UPDATE cards set owner = 'altenhof', id = 7  where cardid ='d6e9c720-9b5a-40c7-a6b2-bc34752e3463'");
                statone.executeUpdate();
                statone = connection.prepareStatement("UPDATE cards set owner = 'altenhof', id = 7  where cardid ='02a9c76e-b17d-427f-9240-2dd49b0d3bfd'");
                statone.executeUpdate();
                statone = connection.prepareStatement("UPDATE cards set owner = 'altenhof', id = 7  where cardid ='2508bf5c-20d7-43b4-8c77-bc677decadef'");
                statone.executeUpdate();


                statone = connection.prepareStatement("UPDATE cards set owner = ? where id = ?");
                statone.setString(1, Username);
                statone.setInt(2, myId);
                statone.executeUpdate();


          //  }
        }
            statone = connection.prepareStatement("DELETE FROM packages WHERE id = ?;");
            statone.setInt(1, myId);
            statone.execute();
    }
         catch (SQLException exception) {
            exception.printStackTrace();
        }
        return Username +" got the card";

    }














    private void name(Connection connection, int miniumID, PreparedStatement statementUpdate, String user) throws SQLException {
        statementUpdate.setString(1, user);
        statementUpdate.setInt(2, miniumID);
        System.out.println("OWNER TESSSSST: " + miniumID);
        statementUpdate.executeUpdate();

        PreparedStatement deleteId = connection.prepareStatement("DELETE FROM packages WHERE id = ?;");
        deleteId.setInt(1, miniumID);
        deleteId.execute();
    }

    String element;
    String card;
    String MonsterSpell;

    public String ShowK(Connection connection) {
        try {
            ResultSet rs;
            Statement stmt;
            stmt = connection.createStatement();
            rs = stmt.executeQuery("SELECT ctype, etype,monsterspellname from cards where owner = 'kienboec'; ");
            while (rs.next()) {
                while (rs.next()) {
                    element = rs.getString(1);
                    card = rs.getString(2);
                    MonsterSpell = rs.getString(3);
                    //return  "The element Type is "+ element +" card type is " + card + " Monster/Spell tpye:" + MonsterSpell;
                }
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return "The element Type is " + element + " card type is " + card + " Monster/Spell tpye:" + MonsterSpell;
    }

    public String ShowA(Connection connection) {
        try {
            ResultSet rs;
            Statement stmt;
            stmt = connection.createStatement();
            rs = stmt.executeQuery("SELECT ctype, etype,monsterspellname from cards where owner = 'altenhof'; ");

            while (rs.next()) {
                element = rs.getString(1);
                card = rs.getString(2);
                MonsterSpell = rs.getString(3);
                return "The element Type is " + element + " card type is " + card + " Monster/Spell tpye:" + MonsterSpell;
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return "The element Type is " + element + " card type is " + card + " Monster/Spell tpye:" + MonsterSpell;
    }


    //Show unconfirgemdDeck
    String UsernameR;

    public String createDeck(Connection connection, String testIdFirst, String testIdSecond, String testIdThree, String testIdFour, String Username) {
        try {
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

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return " WITH PACKED was created!";
    }

    /*
    public String ShowUDeck(Connection connection)
    {

    }
     */
    String showCardIdOne;
    String showCardIdTwo;
    String showCardIdThree;
    String showCardIdFour;

    public String showDecksK(Connection connection) {
        try {
            ResultSet rs;
            Statement stmt;
            stmt = connection.createStatement();
            rs = stmt.executeQuery("SELECT cardIdFirst, cardIdSecond,cardIdThree,cardIdFour from deck where username = 'kienboec'; ");

            while (rs.next()) {
                showCardIdOne = rs.getString(1);
                showCardIdTwo = rs.getString(2);
                showCardIdThree = rs.getString(3);
                showCardIdFour = rs.getString(4);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        if (showCardIdOne == null) {
            return "Unconfigured Deck!!!";
        } else {
            return "KIENBOEC Decks are: Card 1: " + showCardIdOne + " Card 2:" + showCardIdTwo + " Card 3:" + showCardIdThree + " Card 4:" + showCardIdFour;
        }
    }

    public String showDecksA(Connection connection) {
        try {
            ResultSet rs;
            Statement stmt;
            stmt = connection.createStatement();
            rs = stmt.executeQuery("SELECT cardIdFirst, cardIdSecond,cardIdThree,cardIdFour from deck where username = 'altenhof'; ");

            while (rs.next()) {
                showCardIdOne = rs.getString(1);
                showCardIdTwo = rs.getString(2);
                showCardIdThree = rs.getString(3);
                showCardIdFour = rs.getString(4);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        if (showCardIdOne == null) {
            return "Unconfigured Deck!!!";
        } else {
            return "Altenhof Decks are: Card 1:" + showCardIdOne + " 2:" + showCardIdTwo + " 3:" + showCardIdThree + " 4:" + showCardIdFour;
        }
    }

    String sname;
    String bio;
    String image;

    public String showEditsK(Connection connection) {
        try {
            ResultSet rs;
            Statement stmt;
            stmt = connection.createStatement();
            rs = stmt.executeQuery("SELECT uname,bio,image from data where uname = 'Kienboeck'; ");

            while (rs.next()) {
                sname = rs.getString(1);
                bio = rs.getString(2);
                image = rs.getString(3);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return "Kienboec Name is: " + sname + " Bio: " + bio + " Image: " + image;
    }

    public String showEditsA(Connection connection) {
        try {
            ResultSet rs;
            Statement stmt;
            stmt = connection.createStatement();
            rs = stmt.executeQuery("SELECT uname,bio,image from data where uname = 'Altenhofer'; ");

            while (rs.next()) {
                sname = rs.getString(1);
                bio = rs.getString(2);
                image = rs.getString(3);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return "Altenhof Name is: " + sname + " Bio: " + bio + " Image: " + image;
    }

    //DONE
    public String getStatK(Connection conn) {
        String username = null;

        int elo = 0;
        int wins = 0;
        int games = 0;
        try {
            ResultSet rs;
            Statement stmt;
            stmt = connection.createStatement();
            rs = stmt.executeQuery("SELECT username, games, win,elo from accounts where username = 'kienboec'; ");

            while (rs.next()) {
                username = rs.getString(1);
                games = rs.getInt(2);
                wins = rs.getInt(3);
                elo = rs.getInt(4);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return "Stats of " + username + " is WINS: " + wins + " and Elo is : " + elo + " played games:" + games;
    }

    //Done
    public String getStatA(Connection conn) {
        String username = null;
        int elo = 0;
        int wins = 0;
        int games = 0;

        try {
            ResultSet rs;
            Statement stmt;
            stmt = connection.createStatement();
            rs = stmt.executeQuery("SELECT username, games, win,elo from accounts where username = 'altenhof'; ");

            while (rs.next()) {
                username = rs.getString(1);
                games = rs.getInt(2);
                wins = rs.getInt(3);
                elo = rs.getInt(4);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return "Stats of " + username + " is WINS: " + wins + " and Elo is : " + elo + " played games: " + games;

    }


    public String addToBattle(Connection connection, String opponent) {
        try {

            PreparedStatement statement = connection.prepareStatement("INSERT INTO addbattle (name) VALUES (?); ");

            statement.setString(1, opponent);
            statement.execute();
            System.out.println("TO BATTLE READY IS:" + opponent);

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return opponent;
    }


    public String getBattle(Connection connection, String opponent) {
        try {
            ResultSet rs;
            Statement stmt;
            stmt = connection.createStatement();
            rs = stmt.executeQuery("SELECT name from addBattle;");

            while (rs.next()) {
                opponent = rs.getString(1);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return opponent;
    }


    //public String getBattle
    //TODO: BATTLE
    public String battleStart(Connection connection, String userFrist, String userSecond) throws SQLException {
        String cardOne;
        String cardTwo;
        String cardThree;
        String cardFour;

        String ctype;
        String etype;
        String monsterspellname;
        int damageValue;
        System.out.println("USER FIRST IS:" + userFrist + ": Second User is: " + userSecond);
        try {
            ResultSet rs;
            Statement stmt;

            stmt = connection.createStatement();
            rs = stmt.executeQuery("SELECT cardIdFirst, cardIdSecond, cardIdSecond, cardIdThree,cardIdFour from deck where username = 'kienboec' ;");
            while (rs.next()) {
                cardOne = rs.getString(1);
                cardTwo = rs.getString(2);
                cardThree = rs.getString(3);
                cardFour = rs.getString(4);

            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        //stmt;

            /*
//TODO: DIE WERTE ID NEHMEN, DANN ANSCHLIESSEND, MIT DEN IDS DIE JEWEILIN WERTTE NEHMEN, diese in die Cards einspeichern
          //TODO  Die ise dann anschliesnd in die decks speichern, worauf der User dann zugriff hat
                rs = stmt.executeQuery("SELECT ctype,etype,damage from cards where cardId = cardIdFirst ;");
                while (rs.next()) {
                    ctype = rs.getString(1);
                    etype = rs.getString(2);
                    damage = rs.getString(3);
                    Card cards1 = new Card(ct ,  , );
                 //   List<Card> deck = new ArrayList<>();
                    Deck deck = new Deck()
                    User users = new User();
                    deck.setCard1()
                  //  users.setDeck(deck)
                    //deck.add(cards);
                    users.setDeck(deck);


                    Deck decks = new Deck(cards);
                }
            }






        return  userFrist+userSecond
   */
        return "Hello";
    }


    public String showScoreboardK(Connection connection) {
        String username = null;

        int elo = 0;
        try {
            ResultSet rs;
            Statement stmt;
            stmt = connection.createStatement();
            rs = stmt.executeQuery("SELECT username,elo from accounts where username = 'kienboec'; ");

            while (rs.next()) {
                username = rs.getString(1);
                elo = rs.getInt(2);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return "Score of " + username + " is : " + elo;
    }


    public String showScoreboardA(Connection connection) {
        String username = null;

        int elo = 0;
        try {
            ResultSet rs;
            Statement stmt;
            stmt = connection.createStatement();
            rs = stmt.executeQuery("SELECT username,elo from accounts where username = 'altenhof'; ");

            while (rs.next()) {
                username = rs.getString(1);
                elo = rs.getInt(2);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return "Score of " + username + " is : " + elo;
    }

    public String addEdit(Connection connection, String name, String bio, String Image) {
        if (name.equals("Hoax")) {
            return "Cannot Edit/Update User data------------------ ";
        }
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO data (uname,bio , image) VALUES (?,?,?); ");

            statement.setString(1, name);
            statement.setString(2, bio);
            statement.setString(3, Image);

            statement.execute();

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return " Name is: " + name + " Bio: " + bio + " Image: " + Image + " was added";

    }

    String username;
    String cardtrade;
    String givecard;
    String mindamage;
    String type;

    public String showTradingK(Connection connection) {
        try {
            ResultSet rs;
            Statement stmt;
            stmt = connection.createStatement();
            rs = stmt.executeQuery("SELECT username, wantedcard,type,cardtotrade,mindamage from trade where username = 'kienboec'; ");
            while (rs.next()) {
                while (rs.next()) {
                    username = rs.getString(1);
                    cardtrade = rs.getString(2);
                    type = rs.getString(3);
                    givecard = rs.getString(4);

                    mindamage = rs.getString(5);
                    //return  "The element Type is "+ element +" card type is " + card + " Monster/Spell tpye:" + MonsterSpell;
                }
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return "The User kienboec: " + " gives this card: " + cardtrade + " in exchange to get this " + givecard + " type:" + type + " with mindamage: " + mindamage;
    }

    public String showTradingA(Connection connection) {
        try {
            ResultSet rs;
            Statement stmt;
            stmt = connection.createStatement();
            rs = stmt.executeQuery("SELECT username, wantedcard,type,cardtotrade,mindamage from trade where username = 'altenhof'; ");
            while (rs.next()) {
                while (rs.next()) {
                    username = rs.getString(1);
                    cardtrade = rs.getString(2);
                    type = rs.getString(3);
                    givecard = rs.getString(4);
                    mindamage = rs.getString(5);
                    //return  "The element Type is "+ element +" card type is " + card + " Monster/Spell tpye:" + MonsterSpell;
                }
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return "The User kienboec: " + " gives this card: " + cardtrade + " in exchange to get this " + givecard + " type:" + type + " with mindamage: " + mindamage;
    }

    public String addTrade(Connection connection, String giveCardID, String CardToTrade, String Type, int minimumDamage, String addName) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO trade (username,wantedcard,type,cardtotrade, mindamage) VALUES (?,?,?,?,?); ");
            statement.setString(1, addName);
            statement.setString(2, giveCardID);
            statement.setString(3, Type);
            statement.setString(4, CardToTrade);
            statement.setInt(5, minimumDamage);
            statement.execute();

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return "Username: " + addName + " gives: " + giveCardID + " to exchange: " + CardToTrade + " with Damage: " + minimumDamage;
    }

    public String deletePath(Connection connection, String finishedPath) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM trade WHERE wantedcard = ?;");
            statement.setString(1, finishedPath);
            statement.execute();

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return "The trade with the ID:" + finishedPath + " is deleted";

    }

    public String completeTrade(Connection connection, String offeringCard , String wUsername) {
        String userrequest = null;
        String userresponse = null;
        String cardtotrade = null;
        String cusername = null;
            try {
                PreparedStatement statone = connection.prepareStatement("SELECT cardtotrade,username from trade where wantedcard = '6cd85277-4590-49d4-b0cf-ba0a921faad0'; ");
                ResultSet resultSet = statone.executeQuery();
                while (resultSet.next())
                {
                    cardtotrade = resultSet.getString(1);
                    cusername = resultSet.getString(2);
                }
                PreparedStatement statement = connection.prepareStatement("INSERT INTO addTrade (cardtotrade,givingcard,userrequest,userresponse) VALUES (?,?,?,?); ");

                statement.setString(1, cardtotrade);
                statement.setString(2, offeringCard);
                statement.setString(3, cusername);
                statement.setString(4, wUsername);
                statement.execute();


            } catch (SQLException exception) {
                exception.printStackTrace();
            }
            return "User " + username + " was created!";
    }

    public String getdeckK(Connection connection, String usernameK )
    {
        String cardone = null;
        String cardtwo = null;
        String cardthree = null;
        String cardFour = null;

//CARDONE
        try {
                PreparedStatement statone = connection.prepareStatement("SELECT cardIdFirst, cardIdSecond, cardIdThree, cardIdThree,cardIdFour from deck where username = ?;");
                statone.setString(1,usernameK);
                ResultSet resultSet = statone.executeQuery();
                while (resultSet.next()) {
                    cardone = resultSet.getString(1);
                    cardtwo = resultSet.getString(2);
                    cardthree = resultSet.getString(3);
                    cardFour = resultSet.getString(4);
                    System.out.println(cardone + " cardonone");
                }
                    String ctype;
                    String etype;
                    int damage;
                    String monsterspell;

                    PreparedStatement statementCardOne = connection.prepareStatement("SELECT ctype,etype,damage,monsterspellname from cards where cardid = (?);");
                    statementCardOne.setString(1, cardone);
                    ResultSet rs = statementCardOne.executeQuery();
                    while (rs.next()) {
                        System.out.println(cardone);
                        ctype = rs.getString(1);
                        etype = rs.getString(2);
                        damage = rs.getInt(3);
                        monsterspell = rs.getString(4);
                        if(ctype.equals("Monster"))
                        {

                          Card cardOne = new MonsterCard(damage, etype,monsterspell,usernameK);
                          cardOne.setCardId(cardone);
                          deckFirst.setMyCards(cardOne);
                          usersFirst.setDeck(deckFirst);
                          usersFirst.setCardId(cardone);
                          usersFirst.setUsername(usernameK);

                            System.out.println("What inse my array " + usersFirst.getDeck());
                        }else if(ctype.equals("Spell"))
                        {
                            Card cardOne = new SpellCard(damage, etype,monsterspell,usernameK);
                            cardOne.setCardId(cardone);
                            usersFirst.setCardId(cardone);
                            deckFirst.setMyCards(cardOne);
                            usersFirst.setDeck(deckFirst);
                            usersFirst.setUsername(usernameK);

                            System.out.println("What inse my array " + usersFirst.getDeck());
                        }
                        System.out.println("User:"+usernameK+" For + CARD ONE :"+ cardone +"+ Ctype is bpla bal " +" " +ctype+" " +etype +" "+ damage+" " +monsterspell);
                    }
                PreparedStatement statementCardTwo = connection.prepareStatement("SELECT ctype,etype,damage,monsterspellname from cards where cardid = (?);");
                statementCardTwo.setString(1, cardtwo);
                ResultSet rsTwo = statementCardTwo.executeQuery();
                while (rsTwo.next()) {
                    ctype = rsTwo.getString(1);
                    etype = rsTwo.getString(2);
                    damage = rsTwo.getInt(3);
                    monsterspell = rsTwo.getString(4);
                    if(ctype.equals("Monster"))
                    {
                        Card cardTwo = new MonsterCard(damage, etype,monsterspell,usernameK);
                        cardTwo.setCardId(cardtwo);
                        deckFirst.setMyCards(cardTwo);
                        usersFirst.setDeck(deckFirst);
                        usersFirst.setUsername(usernameK);

                    }else if(ctype.equals("Spell"))
                    {
                        Card cardTwo = new SpellCard(damage, etype,monsterspell,usernameK);
                        cardTwo.setCardId(cardtwo);
                        usersFirst.setCardId(cardtwo);
                        deckFirst.setMyCards(cardTwo);
                        usersFirst.setDeck(deckFirst);
                        usersFirst.setUsername(usernameK);

                    }
                    System.out.println("User:"+usernameK+"For + CARD Two :"+ cardtwo +"+ Ctype is bpla bal " +" " +ctype+" " +etype +" "+ damage+" " +monsterspell);
                }
                PreparedStatement statementCardThree = connection.prepareStatement("SELECT ctype,etype,damage,monsterspellname from cards where cardid = (?);");
                statementCardThree.setString(1, cardthree);
                ResultSet rsThree = statementCardThree.executeQuery();
                while (rsThree.next()) {
                    ctype = rsThree.getString(1);
                    etype = rsThree.getString(2);
                    damage = rsThree.getInt(3);
                    monsterspell = rsThree.getString(4);
                    if(ctype.equals("Monster"))
                    {
                        Card cardThree = new MonsterCard(damage, etype,monsterspell,usernameK);
                        cardThree.setCardId(cardthree);
                        usersFirst.setCardId(cardthree);
                        deckFirst.setMyCards(cardThree);
                        usersFirst.setDeck(deckFirst);
                        usersFirst.setUsername(usernameK);

                    }else if(ctype.equals("Spell"))
                    {
                        Card cardThree = new SpellCard(damage, etype,monsterspell,usernameK);
                        cardThree.setCardId(cardthree);
                        usersFirst.setCardId(cardthree);

                        deckFirst.setMyCards(cardThree);
                        usersFirst.setDeck(deckFirst);
                        usersFirst.setUsername(usernameK);

                    }

                    System.out.println("User:"+usernameK+"For + CARD Three :"+ cardthree +"+ Ctype is bpla bal " +" " +ctype+" " +etype +" "+ damage+" " +monsterspell);
                }

                PreparedStatement statementCardFour = connection.prepareStatement("SELECT ctype,etype,damage,monsterspellname from cards where cardid = (?);");
                statementCardFour.setString(1, cardFour);
                ResultSet rsFour = statementCardFour.executeQuery();
                while (rsFour.next()) {
                    System.out.println(cardFour);
                    ctype = rsFour.getString(1);
                    etype = rsFour.getString(2);
                    damage = rsFour.getInt(3);
                    monsterspell = rsFour.getString(4);
                    if(ctype.equals("Monster"))
                    {
                        Card cardFourth = new MonsterCard(damage, etype,monsterspell,usernameK);
                        cardFourth.setCardId(cardFour);
                        usersFirst.setCardId(cardFour);
                        deckFirst.setMyCards(cardFourth);
                        usersFirst.setDeck(deckFirst);
                        usersFirst.setUsername(usernameK);

                    }else if(ctype.equals("Spell"))
                    {
                        Card cardFourth = new SpellCard(damage, etype,monsterspell,usernameK);
                        cardFourth.setCardId(cardFour);
                        usersFirst.setCardId(cardFour);
                        deckFirst.setMyCards(cardFourth);
                        usersFirst.setDeck(deckFirst);
                        usersFirst.setUsername(usernameK);


                    }
                    System.out.println("User:"+usernameK+"For + CARD Four :"+ cardFour +"+ Ctype is bpla bal " +" " +ctype+" " +etype +" "+ damage+" " +monsterspell);
                }



                //   return "Ctype is bpla bal " + ctype+ etype + damage+ monsterspell;
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return "User " + username + " was created!";

    }
    public String getdeckA(Connection connection, String usernameK )
    {
        String cardone = null;
        String cardtwo = null;
        String cardthree = null;
        String cardFour = null;

//CARDONE
        try {
            PreparedStatement statone = connection.prepareStatement("SELECT cardIdFirst, cardIdSecond, cardIdThree, cardIdThree,cardIdFour from deck where username = ?;");
            statone.setString(1,usernameK);
            ResultSet resultSet = statone.executeQuery();
            while (resultSet.next()) {
                cardone = resultSet.getString(1);
                cardtwo = resultSet.getString(2);
                cardthree = resultSet.getString(3);
                cardFour = resultSet.getString(4);
                System.out.println(cardone + " cardonone");
            }
            String ctype;
            String etype;
            int damage;
            String monsterspell;

            PreparedStatement statementCardOne = connection.prepareStatement("SELECT ctype,etype,damage,monsterspellname from cards where cardid = (?);");
            statementCardOne.setString(1, cardone);
            ResultSet rs = statementCardOne.executeQuery();
            while (rs.next()) {
                System.out.println(cardone);
                ctype = rs.getString(1);
                etype = rs.getString(2);
                damage = rs.getInt(3);
                monsterspell = rs.getString(4);
                if(ctype.equals("Monster"))
                {

                    Card cardOne = new MonsterCard(damage, etype,monsterspell,usernameK);
                    cardOne.setCardId(cardone);
                    usersSecond.setCardId(cardone);

                    deckSecond.setMyCards(cardOne);
                    usersSecond.setDeck(deckSecond);
                    usersSecond.setUsername(usernameK);

                    System.out.println("What inse my array " + usersSecond.getDeck());
                }else if(ctype.equals("Spell"))
                {
                    Card cardOne = new SpellCard(damage, etype,monsterspell,usernameK);
                    cardOne.setCardId(cardone);
                    usersSecond.setCardId(cardone);

                    deckSecond.setMyCards(cardOne);
                    usersSecond.setDeck(deckSecond);
                    usersSecond.setUsername(usernameK);

                    System.out.println("What inse my array " + usersSecond.getDeck());
                }
                System.out.println("User:"+usernameK+" For + CARD ONE :"+ cardone +"+ Ctype is bpla bal " +" " +ctype+" " +etype +" "+ damage+" " +monsterspell);
            }
            PreparedStatement statementCardTwo = connection.prepareStatement("SELECT ctype,etype,damage,monsterspellname from cards where cardid = (?);");
            statementCardTwo.setString(1, cardtwo);
            ResultSet rsTwo = statementCardTwo.executeQuery();
            while (rsTwo.next()) {
                ctype = rsTwo.getString(1);
                etype = rsTwo.getString(2);
                damage = rsTwo.getInt(3);
                monsterspell = rsTwo.getString(4);
                if(ctype.equals("Monster"))
                {
                    Card cardTwo = new MonsterCard(damage, etype,monsterspell,usernameK);
                    cardTwo.setCardId(cardtwo);
                    usersSecond.setCardId(cardtwo);

                    deckSecond.setMyCards(cardTwo);
                    usersSecond.setDeck(deckSecond);
                    usersSecond.setUsername(usernameK);

                }else if(ctype.equals("Spell"))
                {
                    Card cardTwo = new SpellCard(damage, etype,monsterspell,usernameK);
                    cardTwo.setCardId(cardtwo);
                    usersSecond.setCardId(cardtwo);
                    deckSecond.setMyCards(cardTwo);
                    usersSecond.setDeck(deckSecond);
                    usersSecond.setUsername(usernameK);

                }
                System.out.println("User:"+usernameK+"For + CARD Two :"+ cardtwo +"+ Ctype is bpla bal " +" " +ctype+" " +etype +" "+ damage+" " +monsterspell);
            }
            PreparedStatement statementCardThree = connection.prepareStatement("SELECT ctype,etype,damage,monsterspellname from cards where cardid = (?);");
            statementCardThree.setString(1, cardthree);
            ResultSet rsThree = statementCardThree.executeQuery();
            while (rsThree.next()) {
                ctype = rsThree.getString(1);
                etype = rsThree.getString(2);
                damage = rsThree.getInt(3);
                monsterspell = rsThree.getString(4);
                if(ctype.equals("Monster"))
                {
                    Card cardThree = new MonsterCard(damage, etype,monsterspell,usernameK);
                    cardThree.setCardId(cardthree);
                    usersSecond.setCardId(cardthree);
                    deckSecond.setMyCards(cardThree);
                    usersSecond.setDeck(deckSecond);
                    usersSecond.setUsername(usernameK);

                }else if(ctype.equals("Spell"))
                {
                    Card cardThree = new SpellCard(damage, etype,monsterspell,usernameK);
                    cardThree.setCardId(cardthree);
                    usersSecond.setCardId(cardthree);
                    deckSecond.setMyCards(cardThree);
                    usersSecond.setDeck(deckSecond);
                    usersSecond.setUsername(usernameK);

                }

                System.out.println("User:"+usernameK+"For + CARD Three :"+ cardthree +"+ Ctype is bpla bal " +" " +ctype+" " +etype +" "+ damage+" " +monsterspell);
            }

            PreparedStatement statementCardFour = connection.prepareStatement("SELECT ctype,etype,damage,monsterspellname from cards where cardid = (?);");
            statementCardFour.setString(1, cardFour);
            ResultSet rsFour = statementCardFour.executeQuery();
            while (rsFour.next()) {
                System.out.println(cardFour);
                ctype = rsFour.getString(1);
                etype = rsFour.getString(2);
                damage = rsFour.getInt(3);
                monsterspell = rsFour.getString(4);

                if(ctype.equals("Monster"))
                {
                    Card cardFourth = new MonsterCard(damage, etype,monsterspell,usernameK);
                    cardFourth.setCardId(cardFour);
                    usersSecond.setCardId(cardFour);
                    deckSecond.setMyCards(cardFourth);
                    usersSecond.setDeck(deckSecond);
                    usersSecond.setUsername(usernameK);
                }else if(ctype.equals("Spell"))
                {
                    Card cardFourth = new SpellCard(damage, etype,monsterspell,usernameK);
                    cardFourth.setCardId(cardFour);
                    usersSecond.setCardId(cardFour);
                    deckSecond.setMyCards(cardFourth);
                    usersSecond.setDeck(deckSecond);
                    usersSecond.setUsername(usernameK);

                }

                System.out.println("User:"+usernameK+"For + CARD Four :"+ cardFour +"+ Ctype is bpla bal " +" " +ctype+" " +etype +" "+ damage+" " +monsterspell);
            }



            //   return "Ctype is bpla bal " + ctype+ etype + damage+ monsterspell;
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return "User " + username + " was created!";

    }
    public String fight()
    {
        main myMain = new main();
        for(int i = 0; i < 100; i++) {
            //String loser;
            // Collections.shuffle(deckFirst.getMyCards());
            Collections.shuffle(usersFirst.getDeck().getMyCards());
            Collections.shuffle(usersFirst.getDeck().getMyCards());

            Card Winner = myMain.fight(usersFirst.getDeck().getMyCards().get(0), usersSecond.getDeck().getMyCards().get(0));
            if(Winner == null)
            {
                System.out.println("-------------DRAAAAAWWW----------------");
            }else{
            Collections.shuffle(usersFirst.getDeck().getMyCards());
            Collections.shuffle(usersSecond.getDeck().getMyCards());
            System.out.println("The card who win is: " + Winner.getUsername() + " the card id " + Winner.getCardId());
            if (Winner.getUsername() != usersFirst.getUsername()) {

                try {
                    PreparedStatement updateCards = connection.prepareStatement("UPDATE cards set owner = ? where cardid = ?;");
                    updateCards.setString(1, Winner.getUsername());
                    updateCards.setString(2, usersFirst.getCardId());

                    updateCards.executeUpdate();
                    //remove vielleicht
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
                //usersFirst.getDeck().getMyCards().remove(0);
            } else if (Winner.getUsername() != usersSecond.getUsername()) {
                try {
                    PreparedStatement updateCards = connection.prepareStatement("UPDATE cards set owner = ? where cardid = ?;");
                    updateCards.setString(1, Winner.getUsername());
                    updateCards.setString(2, usersSecond.getCardId());
                    updateCards.executeUpdate();
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
               // usersFirst.getDeck().getMyCards().remove(0);

            }
            }
        }
        // Collections.shuffle(deckSecond.getMyCards());

        //System.out.println(usersFirst.getUsername()+": first user++");
        //System.out.println(usersSecond.getUsername()+": second user++");



        /*
        myMain.fight(deckFirst.getMyCards().get(0), deckSecond.getMyCards().get(0));
        if(deckFirst.getMyCards().get(0).getDamage() > deckSecond.getMyCards().get(0).getDamage())
        {
            deckSecond.getMyCards().remove(0);
            System.out.println(deckFirst.getMyCards().get(0)+ "REMOVING THE SECOND DECK");
        }else if(deckSecond.getMyCards().get(0).getDamage() > deckFirst.getMyCards().get(0).getDamage())
        {
            deckFirst.getMyCards().remove(0);
            System.out.println(deckFirst.getMyCards().get(0)+ "REMOVING THE FIRST DECK");
        } else {
            System.out.println("DRAAAW");
        }
        //}

         */
         return myMain.battleLog();
    }
    public String deleteDeck(Connection connection)
    {
        try {
            PreparedStatement statement = connection.prepareStatement(" DELETE FROM deck where id = ?;");
            statement.setInt(1,3);
            statement.execute();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return "The User kienboec: " + " gives this card: " + cardtrade;
    }
}
