package com.example.Project2.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Project2.model.Project;
import com.example.Project2.repository.ProjectRepository;


@RestController
@RequestMapping("/api")
public class ProjectController {

    @Autowired
    ProjectRepository projectRepository;


    //to display specific row in the tabel using id
    @GetMapping("/show/{id}")
    public ResponseEntity<Project> geProjectById(@PathVariable Long id){
        Optional<Project> project = projectRepository.findById(id);

        if (project.isPresent()) {
      return new ResponseEntity<>(project.get(), HttpStatus.OK);
    } 
    else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    }

    //to delete row by using id
    @DeleteMapping("delete/{id}")
    public ResponseEntity<HttpStatus> delete_by_id(@PathVariable("id") long id){
        projectRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}