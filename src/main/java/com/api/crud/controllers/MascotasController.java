package com.api.crud.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.crud.models.MascotasModels;
import com.api.crud.models.UserModels;
import com.api.crud.services.MascotasService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/mascotas")
public class MascotasController {
	@Autowired
	MascotasService mascotaService;
	
	  @PostMapping(path = "/addpet")
	  public MascotasModels savePet(@RequestParam Long userId,@RequestBody MascotasModels request) {
	   this.mascotaService.addPet(userId,request);
		  
		  return request;
	  }
	  
	    @PostMapping("editar/{id}")
	    public MascotasModels updatePet(@RequestBody MascotasModels mascota, @PathVariable Long id){
	        mascota.setId(id);
	        return mascotaService.updatePet(mascota);
	    }
	    
	    
		  @GetMapping
		  public List<MascotasModels>getAllPets(){
			  return this.mascotaService.getAllPets();
		  }
		  
		  @GetMapping("buscar/{id}")
		  public List<MascotasModels> buscarMascotasPorCliente(@PathVariable Long id){
			  return this.mascotaService.buscarPetsPorCliente(id);
		  }
}
