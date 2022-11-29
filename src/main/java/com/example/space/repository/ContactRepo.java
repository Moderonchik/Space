package com.example.space.repository;

import com.example.space.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepo extends JpaRepository<Contact, Integer> {
    List<Contact> findAllByName(String name);

    List<Contact> findAllBySurname(String surname);

    List<Contact> findAllByPhone(String phone);

    List<Contact> findAllByEmail(String email);
}
