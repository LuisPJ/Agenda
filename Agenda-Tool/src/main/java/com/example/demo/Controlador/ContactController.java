package com.example.demo.Controlador;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repository.CrudContact;
import com.example.demo.User.Contact;
import com.example.demo.User.Status;


@RestController
public class ContactController {
	
	@Autowired
	CrudContact crudContact;
	
	@PostMapping("/contact/register")
	public Status registerContact(@Valid @RequestBody Contact newContact) {
		crudContact.save(newContact);
		return Status.SUCCESS;
	}
	
	@PostMapping("/contact/update/{id}")
	public Status updateContact(@PathVariable("id") long id, Model model, Contact contactUp) {
		Contact contact = crudContact.findById(id)
			      .orElseThrow(() -> new IllegalArgumentException("Invalid contact Id:" + id));
			    
				contact.setApellido(contactUp.getApellido());
				contact.setDireccion(contactUp.getDireccion());
				contact.setEmail(contactUp.getEmail());
				contact.setNombre(contactUp.getNombre());
				contact.setTelefono(contactUp.getTelefono());
			
			    crudContact.save(contact);
			    return Status.SUCCESS;
	}
	
	@DeleteMapping("/contact/delete/{id}")
	public Status deleteUsers(@PathVariable("id") long id) {
		Contact contact = crudContact.findById(id)
			      .orElseThrow(() -> new IllegalArgumentException("Invalid contact Id:" + id));
		crudContact.delete(contact);
		return Status.SUCCESS;
	}
	
	@DeleteMapping("/contact/read/{id}")
	public Contact getUsers(@PathVariable("id") long id) {
		Contact contact = crudContact.findById(id)
			      .orElseThrow(() -> new IllegalArgumentException("Invalid contact Id:" + id));
		return contact;
	}
	
}
