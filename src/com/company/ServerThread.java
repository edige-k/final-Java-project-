package com.company;

import java.io.*;
import java.net.*;
import java.sql.*;
import java.util.*;

public class ServerThread extends Thread {
    private Connection connection;
    private Socket socket;
    ObjectInputStream inputStream;
    ObjectOutputStream outputStream;

    public ServerThread(Socket socket, Connection connection) {
        this.socket = socket;
        this.connection = connection;
        try {
            inputStream = new ObjectInputStream(this.socket.getInputStream());
            outputStream = new ObjectOutputStream(this.socket.getOutputStream());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void run() {
        try {
            PackageData pd = null;
            while ((pd = (PackageData) inputStream.readObject())!=null) {

                if (pd.getOperationType().equals("Add_Schedule")) {
                    try {
                        Sheadules sheadules = pd.getSheadule();
                        addSheadulesToDb(sheadules);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                else if(pd.getOperationType().equals("Add_Attendences")){
                    try {
                        Attendences attendences= pd.getAttendences().get(0);
                        addAttendencesToDb(attendences);

                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                else if(pd.getOperationType().equals("List_Schedules")){
                    ArrayList<Sheadules> sheadules = getSheadules();
                    PackageData resp = new PackageData();
                    resp.setSheadules(sheadules);
                    outputStream.writeObject(resp);
                }
                else if (pd.getOperationType().equals("List_Students")) {
                    ArrayList<StudentData> students = getAllStudents();
                    PackageData resp = new PackageData();
                    resp.setStudents(students);
                    outputStream.writeObject(resp);
                }
                else if (pd.getOperationType().equals("Add_Student")) { try {
                        StudentData student = pd.getStudent();
                        addStudent(student);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                else if(pd.getOperationType().equals("List_Attendences")){
                    ArrayList<Attendences>attendences=getAttendences();
                    PackageData pd2=new PackageData();
                    pd2.setAttendences(attendences);
                    outputStream.writeObject(pd2);
                }
                else if(pd.getOperationType().equals("Delete_Schedules")){
                    Long id=pd.getId();
                    deleteSheadulesToDB(id);
                }
                else{
                    break;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addSheadulesToDb(Sheadules sheadules) {
        try {
            PreparedStatement ps=connection.prepareStatement("insert into sheadules(id,kindofsubjects,name,time) values(null,?,?,?)");

            ps.setString(1,sheadules.getKindofsubjects());
            ps.setString(2,sheadules.getName());
            ps.setString(3,sheadules.getTime());
            ps.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void addStudent(StudentData student) {
        try {

            PreparedStatement pse = connection.prepareStatement("INSERT INTO studentdata (login, password,address,telephoneNumber,id) VALUES(?,?,?,?,NULL)");
            pse.setString(1, student.getLogin());
            pse.setString(2, student.getPassword());
            pse.setString(3, student.getAddress());
            pse.setString(4, student.getTelephoneNumber());
            pse.executeUpdate();
            pse.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<StudentData> getAllStudents() {
        ArrayList<StudentData> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * from studentdata");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                list.add(new StudentData(rs.getString("login"), rs.getString("password"), rs.getString("address"), rs.getString("telephoneNumber"), rs.getLong("id")));
            }
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


    public  void addAttendencesToDb(Attendences attendences) {
        try {
            PreparedStatement ps = connection.prepareStatement("insert into attendences(id,sheadulesId,name,surname,passwordNumber) values(null,?,?,?,?)");
            ps.setInt(1,attendences.getShedulesId());
            ps.setString(2,attendences.getName());
            ps.setString(3,attendences.getSurname());
            ps.setString(4,attendences.getPasswordNumber());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Sheadules> getSheadules() {
        ArrayList<Sheadules> sheadules = new ArrayList<>();
        try {
            Statement st = connection.createStatement();
            String sql = "SELECT * FROM sheadules";
            ResultSet res = st.executeQuery(sql);
            while(res.next()){
                sheadules.add(new Sheadules(res.getLong("id"), res.getString("kindofsubjects"),res.getString("name"),res.getString("time")));
            }
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sheadules;
    }
    public ArrayList<Attendences> getAttendences() {
        ArrayList<Attendences> attendences = new ArrayList<>();
        try {
            Statement st = connection.createStatement();
            String sql = "SELECT * FROM attendences";
            ResultSet res = st.executeQuery(sql);
            while(res.next()){
                attendences.add(new Attendences(res.getLong("id"), res.getInt("sheadulesId"), res.getString("name"), res.getString("surname"),res.getString("passwordNumber")));
            }
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return attendences;
    }



    public void deleteSheadulesToDB(Long id){
        try{
            PreparedStatement ps=connection.prepareStatement("DELETE FROM sheadules WHERE id=?");
            ps.setLong(1,id);
            int rows= ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
