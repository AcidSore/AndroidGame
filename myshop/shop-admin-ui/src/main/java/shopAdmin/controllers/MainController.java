package shopAdmin.controllers;

import org.springframework.stereotype.Controller;

@Controller
public class MainController {

    public String indexPage(){
        return "index";
    }
}
