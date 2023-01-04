package Server.Connection;

public interface Dao {
    void connection();

    String update(String Username, String password);

    void delete();
   // Connection add();
    String add(String Username, String password);
}
