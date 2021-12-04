package com.example.demo.dao;

import com.example.demo.models.Person;
import com.example.demo.models.TestModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * @author timtims
 * @date 26.09.2020
 */
@Transactional
public interface PersonDAO extends CrudRepository<Person, Long> {

    Optional<Person> findById(Long id);





}
