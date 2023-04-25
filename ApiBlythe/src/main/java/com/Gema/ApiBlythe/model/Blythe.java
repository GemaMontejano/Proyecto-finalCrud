package com.Gema.ApiBlythe.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "blythe")
public class Blythe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;

	@Column(name = "Nombre")
	private String nombre;

	@Column(name = "Fecha de lanzamiento")
	private String lanzamiento;

	@Column(name = "Edicion")
	private String edicion;

	@Column(name = "Tipo de molde")
	private String molde;

	@Column(name = "Color de cabello")
	private String cabello;

	@Column(name = "Color de piel")
	private String piel;

	@Column(name = "Precio")
	private int precio;

	@Column(name = "Imagen")
	private String imagen;

	public Blythe() {
	}

	public Blythe(int id, String nombre, String lanzamiento, String edicion, String molde, String cabello, String piel,
			int precio, String imagen) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.lanzamiento = lanzamiento;
		this.edicion = edicion;
		this.molde = molde;
		this.cabello = cabello;
		this.piel = piel;
		this.precio = precio;
		this.imagen = imagen;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLanzamiento() {
		return lanzamiento;
	}

	public void setLanzamiento(String lanzamiento) {
		this.lanzamiento = lanzamiento;
	}

	public String getEdicion() {
		return edicion;
	}

	public void setEdicion(String edicion) {
		this.edicion = edicion;
	}

	public String getMolde() {
		return molde;
	}

	public void setMolde(String molde) {
		this.molde = molde;
	}

	public String getCabello() {
		return cabello;
	}

	public void setCabello(String cabello) {
		this.cabello = cabello;
	}

	public String getPiel() {
		return piel;
	}

	public void setPiel(String piel) {
		this.piel = piel;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	@Override
	public String toString() {
		return "Blythe [id=" + id + ", nombre=" + nombre + ", lanzamiento=" + lanzamiento + ", edicion=" + edicion
				+ ", molde=" + molde + ", cabello=" + cabello + ", piel=" + piel + ", precio=" + precio + ", imagen="
				+ imagen + "]";
	}

}
