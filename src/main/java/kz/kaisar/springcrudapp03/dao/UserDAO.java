package kz.kaisar.springcrudapp03.dao;

import kz.kaisar.springcrudapp03.models.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDAO {

    private static int USERS_COUNT;

    private List<User> users;

    {
        users = new ArrayList<>();

        users.add(new User(++USERS_COUNT, "User #1"));
        users.add(new User(++USERS_COUNT, "User #2"));
        users.add(new User(++USERS_COUNT, "User #3"));
        users.add(new User(++USERS_COUNT, "User #4"));
        users.add(new User(++USERS_COUNT, "User #5"));
    }

    public List<User> index() {
        return users;
    }

    public User show(int id) {
        return users.stream().filter(user->user.getId() == id).findAny().orElse(null);
    }

    public void save(User user) {
        user.setId(++USERS_COUNT);
        users.add(user);
    }
}
