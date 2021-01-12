package com.example.demo.service;

import com.example.demo.entity.Solution;
import com.example.demo.entity.Task;
import com.example.demo.handler.FileWorker;
import com.example.demo.repository.SolutionRepository;
import com.example.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private SolutionRepository solutionRepository;
    private static int COUNT_ID = 0;
    private static long SLT_ID = 0;

    public void createTask(String statement, String name, String courseID) {
        Task task = new Task();
        task.setCourseId(courseID);
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

    public String getStatement(String id){
        Optional<Task> task = taskRepository.findById(id);

        return task.get().getStatement();
    }

    public String gettingTask(int id)
    {
        Optional<Task> task = taskRepository.findById(String.valueOf(id));

        return task.get().getStatement();
    }

    public Set getCoursesList()
    {
        Iterable<Task> courses = taskRepository.findAll();
        Set<String> courseIdList = new LinkedHashSet<String>();

        for (Task course: courses) {
            courseIdList.add(course.getCourseId());
        }

        courseIdList.stream().sorted();
        return courseIdList;
    }

    public Set<Task> getTaskList(String courseId)
    {
        Iterable<Task> tasks = taskRepository.findAll();
        Set<Task> tasksIdList = new LinkedHashSet<Task>();
        for (Task task: tasks) {
            if(task.getCourseId().equals(courseId)) {
                tasksIdList.add(task);
            }
        }
        return tasksIdList;
    }

    public Iterable<Task> getTasks() {
        return taskRepository.findAll();
    }
}