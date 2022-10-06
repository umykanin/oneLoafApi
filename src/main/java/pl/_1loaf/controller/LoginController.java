package pl._1loaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login-form";
    }

    @GetMapping("/logout-logout")
    public String logout() {
        return "logout-success";
    }
}
