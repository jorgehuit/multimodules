package com.axa.mx.application.controller;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axa.mx.application.dto.CondicionApiDto;
import com.axa.mx.application.dto.CondicionApiDto.CondicionApiOutDto;
import com.axa.mx.application.dto.CondicionInsertApiDto;
import com.axa.mx.application.dto.CondicionesApiBaseDto;
import com.axa.mx.business.dto.CustomErrorResponseDTO;
import com.axa.mx.dto.CondicionInsertServiceDto;
import com.axa.mx.dto.CondicionServiceDto.CondicionServiceOutDto;
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
	
	private final DozerBeanMapper mapper = new DozerBeanMapper();
	
	@ApiOperation(value = "Obtiene una condición por medio del ID")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "SUCCESS", response = CondicionApiDto.class),
			@ApiResponse(code = 404, message = "Not found", response = CustomErrorResponseDTO.class)})
	@GetMapping(value = "/getCondicionById/{id}")
	public ResponseEntity<CondicionApiDto> getCondicionById(@PathVariable("id") Long id){
		CondicionApiDto condicionApiDto = mapper.map(condicionService.getCondicionById(id), CondicionApiDto.class);
		
		return new ResponseEntity<CondicionApiDto> (condicionApiDto, HttpStatus.OK);
	}

	@GetMapping(value = "/getCondiciones")
	public ResponseEntity<List<CondicionesApiBaseDto>> getCondiciones() {
		List<CondicionesApiBaseDto> listCondicionesApiBaseDto = new ArrayList<>();

		listCondicionesApiBaseDto = condicionService.getAllCondiciones()
				.getListCondicionServiceOutDto()
				.stream()
				.map(this::mapFromServiceToApi)
				.collect(toList());

		return new ResponseEntity<List<CondicionesApiBaseDto>>(listCondicionesApiBaseDto, HttpStatus.OK);
	}
	
	@PutMapping(value = "/insertCondicion")
	public ResponseEntity<CondicionApiOutDto> insertCondicion(
			@RequestBody CondicionInsertApiDto condicionInsertApiDto){
		CondicionServiceOutDto insertCondicion = 
				condicionService.insertCondicion(mapper.map(condicionInsertApiDto, CondicionInsertServiceDto.class));
		CondicionApiOutDto condicionApiOutDto = mapper.map(insertCondicion, CondicionApiOutDto.class);
		
		return new ResponseEntity<CondicionApiOutDto>(condicionApiOutDto, HttpStatus.CREATED);
	}
	
	@DeleteMapping(value = "/bajaCondicion/{id}")
	public ResponseEntity<CondicionApiDto> bajaCondicion(@PathVariable("id") Long id){
		CondicionApiDto condicionApiDto = mapper.map(condicionService.bajaLogicaCondicion(id), CondicionApiDto.class);
		
		return new ResponseEntity<CondicionApiDto> (condicionApiDto, HttpStatus.OK);
	}
	
	private CondicionesApiBaseDto mapFromServiceToApi(CondicionServiceOutDto condicionServiceOutDto) {
		return mapper.map(condicionServiceOutDto, CondicionesApiBaseDto.class);
	}

}
