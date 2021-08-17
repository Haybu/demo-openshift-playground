package io.agilehandy.com.demoopenshiftpalyground;

import io.agilehandy.com.demoopenshiftpalyground.students.Student;
import io.agilehandy.com.demoopenshiftpalyground.students.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootApplication
@EnableMongoRepositories
@Slf4j
public class DemoOpenshiftPalygroundApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoOpenshiftPalygroundApplication.class, args);
	}

	@Bean
	ApplicationListener<ApplicationStartedEvent> start(StudentRepository repository) {
		return event -> {
			Flux.just("Haytham", "Eyman", "Monira", "Mariam")
					.zipWith(Flux.just("Mohamed", "Ahmad", "Mahmoud", "Osman"))
					.map(tuple2 -> new Student(null, tuple2.getT1(), tuple2.getT2()) )
					.flatMap(repository::save)
					.thenMany(repository.findAll())
					.doOnNext(student -> log.info(student.toString()))
					.subscribe();
		};
	}
}
