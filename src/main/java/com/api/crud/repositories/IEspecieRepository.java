package com.api.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.crud.models.EspecieModels;

public interface IEspecieRepository  extends JpaRepository<EspecieModels, Long> {

}
