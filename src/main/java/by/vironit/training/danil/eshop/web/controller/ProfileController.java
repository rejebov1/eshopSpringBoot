package by.vironit.training.danil.eshop.web.controller;

import by.vironit.training.danil.eshop.model.User;
import by.vironit.training.danil.eshop.service.UserService;
import by.vironit.training.danil.eshop.web.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.io.IOException;
import java.security.Principal;

@Controller
@RequestMapping(value = "/profile")
public class ProfileController {

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private UserService userService;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(userValidator);
    }

    @RequestMapping(method = RequestMethod.GET)
    public String profile(ModelMap model, Principal principal) throws IOException {
        model.addAttribute("user", userService.getByEmail(principal.getName()));
        return "profile";
    }

    @RequestMapping(value = {"/edit"}, method = RequestMethod.GET)
    public String editProfile(ModelMap model, Principal principal) throws IOException {
        model.addAttribute("user", userService.getByEmail(principal.getName()));
        return "editProfile";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String saveNewProfile(@Valid @ModelAttribute("user") User user, BindingResult result, Principal principal) {
        if (result.hasErrors()) {
            for (FieldError error : result.getFieldErrors()) {
                String fieldName = error.getField();
                if (!fieldName.equals("email") && !fieldName.equals("password") && !fieldName.equals("confirmPassword")) {
                    return "editProfile";
                }
            }
        }
        user.setId( userService.getByEmail(principal.getName()).getId());
        userService.updateUserProfile(user);
        return "redirect:/profile";
    }

    @RequestMapping(value = {"/changePassword"}, method = RequestMethod.GET)
    public String changePasswordForm(ModelMap model) throws IOException {
        model.addAttribute("user", new User());
        return "changePassword";
    }

    @RequestMapping(value = "/changePassword", method = RequestMethod.POST)
    public String saveNewPassword(@Valid @ModelAttribute("user") User user, BindingResult result, Principal principal) {
        if (result.hasErrors()) {
            for (FieldError error : result.getFieldErrors()) {
                String fieldName = error.getField();
                if (fieldName.equals("password") || fieldName.equals("confirmPassword")) {
                    return "changePassword";
                }
            }
        }
        user.setId( userService.getByEmail(principal.getName()).getId());
        userService.updateUserPassword(user);
        return "redirect:/profile";
    }
}
