package com.example.demo.service;

import com.example.demo.entity.Task;
import com.example.demo.entity.Test;
import com.example.demo.repository.TaskRepository;
import com.example.demo.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class TestService {
    @Autowired
    private TestRepository testRepository;

    private static long SLT_ID = 0;

    public void addTest(String name, String input, String output)
    {
        Test test = new Test();
        test.setCourse_number("0");
        if (input.isEmpty())
            test.setInput("\r");
        test.setOutput(output);
        test.setTask_number(name);
        test.setID(String.valueOf(SLT_ID++));
        testRepository.save(test);
    }
    public Iterable<Test> getTestList()
    {
        return testRepository.findAll();
    }

}
