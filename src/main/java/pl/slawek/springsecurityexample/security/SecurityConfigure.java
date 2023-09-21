package pl.slawek.springsecurityexample.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

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

    @Bean
    SecurityFilterChain buildChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize  -> authorize
                            .requestMatchers("/", "/swagger-ui/index.html","/api-docs").permitAll()
                            .requestMatchers("/user").hasAnyRole("USER", "ADMIN")
                            .requestMatchers("/admin", "/register/**").hasRole("ADMIN"))
                .formLogin(Customizer.withDefaults())
                .logout(Customizer.withDefaults());
        return http.build();
    }


}
