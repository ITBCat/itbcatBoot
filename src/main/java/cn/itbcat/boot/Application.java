package cn.itbcat.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
@EnableWebMvc
@EnableCaching
@SpringBootApplication
@PropertySources(value = { @PropertySource("classpath:messages.properties") })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
