package questao2.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@ComponentScan(value = "questao2.application")
@SpringBootApplication
@EnableAsync
@EnableSwagger2
public class Questao2Application {
	public static void main(String[] args) {
		SpringApplication.run(Questao2Application.class, args);
	}
//	http://localhost:8080/swagger-ui.html#/
}
