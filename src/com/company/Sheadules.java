package com.company;

import java.io.Serializable;

public class Sheadules implements Serializable {
    private Long id;
    private String kindofsubjects;
    private String name;
    private String time;

    public Sheadules(){}

    public Sheadules(Long id, String kindofsubjects, String name, String time) {
        this.id = id;
        this.kindofsubjects = kindofsubjects;
        this.name = name;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Sheadules{" +
                "id=" + id +
                ", kindofsubjects='" + kindofsubjects + '\'' +
                ", name='" + name + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setKindofsubjects(String kindofsubjects) {
        this.kindofsubjects = kindofsubjects;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public String getKindofsubjects() {
        return kindofsubjects;
    }

    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }
}
