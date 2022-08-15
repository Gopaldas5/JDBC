package com.bridgeLabz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Start {
    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to student Management App");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            System.out.println("Press 1 to Add student");
            System.out.println("Press 2 to Delete student");
            System.out.println("Press 3 to Display student");
            System.out.println("Press 4 to update");
            System.out.println("Press 5 to Exit app");

            int c = Integer.parseInt(br.readLine());
            if (c == 1){
                // add student...
                System.out.println("Enter user name : ");
                String name = br.readLine();

                System.out.println("Enter user phone : ");
                String phone = br.readLine();

                System.out.println("Enter user city : ");
                String city = br.readLine();

                //create student object to store student
                Students st = new Students(name, phone, city);
               boolean answer = StudentDao.insertStudentToDB(st);
               if (answer){
                   System.out.println("Student is added successfully...");
               }
               else {
                   System.out.println("Something went wrong ... Try again....");
               }
                System.out.println(st);

            } else if (c == 2) {
                //delete student..
                System.out.println("Enter student id to delete: ");
                int userId = Integer.parseInt(br.readLine());
               boolean f = StudentDao.deleteStudent(userId);
               if (f){
                   System.out.println("Deleted.....");

               }else {
                   System.out.println("Something went wrong ...");
               }

            } else if (c == 3) {
               //display student..
                StudentDao.showAllStudent();

            } else if (c == 4) {
                //update....

            } else if (c == 5) {
                //exit
                break;
            }
            else {

            }
        }
        System.out.println("Thank you for using my App....");
        System.out.println("See you soon ....bye bye");
    }
}
