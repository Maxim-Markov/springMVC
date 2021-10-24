package web.DAO;


import web.model.User;

import java.util.List;

public interface UserDao {
    void createUser(User user);

    List<User> getUsers();

    User getUser(long id);

    void updateUser(long id, User user);

    void deleteUser(long id);
}
