package Server.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SpellDaoImpl implements Dao{


    @Override
    public void connection() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/CardGame","postgres","");
            PreparedStatement statement = connection.prepareStatement("INSERT INTO spell(spellId,monsterType, elementType) VALUES (?,?,?); ");

            SpellDaoImpl data = new SpellDaoImpl();
            statement.setInt(1, 1);
           // statement.setString(2,data.elementType());
          //  statement.setString(3, data.spellType());
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

 */
/*
    @Override
    public String spellType() {
        int random = 0;
        if(random % 2 == 0)
        {
            random++;
            return "NormalSpell";
        }
        else if(random % 3 == 0)
        {
            random++;
            return "WaterSpell";
        }
        else {
            random++;
            return "FireSpell";
        }
    } */
}
