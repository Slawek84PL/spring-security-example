package pl.slawek.springsecurityexample;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Security Example", description = "Slawek84PL", version = "1.0"))
public class SpringSecurityExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityExampleApplication.class, args);
	}

}
