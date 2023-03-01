package com.ista.spingboot.web.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ista.spingboot.web.app.models.Curso;

public interface ICursoRepository extends MongoRepository<Curso, Long>{

}
