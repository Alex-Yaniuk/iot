package by.pvt.util;

import by.pvt.model.AppUser;
import by.pvt.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
@PropertySource("classpath:validator.properties")
public class UserRegistrationValidator implements Validator {

    @Autowired
    private Environment env;

    @Autowired
    private UserDao userDao;

    @Override
    public boolean supports(Class<?> aClass) {
        return AppUser.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        AppUser user = (AppUser) o;
        if (userDao.findUserByEmail(user.getEmail()) != null) {
            errors.rejectValue("email", "", env.getProperty("Duplicate.email"));
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"firstName","",env.getProperty("Required"));
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"lastName","",env.getProperty("Required"));
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"email","",env.getProperty("Required"));
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "", env.getProperty("Required"));
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmedPassword", "", env.getProperty("Required"));

        if (!user.getPassword().equals(user.getConfirmedPassword())) {
            errors.rejectValue("confirmedPassword", "", env.getProperty("Different.password"));
        }


    }
}
