package com.example.demo.handler.java;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseWorker {

    protected static Connection connection;
    protected static Statement stmt;
    private static PreparedStatement psInsert;
    private static PreparedStatement psSelectInput;
    private static PreparedStatement psSelectOutput;

    public DatabaseWorker() {
        try {
            connect();
            psInsert = connection.prepareStatement("INSERT INTO Tests (course_number, task_number, input, output) VALUES (?,?,?,?);");
            psSelectInput = connection.prepareStatement("SELECT input FROM Tests WHERE course_number=? and task_number=?;");
            psSelectOutput = connection.prepareStatement("SELECT output FROM Tests WHERE course_number=? and task_number=?;");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void setData(int numberCourse ,int numberTask, String inputData, String outputData) {
        try {
            psInsert.setInt(1, numberCourse);
            psInsert.setInt(2, numberTask);
            psInsert.setString(3, inputData);
            psInsert.setString(4, outputData);
            psInsert.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    protected ArrayList<String> getInputData(int numberCourse, int numberTask) {
        ArrayList<String> inputDataList = new ArrayList();
        try {
            psSelectInput.setInt(1, numberCourse);
            psSelectInput.setInt(2, numberTask);
            ResultSet rs = psSelectInput.executeQuery();
            for (int i = 0; rs.next(); i++) {
                if (rs.getString("input") != null) {
                    inputDataList.add(i, rs.getString("input"));
                }
                else{
                    inputDataList.add(i, rs.getString(""));
                }
            }
            return inputDataList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    protected ArrayList<String> getOutputData(int numberCourse, int numberTask) {
        ArrayList<String> outputDataList = new ArrayList();
        try {
            psSelectOutput.setInt(1, numberCourse);
            psSelectOutput.setInt(2, numberTask);
            ResultSet rs = psSelectOutput.executeQuery();
            for (int i = 0; rs.next(); i++) {
                if (rs.getString("output") != null) {
                    String data = rs.getString("output");
                    outputDataList.add(i, data);
                }
                else{
                    outputDataList.add(i, "");
                }
            }
            return outputDataList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public static void disconnect() {
        try {
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:Handler/src/main/resources/Database.db");
        stmt = connection.createStatement();
    }
}
