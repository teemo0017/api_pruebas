package com.api.crud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.access.RequestMatcherDelegatingWebInvocationPrivilegeEvaluator;
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

	public MascotasModels updatePet(MascotasModels request, Long idPet, Long idUser) {
		Optional<MascotasModels> petOptional = mascotaRepository.findById(idPet);
		Optional<UserModels> userOptional = userRepository.findById(idUser);

		if (petOptional.isPresent() && userOptional.isPresent()) {

			MascotasModels pet = petOptional.get();
			UserModels user = userOptional.get();

			pet.setNombre_mascota(request.getNombre_mascota());
			pet.setEdad(request.getEdad());
			pet.setEspecie(request.getEspecie());
			pet.setGenero(request.getGenero());
			pet.setColor(request.getColor());
			pet.setPeso(request.getPeso());
			pet.setCliente(user);

			return mascotaRepository.save(pet);

		} else {
			// Manejar el caso donde la mascota o el usuario no se encuentran
			if (!petOptional.isPresent()) {
				throw new RuntimeException("Mascota no encontrada con el ID: " + idPet);
			}
			if (!userOptional.isPresent()) {
				throw new RuntimeException("Usuario no encontrado con el ID: " + idUser);
			}

		}
		return null;
	}

	public List<MascotasModels> getAllPets() {
		return (List<MascotasModels>) mascotaRepository.findAll();
	}

	public List<MascotasModels> buscarPetsPorCliente(Long clienteId) {
		return mascotaRepository.findByClienteId(clienteId);
	}
	
	public Optional<MascotasModels> buscarPet(Long petId) {
		return mascotaRepository.findById(petId);
	}

}
