package com.example.demo.repository;

import com.example.demo.entity.Solution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface SolutionRepository extends CrudRepository<Solution, Long> {

//    @Modifying
//    @Query("UPDATE score SET tries = :tries WHERE student_id = :student_id AND task_id = :task_id")
//    void incrementTry(@Param("student_id") String student_id, @Param("task_id") String task_id, @Param("tries") int tries) throws Exception;
//
//    @Modifying
//    @Query("UPDATE solution SET is_checked = :is_checked WHERE student_name = :student_id AND task_id = :task_id")
//    void changeChecked(@Param("student_id") String student_id, @Param("task_id") String task_id, @Param("is_checked") Boolean is_checked)throws Exception;
//
//    @Modifying
//    @Query("UPDATE solution SET is_right = :is_right WHERE student_name = :student_id AND task_id = :task_id")
//    void changeRight(@Param("student_id") String student_id, @Param("task_id") String task_id, @Param("is_right") Boolean is_right)throws Exception;
}
