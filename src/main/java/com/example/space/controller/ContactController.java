package com.example.space.controller;

import com.example.space.model.Contact;
import com.example.space.repository.ContactRepo;
import com.example.space.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("contact")
@RequiredArgsConstructor
public class ContactController {
    private final ContactService service;

    @PostMapping
    public Contact create(@RequestBody Contact contact){
        return service.create(contact);
    }

    @GetMapping
    public List<Contact> list(){
        return service.list();
    }

    @GetMapping("{id}")
    public Contact getById(@PathVariable("id") Contact contact){
        return service.getById(contact);
    }

    @GetMapping("/search/name/{name}")
    public List<Contact> getByName(@PathVariable("name") String name){
        return service.getByName(name);
    }

    @GetMapping("/search/surname/{surname}")
    public List<Contact> getBySurname(@PathVariable("surname") String surname){
        return service.getBySurname(surname);
    }

    @GetMapping("/search/phone/{phone}")
    public List<Contact> getByPhone(@PathVariable("phone") String phone){
        return service.getByPhone(phone);
    }

    @GetMapping("/search/email/{email}")
    public List<Contact> getByEmail(@PathVariable("email") String email){
        return service.getByEmail(email);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Contact contact){
        service.delete(contact);
    }

    @PutMapping("{id}")
    public Contact update(@PathVariable("id") Contact contact,@RequestBody Contact newContact){
        return service.update(contact, newContact);
    }
}
