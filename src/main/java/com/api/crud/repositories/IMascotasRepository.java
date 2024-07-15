package com.api.crud.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.crud.models.MascotasModels;

public interface IMascotasRepository extends JpaRepository<MascotasModels, Long> {

	
	List<MascotasModels> findByClienteId(Long clienteId);
}
