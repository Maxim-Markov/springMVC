package web.DAO;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private EntityManager entityManager;

    @Autowired
    public void setEntityManager(@Qualifier("entityManagerBean") EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void createUser(User user) {
        entityManager.persist(user);
        entityManager.joinTransaction();
        System.out.println("User с именем – " + user.getName() + " добавлен в базу данных");
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> getUsers() {
        return (List<User>) entityManager.createQuery("from User").getResultList();
    }

    @Override
    public User getUser(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void updateUser(long id, User user) {
       /* CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaUpdate<User> criteria = builder.createCriteriaUpdate(User.class);
        Root<User> root = criteria.from(User.class);
        criteria.set(root.get("name"), user.getName());
        criteria.set(root.get("lastName"), user.getLastName());
        criteria.set(root.get("age"), user.getAge());
        criteria.where(builder.equal(root.get("id"), id));
        Query query = entityManager.createQuery(criteria);
        entityManager.joinTransaction();
        query.executeUpdate();*/
           User userFromDB = entityManager.find(User.class, id);
        if (userFromDB != null) {
            userFromDB.setName(user.getName());
            userFromDB.setLastName(user.getLastName());
            userFromDB.setAge(user.getAge());
        }
        entityManager.joinTransaction();
    }

    @Override
    public void deleteUser(long id) {
        User userFromDB = entityManager.find(User.class, id);
        entityManager.joinTransaction();
        if (userFromDB != null) {
            entityManager.remove(userFromDB);
        }

    }

}


