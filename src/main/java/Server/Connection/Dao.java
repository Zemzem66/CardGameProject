package Server.Connection;

import java.sql.Connection;

public interface Dao {
    void connection();
    void update();
    void delete();
    Connection add();
}
