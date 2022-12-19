package Server.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MonsterDaoImpl implements MonsterDao{
    @Override
    public void connection() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/CardGame","postgres","");
            PreparedStatement statement = connection.prepareStatement("INSERT INTO monster(monsterId,monsterType, elementType) VALUES (?,?,?); ");

            MonsterDaoImpl data = new MonsterDaoImpl();
            statement.setInt(1, 1);
            statement.setString(2,data.elementType());
            statement.setString(3, data.monsterType());
            statement.execute();
        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }
    public String elementType() {
        int random = 0;
        if(random % 2 == 0)
        {
            random++;
            return "Water";
        }
        else if(random % 3 == 0)
        {
            random++;
            return "Normal";
        }
        else {
            random++;
            return "Fire";
        }
    }

    @Override
    public String monsterType() {
        int random = 0;
        if(random % 2 == 0)
        {
            random++;
            return "Wizzard";
        }
        else if(random % 3 == 0)
        {
            random++;
            return "Elve";
        }
        else {
            random++;
            return "Ork";
        }
    }
}
