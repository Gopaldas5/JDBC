package com.bridgeLabz;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
    static Connection con;

    public static Connection createConnection(){
        try{

            //load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            String user = "root";
            String password = "Lapog@87575";
            String url = "jdbc:mysql://localhost:3306/student_manage";

            con = DriverManager.getConnection(url, user, password);

        }
        catch(Exception e){
            e.printStackTrace();
        }
        return con;
    }

}
