package com.ista.spingboot.web.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import com.ista.spingboot.web.app.models.Depto;
import com.ista.spingboot.web.app.repository.IDeptoRepository;

@Service
public class IDeptoServiceImpl extends GenericaServiceImpl<Depto, Long> implements IDeptoService {
	
	@Autowired
    IDeptoRepository deptoRepository;
    @Override
    public CrudRepository<Depto, Long> getDao() {
        return deptoRepository;

	}
}
