package by.pvt.repository;

import by.pvt.pojo.AppUser;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public class UserRepository {


    @Autowired
    private SessionFactory sessionFactory;

    public void save(AppUser appUser) {
        sessionFactory.getCurrentSession().save(appUser);
    }

    @Transactional
    public AppUser findUserByEmail(String email) {

            return sessionFactory.getCurrentSession()
                    .createQuery("from AppUser where email like :param1", AppUser.class)
                    .setParameter("param1", email)
                    .list().stream().findFirst().orElse(null);
        }
    }


