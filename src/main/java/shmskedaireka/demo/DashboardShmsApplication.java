package shmskedaireka.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import shmskedaireka.demo.Controller.UserController;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@RestController
@ComponentScan(basePackageClasses = UserController.class)
public class DashboardShmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DashboardShmsApplication.class, args);
	}

	@GetMapping("/login")
	public String Login() {
		return "hello";
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*");
			}
		};
	}

}
