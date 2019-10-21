package com.axa.mx.application.controller;

import static java.util.stream.Collectors.toList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axa.mx.application.dto.CondicionApiDto;
import com.axa.mx.application.dto.CondicionApiDto.CondicionApiOutDto;
import com.axa.mx.application.dto.CondicionApiDto.ListCondicionApiDto;
import com.axa.mx.application.dto.CondicionInsertApiDto;
import com.axa.mx.business.dto.CustomErrorResponseDTO;
import com.axa.mx.dto.CondicionInsertServiceDto;
import com.axa.mx.dto.CondicionServiceDto;
import com.axa.mx.dto.CondicionServiceDto.CondicionServiceOutDto;
import com.axa.mx.dto.CondicionServiceDto.ListCondicionServiceOutDto;
import com.axa.mx.service.CondicionService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = { "http://localhost:4200" })
public class CondicionController {
	
	@Autowired
	private CondicionService condicionService;
	
	@ApiOperation(value = "Obtiene una condición por medio del ID")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "SUCCESS", response = CondicionApiDto.class),
			@ApiResponse(code = 404, message = "Not found", response = CustomErrorResponseDTO.class)
	})
	@GetMapping(value = "/getCondicionById/{id}")
	public ResponseEntity<CondicionApiDto> getCondicionById(@PathVariable("id") Long id){
		CondicionServiceDto condicionServiceDto = condicionService.getCondicionById(id);
		CondicionApiDto condicionApiDto = mapFromServiceToAPi(condicionServiceDto);
		
		return new ResponseEntity<CondicionApiDto> (condicionApiDto, HttpStatus.OK);
	}

	@GetMapping(value = "/getAllCondicion")
	public ResponseEntity<ListCondicionApiDto> getAllCondicion() {
		ListCondicionApiDto listCondicionApiDto = new ListCondicionApiDto();
		listCondicionApiDto.setListCondicionApiDto(
				condicionService
				.getAllCondiciones()
				.getListCondicionServiceOutDto()
				.stream()
				.map(this::createList)
				.collect(toList()));

		return new ResponseEntity<ListCondicionApiDto>(listCondicionApiDto, HttpStatus.OK);
	}
	
	@PostMapping(value = "/insertCondicion")
	public ResponseEntity<CondicionApiOutDto> insertCondicion(
			@RequestBody CondicionInsertApiDto condicionInsertApiDto){
		CondicionApiOutDto insertCondicionOutDto = new CondicionApiOutDto();
		
		CondicionServiceOutDto insertCondicion = 
				condicionService.insertCondicion(mapFromInsertApiToInsertService(condicionInsertApiDto));
		insertCondicionOutDto.setDescripcion(insertCondicion.getDescripcion());
		insertCondicionOutDto.setEstatus(insertCondicion.getEstatus());
		insertCondicionOutDto.setId(insertCondicion.getId());
		insertCondicionOutDto.setIdGenerado(insertCondicion.getIdGenerado());
		insertCondicionOutDto.setTexto(insertCondicion.getTexto());
		insertCondicionOutDto.setTipo(insertCondicion.getTipo());
		insertCondicionOutDto.setTitulo(insertCondicion.getTitulo());
		
		return new ResponseEntity<CondicionApiOutDto>(insertCondicionOutDto, HttpStatus.OK);
	}
	
	private CondicionInsertServiceDto mapFromInsertApiToInsertService(CondicionInsertApiDto condicionInsertApiDto) {
		CondicionInsertServiceDto condicionInsertServiceDto = new CondicionInsertServiceDto();
		condicionInsertServiceDto.setDescripcion(condicionInsertApiDto.getDescripcion());
		condicionInsertServiceDto.setTexto(condicionInsertApiDto.getTexto());
		condicionInsertServiceDto.setTipo(condicionInsertApiDto.getTipo());
		condicionInsertServiceDto.setTitulo(condicionInsertApiDto.getTitulo());
		
		return condicionInsertServiceDto;
		
	}
	
	private CondicionApiDto mapFromServiceToAPi(CondicionServiceDto condicionServiceDto) {
		CondicionApiDto condicionApiDto = new CondicionApiDto();
		
		condicionApiDto.setDescripcion(condicionServiceDto.getDescripcion());
		condicionApiDto.setTexto(condicionServiceDto.getTexto());
		condicionApiDto.setTipo(condicionServiceDto.getTipo());
		condicionApiDto.setTitulo(condicionServiceDto.getTitulo());
		condicionApiDto.setIdGenerado(condicionServiceDto.getIdGenerado());
		condicionApiDto.setEstatus(condicionServiceDto.getEstatus());
		
		return condicionApiDto;
	}
	
	private CondicionApiOutDto createList(CondicionServiceOutDto condicionServiceOutDto) {
		CondicionApiOutDto  condicionOutDto = new CondicionApiOutDto();
		condicionOutDto.setDescripcion(condicionServiceOutDto.getDescripcion());
		condicionOutDto.setTexto(condicionServiceOutDto.getTexto());
		condicionOutDto.setTipo(condicionServiceOutDto.getTipo());
		condicionOutDto.setTitulo(condicionServiceOutDto.getTitulo());
		condicionOutDto.setIdGenerado(condicionServiceOutDto.getIdGenerado());
		condicionOutDto.setEstatus(condicionServiceOutDto.getEstatus());
		condicionOutDto.setId(condicionServiceOutDto.getId());
		
		return condicionOutDto;
	}

}
