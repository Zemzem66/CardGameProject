package Server.Connection;
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
    
     public String add(Connection connection,String username, String password){
       try{

           PreparedStatement statement = connection.prepareStatement("INSERT INTO accounts (username, password) VALUES (?,?); ");

           statement.setString(1,username);
           statement.setString(2, password);
           statement.execute();
           System.out.println(username + "-----" + password  + "-----");

       }catch (SQLException exception)
       {
           exception.printStackTrace();
       }
         return "User " + username + " was created!";
     }
    public static void main(String[] args)
    {
        DriverMangerConnection.Connection();
        //DriverMangerConnection.connection();
    }

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
            statement.execute();
            System.out.println("PackageID"  + packedid + " ----- " + "-----" );

        }catch (SQLException exception)
        {
            exception.printStackTrace();
        }
        return  packedid+" WITH PACKED was created!";

    }

    public String createCard(Connection connection,String cardId,double damage, String ctype, String etype, String name)
    {
        try{
            PreparedStatement statement = connection.prepareStatement("INSERT INTO cards (cardId,damage, ctype,etype,name) VALUES (?,?,?,?,?); ");
            statement.setString(1,cardId);
            statement.setDouble(2,damage);
            statement.setString(3,ctype);
            statement.setString(4,etype);
            statement.setString(5,name);

            statement.execute();
            System.out.println("Package"  + damage + " ----- " + ctype  + "-----" + damage+ "------"+ name);

        }catch (SQLException exception)
        {
            exception.printStackTrace();
        }
        return  damage+" WITH " + name + "and" +damage+" was created "+ ctype +"-------" + etype;
    }
}
