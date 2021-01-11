package com.example.demo.service;

import com.example.demo.entity.Solution;
import com.example.demo.entity.Task;
import com.example.demo.handler.fileWorker.FileWorker;
import com.example.demo.repository.SolutionRepository;
import com.example.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private SolutionRepository solutionRepository;
    private static int COUNT_ID = 0;
    private static long SLT_ID = 0;

    public void createTask(String statement, String name) {
        Task task = new Task();
        task.setTaskId(String.valueOf(COUNT_ID++));
        task.setStatement(statement);
        task.setName(name);
        taskRepository.save(task);
    }
    public void createSolution(String newSolution, String id)
    {
        String currentUser = SecurityContextHolder.getContext().getAuthentication().getName();
        Solution solution = new Solution();
        Task task = new Task();
        solution.setTaskID(id);
        solution.setSolution(newSolution);
        solution.setRight(null);
        solution.setChecked(false);
        solution.setSolutionID(SLT_ID++);
        solution.setStudentName(currentUser);
        solutionRepository.save(solution);
        FileWorker fileWorker = new FileWorker(String.valueOf(SLT_ID), newSolution);
    }

    public String gettingTask(int id)
    {
        Optional<Task> task = taskRepository.findById(String.valueOf(id));

        return task.get().getStatement();
    }

    public Iterable<Task> getTaskList()
    {
        Iterable<Task> task = taskRepository.findAll();

        return task;
    }

    public Iterable<Task> getTasks() {
        return taskRepository.findAll();
    }
}