package com.api.crud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.crud.models.CitasModels;
import com.api.crud.models.MascotasModels;
import com.api.crud.models.UserModels;
import com.api.crud.repositories.ICitasRepository;
import com.api.crud.repositories.IMascotasRepository;
import com.api.crud.repositories.IUserRepository;

@Service
public class CitasService {

	@Autowired
	IUserRepository userRepository;
	
	@Autowired
	IMascotasRepository mascotaRepository;
	
	
	@Autowired
	ICitasRepository citasRepository;
	
	
	
	public CitasModels addCita(Long userId , Long petId, CitasModels request) {
		Optional<UserModels> userOptional = userRepository.findById(userId);
		Optional<MascotasModels> petOptional = mascotaRepository.findById(petId);
		
		if(userOptional.isPresent() && petOptional.isPresent()) {
			UserModels user = userOptional.get();
			MascotasModels pet = petOptional.get();
			
			request.setCliente(user);
			request.setMascota(pet);
			
			return  citasRepository.save(request);		
		}else {
			  throw new RuntimeException("Usuario o mascota no encontrados");
		}
		
		
	}
	
	
	public List<CitasModels> getAllCitas() {
		
		return (List<CitasModels>) this.citasRepository.findAll();
		
	}
	
    public List<CitasModels> buscarCitasPorCliente(Long clienteId) {
        return citasRepository.findByClienteId(clienteId);
    }
    
    public void deleteById(Long id) {
    	citasRepository.deleteById(id);
    }
}
