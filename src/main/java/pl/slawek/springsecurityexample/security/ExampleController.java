package pl.slawek.springsecurityexample.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class ExampleController {

    @GetMapping("/")
    public String getHome() {
        return "Home Page";
    }

    @GetMapping("/user")
    public String getUser() {
        return "User Page";
    }

    @GetMapping("/admin")
    public String getAdmin() {
        return "Admin Page";
    }
}
