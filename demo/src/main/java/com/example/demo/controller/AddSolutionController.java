package com.example.demo.controller;

import com.example.demo.entity.Solution;
import com.example.demo.repository.TaskRepository;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.service.HomeService;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;


@Controller
public class AddSolutionController {
    @Autowired
    private TaskService taskService;

    @Autowired
    private DbUpdateService dbUpdateService;

    @Autowired
    HomeService homeService;

    @Autowired
    TesterService testerService;


    private String id;

    @Autowired
    TaskRepository taskRepository;

    static private long solution_id =0;

    public void setTaskID(String taskID) {
        this.id = taskID;
    }


    @GetMapping("/addSolution")
    public String addSolution(@RequestParam String newSolution/*, @RequestParam File fileSolution,*/, Model model){
        testerService.setTaskID(id);
        String student_id = taskService.getUserName();
        id = taskService.getName(id);
        dbUpdateService.insertStudent(student_id, id, solution_id);
        if(dbUpdateService.isSolutionRight(student_id, id))
        {
            model.addAttribute("standard", taskService.getStandardSolution(id));
        }
        testerService.startTest(newSolution/*, fileSolution*/);
        homeService.personalPage(model);
        return "home";
    }

    @GetMapping("/addFileSolution")
    public String addFileSolution(@RequestParam("file") File file, Model model){
        testerService.setTaskID(id);
        String student_id = taskService.getUserName();
        id = taskService.getName(id);
        dbUpdateService.insertStudent(student_id, id, solution_id);
        String path = "C:\\Users\\bober\\IdeaProjects\\homework_check_system\\demo\\src\\main\\java\\com\\example\\demo\\handler\\tasks\\solutionId_1";
        File uploadDir = new File(path);
        if (!uploadDir.exists()){
            uploadDir.mkdir();
        }
        homeService.personalPage(model);
        return "home";
    }
}
/*
* taskService.createSolution(newSolution, id);
        String student_id = taskService.getUserName();
        id = taskService.getName(id);
        dbUpdateService.insertStudent(student_id, id, solution_id);
        if(dbUpdateService.isSolutionRight(student_id, id))
        {
            model.addAttribute("standard", taskService.getStandardSolution(id));
        }
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
        homeService.personalPage(model);
        return "home";
* */
