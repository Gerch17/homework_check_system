package com.example.demo.service;

import com.example.demo.handler.java.Broker;
import com.example.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

import java.io.IOException;

@Service
public class TesterService {

    @Autowired
    private TaskService taskService;

    @Autowired
    private DbUpdateService dbUpdateService;

    @Autowired
    HomeService homeService;

    private String id;

    @Autowired
    TaskRepository taskRepository;

    static private long solution_id =0;

    public void setTaskID(String taskID) {
        this.id = taskID;
    }

    public void startTest(String newSolution /*, File fileSolution*/)
    {
        taskService.createSolution(newSolution, id);
        String student_id = taskService.getUserName();
        id = taskService.getName(id);
        dbUpdateService.insertStudent(student_id, id, solution_id);
        try {
            Broker broker = new Broker(student_id);
            int temp = dbUpdateService.findTries(student_id, id);
            temp++;
            if(!broker.runTest(id, solution_id+1))
            {
                try {
                    dbUpdateService.updateTries(student_id, id, temp, false);
                    dbUpdateService.updateVerified(solution_id, false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else{
                try {
                    dbUpdateService.updateVerified(solution_id, true);
                    dbUpdateService.updateTries(student_id, id, temp, true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        solution_id++;
    }
}
