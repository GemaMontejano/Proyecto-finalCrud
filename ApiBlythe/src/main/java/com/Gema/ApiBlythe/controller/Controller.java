package com.Gema.ApiBlythe.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Gema.ApiBlythe.model.Blythe;
import com.Gema.ApiBlythe.repository.BlytheRepository;

@CrossOrigin
@RestController
@RequestMapping("/api")

public class Controller {
	@Autowired
	BlytheRepository blytheRepository;

	@GetMapping("/Blythe")
	public ResponseEntity<List<Blythe>> getAll() {
		try {
			List<Blythe> blythe = blytheRepository.findAll();

			if (blythe.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(blythe, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/Blythe/{ID}")
	public ResponseEntity<Blythe> getById(@PathVariable("ID") int id) {
		Optional<Blythe> blythe = blytheRepository.findById(id);

		if (blythe.isPresent()) {
			return new ResponseEntity<>(blythe.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/Blythe")
	public ResponseEntity<Blythe> create(@RequestBody Blythe blythe) {
		try {
			Blythe newBlythe = new Blythe(0, blythe.getNombre(), blythe.getLanzamiento(), blythe.getEdicion(),
					blythe.getMolde(), blythe.getCabello(), blythe.getPiel(), blythe.getPrecio(), blythe.getImagen());
			newBlythe = blytheRepository.save(newBlythe);
			return new ResponseEntity<>(newBlythe, HttpStatus.OK);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("Blythe/{ID}")
	public ResponseEntity<Blythe> update(@PathVariable("ID") int id, @RequestBody Blythe blythe) {
		try {
			Optional<Blythe> newBlythe = blytheRepository.findById(id);
			if (newBlythe.isPresent()) {
				Blythe updBlythe = newBlythe.get();
				updBlythe.setNombre(blythe.getNombre());
				updBlythe.setLanzamiento(blythe.getLanzamiento());
				updBlythe.setEdicion(blythe.getEdicion());
				updBlythe.setMolde(blythe.getMolde());
				updBlythe.setCabello(blythe.getCabello());
				updBlythe.setPiel(blythe.getPiel());
				updBlythe.setPrecio(blythe.getPrecio());
				updBlythe.setImagen(blythe.getImagen());
				updBlythe = blytheRepository.save(updBlythe);
				return new ResponseEntity<>(updBlythe, HttpStatus.OK);

			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/Blythe/{ID}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("ID") int id) {
		try {
			blytheRepository.deleteById(id);
			return ResponseEntity.ok(null);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/Blythe/search/{keyword}")
	public ResponseEntity<List<Blythe>> search(@PathVariable String keyword) {
		System.out.println(keyword);
		try {
			List<Blythe> blythe = new ArrayList<Blythe>();

			if (keyword == null) {
				blytheRepository.findAll().forEach(blythe::add);
			} else {
				System.out.println("busqueda");
				blytheRepository.findByNombreContainingIgnoreCase(keyword).forEach(blythe::add);
				blytheRepository.findByLanzamientoContainingIgnoreCase(keyword).forEach(blythe::add);
				blytheRepository.findByEdicionContainingIgnoreCase(keyword).forEach(blythe::add);
				blytheRepository.findByMoldeContainingIgnoreCase(keyword).forEach(blythe::add);
				blytheRepository.findByCabelloContainingIgnoreCase(keyword).forEach(blythe::add);
				blytheRepository.findByPielContainingIgnoreCase(keyword).forEach(blythe::add);
				blytheRepository.findByImagenContainingIgnoreCase(keyword).forEach(blythe::add);
			}

			if (blythe.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(blythe, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
