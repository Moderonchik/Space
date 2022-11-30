package com.example.space.repository;

import com.example.space.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepo extends JpaRepository<Project, Integer> {
}
