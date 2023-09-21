package pl.slawek.springsecurityexample.security;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
class MyUserDetailsList {

    List<User> users = new ArrayList<>();

    private final MyBCryptPasswordEncoder passwordEncoder;

    MyUserDetailsList(final MyBCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;

        users.add(new User("user",
                passwordEncoder.encode("user"),
                Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"))));
        users.add(new User("admin",
                passwordEncoder.encode("admin"),
                Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN"))));
    }

    List<User> getUsers() {
        return users;
    }

    User createUser(final String username, final String pass) {
        User user = new User(username,
                passwordEncoder.encode(pass),
                Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")));
        users.add(user);
        return user;
    }
}
