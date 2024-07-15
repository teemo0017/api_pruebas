package com.api.crud.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.crud.models.EspecieModels;
import com.api.crud.repositories.IEspecieRepository;

@Service
public class EspecieService {

	@Autowired
	IEspecieRepository especieRepository;
	
	
	
	public List<EspecieModels> findAllEspecies(){
		
		return (List<EspecieModels>) especieRepository.findAll();
		
	}
}
