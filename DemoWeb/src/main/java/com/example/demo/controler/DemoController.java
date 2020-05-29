package com.example.demo.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Persona;
//import com.example.demo.repo.IPersonaRepo;
import com.example.demo.service.PersonaService;

@Controller
public class DemoController {
	
	@Autowired
	private PersonaService service;
	
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
	 
		List<Persona> listPersona = service.lisAll();
		model.addAttribute("listPersona", listPersona);
		
	    return "greeting";
	}
	
	
	
	
	
//	@GetMapping("/greeting")
//	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {		
//		Persona p = new Persona();		
//		p.setIdPersona(2);
//		p.setNombre("Code");
//		repo.save(p);
//		model.addAttribute("name", name);
//		
//		return "greeting";
//	}	
//	
//	@GetMapping("/listar")
//	public String greeting(Model model) {		
//		
//		model.addAttribute("persona", repo.findAll());
//		return "greeting";
//	}	
//	
	
	
}
