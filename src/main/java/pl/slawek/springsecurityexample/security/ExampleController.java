package pl.slawek.springsecurityexample.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
class ExampleController {

    private final MyUserDetailsList userDetailsList;

    ExampleController(final MyUserDetailsList userDetailsList) {
        this.userDetailsList = userDetailsList;
    }

    @GetMapping("/")
    public String getHome() {
        return "<h1>Home Page<h1>";
    }

    @GetMapping("/user")
    public String getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        return String.format("<h1>Hello %s on User Page<h1>", authentication.getName());
    }

    @GetMapping("/admin")
    public String getAdmin() {
        return "<h1>Admin Page<h1>";
    }

    @GetMapping("/register/{username}/{pass}")
    public String createUser(@PathVariable String username, @PathVariable String pass) {
        User user = userDetailsList.createUser(username, pass);
        return String.format("<h1>Created:<h1><br> <h1>UserName: %s Password: %s Rola: %s<h1><br> " +
                "możesz zalogować się na to konto", user.getUsername(), user.getPassword(), user.getAuthorities());
    }
}
