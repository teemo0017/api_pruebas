package com.api.crud.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.crud.models.ServiciosModels;
import com.api.crud.models.UserModels;
import com.api.crud.repositories.IServiciosRepository;

@Service
public class ServiciosService {
	
	@Autowired
	IServiciosRepository servicesRepository;
	
	public ArrayList<ServiciosModels> getServices(){
		return (ArrayList<ServiciosModels>) servicesRepository.findAll();
	}
	
	 public Optional<ServiciosModels> getByid(Long id){
		 return servicesRepository.findById(id);
	 }
	 
	  public ServiciosModels saveService(ServiciosModels service) {
		  return servicesRepository.save(service);
	  }
	  
	   

}
