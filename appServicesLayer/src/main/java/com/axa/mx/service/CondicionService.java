package com.axa.mx.service;

import com.axa.mx.dto.CondicionInsertServiceDto;
import com.axa.mx.dto.CondicionServiceDto;
import com.axa.mx.dto.CondicionServiceDto.CondicionServiceOutDto;
import com.axa.mx.dto.CondicionServiceDto.ListCondicionServiceOutDto;
import com.axa.mx.dto.CondicionServiceDto.ProvisionalIdServiceDto;

public interface CondicionService {
	CondicionServiceDto getCondicionById(Long id);

	CondicionServiceOutDto insertCondicion(CondicionInsertServiceDto condicionInsertServiceDto);
	
	ListCondicionServiceOutDto getAllCondiciones();
	
	CondicionServiceDto bajaLogicaCondicion(Long id);

	CondicionServiceDto editarCondicion(Long id, CondicionInsertServiceDto condicionInsertServiceDto);
	
	String generarIdProvicional(ProvisionalIdServiceDto provisionalIdServiceDto);
}
