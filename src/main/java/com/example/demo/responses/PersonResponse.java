package com.example.demo.responses;/*
 * @author timtims
 * @date 04.12.2021
 */

public class PersonResponse {
    private Long id;
    private String surName;
    private String name;
    private String otchestvo;

    public PersonResponse(Long id, String surName, String name, String otchestvo) {
        this.id = id;
        this.name =name;
        this.surName = surName;
        this.otchestvo = otchestvo;
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

    public String getOtchestvo() {
        return otchestvo;
    }

    public void setOtchestvo(String otchestvo) {
        this.otchestvo = otchestvo;
    }
}
