package com.sabrouch.springjpapostgres;

import com.github.javafaker.Faker;
import com.sabrouch.springjpapostgres.dao.StudentRepository;
import com.sabrouch.springjpapostgres.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringjpapostgresApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringjpapostgresApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args -> {
          generateListOfStudent(studentRepository);
          studentRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));

        };
    }
    private void generateListOfStudent(StudentRepository studentRepository){
        Faker f = new Faker();
        for (int i = 0; i < 20; i++) {
            String name = f.name().firstName(); // Miss Samanta Schmidt
            String lastName = f.name().lastName(); // Barton
            String email = String.format("%s%s@gmail.com", name, lastName);
            int age = f.number().numberBetween(17,65);// Emory
            Student student = new Student(name, lastName,email,age);
            studentRepository.save(student);
        }
    }


}
