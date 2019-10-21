package com.axa.mx.business.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

import com.axa.mx.business.dto.DataRestClientDto;

@FeignClient(name = "clientRemote", url = "http://localhost:8081")
public interface ClientRemote {
	
	@GetMapping(value="/remoteHello", consumes=MediaType.APPLICATION_JSON_VALUE)
	DataRestClientDto getHello();

}
