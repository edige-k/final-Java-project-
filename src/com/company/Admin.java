package com.company;

import java.io.*;
import java.net.*;
import java.util.*;
public class Admin {
    public static ObjectOutputStream outputStream;
    public static ObjectInputStream inputStream;
    public static  Socket socket;
    public static AdminMainFrame frame;

    public static void connectToServer(){
        try {
            socket=new Socket("127.0.0.1",4000);
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            inputStream = new ObjectInputStream(socket.getInputStream());
        }catch (Exception e){e.printStackTrace();}
    }

    public static void addShedules(Sheadules sheadules){
        PackageData pd=new PackageData();
        pd.setOperationType("Add_Schedule");
        pd.setSheadule(sheadules);
        try {
            outputStream.writeObject(pd);
        }catch (Exception e){e.printStackTrace();}
    }

    public static ArrayList<Sheadules> listSchedules(){
        ArrayList<Sheadules> sheadules=new ArrayList<>();
        PackageData pd=new PackageData();
        pd.setOperationType("List_Schedules");
        pd.setSheadules(sheadules);
        try {
            outputStream.writeObject(pd);
            if((pd = (PackageData) inputStream.readObject())!=null){
                sheadules=pd.getSheadules();
            }
        }catch (Exception e){e.printStackTrace();}

        return sheadules;
    }

    public static void deleteWithId(Long id){
        PackageData pd=new PackageData();
        pd.setOperationType("Delete_Schedules");
        pd.setId(id);
        ArrayList<Sheadules> sheadules=pd.getSheadules();
        try {
            outputStream.writeObject(pd);
        }catch(Exception e){e.printStackTrace();}
    }

    public static void showAddPage(){
        Admin.frame.menu.setVisible(false);
        Admin.frame.list.setVisible(false);
        Admin.frame.deletePage.setVisible(false);
        Admin.frame.add.setVisible(true);
        Admin.frame.repaint();
    }

    public static void showListPage(){
        frame.menu.setVisible(false);
        frame.add.setVisible(false);
        frame.deletePage.setVisible(false);
        frame.list.setVisible(true);
        ArrayList<Sheadules> list = listSchedules();
        Admin.frame.list.updateArea(list);
    }

    public static void MenuPage(){
        frame.menu.setVisible(true);
        frame.add.setVisible(false);
        frame.deletePage.setVisible(false);
        frame.list.setVisible(false);
        frame.welcome.setVisible(false);
    }

    public static void showDeletePage(){
        Admin.frame.menu.setVisible(false);
        Admin.frame.add.setVisible(false);
        Admin.frame.list.setVisible(false);;
        ArrayList<Sheadules> list=listSchedules();
        frame.deletePage.updateArea(list);
        Admin.frame.deletePage.setVisible(true);
        Admin.frame.repaint();
    }

    public static void showMenuPage(){
         Admin.frame.add.setVisible(false);
        Admin.frame.list.setVisible(false);
        Admin.frame.deletePage.setVisible(false);
        Admin.frame.menu.setVisible(true);
        Admin.frame.repaint();
    }


    public static void main(String[] args){
        connectToServer();

        frame = new AdminMainFrame();
        frame.setVisible(true);
    }
}

