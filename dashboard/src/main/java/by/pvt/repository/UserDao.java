package by.pvt.repository;

import by.pvt.model.AppUser;

public interface UserDao {

    void save(AppUser appUser);

    AppUser findUserByEmail(String email);

}
