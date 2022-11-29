package com.example.space.controller;

import com.example.space.model.Note;
import com.example.space.repository.NoteRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("note")
@RequiredArgsConstructor
public class NoteController {

    private final NoteRepo repo;
    @PostMapping
    public Note create(@RequestBody Note note){
        note.setCreated(LocalDateTime.now());
        return repo.save(note);
    }

    @GetMapping
    public List<Note> list(){
        return repo.findAll();
    }

    @GetMapping("{id}")
    public Note getBYId(@PathVariable("id") Note note){
        return note;
    }

    @GetMapping("/search/{text}")
    public Note getByText(@PathVariable("text") String text){
        return repo.getByText(text);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Note note){
        repo.delete(note);
    }

    @PutMapping("{id}")
    public Note update(@PathVariable("id") Note note,@RequestBody Note newNote){
        BeanUtils.copyProperties(newNote, note, "id","created");
        return repo.save(note);
    }


}
