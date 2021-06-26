package com.springbootshoppingcart.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbootshoppingcart.models.entity.Rol;
@Repository
public interface IRolRepository extends JpaRepository<Rol, Long>{
  Rol findByName(String name); 
}
