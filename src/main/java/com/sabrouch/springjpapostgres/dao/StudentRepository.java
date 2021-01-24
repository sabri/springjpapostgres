package com.sabrouch.springjpapostgres.dao;

import com.sabrouch.springjpapostgres.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


/**
 * Created by sabrouch.
 * Date: 1/23/2021
 */
@Repository
public interface StudentRepository extends PagingAndSortingRepository<Student, Long> {
    @Query("SELECT s from Student s where s.age=?1")
    Optional<Student> findStudentByAge(int s);

    @Query("SELECT s from Student s where s.age= :s")
    Optional<Student> findStudentByAgeParm(@Param("s")int s);

    @Query(value = "SELECT * from Student s where s.age between ?1 and ?2", nativeQuery = true)
    Optional<Student> findStudentByAgeBetween(int s , int l);

    @Modifying
    @Transactional
    @Query(" DELETE FROM Student u where u.age = ?1" )
    void deleteByAge(int s);


}
