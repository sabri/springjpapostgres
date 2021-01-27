package com.sabrouch.springjpapostgres.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by sabrouch.
 * Date: 1/27/2021
 */
@Data
@Entity(name = "book" )
@Table(name = "book" )
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "seq", sequenceName = "seq",allocationSize = 1)

public class Book {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq"
    )
    @Column(nullable = false, updatable = false)
    private Long id;
    @Column(nullable = false)
    private String bookName;
    @Column(
            nullable = false,
            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"
    )
    private LocalDateTime createdAt;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name ="student_book_fk"))
    private Student student;



}
