package com.axa.mx.business.services;

import com.axa.mx.business.dto.CondicionBusinessDto;
import com.axa.mx.business.dto.CondicionBusinessDto.InsertCondicionBusinessOutDto;
import com.axa.mx.business.dto.CondicionInsertBusinessDto;

public interface CondicionBusinessService {
	
	CondicionBusinessDto getInfoCondicionById(Long id);

	InsertCondicionBusinessOutDto insertCondicion(CondicionInsertBusinessDto condicionInsertBusinessDto);

}
