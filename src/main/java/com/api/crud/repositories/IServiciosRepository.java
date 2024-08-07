package com.api.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.crud.models.ServiciosModels;

@Repository
public interface IServiciosRepository extends JpaRepository<ServiciosModels, Long>{

}
