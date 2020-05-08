package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class PackageData implements Serializable {

    String operationType;
    ArrayList<Attendences> attendences;
    ArrayList<Sheadules> sheadules;
    ArrayList<StudentData> students;
    StudentData student;
    Sheadules sheadule;
    Attendences attendence;
    Long id;

    public PackageData(){}

    public PackageData(String operationType, ArrayList<Attendences> attendences, ArrayList<Sheadules> sheadules, ArrayList<StudentData> students, StudentData student, Sheadules sheadule, Attendences attendence, Long id) {
        this.operationType = operationType;
        this.attendences = attendences;
        this.sheadules = sheadules;
        this.students = students;
        this.student = student;
        this.sheadule = sheadule;
        this.attendence = attendence;
        this.id = id;
    }

    @Override
    public String toString() {
        return "PackageData{" +
                "operationType='" + operationType + '\'' +
                ", attendences=" + attendences +
                ", sheadules=" + sheadules +
                ", students=" + students +
                ", student=" + student +
                ", sheadule=" + sheadule +
                ", attendence=" + attendence +
                ", id=" + id +
                '}';
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public void setAttendences(ArrayList<Attendences> attendences) {
        this.attendences = attendences;
    }

    public void setSheadules(ArrayList<Sheadules> sheadules) {
        this.sheadules = sheadules;
    }

    public void setStudents(ArrayList<StudentData> students) {
        this.students = students;
    }

    public void setStudent(StudentData student) {
        this.student = student;
    }

    public void setSheadule(Sheadules sheadule) {
        this.sheadule = sheadule;
    }

    public void setAttendence(Attendences attendence) {
        this.attendence = attendence;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOperationType() {
        return operationType;
    }

    public ArrayList<Attendences> getAttendences() {
        return attendences;
    }

    public ArrayList<Sheadules> getSheadules() {
        return sheadules;
    }

    public ArrayList<StudentData> getStudents() {
        return students;
    }

    public StudentData getStudent() {
        return student;
    }

    public Sheadules getSheadule() {
        return sheadule;
    }

    public Attendences getAttendence() {
        return attendence;
    }

    public Long getId() {
        return id;
    }
}
