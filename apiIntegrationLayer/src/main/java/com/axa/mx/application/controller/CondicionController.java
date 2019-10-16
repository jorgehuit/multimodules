package com.axa.mx.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axa.mx.application.dto.CondicionApiDto;
import com.axa.mx.application.dto.CondicionInsertApiDto;
import com.axa.mx.application.dto.DataApi;
import com.axa.mx.dto.CondicionInsertServiceDto;
import com.axa.mx.dto.CondicionServiceDto;
import com.axa.mx.service.CondicionService;

@RestController
@RequestMapping("/api")
public class CondicionController {
	
	@Autowired
	private CondicionService condicionService;
	
	@GetMapping(value = "/getCondicionById/{id}")
	public ResponseEntity<CondicionApiDto> getCondicionById(@PathVariable("id") Long id){
		CondicionServiceDto condicionServiceDto = condicionService.getCondicionById(id);
		CondicionApiDto condicionApiDto = mapFromServiceToAPi(condicionServiceDto);
		
		return new ResponseEntity<CondicionApiDto> (condicionApiDto, HttpStatus.OK);
	}
	
	@PostMapping(value = "/insertCondicion")
	public ResponseEntity<DataApi> insertCondicion(@RequestBody CondicionInsertApiDto condicionInsertApiDto){
		String message = condicionService.insertCondicion(
				mapFromInsertApiToInsertService(condicionInsertApiDto)
				);
		
		return new ResponseEntity<DataApi>(new DataApi(message), HttpStatus.OK);
	}
	
	CondicionInsertServiceDto mapFromInsertApiToInsertService(CondicionInsertApiDto condicionInsertApiDto) {
		CondicionInsertServiceDto condicionInsertServiceDto = new CondicionInsertServiceDto();
		condicionInsertServiceDto.setDescripcion(condicionInsertApiDto.getDescripcion());
		condicionInsertServiceDto.setTexto(condicionInsertApiDto.getTexto());
		condicionInsertServiceDto.setTipo(condicionInsertApiDto.getTipo());
		condicionInsertServiceDto.setTitulo(condicionInsertApiDto.getTitulo());
		
		return condicionInsertServiceDto;
		
	}
	
	CondicionApiDto mapFromServiceToAPi(CondicionServiceDto condicionServiceDto) {
		CondicionApiDto condicionApiDto = new CondicionApiDto();
		
		condicionApiDto.setDescripcion(condicionServiceDto.getDescripcion());
		condicionApiDto.setTexto(condicionServiceDto.getTexto());
		condicionApiDto.setTipo(condicionServiceDto.getTipo());
		condicionApiDto.setTitulo(condicionServiceDto.getTitulo());
		
		return condicionApiDto;
	}

}