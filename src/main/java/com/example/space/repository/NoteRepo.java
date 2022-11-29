package com.example.space.repository;

import com.example.space.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepo extends JpaRepository<Note, Integer> {

    List<Note> findAllByText(String text);
}
