package com.axis.petclinic.repository.springdatajpa;

import com.axis.petclinic.model.User;
import com.axis.petclinic.repository.UserRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.Repository;


@Profile("spring-data-jpa")
public interface SpringDataUserRepository extends UserRepository, Repository<User, Integer>  {

}
