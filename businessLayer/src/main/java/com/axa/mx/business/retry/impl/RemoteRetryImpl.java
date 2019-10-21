package com.axa.mx.business.retry.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.axa.mx.business.client.ClientRemote;
import com.axa.mx.business.dto.DataRestClientDto;
import com.axa.mx.business.exception.FeignException;
import com.axa.mx.business.retry.RemoteRetry;

import feign.RetryableException;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class RemoteRetryImpl implements RemoteRetry{
	
	@Autowired
	private ClientRemote clientRemote;

	@Override
	public String getRemoteBackendResponse() throws FeignException {
		log.info("Entra a getRemoteBackendResponse");
		DataRestClientDto dataRestClientDto = null;
		try {
			dataRestClientDto = clientRemote.getHello();
			
		} catch (RetryableException e) {
			throw new FeignException("ERROR :: getRemoteBackendResponse.", e);
		}
		
		return dataRestClientDto.getDataRemote();
	}

	@Override
	public void recover(FeignException ge) {
		log.info("TODOS LOS INTENTOS FUERON REALIZADOS, PERO EL SERVICIO NO CONTESTA");
//		throw new FeignException("NO se pudo conectar al serivdor remoto despues de 3 intentos. ");
		throw new ResponseStatusException(HttpStatus.GATEWAY_TIMEOUT, "Server not response 3 times", ge);
	}

}
