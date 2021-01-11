package com.example.demo.handler.java;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class Broker {
    private final DatabaseWorker db;
    private ConsoleWorker cw;
    private TaskDealler td;
    private int studentID;

    public Broker(int studentID) throws IOException {
        db = new DatabaseWorker();
        this.studentID = studentID;
        td = new TaskDealler();
    }

    private ArrayList<String> getInputDataFromDB(int numberCourse, int numberTask) {
        return db.getInputData(numberCourse, numberTask);
    }

    private ArrayList<String> getOutputDataFromDB(int numberCourse, int numberTask) {
        return db.getOutputData(numberCourse, numberTask);
    }

    protected boolean runTest(int numberCourse, int numberTask, String name) throws IOException {
        ArrayList<String> listOutput = db.getOutputData(numberCourse,numberTask);
        ArrayList<String> listInput = db.getInputData(numberCourse, numberTask);
        try {
            if (!(td.isStudentExist(studentID, numberCourse, numberTask))) {
                td.insertStudent(studentID, numberCourse, numberTask, 0);
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        Boolean check = true;
        for(int i = 0; i < listOutput.size(); i++)
        {
            cw = new ConsoleWorker(name);
            cw.setTestData(listInput.get(i));
            String a = listOutput.get(i);
            String b = cw.getTestData();
            if(a.equals(b))
            {
            }else
            {
                check = false;
                td.incTry(studentID, numberCourse, numberTask);
                break;
            }
        }
        return check;
    }
}
