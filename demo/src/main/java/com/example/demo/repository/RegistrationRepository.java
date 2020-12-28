package com.example.demo.repository;

import com.example.demo.entity.Registration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends CrudRepository<Registration, String> {
}
