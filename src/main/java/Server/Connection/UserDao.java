package Server.Connection;

public interface UserDao {
    void create(UserDB userDB);
    UserDB read(Long id);
    void update(UserDB userDB);
    void delete(String userName);

}
