package com.api.crud.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.crud.models.CitasModels;

public interface ICitasRepository extends JpaRepository<CitasModels, Long> {

	
	
	List<CitasModels> findByClienteId(Long clienteId);
}
