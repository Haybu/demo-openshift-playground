package io.agilehandy.com.demoopenshiftpalyground;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class MyController {

    @GetMapping("/")
    public Mono<String> ping() {
        return Mono.just("Hello from OpenShift!");
    }
}
