/**
 * 
 */
package com.example.demo.Repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.User.Event;

/**
 * @author user
 *
 */
public interface CrudEvent extends CrudRepository<Event, Long>{

}
