package pl.slawek.springsecurityexample.security;

import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.stereotype.Component;

@Component
class MyDaoAuthenticationProvider extends DaoAuthenticationProvider {

    MyDaoAuthenticationProvider(final MyUserDetailsService myUserDerailService, final MyBCryptPasswordEncoder passwordEncoder) {
        super.setPasswordEncoder(passwordEncoder);
        super.setUserDetailsService(myUserDerailService);
    }

}
