package com.ista.spingboot.web.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ista.spingboot.web.app.models.Profesor;

public interface IProfesorRepository extends MongoRepository<Profesor, Long>{

}
