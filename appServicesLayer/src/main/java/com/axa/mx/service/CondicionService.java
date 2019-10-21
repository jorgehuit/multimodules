package com.axa.mx.service;

import com.axa.mx.dto.CondicionInsertServiceDto;
import com.axa.mx.dto.CondicionServiceDto;
import com.axa.mx.dto.CondicionServiceDto.CondicionServiceOutDto;
import com.axa.mx.dto.CondicionServiceDto.ListCondicionServiceOutDto;

public interface CondicionService {
	CondicionServiceDto getCondicionById(Long id);

	CondicionServiceOutDto insertCondicion(CondicionInsertServiceDto condicionInsertServiceDto);
	
	ListCondicionServiceOutDto getAllCondiciones();
}
