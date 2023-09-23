package pl.slawek.springsecurityexample.security;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class ExampleController {

    private final MyUserDetailsList userDetailsList;

    ExampleController(final MyUserDetailsList userDetailsList) {
        this.userDetailsList = userDetailsList;
    }

    @GetMapping()
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

    @PostMapping("/register/{username}/{pass}")
    public String createUser(@PathVariable String username, @PathVariable String pass) {
        User user = userDetailsList.createUser(username, pass);
        return String.format("<h1>Created:<h1><br> <h1>UserName: %s Password: %s Rola: %s<h1><br> " +
                "możesz zalogować się na to konto", user.getUsername(), user.getPassword(), user.getAuthorities());
    }

    @GetMapping("/users")
    public ResponseEntity<String> getUsers() {
        return ResponseEntity.ok(userDetailsList.getUsers().toString());
    }
}
