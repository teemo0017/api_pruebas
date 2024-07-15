package com.api.crud.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.crud.models.EspecieModels;
import com.api.crud.services.EspecieService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/especies")
public class EspecieController {

	
	@Autowired
	EspecieService especieService;
	
	
	@GetMapping
	  public List<EspecieModels> getAllCitas(){
		  return this.especieService.findAllEspecies();
	  }
}
