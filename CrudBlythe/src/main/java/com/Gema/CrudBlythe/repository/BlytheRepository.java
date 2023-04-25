package com.Gema.CrudBlythe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Gema.CrudBlythe.model.Blythe;

public interface BlytheRepository extends JpaRepository<Blythe, Integer> {
	List<Blythe> findByNombreContainingIgnoreCase(String nombre);
	List<Blythe> findByLanzamientoContainingIgnoreCase(String lanzamiento);
	List<Blythe> findByEdicionContainingIgnoreCase(String edicion);
	List<Blythe> findByMoldeContainingIgnoreCase(String molde);
	List<Blythe> findByCabelloContainingIgnoreCase(String cabello);
	List<Blythe> findByPielContainingIgnoreCase(String piel);
	List<Blythe> findByImagenContainingIgnoreCase(String imagen);
}
