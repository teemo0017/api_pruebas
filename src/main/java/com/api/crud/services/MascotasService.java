package com.api.crud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.crud.models.MascotasModels;
import com.api.crud.models.UserModels;
import com.api.crud.repositories.IMascotasRepository;
import com.api.crud.repositories.IUserRepository;

@Service
public class MascotasService {

		@Autowired
		IUserRepository userRepository;
		
		@Autowired
		IMascotasRepository mascotaRepository;
	
		
		
	 public MascotasModels addPet(Long userId, MascotasModels request) {
		 
	     Optional<UserModels> userOptional = userRepository.findById(userId);
	     
	     
	        if (userOptional.isPresent()) {
	            UserModels user = userOptional.get();
	            
	            request.setCliente(user);
	            
	            
	            return mascotaRepository.save(request);
	        } else {
	            // Manejar el caso donde el usuario no se encuentra
	            throw new RuntimeException("Usuario no encontrado con el ID: " + request.getCliente().getId());
	        }
	 }	
	 
	 public MascotasModels updatePet(MascotasModels request) {
		 return mascotaRepository.save(request);
	 }
	 
	 public List<MascotasModels> getAllPets(){
		 return (List<MascotasModels>) mascotaRepository.findAll();
	 }
	 
	 public List<MascotasModels> buscarPetsPorCliente(Long clienteId){
		 return mascotaRepository.findByClienteId(clienteId);
	 }
	 
	 
}
