package shopAdmin.controllers;

import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    public String loginPage(){
        return "login";
    }
}
