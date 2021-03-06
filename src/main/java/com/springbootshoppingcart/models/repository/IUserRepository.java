package com.springbootshoppingcart.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springbootshoppingcart.models.entity.User;
@Repository
public interface IUserRepository extends JpaRepository<User, Long>{
 
  public User findByMail(String mailId);
}
