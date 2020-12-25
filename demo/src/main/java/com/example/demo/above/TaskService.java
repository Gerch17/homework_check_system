package com.example.demo.above;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;
    private static int COUNT_ID = 0;

    public void createTask(String statement, String name) {
        Task task = new Task();
        task.setTaskId(String.valueOf(COUNT_ID++));
        task.setStatement(statement);
        task.setName("Задача");
        taskRepository.save(task);
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
