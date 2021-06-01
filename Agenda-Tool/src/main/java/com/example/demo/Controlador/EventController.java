package com.example.demo.Controlador;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.Repository.CrudEvent;
import com.example.demo.User.Event;
import com.example.demo.User.Status;

public class EventController {
	@Autowired
	CrudEvent crudEvent;
	
	@PostMapping("/event/register")
	public Status registerEvent(@Valid @RequestBody Event newEvent) {
		crudEvent.save(newEvent);
		return Status.SUCCESS;
	}
	
	@PostMapping("/event/update/{id}")
	public Status updateEvent(@PathVariable("id") long id, Model model, Event eventUp) {
		Event evento = crudEvent.findById(id)
			      .orElseThrow(() -> new IllegalArgumentException("Invalid event Id:" + id));
			    
				evento.setDescripcion(eventUp.getDescripcion());
				evento.setContactos(eventUp.getContactos());
				evento.setFecha_fin(eventUp.getFecha_fin());
				evento.setFecha_inicio(eventUp.getFecha_inicio());
				evento.setLugar(eventUp.getLugar());
				evento.setTitulo(eventUp.getTitulo());
			
			    crudEvent.save(evento);
			    return Status.SUCCESS;
	}
	
	@DeleteMapping("/event/delete/{id}")
	public Status deleteEvent(@PathVariable("id") long id) {
		Event event = crudEvent.findById(id)
			      .orElseThrow(() -> new IllegalArgumentException("Invalid event Id:" + id));
		crudEvent.delete(event);
		return Status.SUCCESS;
	}
	
	@DeleteMapping("/event/read/{id}")
	public Event getEvent(@PathVariable("id") long id) {
		Event event = crudEvent.findById(id)
			      .orElseThrow(() -> new IllegalArgumentException("Invalid event Id:" + id));
		return event;
	}
}
