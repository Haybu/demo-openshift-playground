package io.agilehandy.com.demoopenshiftpalyground.students;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping("school")
@AllArgsConstructor
@RestController
@Slf4j
public class StudentController {

    private StudentService registrationService;

    @GetMapping("/students")
    public Flux<Student> getAll() {
        log.info("::GET_ALL Students::");
        return registrationService.getAll();
    }

    @PutMapping("/students")
    public Mono update(@RequestBody final Student student) {
        log.info("::Update the Student record::");
        return registrationService.update(student);
    }

    @PostMapping("/students")
    public Mono save(@RequestBody final Student student) {
        log.info("Will register the student :: "+ student.getId() + " :: " + student.getFirstName());
        return registrationService.save(student);
    }

    @GetMapping("/students/{id}")
    public Mono<Student> getById(@PathVariable("id") final String id) {
        log.info("::Will Return a Student::");
        return registrationService.getById(id);
    }

    @DeleteMapping("/students/{id}")
    public Mono deleteById(@PathVariable final String id) {
        log.info("::Will delete a Student::");
        return registrationService.delete(id);
    }
}
