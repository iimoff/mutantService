package com.mercadolibre.iimoff.mutantService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.FORBIDDEN, reason="An error occurs please contact the API admin.")
public class MutantApiException extends Exception{

	private static final long serialVersionUID = 5810651289023858018L;

}
