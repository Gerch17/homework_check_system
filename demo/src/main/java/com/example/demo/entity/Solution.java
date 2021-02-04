package com.example.demo.entity;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Solution {
    @Id
    private long solution_id;

    private String course_id;

    private String task_id;

    private String solution;

    private String student_name;

    private Boolean is_checked;

    private Boolean is_right;

    private String fileName;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String courseID) {
        this.course_id = courseID;
    }

    public long getSolution_id() {
        return solution_id;
    }

    public void setSolution_id(long solutionID) {
        this.solution_id = solutionID;
    }

    public String getTask_id() {
        return task_id;
    }

    public void setTask_id(String taskID) {
        this.task_id = taskID;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String studentName) {
        this.student_name = studentName;
    }

    public Boolean getChecked() {
        return is_checked;
    }

    public void setChecked(Boolean checked) {
        is_checked = checked;
    }

    public Boolean getRight() {
        return is_right;
    }

    public void setRight(Boolean right) {
        is_right = right;
    }

}
