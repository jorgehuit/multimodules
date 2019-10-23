package com.axa.mx.service.impl;

import static java.util.stream.Collectors.toList;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	private final DozerBeanMapper mapper = new DozerBeanMapper();

	@Override
	public CondicionServiceDto getCondicionById(Long id) {
		return mapper.map(condicionBusinessService.getInfoCondicionById(id), CondicionServiceDto.class);
	}
	
	@Override
	public CondicionServiceOutDto insertCondicion(CondicionInsertServiceDto condicionInsertServiceDto) {
		CondicionBusinessOutDto condicionBusinessOutDto = 
				condicionBusinessService.insertCondicion(
						mapper.map(condicionInsertServiceDto, CondicionInsertBusinessDto.class));
		
		return mapper.map(condicionBusinessOutDto, CondicionServiceOutDto.class);
	}
	
	@Override
	public ListCondicionServiceOutDto getAllCondiciones() {
		ListCondicionServiceOutDto listCondicionServiceOutDto = new ListCondicionServiceOutDto();
		listCondicionServiceOutDto.setListCondicionServiceOutDto(
				condicionBusinessService
				.getAllCondiciones()
				.getListCondicionBusinessOutDto()
				.stream()
				.map(this::mapFromBusinessToService)
				.collect(toList()));
		
		return listCondicionServiceOutDto;
	}
	
	@Override
	public CondicionServiceDto bajaLogicaCondicion(Long id) {
		return mapper.map(condicionBusinessService.bajaLogicaCondicion(id), CondicionServiceDto.class);
		
	}

	CondicionServiceOutDto mapFromBusinessToService(CondicionBusinessOutDto condicionBusinessOutDto) {
		CondicionServiceOutDto condicionServiceOutDto = mapper.map(condicionBusinessOutDto, CondicionServiceOutDto.class);
		
		return condicionServiceOutDto;
	}

}
