package com.axa.mx.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axa.mx.business.retry.RemoteRetry;
import com.axa.mx.service.ServiceRemote;

@Service
public class ServiceRemoteImpl implements ServiceRemote {
	
	@Autowired
	private RemoteRetry remoteRetry;

	@Override
	public String helloRemote() {
		return remoteRetry.getRemoteBackendResponse();
	}

}
