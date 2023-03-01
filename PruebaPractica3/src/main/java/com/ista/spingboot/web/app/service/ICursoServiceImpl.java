package com.ista.spingboot.web.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import com.ista.spingboot.web.app.models.Curso;
import com.ista.spingboot.web.app.repository.ICursoRepository;

@Service
public class ICursoServiceImpl extends GenericaServiceImpl<Curso, Long> implements ICursoService{

	@Autowired
    ICursoRepository cursoRepository;
    @Override
    public CrudRepository<Curso, Long> getDao() {
        return cursoRepository;
	
    }
}