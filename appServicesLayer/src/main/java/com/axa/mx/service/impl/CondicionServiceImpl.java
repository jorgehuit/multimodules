package com.axa.mx.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axa.mx.business.dto.CondicionBusinessDto;
import com.axa.mx.business.dto.CondicionInsertBusinessDto;
import com.axa.mx.business.services.CondicionBusinessService;
import com.axa.mx.dto.CondicionInsertServiceDto;
import com.axa.mx.dto.CondicionServiceDto;
import com.axa.mx.service.CondicionService;

@Service
public class CondicionServiceImpl implements CondicionService {
	
	@Autowired
	private CondicionBusinessService condicionBusinessService;

	@Override
	public CondicionServiceDto getCondicionById(Long id) {
		CondicionBusinessDto condicionBusinessDto = condicionBusinessService.getInfoCondicionById(id);
		return mapFromBusinessToService(condicionBusinessDto);
	}
	
	@Override
	public String insertCondicion(CondicionInsertServiceDto condicionInsertServiceDto) {
		
		CondicionInsertBusinessDto condicionInsertBusinessDto = mapFromInsertServiceToInsertBusiness(condicionInsertServiceDto);
		
		return condicionBusinessService.insertCondicion(condicionInsertBusinessDto);
	}
	
	CondicionInsertBusinessDto mapFromInsertServiceToInsertBusiness(CondicionInsertServiceDto condicionInsertServiceDto){
		CondicionInsertBusinessDto condicionInsertBusinessDto = new CondicionInsertBusinessDto();
		condicionInsertBusinessDto.setDescripcion(condicionInsertServiceDto.getDescripcion());
		condicionInsertBusinessDto.setTexto(condicionInsertServiceDto.getTexto());
		condicionInsertBusinessDto.setTipo(condicionInsertServiceDto.getTipo());
		condicionInsertBusinessDto.setTitulo(condicionInsertServiceDto.getTitulo());
		
		return condicionInsertBusinessDto;
		
	}

	CondicionServiceDto mapFromBusinessToService(CondicionBusinessDto condicionBusinessDto) {
		CondicionServiceDto condicionServiceDto = new CondicionServiceDto();
		condicionServiceDto.setDescripcion(condicionBusinessDto.getDescripcion());
		condicionServiceDto.setTexto(condicionBusinessDto.getTexto());
		condicionServiceDto.setTipo(condicionBusinessDto.getTipo());
		condicionServiceDto.setTitulo(condicionBusinessDto.getTitulo());
		condicionServiceDto.setIdGenerado(condicionBusinessDto.getIdGenerado());
		condicionServiceDto.setEstatus(condicionBusinessDto.getEstatus());
		
		return condicionServiceDto;
	}

	
}
