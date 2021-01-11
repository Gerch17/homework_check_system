package com.example.demo.repository;

import com.example.demo.entity.Solution;
import org.springframework.data.repository.CrudRepository;

public interface SolutionRepository extends CrudRepository<Solution, String> {
}
