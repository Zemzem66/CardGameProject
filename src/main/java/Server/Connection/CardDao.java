package Server.Connection;

import java.sql.Connection;

public interface CardDao {
    void connection();
    String getType();
    String update();
    void delete();
    Connection add(String Username, String password);
}
