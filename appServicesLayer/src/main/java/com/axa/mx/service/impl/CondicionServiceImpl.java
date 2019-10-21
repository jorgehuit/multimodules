package com.axa.mx.service.impl;

import static java.util.stream.Collectors.toList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axa.mx.business.dto.CondicionBusinessDto;
import com.axa.mx.business.dto.CondicionBusinessDto.CondicionBusinessOutDto;
import com.axa.mx.business.dto.CondicionInsertBusinessDto;
import com.axa.mx.business.services.CondicionBusinessService;
import com.axa.mx.dto.CondicionInsertServiceDto;
import com.axa.mx.dto.CondicionServiceDto;
import com.axa.mx.dto.CondicionServiceDto.CondicionServiceOutDto;
import com.axa.mx.dto.CondicionServiceDto.ListCondicionServiceOutDto;
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
	public CondicionServiceOutDto insertCondicion(CondicionInsertServiceDto condicionInsertServiceDto) {
		CondicionServiceOutDto insertCondicionServiceOutDto = new CondicionServiceOutDto();
		CondicionInsertBusinessDto condicionInsertBusinessDto = mapFromInsertServiceToInsertBusiness(condicionInsertServiceDto);
		CondicionBusinessOutDto insertCondicionBusinessOutDto = 
				condicionBusinessService.insertCondicion(condicionInsertBusinessDto);
		insertCondicionServiceOutDto.setDescripcion(insertCondicionBusinessOutDto.getDescripcion());
		insertCondicionServiceOutDto.setEstatus(insertCondicionBusinessOutDto.getEstatus());
		insertCondicionServiceOutDto.setId(insertCondicionBusinessOutDto.getId());
		insertCondicionServiceOutDto.setIdGenerado(insertCondicionBusinessOutDto.getIdGenerado());
		insertCondicionServiceOutDto.setTexto(insertCondicionBusinessOutDto.getTexto());
		insertCondicionServiceOutDto.setTipo(insertCondicionBusinessOutDto.getTipo());
		insertCondicionServiceOutDto.setTitulo(insertCondicionBusinessOutDto.getTitulo());
		
		
		return insertCondicionServiceOutDto;
	}
	
	@Override
	public ListCondicionServiceOutDto getAllCondiciones() {
		ListCondicionServiceOutDto listCondicionServiceOutDto = new ListCondicionServiceOutDto();
		listCondicionServiceOutDto.setListCondicionServiceOutDto(
				condicionBusinessService
				.getAllCondiciones()
				.getListCondicionBusinessOutDto()
				.stream()
				.map(this::mapFromBusinessToServiceId)
				.collect(toList()));
		
		return listCondicionServiceOutDto;
	}
	
	CondicionInsertBusinessDto mapFromInsertServiceToInsertBusiness(
			CondicionInsertServiceDto condicionInsertServiceDto){
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

	CondicionServiceOutDto mapFromBusinessToServiceId(CondicionBusinessOutDto condicionBusinessOutDto) {
		CondicionServiceOutDto condicionServiceOutDto = new CondicionServiceOutDto();
		condicionServiceOutDto.setDescripcion(condicionBusinessOutDto.getDescripcion());
		condicionServiceOutDto.setTexto(condicionBusinessOutDto.getTexto());
		condicionServiceOutDto.setTipo(condicionBusinessOutDto.getTipo());
		condicionServiceOutDto.setTitulo(condicionBusinessOutDto.getTitulo());
		condicionServiceOutDto.setIdGenerado(condicionBusinessOutDto.getIdGenerado());
		condicionServiceOutDto.setEstatus(condicionBusinessOutDto.getEstatus());
		condicionServiceOutDto.setId(condicionBusinessOutDto.getId());
		
		return condicionServiceOutDto;
	}
	
}
