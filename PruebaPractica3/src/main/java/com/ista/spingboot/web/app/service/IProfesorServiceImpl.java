package com.ista.spingboot.web.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.ista.spingboot.web.app.models.Profesor;
import com.ista.spingboot.web.app.repository.IProfesorRepository;

@Service
public class IProfesorServiceImpl extends GenericaServiceImpl<Profesor, Long> implements IProfesorService{

	@Autowired
    IProfesorRepository profesorRepository;
    @Override
    public CrudRepository<Profesor, Long> getDao() {
        return profesorRepository;
    }
}
