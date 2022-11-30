package com.example.space.service;

import com.example.space.model.Note;
import com.example.space.repository.NoteRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteService {
    private final NoteRepo repo;

    public Note create(Note note){
        note.setCreated(LocalDateTime.now());
        return repo.save(note);
    }

    public List<Note> list(){
        return repo.findAll();
    }

    public Note getById(Note note){
        return note;
    }

    public List<Note> getByText(String text){
        return repo.findAllByText(text);
    }

    public void delete(Note note){
        repo.delete(note);
    }

    public Note update(Note note,Note newNote){
        BeanUtils.copyProperties(newNote, note, "id","created");
        return repo.save(note);
    }
}
