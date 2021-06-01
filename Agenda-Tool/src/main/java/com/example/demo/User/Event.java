/**
 * 
 */
package com.example.demo.User;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
 * @author user
 *
 */

@Entity
@Table(name = "Event")
public class Event {
	private @Id @GeneratedValue long id;
	private @NotBlank String titulo;
	private @NotBlank String lugar;
	private @NotBlank String fecha_inicio;
	private @NotBlank String fecha_fin;
	private @NotBlank String descripcion;
	@ManyToMany
	@JoinTable(name = "events", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name="id"))
	public Contact[] contactos;
	/**
	 * 
	 */
	public Event() {
		super();
	}
	/**
	 * @param id
	 * @param titulo
	 * @param lugar
	 * @param fecha_inicio
	 * @param fecha_fin
	 * @param descripcion
	 * @param contactos
	 */
	public Event(long id, @NotBlank String titulo, @NotBlank String lugar, @NotBlank String fecha_inicio,
			@NotBlank String fecha_fin, @NotBlank String descripcion, Contact[] contactos) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.lugar = lugar;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		this.descripcion = descripcion;
		this.contactos = contactos;
	}
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}
	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	/**
	 * @return the lugar
	 */
	public String getLugar() {
		return lugar;
	}
	/**
	 * @param lugar the lugar to set
	 */
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	/**
	 * @return the fecha_inicio
	 */
	public String getFecha_inicio() {
		return fecha_inicio;
	}
	/**
	 * @param fecha_inicio the fecha_inicio to set
	 */
	public void setFecha_inicio(String fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}
	/**
	 * @return the fecha_fin
	 */
	public String getFecha_fin() {
		return fecha_fin;
	}
	/**
	 * @param fecha_fin the fecha_fin to set
	 */
	public void setFecha_fin(String fecha_fin) {
		this.fecha_fin = fecha_fin;
	}
	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/**
	 * @return the contactos
	 */
	public Contact[] getContactos() {
		return contactos;
	}
	/**
	 * @param contactos the contactos to set
	 */
	public void setContactos(Contact[] contactos) {
		this.contactos = contactos;
	}
	@Override
	public String toString() {
		return "Event [id=" + id + ", titulo=" + titulo + ", lugar=" + lugar + ", fecha_inicio=" + fecha_inicio
				+ ", fecha_fin=" + fecha_fin + ", descripcion=" + descripcion + ", contactos="
				+ Arrays.toString(contactos) + "]";
	}
	
	
}
