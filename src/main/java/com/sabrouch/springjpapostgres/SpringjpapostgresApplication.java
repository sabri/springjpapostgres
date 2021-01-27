package com.sabrouch.springjpapostgres;

import com.github.javafaker.Faker;
import com.sabrouch.springjpapostgres.dao.StudentIdCardRepository;
import com.sabrouch.springjpapostgres.dao.StudentRepository;
import com.sabrouch.springjpapostgres.entity.Student;
import com.sabrouch.springjpapostgres.entity.StudentIdCard;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class SpringjpapostgresApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringjpapostgresApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository, StudentIdCardRepository studentIdCardRepository){
        return args -> {
         generateListOfStudent(studentRepository);
            Faker faker = new Faker();

            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
            String email = String.format("%s.%s@amigoscode.edu", firstName, lastName);
            Student student = new Student(
                    firstName,
                    lastName,
                    email,
                    faker.number().numberBetween(17, 55));

            StudentIdCard studentIdCard = new StudentIdCard(
                    "123456789",
                    student);

            studentIdCardRepository.save(studentIdCard);

            studentRepository.findById(1L)
                    .ifPresent(System.out::println);

            studentIdCardRepository.findById(1L)
                    .ifPresent(System.out::println);

           // studentRepository.deleteById(1L);
        };
    }
    private void generateListOfStudent(StudentRepository studentRepository){
        Faker faker = new Faker();
        for (int i = 0; i < 20; i++) {
            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
            String email = String.format("%s.%s@amigoscode.edu", firstName, lastName);
            Student student = new Student(
                    firstName,
                    lastName,
                    email,
                    faker.number().numberBetween(17, 55));
            studentRepository.save(student);
        }

    }


}
