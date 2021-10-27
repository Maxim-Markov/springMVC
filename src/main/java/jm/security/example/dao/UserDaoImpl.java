package jm.security.example.dao;

import jm.security.example.model.Role;
import jm.security.example.model.User;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

@Repository
public class UserDaoImpl implements UserDao {
    private final Map<String, User> userMap = Map.of(
            "test", new User(1L, "test", "test", Set.of(new Role(3L, "ROLE_UNDEFINED"),new Role(1L,"ROLE_USER"))),
            "admin",new User(1L, "admin", "admin", Set.of(new Role(3L, "ROLE_UNDEFINED"),new Role(2L,"ROLE_ADMIN")))); // name - уникальное значение, выступает в качестве ключа Map

    @Override
    public User getUserByName(String name) {
        if (!userMap.containsKey(name)) {
            return null;
        }

        return userMap.get(name);
    }
}

