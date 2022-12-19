package Server.Connection;
import com.example.cardgame.User;

import javax.persistence.EntityManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class UserDaoImpl implements Dao{

    private final EntityManager entityManager;

    public UserDaoImpl(EntityManager entityManager) { // so richtig????
        this.entityManager = entityManager;
    }

    @Override
    public void create(UserDB userDB) {

        entityManager.persist(userDB);
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

    }

    @Override
    public void connection() {

    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }

    @Override
    public void add() {

    }
}
