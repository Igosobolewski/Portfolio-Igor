package com.example.portfolioapp.service;
import com.example.portfolioapp.model.Project;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Arrays;

@Service
public class ProjectService {
    public List<Project> getProjects() {
        return Arrays.asList(
                new Project("Projekt 1", "Opis pierwszego projektu", "#"),
                new Project("Projekt 1", "Opis pierwszego projektu", "#"),
                new Project("Projekt 1", "Opis pierwszego projektu", "#")
        );
    }
}
