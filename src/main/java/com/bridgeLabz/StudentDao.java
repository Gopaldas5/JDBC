package com.bridgeLabz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDao {

    public static boolean insertStudentToDB(Students st){

        boolean f = false;
        try {
            // jdbc code...
            Connection con = ConnectionProvider.createConnection();
            String query = "insert into students(sname,sphone,scity) value(?,?,?)";
            //preparedStatement
            PreparedStatement preparedStatement = con.prepareStatement(query);
            //set the value of parameter
            preparedStatement.setString(1, st.getStudentName());
            preparedStatement.setString(2, st.getStudentPhone());
            preparedStatement.setString(3, st.getStudentCity());

            //execute...
            preparedStatement.executeUpdate();
            f = true;

        }catch (Exception e){
            e.printStackTrace();
        }
        return f;
    }

    public static boolean deleteStudent(int userId) {

        boolean f = false;
        try {
            // jdbc code...
            Connection con = ConnectionProvider.createConnection();
            String query = "delete from students where sid=?";
            //preparedStatement
            PreparedStatement preparedStatement = con.prepareStatement(query);
            //set the value of parameter
            preparedStatement.setInt(1, userId);

            //execute...
            preparedStatement.executeUpdate();
            f = true;

        }catch (Exception e){
            e.printStackTrace();
        }
        return f;
    }

    public static void showAllStudent() {

        boolean f = false;
        try {
            // jdbc code...
            Connection con = ConnectionProvider.createConnection();
            String query = "select * from students";
            Statement statement = con.createStatement();

           ResultSet set = statement.executeQuery(query);

           while (set.next()){
               int id = set.getInt(1);
               String name = set.getString(2);
               String phone = set.getString(3);
               String city = set.getString(4);

               System.out.println("ID : "+id);
               System.out.println("Name : "+name);
               System.out.println("Phone : "+phone);
               System.out.println("city : "+city);

               System.out.println("-------------------------------------------------------------------");
           }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
