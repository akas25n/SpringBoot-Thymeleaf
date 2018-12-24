package com.test.project.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.test.project.entity.Person;
import com.test.project.repository.PersonRepository;
import com.test.project.service.PersonService;

@RestController
public class TestController {
	
	@Autowired
	private PersonRepository personRepo;
	
	
	@Autowired
	private PersonService personService;

	@RequestMapping(value="/hello", method=RequestMethod.GET )
	public ModelAndView showMsg() {
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("hello");
		
		return mv;
		
	}
	
	
	@RequestMapping(value="/person", method=RequestMethod.GET)
	public ModelAndView showPerson() {
		ModelAndView mv = new ModelAndView();
		Person person = new Person();
		mv.addObject("person", person);
		mv.setViewName("person");
		
		return mv;
	}
	
	
	
	
	@RequestMapping(value="/person/save", method=RequestMethod.POST)
	public ModelAndView savePerson(@Valid Person person, BindingResult bindingResult) {
		ModelAndView mv = new ModelAndView();
		
		if (bindingResult.hasErrors()) {
			mv.setViewName("person");
		}
		
		
		
		//List<Person> person=personRepo.findAll();
		personService.savePerson(person);
		mv.addObject("msg", "Person have been saved successfully");
		mv.addObject("person", new Person());
		
		mv.setViewName("person");
		
		return mv;
	}	
	
	
	@RequestMapping(value="/person/{id}", method=RequestMethod.GET)
	public ModelAndView getPerson(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView();
		
		Optional<Person> person = personRepo.findById(id);
		mv.addObject("person", person);
		mv.setViewName("person");
		
		return mv;
	}
	
	@RequestMapping(value="/person/update", method=RequestMethod.POST)
	public ModelAndView updatePerson(@Valid Person person, BindingResult bindingResult) {
		ModelAndView mv = new ModelAndView();
		
		if (bindingResult.hasErrors()) {
			person.setPerson_id(person.getPerson_id());
			mv.setViewName("updateUser");
		}
		
		
		
		//List<Person> person=personRepo.findAll();
		//personService.savePerson(person);
		personRepo.save(person);
		mv.addObject("msg", "Person have been saved successfully");
		mv.addObject("person", personRepo.findAll());
		
		mv.setViewName("hello");
		
		return new ModelAndView("redirect:/hello");
	}	
	
	
}
