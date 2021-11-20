package com.example.demo.models;

import com.google.gson.Gson;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author timtims
 * @date 15.09.2020
 */

@Entity
@Table(name = "test", schema = "test")
public class TestModel  {
@Id
@GeneratedValue(strategy=GenerationType.SEQUENCE,
        generator="test_seq")
@SequenceGenerator(name="test_seq", schema = "test", sequenceName="test_seq", allocationSize = 1)
@Column(name = "id") private Long id;
@Column(name = "llichnost_id") private Long personId;
@Column(name = "login") private String login;
@Column(name = "password") private String password;



    /*@OneToOne//(fetch = FetchType.EAGER)
    @JoinColumn(name="llichnost_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Person person;*/


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="llichnost_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Person person;

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    public TestModel() {};

    public TestModel(Long personId, String login, String password){
        this.personId = personId;
        this.login = login;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setCode(Long personId) {
        this.personId = personId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toJson() {
        Map<String, Object> m = toMap();
        return new Gson().toJson(m);
    }

    public Map<String, Object> toMap() {
        Map<String, Object> m = new HashMap<>();
        m.put("id", this.id);
        m.put("personid", this.personId);
        m.put("login", this.login);
        m.put("password", this.password);
        return m;
    }


}
