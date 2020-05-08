package com.company;

import java.io.*;
import java.net.*;
import java.util.*;
public class Student {
    public static ObjectOutputStream outputStream;
    public static ObjectInputStream inputStream;
    public static StudentMainFrame frame;
    public static Socket  socket;
    public static String accaunt=null;

    private static  ArrayList<StudentData> students;

    public static void connectToServer(){
        try{
            socket=new Socket("127.0.0.1",4000);
            outputStream=new ObjectOutputStream(socket.getOutputStream());
            inputStream=new ObjectInputStream((socket.getInputStream()));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void addStudent(StudentData student){
        PackageData pd=new PackageData();
        pd.setOperationType("Add_Student");
        pd.setStudent(student);
        try {
            outputStream.writeObject(pd);
        }catch (Exception e){e.printStackTrace();}
    }

    public static void deleteWithId(Long id){
        PackageData pd=new PackageData();
        pd.setOperationType("Delete_Attendences");
        pd.setId(id);
        ArrayList<Attendences> attendences=pd.getAttendences();
        try {
            outputStream.writeObject(pd);
        }catch(Exception e){e.printStackTrace();}
    }

    public static ArrayList<StudentData> listStudents(){
        ArrayList<StudentData> students=new ArrayList<>();
        PackageData pd=new PackageData();
        pd.setOperationType("List_Students");
        pd.setStudents(students);
        try {
            outputStream.writeObject(pd);
            if((pd = (PackageData) inputStream.readObject())!=null){
                students=pd.getStudents();
                for(StudentData bd : students)
                    System.out.println(bd);
            }
        }catch (Exception e){e.printStackTrace();}
        return students;
    }

    public static void addAttendences(Attendences attendences){
        PackageData pd=new PackageData();
        ArrayList<Attendences> attendences1 = new ArrayList<>();
        attendences1.add(attendences);
        pd.setOperationType("Add_Attendences");
        pd.setAttendences(attendences1);
        try {
            outputStream.writeObject(pd);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static ArrayList<Attendences> listAttendencess(){
        ArrayList<Attendences> attendences=new ArrayList<>();
        PackageData pd=new PackageData();
        pd.setOperationType("List_Attendences");
        pd.setAttendences(attendences);
        try {
            outputStream.writeObject(pd);
            if((pd = (PackageData) inputStream.readObject())!=null){
                attendences =pd.getAttendences();
            }
        }catch (Exception e){e.printStackTrace();}
        return attendences;
    }

    public static ArrayList<Attendences> listAttendences(){
        ArrayList<Attendences> attendences=new ArrayList<>();
        PackageData pd=new PackageData();
        pd.setOperationType("List_Attendences");
        pd.setAttendences(attendences);
        try {
            outputStream.writeObject(pd);
            if((pd = (PackageData) inputStream.readObject())!=null){
                attendences =pd.getAttendences();
            }
        }catch (Exception e){e.printStackTrace();}
        return attendences;
    }

    public static ArrayList<Sheadules> listSheadules(){
        ArrayList<Sheadules> sheadules=new ArrayList<>();
        PackageData pd=new PackageData();
        pd.setOperationType("List_Schedules");
        try {
            outputStream.writeObject(pd);
            if((pd=(PackageData)inputStream.readObject())!=null){
                sheadules=pd.getSheadules();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return sheadules;
    }


    public static void showRegistrPage(){
        Student.frame.addStudent.setVisible(false);
        Student.frame.regitr.setVisible(true);
        Student.frame.menu.setVisible(false);
        Student.frame.repaint();
    }

    public static void myLogin(String login){
        accaunt=login;
    }

    public static void showListPage(){
        Student.frame.menu.setVisible(false);
        Student.frame.Attendences.setVisible(false);
        Student.frame.list.setVisible(true);
        ArrayList<Attendences>list=listAttendences();
        frame.list.updateArea(list);
        Student.frame.repaint();
    }


    public static void showMenuPage() {
        Student.frame.addStudent.setVisible(true);
        Student.frame.regitr.setVisible(false);
        Student.frame.welcome2.setVisible(false);
        Student.frame.menu.setVisible(false);
        Student.frame.repaint();
    }

    public static void showMainMenu() {
        Student.frame.addStudent.setVisible(false);
        Student.frame.regitr.setVisible(false);
        Student.frame.welcome2.setVisible(false);
        Student.frame.menu.setVisible(true);
        Student.frame.list.setVisible(false);
        Student.frame.repaint();
    }



    public static void main(String[] args){
        connectToServer();
        frame = new StudentMainFrame();
        frame.setVisible(true);
    }
}

