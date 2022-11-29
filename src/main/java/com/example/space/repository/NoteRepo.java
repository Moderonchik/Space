package com.example.space.repository;

import com.example.space.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepo extends JpaRepository<Note, Integer> {
    Note getByText(String text);
}
