package com.example.demo.models;

import com.google.gson.Gson;

import javax.annotation.Generated;
import javax.persistence.*;
import java.beans.ConstructorProperties;
import java.util.*;

import static javax.persistence.CascadeType.ALL;

/**
 * @author timtims
 * @date 26.09.2020
 */
@Entity
@Table(name = "person", schema = "test")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "person_seq")
    @SequenceGenerator(name = "person_seq", schema = "test", sequenceName = "person_seq", allocationSize = 1)
    @Column(name = "id") private Long id;
    @Column(name = "surname") private String surName;
    @Column(name = "name") private String name;
    @Column(name = "patronyc") private String patronymic;
    @Column(name = "birthday") private Date birthday;




    public List<TestModel> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<TestModel> accounts) {
        this.accounts = accounts;
    }

    @OneToMany(mappedBy="person", fetch = FetchType.EAGER)
    private List<TestModel> accounts;



    /*@OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="id", referencedColumnName = "llichnost_id", insertable = false, updatable = false)
    private List<TestModel>  accounts;*/

/*
    public List<TestModel> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<TestModel> accounts) {
        this.accounts = accounts;
    }
*/

    public Person() { }

    public Person(String surName, String name, String patronymic) {
        this.surName = surName;
        this.name = name;
        this.patronymic = patronymic;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String toJson() {
        Map<String, Object> m = toMap();
        return new Gson().toJson(m);
    }

    public Map<String, Object> toMap() {
        Map<String, Object> m = new HashMap<>();
        m.put("id", this.id);
        m.put("secondName", this.surName);
        m.put("name", this.name);
        m.put("otchestvo", this.patronymic);
        m.put("birtday", this.birthday);
        return m;
    }
}


