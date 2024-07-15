package com.api.crud.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.crud.models.CitasModels;

import com.api.crud.services.CitasService;

import jakarta.websocket.server.PathParam;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/citas")
public class CitasController {

	
@Autowired
CitasService citasService;

	  @PostMapping(path = "/addcite")
	  public CitasModels saveCite(@RequestParam Long userId , @RequestParam Long petId,@RequestBody CitasModels request) {
	   
		  this.citasService.addCita(userId, petId, request);
		  
		  return request;
	  }
	  
	  @GetMapping
	  public List<CitasModels> getAllCitas(){
		  return this.citasService.getAllCitas();
	  }
	  
	  
	  @GetMapping(path = "buscar/{id}")
	  public List<CitasModels> buscarCitasPorCliente(@PathVariable Long id){
		return  this.citasService.buscarCitasPorCliente(id);
	  }
	  
	  
	  
	  @GetMapping("remove/{id}")
	  public ResponseEntity<Void> deleteCite(@PathVariable Long id){
		  this.citasService.deleteById(id);
		  return ResponseEntity.ok().build();
	  }
	  
	  

	  
	
}
