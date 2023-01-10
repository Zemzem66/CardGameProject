package Server.Connection;
import com.example.cardgame.Card;
import com.example.cardgame.User;

import java.sql.*;
import java.util.Scanner;

public class DriverMangerConnection {
    int newId ;
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

    public String createCard(Connection connection,String cardId,double damage, String ctype, String etype, String name, String owner)
    {

        try{
            ResultSet rs;
            Statement stmt;
            stmt =connection.createStatement();
            rs = stmt.executeQuery("SELECT id, cardId from packages;");
            while (rs.next()) {
                newId = rs.getInt(1);
                String cardTestId = rs.getString(2);
                System.out.println("TESSSST CARRRD "+ cardTestId);
                System.out.println("Package Number : "+ newId);
            }
            PreparedStatement statement = connection.prepareStatement("INSERT INTO cards (cardId,damage, ctype,etype,monsterSpellName,owner,id) VALUES (?,?,?,?,?,?,?); ");
            statement.setString(1,cardId);
            statement.setDouble(2,damage);
            statement.setString(3,ctype);
            statement.setString(4,etype);
            statement.setString(5,name);
            statement.setString(6,owner);
            statement.setInt(7,newId);

            statement.execute();
            System.out.println("Package"  + damage + " ----- " + ctype  + "-----" + damage+ "------"+ name+ "owner of the cards: " +owner + "THE ID of the card is " +newId);

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
                        statementUpdate.setString(1, user);
                        statementUpdate.setInt(2, miniumID);
                        System.out.println("OWNER TESSSSST: " + miniumID);
                        statementUpdate.executeUpdate();

                        PreparedStatement deleteId = connection.prepareStatement("DELETE FROM packages WHERE id = ?;");
                        deleteId.setInt(1,miniumID);
                        deleteId.execute();
                    }


                }

           // }
            rs.close();
            stmt.close();


        }catch (SQLException exception)
        {
            exception.printStackTrace();
        }
        return  token+" : return value of token ";

    }
    public String AcquirePackageA(Connection connection)
    {
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

    }

}
