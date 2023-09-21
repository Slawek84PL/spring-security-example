package pl.slawek.springsecurityexample.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class MyUserDetailsService implements UserDetailsService {


    private final MyUserDetailsList users;

    MyUserDetailsService(final MyUserDetailsList users) {
        this.users = users;
    }

    @Override
    public UserDetails loadUserByUsername(final String username) {
        List<User> userList = users.users;

        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                return user;
            }
            }
        throw new UsernameNotFoundException("Nie znaleziono użytkownika");
    }
}
