package pl.slawek.springsecurityexample.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
class SecurityConfigure {

    private final MyDaoAuthenticationProvider provider;

    SecurityConfigure(final MyDaoAuthenticationProvider provider) {
        this.provider = provider;
    }

    @Bean
    SecurityFilterChain buildChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize  -> authorize
                            .requestMatchers("/").permitAll()
                            .requestMatchers(WHITE_LIST).permitAll()
                            .requestMatchers("/user").hasAnyRole("USER", "ADMIN")
                            .requestMatchers("/admin", "/users").hasRole("ADMIN")
                            .requestMatchers(HttpMethod.POST,"/register/{username}/{pass}").hasRole("ADMIN")
                            .anyRequest().authenticated())
                .authenticationProvider(provider)
                .formLogin(Customizer.withDefaults())
                .logout(logoutConfigurer -> logoutConfigurer.logoutSuccessUrl("/"));
        return http.build();
    }

    private static final String[] WHITE_LIST = {
            "/api/v1/auth/**",
            "/v3/api-docs/**",
            "/v3/api-docs.yaml",
            "/swagger-ui/**",
            "/swagger-ui.html"
    };

}
