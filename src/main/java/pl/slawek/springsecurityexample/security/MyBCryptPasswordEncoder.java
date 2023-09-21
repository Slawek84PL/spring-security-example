package pl.slawek.springsecurityexample.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
class MyBCryptPasswordEncoder extends BCryptPasswordEncoder {
}
