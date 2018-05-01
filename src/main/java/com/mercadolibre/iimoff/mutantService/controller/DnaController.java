package com.mercadolibre.iimoff.mutantService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mercadolibre.iimoff.mutantService.entity.DnaEntity;
import com.mercadolibre.iimoff.mutantService.entity.StatEntity;
import com.mercadolibre.iimoff.mutantService.exception.MutantApiException;
import com.mercadolibre.iimoff.mutantService.exception.MutantDnaNotFoundException;
import com.mercadolibre.iimoff.mutantService.service.DnaService;


@RestController
@RequestMapping("/mutantservice")
public class DnaController {
	
	@Autowired
	private DnaService dnaService;	
	
	@RequestMapping(method = RequestMethod.POST, value="/mutant" )
	public void isMutant( @RequestBody DnaEntity dna) throws MutantDnaNotFoundException {
		
		try {
			
			/*CHECKS IF THE REQUEST HAS A MATRIX*/
			if(dna.getDna() == null || dna.getDna().length == 0) {
				throw new MutantDnaNotFoundException();
			}
			/*CHECK IF IS A MUTANT*/
			if(!dnaService.isMutant(dna.getDna())) {
				throw new MutantDnaNotFoundException();
			}
		
		/*CATCHS AN INDEX OF OUT BOUNDS PRODUCED BY AN
		 * IRREGULAR MATRIX*/
		}catch (IndexOutOfBoundsException e) {
			e.printStackTrace();			
			throw new MutantDnaNotFoundException();		
		/*
		 * CATCH ALL THE EXCEPTIONS AND 
		 * WRAP IT INTO MutantDnaNotFoundException IN ORDER
		 * TO AVOID PROVIDE API INFO TO HACKERS
		 */
		}catch (Exception e) {
			e.printStackTrace();			
			throw new MutantDnaNotFoundException();
		}
		 
	 }
	
	
	@RequestMapping(method = RequestMethod.GET, value="/stats" )
	public StatEntity getStats() throws MutantApiException {
		
		StatEntity statEntity = null;
		try {
			statEntity = dnaService.getDnaVerificationStats();
		/* 
		 * CATCH ALL THE EXCEPTIONS AND 
		 * WRAP IT INTO MutantApiExcpetion IN ORDER
		 * TO AVOID PROVIDE API INFO TO HACKERS
		 */
		}catch (Exception e) {
			e.printStackTrace();
			throw new MutantApiException();
		}
		
		return statEntity;
	}
	
}
