package com.axa.mx.service;

import com.axa.mx.dto.CondicionInsertServiceDto;
import com.axa.mx.dto.CondicionServiceDto;

public interface CondicionService {
	CondicionServiceDto getCondicionById(Long id);

	String insertCondicion(CondicionInsertServiceDto condicionInsertServiceDto);
}
