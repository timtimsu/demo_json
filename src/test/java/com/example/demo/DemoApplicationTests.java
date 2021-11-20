package com.example.demo;

import com.example.demo.dao.PersonDAO;
import com.example.demo.dao.TestModelDAO;
import com.example.demo.models.Person;
import com.example.demo.models.TestModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.text.html.parser.Entity;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@SpringBootTest
class DemoApplicationTests {
    @Autowired TestModelDAO testModelDAO;
    @Autowired PersonDAO personDAO;
    @Test
    void contextLoads() {

        final String PERSISTENCE_UNIT_NAME = "test";
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        EntityManager em = factory.createEntityManager();

        Query q = em.createNativeQuery("SELECT a.surname, a.name FROM person a ");
        List<Object> res = q.getResultList();

        /*Person person = personDAO.save(new Person("Кузнецов", "Дмитрий", "Юрьевич"));

        TestModel account = testModelDAO.save(new TestModel(person.getId(),"dima", "dima"));
*/
/*
        TestModel testModel = testModelDAO.findById(7L).orElse(new TestModel());
        System.out.println(testModel.getPerson().getSurName());
*/

        Person person = personDAO.findById(1L).orElse(new Person());
        Calendar calendar = GregorianCalendar.getInstance();

        /*calendar.setTime(person.getBirthday());*/

        /*System.out.println(dateFormat.format(calendar.getTime()));*/

        String dates = "01.11.2020";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate date = LocalDate.parse(dates, formatter);
        person.setBirthday(java.sql.Date.valueOf(date));

        System.out.println(date);
/*
        person.setBirthday(calendar.getTime());
        personDAO.save(person);
*/
/*
        Person person = personDAO.findById(1L).orElse(new Person());

        person.getAccounts().forEach(a ->
                System.out.println(a.getLogin())
                );
*/

        //System.out.println(person.getSurName());
       //System.out.println(testModel.getPerson().getSurName());
        /*
        TestModel testModel = testModelDAO.findById(1L).orElse(new TestModel());
        System.out.println(testModel.getLogin() + ' ' + testModel.getPassword());
*/



    }



}
