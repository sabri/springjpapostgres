package com.sabrouch.springjpapostgres;

import com.sabrouch.springjpapostgres.dao.StudentRepository;
import com.sabrouch.springjpapostgres.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
            Student s1 = new Student("sabri", "baazaoui", "baazaouisabri@gmail.com", 30);
            Student s2 = new Student("Med", "baazaouzi", "baazaouissabri@gmail.com", 20);

            List<Student> l =new ArrayList<>();
            l.add(s1);
            l.add(s2);
            List<Student> s11 = List.of(s1, s2);
            studentRepository.saveAll(s11);
           // l.forEach(student -> studentRepository.save(student));
            System.out.println(studentRepository.count());
            //studentRepository.deleteById(2L);
            List<Student> all = studentRepository.findAll();
            all.forEach(System.out::println);
            //studentRepository.findById(2l).ifPresentOrElse(System.out::println,()-> System.out.println("is not exist"));
           // studentRepository.findById(3l).ifPresentOrElse((student)->System.out.println(student),()-> System.out.println("is not exist"));
            studentRepository.findStudentByAge(20).ifPresentOrElse(System.out::println,()-> System.out.println("not exist"));
            studentRepository.findStudentByAgeBetween(20, 22).ifPresentOrElse(System.out::println,()-> System.out.println("not exist"));

        };
    }


}
