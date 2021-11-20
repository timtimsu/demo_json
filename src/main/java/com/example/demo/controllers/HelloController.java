package com.example.demo.controllers;

import com.example.demo.dao.PersonDAO;
import com.example.demo.dao.TestModelDAO;
import com.example.demo.models.Person;
import com.example.demo.models.TestModel;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.print.attribute.standard.Media;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author timtims
 * @date 10.10.2020
 */
@RestController
public class HelloController {

    private final TestModelDAO testModel;
    private final PersonDAO personDAO;

    @Autowired
    HelloController(TestModelDAO testModel, PersonDAO person){
        this.personDAO = person;
        this.testModel = testModel;
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String sayHello(@RequestParam(value = "name", required=false, defaultValue="World") String name) {
        return "<b>Привет </b>" + name + "!";
        //model.addAttribute("name", name);
        // return "hello";
    }

    /*@RequestMapping(value = "/")
    public String sayHello() {
        return "<b>Привет всем!</b>";
        //model.addAttribute("name", name);
        // return "hello";
    }*/

    @RequestMapping(value = "/acc", produces = MediaType.APPLICATION_JSON_VALUE)
    String sayAccounts(Model model) {
        /*model.addAttribute("users", personDAO.findAll());
        return "ok";*/
        JsonNodeFactory factory = JsonNodeFactory.instance;
        ArrayNode root = factory.arrayNode();
        List<Person> persons = new ArrayList<Person>();
        personDAO.findAll().forEach(persons::add);

                //accounts.stream().map(it  -> it.toString()).collect(Collectors.joining(" "));


       return persons.stream().map(person-> person.toJson()).collect(Collectors.joining(", ","{\"success\":true, \"data\": [","]}"));

        /*persons.forEach(person ->{
            ObjectNode entry = root.addObject();
            Date currentDate = new Date();
            Timestamp timestamp = new Timestamp(currentDate.getTime());


            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            entry.put("date", dateFormat.format(timestamp));
            entry.put("personId", person.getId());
            entry.put("login", person.getName());
            entry.put("birthday", 1);

                });*/
        //return root;

    }

    @ModelAttribute(name= "countrieslist")
    public List<String> populateCountries() {

        List<String> countries= new ArrayList<String>();
        countries.add("India");
        countries.add("United States");
        countries.add("Japan");
        countries.add("Australia");
        countries.add("Canda");

        return countries;
    }

    @RequestMapping(value= "/init", method= RequestMethod.GET)
    public ModelAndView initView(@ModelAttribute(name= "countrieslist") List<String> countries) {

        ModelAndView modelview = new ModelAndView();
        modelview.addObject("message", "This is an example of using the @ModelAttribute annotation .....!");
        modelview.setViewName("output");

        return modelview;
    }

}
