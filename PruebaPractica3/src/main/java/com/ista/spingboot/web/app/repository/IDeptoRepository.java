package com.ista.spingboot.web.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ista.spingboot.web.app.models.Depto;

public interface IDeptoRepository extends MongoRepository<Depto, Long>{

}
