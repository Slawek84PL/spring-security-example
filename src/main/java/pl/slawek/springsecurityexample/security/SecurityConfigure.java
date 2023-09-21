package pl.slawek.springsecurityexample.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
class SecurityConfigure {

    private final MyUserDetailsService myUserDerailService;
    private final MyBCryptPasswordEncoder passwordEncoder;

    SecurityConfigure(final MyUserDetailsService myUserDerailService, final MyBCryptPasswordEncoder passwordEncoder) {
        this.myUserDerailService = myUserDerailService;
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    DaoAuthenticationProvider getProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(myUserDerailService);
        provider.setPasswordEncoder(passwordEncoder);
        return provider;
    }


}
