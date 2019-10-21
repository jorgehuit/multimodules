package com.axa.mx.business.retry;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;

import com.axa.mx.business.exception.FeignException;


public interface RemoteRetry {
	
	@Retryable(
			value = {FeignException.class }, 
			maxAttempts = 3, 
			backoff = @Backoff(delay = 1000))
	public String getRemoteBackendResponse() throws FeignException;
	
	@Recover
	public void recover(FeignException ge);

}
