package com.example.space.controller;

import com.example.space.model.Contact;
import com.example.space.repository.ContactRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("contact")
@RequiredArgsConstructor
public class ContactController {
    private final ContactRepo repo;

    @PostMapping
    public Contact create(@RequestBody Contact contact){
        contact.setCreated(LocalDateTime.now());
        return repo.save(contact);
    }

    @GetMapping
    public List<Contact> list(){
        return repo.findAll();
    }

    @GetMapping("{id}")
    public Contact getById(@PathVariable("id") Contact contact){
        return contact;
    }

    @GetMapping("/search/name/{name}")
    public List<Contact> getByName(@PathVariable("name") String name){
        return repo.findAllByName(name);
    }

    @GetMapping("/search/surname/{surname}")
    public List<Contact> getBySurname(@PathVariable("surname") String surname){
        return repo.findAllBySurname(surname);
    }

    @GetMapping("/search/phone/{phone}")
    public List<Contact> getByPhone(@PathVariable("phone") String phone){
        return repo.findAllByPhone(phone);
    }

    @GetMapping("/search/email/{email}")
    public List<Contact> getByEmail(@PathVariable("email") String email){
        return repo.findAllByEmail(email);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Contact contact){
        repo.delete(contact);
    }

    @PutMapping("{id}")
    public Contact update(@PathVariable("id") Contact contact,@RequestBody Contact newContact){
        BeanUtils.copyProperties(newContact, contact, "id","created");
        return repo.save(contact);
    }
}
