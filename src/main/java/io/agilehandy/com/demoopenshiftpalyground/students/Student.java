package io.agilehandy.com.demoopenshiftpalyground.students;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@AllArgsConstructor
@Document
@ToString
public class Student {

    @Id
    private String id;
    private String firstName;
    private String lastName;

}