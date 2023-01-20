/*
 * Copyright 2002-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.axis.petclinic.repository.jpa;

import java.util.Collection;

import org.springframework.context.annotation.Profile;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.axis.petclinic.model.Vet;
import com.axis.petclinic.repository.VetRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
@Profile("jpa")
public class JpaVetRepositoryImpl implements VetRepository {

    @PersistenceContext
    private EntityManager em;

   
	@Override
	public Vet findById(int id) throws DataAccessException {
		return this.em.find(Vet.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Vet> findAll() throws DataAccessException {
		return this.em.createQuery("SELECT vet FROM Vet vet").getResultList();
	}

	@Override
	public void save(Vet vet) throws DataAccessException {
        if (vet.getId() == null) {
            this.em.persist(vet);
        } else {
            this.em.merge(vet);
        }
	}

	@Override
	public void delete(Vet vet) throws DataAccessException {
		this.em.remove(this.em.contains(vet) ? vet : this.em.merge(vet));
	}


}
