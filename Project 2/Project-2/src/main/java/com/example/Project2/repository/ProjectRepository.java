package com.example.Project2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Project2.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    
}
