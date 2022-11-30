package com.example.space.controller;

import com.example.space.model.Note;
import com.example.space.repository.NoteRepo;
import com.example.space.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("note")
@RequiredArgsConstructor
public class NoteController {
    private final NoteService service;

    @PostMapping
    public Note create(@RequestBody Note note){
        return service.create(note);
    }

    @GetMapping
    public List<Note> list(){
        return service.list();
    }

    @GetMapping("{id}")
    public Note getById(@PathVariable("id") Note note){
        return service.getById(note);
    }

    @GetMapping("/search/{text}")
    public List<Note> getByText(@PathVariable("text") String text){
        return service.getByText(text);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Note note){
        service.delete(note);
    }

    @PutMapping("{id}")
    public Note update(@PathVariable("id") Note note,@RequestBody Note newNote){
        return service.update(note,newNote);
    }


}
