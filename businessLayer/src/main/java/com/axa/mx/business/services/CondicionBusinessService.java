package com.axa.mx.business.services;

import com.axa.mx.business.dto.CondicionBusinessDto;
import com.axa.mx.business.dto.CondicionBusinessDto.CondicionBusinessOutDto;
import com.axa.mx.business.dto.CondicionBusinessDto.ListCondicionBusinessOutDto;
import com.axa.mx.business.dto.CondicionInsertBusinessDto;

public interface CondicionBusinessService {
	
	CondicionBusinessDto getInfoCondicionById(Long id);

	CondicionBusinessOutDto insertCondicion(CondicionInsertBusinessDto condicionInsertBusinessDto);
	
	ListCondicionBusinessOutDto getAllCondiciones();
	
	CondicionBusinessDto bajaLogicaCondicion(Long id);

	CondicionBusinessDto editarCondicion(Long id, CondicionInsertBusinessDto condicionInsertBusinessDto);

}
