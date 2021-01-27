package com.sabrouch.springjpapostgres.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sabrouch.
 * Date: 1/23/2021
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SequenceGenerator(name = "seq", sequenceName = "seq",allocationSize = 1)
@Table( uniqueConstraints = {@UniqueConstraint(name = "email", columnNames ="email")})
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @Column(nullable = false)
    private Long id;
    @Column(nullable = false, columnDefinition = "Text")
    private String name;
    @Column(nullable = false,columnDefinition = "Text")
    private String lastname;
    @Column(nullable = false,columnDefinition = "Text")
    private String email;
    @Column(nullable = false)
    private Integer age;
    @OneToOne(
            mappedBy = "student",
            orphanRemoval = true
    )
    private StudentIdCard studentIdCard;
    @OneToMany(
            mappedBy = "student",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.LAZY
    )
    private List<Book> books = new ArrayList<>();

    public Student(String name, String lastname, String email, Integer age) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.age = age;
    }


}
