package com.example.space.service;

import com.example.space.model.Contact;
import com.example.space.repository.ContactRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactService {
    private final ContactRepo repo;

    public Contact create(Contact contact){
        contact.setCreated(LocalDateTime.now());
        return repo.save(contact);
    }

    public List<Contact> list(){
        return repo.findAll();
    }

    public Contact getById(Contact contact){
        return contact;
    }

    public List<Contact> getByName(String name){
        return repo.findAllByName(name);
    }

    public List<Contact> getBySurname(String surname){
        return repo.findAllBySurname(surname);
    }

    public List<Contact> getByPhone(String phone){
        return repo.findAllByPhone(phone);
    }

    public List<Contact> getByEmail(String email){
        return repo.findAllByEmail(email);
    }

    public void delete(Contact contact){
        repo.delete(contact);
    }

    public Contact update(Contact contact,Contact newContact){
        BeanUtils.copyProperties(newContact, contact, "id","created");
        return repo.save(contact);
    }
}
