package com.axa.mx.service;

import com.axa.mx.dto.CondicionInsertServiceDto;
import com.axa.mx.dto.CondicionServiceDto;
import com.axa.mx.dto.CondicionServiceDto.InsertCondicionServiceOutDto;

public interface CondicionService {
	CondicionServiceDto getCondicionById(Long id);

	InsertCondicionServiceOutDto insertCondicion(CondicionInsertServiceDto condicionInsertServiceDto);
}
