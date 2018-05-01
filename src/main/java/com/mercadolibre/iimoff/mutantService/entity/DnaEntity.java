package com.mercadolibre.iimoff.mutantService.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection= "dnas")
public class DnaEntity {	
	
	private String[] dna;
	private boolean isMutant;
	
	public DnaEntity(){
		super();
		this.dna = null;
		this.isMutant = false;
	}
	
	public DnaEntity(boolean isMutant){
		super();
		this.dna = null;
		this.isMutant = isMutant;
	}
	
	public DnaEntity(String[]dna, boolean isMutant){
		super();
		this.dna = dna;
		this.isMutant = isMutant;
	}
	
	public DnaEntity(String[] dna) {
		this.dna = dna;
		this.isMutant = false;
	}
			
	public String[] getDna() {
		return dna;
	}
	public void setDna(String[] dna) {
		this.dna = dna;
	}

	public boolean getIsMutant() {
		return isMutant;
	}

	public void setIsMutant(boolean isMutant) {
		this.isMutant = isMutant;
	}
	
	

}
