package com.example20.SchoolApplication.repository;


import com.example20.SchoolApplication.model.Contact;

import org.springframework.stereotype.Repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

/*
@Repository stereotype annotation is used to add a bean of this class
type to the Spring context and indicate that given Bean is used to perform
DB related operations and
* */
@Repository
public interface ContactRepository extends CrudRepository<Contact, Integer> {

    List<Contact> findByStatus(String status);

}
