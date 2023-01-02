package Server.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CardDaoImpl implements Dao{


    @Override
    public void connection() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/CardGame","postgres","");
            PreparedStatement statement = connection.prepareStatement("INSERT INTO card (card_id,type) VALUES (?,?); ");
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
    /*
    @Override
    public String getType() {
        //random generator for Spell or Monster
        int random = 0;
        if(random % 2 == 0)
        {
            random++;
            return "MonsterType";
        }
        else {
            random++;
            return "SpellType";
        }
    }*/

    @Override
    public void update() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/CardGame","postgres","");
            PreparedStatement statement = connection.prepareStatement(" update card (card_id,type) VALUES (?,?); ");
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
    public void delete() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/CardGame","postgres","");
            PreparedStatement statement = connection.prepareStatement("drop card (card_id,type) VALUES (?,?); ");
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
    public Connection add() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/CardGame","postgres","");
            PreparedStatement statement = connection.prepareStatement("INSERT INTO card (card_id,type) VALUES (?,?); ");
            CardDaoImpl data = new CardDaoImpl();
            statement.setInt(1, 1);
            // statement.setString(2,data.getType());
            //statement.setString(3, data.getPassword());
            statement.execute();
        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return null;
    }
}
