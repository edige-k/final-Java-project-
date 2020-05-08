package com.company;

import java.io.Serializable;

public class Attendences implements Serializable {

    private Long id;
    private int shedulesId;
    private String name;
    private String surname;
    private String passwordNumber;

    public Attendences(){}

    public Attendences(Long id, int shedulesId, String name, String surname, String passwordNumber) {
        this.id = id;
        this.shedulesId = shedulesId;
        this.name = name;
        this.surname = surname;
        this.passwordNumber = passwordNumber;
    }

    @Override
    public String toString() {
        return "Attendences{" +
                "id=" + id +
                ", shedulesId=" + shedulesId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", passwordNumber='" + passwordNumber + '\'' +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setShedulesId(int shedulesId) {
        this.shedulesId = shedulesId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPasswordNumber(String passwordNumber) {
        this.passwordNumber = passwordNumber;
    }

    public Long getId() {
        return id;
    }

    public int getShedulesId() {
        return shedulesId;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPasswordNumber() {
        return passwordNumber;
    }
}
