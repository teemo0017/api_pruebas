package com.api.crud.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.crud.models.MascotasModels;
import com.api.crud.models.UserModels;
import com.api.crud.repositories.IMascotasRepository;
import com.api.crud.repositories.IUserRepository;

@Service
public class UserService {

	@Autowired
	IUserRepository userRepository;
	
	@Autowired
	IMascotasRepository mascotaRepository;
	
	
	public ArrayList<UserModels> getUsers(){
		return (ArrayList<UserModels>) userRepository.findAll();
	}
	
	
	
	  public UserModels saveUser(UserModels user) {
		  return userRepository.save(user);
	  }
	  
	 public Optional<UserModels> getByid(Long id){
		 return userRepository.findById(id);
	 }
	 
	 public UserModels updateById(UserModels request , Long id ){
		 UserModels user = userRepository.findById(id).get();
				 
		 user.setFirstName(request.getFirstName());
		 user.setLastName(request.getLastName());
		 user.setEmail(request.getEmail());
		 
		 userRepository.save(user);
		 
		 return user;
	 }
	 
	    public void deleteById(Long id) {
	        userRepository.deleteById(id);
	    }
	 
	 

	 
}
