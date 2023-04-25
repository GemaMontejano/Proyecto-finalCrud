package com.Gema.CrudBlythe.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Gema.CrudBlythe.model.Blythe;
import com.Gema.CrudBlythe.repository.BlytheRepository;

@Controller

public class BlytheController {
	@Autowired
	private BlytheRepository blytheRepository;

	@GetMapping("/Blythe")
	public String getAll(Model model, @Param("keyword") String keyword) {

		try {
			List<Blythe> blythe = new ArrayList<Blythe>();

			if (keyword == null) {
				blytheRepository.findAll().forEach(blythe::add);
			} else {
				blytheRepository.findByNombreContainingIgnoreCase(keyword).forEach(blythe::add);
				model.addAttribute("keyword", keyword);
				blytheRepository.findByLanzamientoContainingIgnoreCase(keyword).forEach(blythe::add);
				model.addAttribute("keyword", keyword);
				blytheRepository.findByEdicionContainingIgnoreCase(keyword).forEach(blythe::add);
				model.addAttribute("keyword", keyword);
				blytheRepository.findByMoldeContainingIgnoreCase(keyword).forEach(blythe::add);
				model.addAttribute("keyword", keyword);
				blytheRepository.findByCabelloContainingIgnoreCase(keyword).forEach(blythe::add);
				model.addAttribute("keyword", keyword);
				blytheRepository.findByPielContainingIgnoreCase(keyword).forEach(blythe::add);
				model.addAttribute("keyword", keyword);
				blytheRepository.findByImagenContainingIgnoreCase(keyword).forEach(blythe::add);
				model.addAttribute("keyword", keyword);
			}
			model.addAttribute("blythe", blythe);
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
		}
		return "blythe";
	}
	@GetMapping("/Blythe/new")
	public String add(Model model) {
		Blythe blythe = new Blythe();
		model.addAttribute("blythe", blythe);
		model.addAttribute("pageTitle", "Crear muñeca");

		return "blytheForm";
	}

	@PostMapping("/Blythe/save")
	public String save(Blythe blythe, RedirectAttributes redirectAttributes) {
		try {
			blytheRepository.save(blythe);
			redirectAttributes.addFlashAttribute("message", "Muñeca guardada");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("message", e.getMessage());
		}
		return "redirect:/Blythe";
	}

	@GetMapping("/Blythe/{id}")
	public String editTutorial(@PathVariable("id") Integer id, Model model, RedirectAttributes redirectAttributes) {
		try {
			Blythe blythe = blytheRepository.findById(id).get();

			model.addAttribute("blythe", blythe);
			model.addAttribute("pageTitle", "Editar Muñeca (ID: " + id + ")");

			return "blytheForm";
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("message", e.getMessage());
		}
		return "blytheForm";
	}

	@GetMapping("/Blythe/delete/{id}")
	public String delete(@PathVariable("id") Integer id, Model model, RedirectAttributes redirectAttributes) {

		try {
			blytheRepository.deleteById(id);

			redirectAttributes.addFlashAttribute("message", "Muñeca con id=" + id + " eliminada");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("message", e.getMessage());
		}

		return "redirect:/Blythe";
	}

}
