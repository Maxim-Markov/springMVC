package web.DAO;


import org.springframework.beans.factory.annotation.Autowired;
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

    private EntityManagerFactory entityManagerFactory;

    @Autowired
    public void setSessionFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public void createUser(User user) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        System.out.println("User с именем – " + user.getName() + " добавлен в базу данных");
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> getUsers() {
        EntityManager em = entityManagerFactory.createEntityManager();
        List<User> users = em.createQuery("from User").getResultList();
        em.close();
        return users;
    }

    @Override
    public User getUser(long id) {

        EntityManager em = entityManagerFactory.createEntityManager();
        User user = em.find(User.class, id);
        em.close();
        return user;
    }

    @Override
    public void updateUser(long id, User user) {

        EntityManager em = entityManagerFactory.createEntityManager();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaUpdate<User> criteria = builder.createCriteriaUpdate(User.class);
        Root<User> root = criteria.from(User.class);
        criteria.set(root.get("name"), user.getName());
        criteria.set(root.get("lastName"), user.getLastName());
        criteria.set(root.get("age"), user.getAge());
        criteria.where(builder.equal(root.get("id"), id));
        Query query = em.createQuery(criteria);
        em.joinTransaction();
        query.executeUpdate();
//           User userFromDB = em.find(User.class, id);
//        if (userFromDB != null) {
//            userFromDB.setName("fef");
//        }
        em.close();
        System.out.println("f");
    }

    @Override
    public void deleteUser(long id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        User userFromDB = em.find(User.class, id);
        em.joinTransaction();
        if (userFromDB != null) {
            em.remove(userFromDB);
        }
        em.close();

    }

}


