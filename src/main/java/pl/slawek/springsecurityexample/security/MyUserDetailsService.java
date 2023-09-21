package pl.slawek.springsecurityexample.security;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
class MyUserDetailsService implements UserDetailsService {

    private final MyBCryptPasswordEncoder passwordEncoder;

    MyUserDetailsService(final MyBCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        return new User("user", passwordEncoder.encode("user"), Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")));
    }
}
