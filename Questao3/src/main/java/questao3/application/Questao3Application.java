package questao3.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@ComponentScan(value = "questao3.application")
@SpringBootApplication
@EnableAsync
@EnableSwagger2
public class Questao3Application {
	public static void main(String[] args) {
		SpringApplication.run(Questao3Application.class, args);
	}
//	http://localhost:8080/swagger-ui.html#/
}