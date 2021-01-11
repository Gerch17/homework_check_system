package com.example.demo.handler.java;

import java.sql.*;
import java.util.function.Predicate;

public class TaskDealler {
    private Connection co;

    TaskDealler() {
        try {
            Class.forName("org.sqlite.JDBC");
            co = DriverManager.getConnection("jdbc:sqlite:Handler/src/main/resources/TaskDB.db");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int[] selectStudent(int studentID, int courseID, int taskID)
    {
        int[] mas = new int[4];
        try{
            Statement statement = co.createStatement();
            String query = "SELECT studentID, courseID, taskID, tries FROM TaskDB WHERE " +
                            "studentID = " + studentID +
                            " AND courseID = " + courseID +
                            " AND taskID = " + taskID;
            ResultSet rs = statement.executeQuery(query);
            mas[0] = rs.getInt("studentID"); 
            mas[1] = rs.getInt("courseID");
            mas[2] = rs.getInt("taskID");
            mas[3] = rs.getInt("tries");
            rs.close();
            statement.close();
            return mas;
        }catch(Exception e)
        {
            e.printStackTrace();
            return mas;
        }
    }

    public Boolean isStudentExist(int studentID, int courseID, int taskID) throws SQLException {
        try {
            String query = "SELECT * FROM TaskDB WHERE EXISTS (SELECT * FROM TaskDB WHERE " +
                    "studentID = " + studentID +
                    " AND courseID = " + courseID +
                    " AND taskID = " + taskID + ")";
            PreparedStatement ps = co.prepareStatement(query);
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next())
                {
                    boolean found = rs.getBoolean(1);
                    if(found)
                    {
                        return true;
                    }else
                    {
                        return false;
                    }
                }
            }catch (SQLException e)
            {
                e.printStackTrace();
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    public void incTry(int studentID, int courseID, int taskID)
    {
        try{
            Statement statement = co.createStatement();
            String query = "SELECT tries FROM TaskDB WHERE " +
                            "studentID = " + studentID + 
                            " AND courseID = " + courseID +
                            " AND taskID = " + taskID;
            ResultSet rs = statement.executeQuery(query);
            int temp;
            temp = rs.getInt("tries");
            temp++;
            String queryIn = "UPDATE TaskDB SET tries = "+temp+" WHERE " +
            "studentID = " + studentID + 
            " AND courseID = " + courseID +
            " AND taskID = " + taskID; 
            try{
                statement.executeUpdate(queryIn);
            }catch(SQLException e)
            {
                e.printStackTrace();
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void insertStudent(int StudentID, int courseID, int taskID, int tries) {
        String query = "INSERT INTO TaskDB(studentID, courseID, taskID, tries) " + "VALUES (" + StudentID + ", "+ courseID + ", " + taskID + ", "
                + tries + ")";
        Statement statement;
        try {
            statement = co.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void disconnectDB()
    {
        try{
        co.close();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
