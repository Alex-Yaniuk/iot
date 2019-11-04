package by.pvt.repository.impl;

import by.pvt.pojo.AppUser;
import by.pvt.repository.UserDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public class UserRepositoryImpl implements UserDao {


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


