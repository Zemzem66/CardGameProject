package Server.Connection;
import com.example.cardgame.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class UserDaoImpl implements Dao{

    //private final EntityManager entityManager;

    //public UserDaoImpl(EntityManager entityManager) { // so richtig????
      //  this.entityManager = entityManager;
    //}



    @Override
    public void connection() {

    }



    @Override
    public String update(String Username, String password ) {
        try {
            //Login
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/CardGame","postgres","");
            PreparedStatement statement = connection.prepareStatement(" SELECT * FROM user where username = ? AND password = ?; ");

            User data = new User("admin","admin");
            statement.setString(1, Username);
            statement.setString(2,password);
           // statement.setString(3, password);
            statement.execute();
            return "Login with" + Username+ "was succesful";

        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return "Tester";
    }

    @Override
    public void delete() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/CardGame","postgres","");
            PreparedStatement statement = connection.prepareStatement("DROP user (userId,username, password) VALUES (?,?,?); ");

            User data = new User("admin","admin");
            statement.setInt(1, 1);
            statement.setString(2,data.getUsername());
            statement.setString(3, data.getPassword());
            statement.execute();
        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }



    @Override
    public String add(String Username, String password) {
        //Create
       // entityManager.persist(userDB);
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/CardGame","postgres","");
            PreparedStatement statement = connection.prepareStatement("INSERT INTO user(username, password) VALUES (?,?); ");

            User data = new User("admin","admin");

           // statement.setInt(1, 1);
            statement.setString(1,Username);
            statement.setString(2,password);
            statement.execute();
            return Username+"was created succesfully";
        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return "";
    }
}
