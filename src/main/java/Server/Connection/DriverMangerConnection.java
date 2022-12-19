package Server.Connection;
import com.example.cardgame.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DriverMangerConnection {

    public static void Connection /*connection*/()
    {
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/CardGame","postgres","");
            PreparedStatement statement = connection.prepareStatement("INSERT INTO user (userId,username, password) VALUES (?,?,?); ");

            User data = new User("admin","admin");
            statement.setInt(1, 1);
            statement.setString(2,data.getUsername());
            statement.setString(3, data.getPassword());
            statement.execute();
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
        
    }
    
     
    public static void main(String[] args)
    {
        DriverMangerConnection.Connection();
        //DriverMangerConnection.connection();
    }
}
