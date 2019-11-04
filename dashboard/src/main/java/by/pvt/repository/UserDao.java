package by.pvt.repository;

import by.pvt.pojo.AppUser;

public interface UserDao {

    void save(AppUser appUser);

    AppUser findUserByEmail(String email);

}
