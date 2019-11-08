package by.pvt.util;

import by.pvt.model.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


@Component
@PropertySource("classpath:validator.properties")
public class DeviceRegistrationValidator implements Validator {

    @Autowired
    private Environment env;

    @Override
    public boolean supports(Class<?> clazz) {
        return Device.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Device device = (Device) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"location","",env.getProperty("Required"));
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"ipAddress","",env.getProperty("Required"));

    }
}
