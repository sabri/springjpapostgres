package com.sabrouch.springjpapostgres.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;

/**
 * Created by sabrouch.
 * Date: 1/24/2021
 */
@Entity(name = "StudentIdCard")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "student_card", uniqueConstraints = {@UniqueConstraint(name = "cardNumber", columnNames = "cardNumber")})
public class StudentIdCard {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @Column(nullable = false, updatable = false)
    private Long id;


    @Column( columnDefinition = "Text", nullable = false)
    private String cardNumber;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Student_id", referencedColumnName = "id")
    private Student student;

    public StudentIdCard( String cardNumber, Student student) {
        this.cardNumber = cardNumber;
        this.student = student;
    }
}