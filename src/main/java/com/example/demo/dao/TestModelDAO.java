package com.example.demo.dao;

import com.example.demo.models.Person;
import com.example.demo.models.TestModel;

import org.aspectj.weaver.ast.Test;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author timtims
 * @date 15.09.2020
 */
@Transactional
public interface TestModelDAO extends CrudRepository<TestModel, Long> {

    Optional<TestModel> findById(Long id);

    TestModel findByLogin(String userName);

    @Query(value = "select * from test t", nativeQuery = true)
    ArrayList<TestModel> findAllAccpints();


}
