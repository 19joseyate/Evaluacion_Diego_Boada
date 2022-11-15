package com.gestion.clientes.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "cedula", length = 60, nullable = false)
	private String cedula;

	@Column(name = "nombre", length = 60, nullable = false)
	private String nombre;
	
	@Column(name = "apellido", length = 60, nullable = false)
	private String apellido;
	
	@Column(name = "fecha_nacimiento", length = 60, nullable = false)
	private String fecha_nacimiento;
	
	@Column(name = "ciudad", length = 60, nullable = false)
	private String ciudad;

	@Column(name = "email", length = 60, nullable = false, unique = true)
	private String email;
	
	@Column(name = "telefono", length = 60, nullable = false)
	private String telefono;
	
	@Column(name = "ocupacion", length = 60, nullable = false)
	private String ocupacion;

	public Cliente() {

	}

	public Cliente(Long id, String cedula, String nombre, String apellido, String fecha_nacimiento, String ciudad,
			String email, String telefono, String ocupacion) {
		super();
		this.id = id;
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fecha_nacimiento = fecha_nacimiento;
		this.ciudad = ciudad;
		this.email = email;
		this.telefono = telefono;
		this.ocupacion = ocupacion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getOcupacion() {
		return ocupacion;
	}

	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", fecha_nacimiento=" + fecha_nacimiento + ", ciudad=" + ciudad + ", email=" + email + ", telefono="
				+ telefono + ", ocupacion=" + ocupacion + "]";
	}


}
