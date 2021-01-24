package com.sabrouch.springjpapostgres.dao;

import com.sabrouch.springjpapostgres.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


/**
 * Created by sabrouch.
 * Date: 1/23/2021
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("SELECT s from Student s where s.age=?1")
    Optional<Student> findStudentByAge(int s);

    @Query(value = "SELECT * from Student s where s.age between ?1 and ?2", nativeQuery = true)
    Optional<Student> findStudentByAgeBetween(int s , int l);
}
