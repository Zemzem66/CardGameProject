package Server.HttpServer.Handle;

import Server.HttpServer.user.User;

import java.util.ArrayList;
import java.util.List;

public class Dao {

    private List<User> userData;

    public Dao()
    {
        userData = new ArrayList<>();
        userData.add(new User(1,"Mustafa","1233"));
        userData.add(new User(2,"zx","1233"));
        userData.add(new User(3,"as","1233"));
    }

    public User getUser(Integer ID)
    {
        User foundUser = userData.stream().filter(user -> ID == user.getId()).findAny().orElse(null);
        return foundUser;
    }

    public List<User> getUser()
    {
        return userData;
    }


    public void addUser(User user)
    {
        userData.add(user);
    }
}
