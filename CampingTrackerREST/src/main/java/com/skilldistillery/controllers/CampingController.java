package com.skilldistillery.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.entities.Camping;
import com.skilldistillery.services.CampingService;

@RestController
@RequestMapping("api")
@CrossOrigin({"*", "http://localhost:4202"})
public class CampingController {
	
	@Autowired
	CampingService serv;

	@GetMapping("camp")
	public List<Camping> index(){
		return serv.index();
		
	}
	
	@GetMapping("camp/{id}")
	public Camping findById(@PathVariable int id) {
		return serv.findById(id); //change
	}
	
	@PostMapping("camp")
	public Camping create(@RequestBody Camping camp) {
		return serv.create(camp);
	}
	
	
	@PutMapping("camp/{id}")
	public Camping update(@RequestBody Camping camp, @PathVariable int id) {
		return serv.update(id, camp);
		
	}
	
	
	@DeleteMapping("camp/{id}")
	public boolean delete(@PathVariable int id) {
		return serv.delete(id);
	}
}
