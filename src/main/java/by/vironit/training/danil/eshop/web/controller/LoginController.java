package by.vironit.training.danil.eshop.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class LoginController {

    /*@RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String getAuthorizationPage(Model model){
        return "login";
    }*/

   /* @Autowired
    public UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView model = new ModelAndView();
        model.setViewName("login");
        return model;
    }*/
   @GetMapping(value="/login")
   public String loginPage(@RequestParam(value="from", required=false) String from, ModelMap model, HttpSession session) throws IOException {
       session.setAttribute("referURI", from);
       return "login";
   }

}

