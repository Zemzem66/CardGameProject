package Server.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StackDaoImpl implements Dao {
    @Override
    public void connection() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/CardGame","postgres","");
            PreparedStatement statement = connection.prepareStatement("INSERT INTO stack (stack_id,card) VALUES (?,?); ");
            StackDaoImpl data = new StackDaoImpl();
            statement.setInt(1, 1);
            //statement.setString(2,data.create());// ERROR????? create
            //statement.setString(3, data.getPassword());
            statement.execute();
        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }

    @Override
    public Connection add() {

        return null;
    }

   /* @Override
    public CardDaoImpl create() {
        //INSERT INTO CARD?????????
        return null;
    }*/
}
