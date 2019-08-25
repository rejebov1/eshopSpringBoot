package by.vironit.training.danil.eshop.web;


import by.vironit.training.danil.eshop.model.User;
import by.vironit.training.danil.eshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Component
public class UserValidator implements Validator {

    @Autowired
    private UserService userService;


    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;
        if (user.getPassword() != null && !user.getPassword().equals(user.getConfirmPassword())) {
            errors.rejectValue("confirmPassword", "reg.user.passwordsNotMatch", "Passwords not match");
        }
    }

}


