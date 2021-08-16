package io.agilehandy.com.demoopenshiftpalyground;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class DemoOpenshiftPalygroundApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoOpenshiftPalygroundApplication.class, args);
	}

}
