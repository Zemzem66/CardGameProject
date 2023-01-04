package Server.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeckDaoImpl implements Dao{

    @Override
    public void connection() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/CardGame","postgres","");
            PreparedStatement statement = connection.prepareStatement("INSERT INTO deck(deck_id,stack) VALUES (?,?); ");
            CardDaoImpl data = new CardDaoImpl();
            statement.setInt(1, 1);
           // statement.setString(2,data.getType());
            //statement.setString(3, data.getPassword());
            statement.execute();
        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }



    @Override
    public String update(String Username, String password) {
        return null;
    }

    @Override
    public void delete() {

    }

    @Override
    public String add(String Username, String password) {

        return null;
    }

    /*
    @Override
    public StackDaoImpl create() {
        //HOW TO CREATE A STACK
        return null;
    }
    */

}
