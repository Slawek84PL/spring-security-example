package pl.slawek.springsecurityexample.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class ExampleController {

    @GetMapping("/")
    public String getHome() {
        return "<h1>Home Page<h1>";
    }

    @GetMapping("/user")
    public String getUser() {
        return "<h1>User Page<h1>";
    }

    @GetMapping("/admin")
    public String getAdmin() {
        return "<h1>Admin Page<h1>";
    }
}
