package com.axa.mx.business.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axa.mx.business.dto.CondicionBusinessDto;
import com.axa.mx.business.dto.CondicionInsertBusinessDto;
import com.axa.mx.business.services.CondicionBusinessService;
import com.axa.mx.persistence.entity.Condicion;
import com.axa.mx.persistence.repository.CondicionRepository;

@Service
public class CondicionBusinessServiceImpl implements CondicionBusinessService {
	
	@Autowired
	private CondicionRepository condicionRepository;

	@Override
	public CondicionBusinessDto getInfoCondicionById(Long id) {
		Condicion condicionEntity = condicionRepository.findById(id).get();
		return mapFromCondicionBusinessDtoToEntity(condicionEntity);
	}
	
	CondicionBusinessDto mapFromCondicionBusinessDtoToEntity(Condicion condicion) {
		CondicionBusinessDto condicionBusinessDto = new CondicionBusinessDto();
		condicionBusinessDto.setDescripcion(condicion.getDescripcion());
		condicionBusinessDto.setTexto(condicion.getTexto());
		condicionBusinessDto.setTipo(condicion.getTipo());
		condicionBusinessDto.setTitulo(condicion.getTitulo());
		
		return condicionBusinessDto;
	}

	@Override
	public String insertCondicion(CondicionInsertBusinessDto condicionInsertBusinessDto) {
		Condicion condicionEntity = condicionRepository.save(createInsertCondicion(condicionInsertBusinessDto));
		
		return condicionEntity != null ? "Insert Correct " + condicionEntity.getId() : null;
	}

	private Condicion createInsertCondicion(CondicionInsertBusinessDto condicionInsertBusinessDto) {
		Condicion condicion = new Condicion();
		condicion.setDescripcion(condicionInsertBusinessDto.getDescripcion());
		condicion.setTexto(condicionInsertBusinessDto.getTexto());
		condicion.setTipo(condicionInsertBusinessDto.getTipo());
		condicion.setTitulo(condicionInsertBusinessDto.getTitulo());
		return condicion;
	}

}
