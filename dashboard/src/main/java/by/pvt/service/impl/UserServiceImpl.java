package by.pvt.service.impl;

import by.pvt.model.AppUser;
import by.pvt.repository.UserDao;
import by.pvt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public boolean registerNewUser(AppUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return true;
    }
}
