package com.axis.petclinic.repository;

import com.axis.petclinic.model.User;
import org.springframework.dao.DataAccessException;

public interface UserRepository {
    void save(User user) throws DataAccessException;
}
