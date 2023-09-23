package pl.slawek.springsecurityexample.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class MyUserDetailsService implements UserDetailsService {


    private final MyUserDetailsList myUserDetailsList;

    MyUserDetailsService(final MyUserDetailsList myUserDetailsList) {
        this.myUserDetailsList = myUserDetailsList;
    }

    @Override
    public UserDetails loadUserByUsername(final String username) {
        List<User> userList = myUserDetailsList.getUsers();

        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                return new User(user.getUsername(), user.getPassword(),
                        true, true,
                        true, true,
                        user.getAuthorities());
            }
            }
        throw new UsernameNotFoundException("Nie znaleziono użytkownika");
    }
}
