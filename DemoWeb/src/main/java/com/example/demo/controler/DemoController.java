package com.example.demo.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Persona;
//import com.example.demo.repo.IPersonaRepo;
import com.example.demo.service.PersonaService;

@Controller
public class DemoController {
	
	@Autowired
	private PersonaService service;
	
	
	@RequestMapping("/")
	public String viewHomePersona(Model model) {
	 
		List<Persona> listPersona = service.lisAll();
		model.addAttribute("listPersonas", listPersona);
		
	    return "greeting";
	}
	
	
	@RequestMapping("/nuevo")
	public String showNewPersona(Model model) {
	 
		Persona persona = new Persona();
		model.addAttribute("persona", persona);
		
	    return "nuevo_asesor";
	}
	
	
	@RequestMapping(value = "/guardar", method = RequestMethod.POST)
	public String savePersona(@ModelAttribute("persona") Persona persona) {
	 
			service.save(persona);
		
	    return "redirect:/";
	}
	
	
	@RequestMapping("/editar/{id}")
	public ModelAndView showEditPersona(@PathVariable(name = "id") int id) {
	 
		ModelAndView mav = new ModelAndView("edit_asesor");
		
		Persona persona = service.get(id);
		mav.addObject("persona", persona);
		
	    return mav;
	}
	
	
	@RequestMapping("/eliminar/{id}")
	public String showEliminarPersona(@PathVariable(name = "id") int id) {
		service.delete(id);
		return "redirect:/";
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
