package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.DAO.UserDao;
import web.model.User;


import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDao dao;

    @Autowired
    public void setDao(UserDao dao) {
        this.dao = dao;
    }

    @Override
    @Transactional
    public List<User> getUsers() {
        return dao.getUsers();
    }

    @Override
    @Transactional
    public User getUser(long id) {
        return dao.getUser(id);
    }

    @Override
    @Transactional
    public void updateUser(long id, User user) {
        dao.updateUser(id, user);
    }


    @Override
    @Transactional
    public void deleteUser(long id) {
        dao.deleteUser(id);
    }

    @Override
    @Transactional
    public void createUser(User user) {
        dao.createUser(user);
    }
}
