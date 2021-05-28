package com.example.demo.Repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.User.Contact;

public interface CrudContact extends CrudRepository<Contact, Long>{

}
