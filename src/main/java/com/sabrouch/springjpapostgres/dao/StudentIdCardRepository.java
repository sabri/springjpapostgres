package com.sabrouch.springjpapostgres.dao;

import com.sabrouch.springjpapostgres.entity.StudentIdCard;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by sabrouch.
 * Date: 1/24/2021
 */
public interface StudentIdCardRepository extends CrudRepository<StudentIdCard, Long> {
}
