package com.mercadolibre.iimoff.mutantService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.FORBIDDEN, reason="Mutant DNA not found.")
public class MutantDnaNotFoundException extends MutantApiException{
	
	private static final long serialVersionUID = -8176828804876463942L;

}
