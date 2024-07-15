package com.api.crud.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.crud.models.ServiciosModels;
import com.api.crud.services.ServiciosService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/servicios")
public class ServiciosController {

	
	@Autowired
	ServiciosService serviciosService;
	
	
	@GetMapping
	public ArrayList<ServiciosModels>getServices(){
		return this.serviciosService.getServices();
	}
	
	  @GetMapping(path = "/{id}")
	  public Optional<ServiciosModels> getUserById(@PathVariable Long id){
		  return this.serviciosService.getByid(id);
	  }
	  
	  @PostMapping
	  public ServiciosModels saveUser(@RequestBody ServiciosModels servicio) {
		  return this.serviciosService.saveService(servicio); 
	  }
	
}
