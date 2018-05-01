package com.mercadolibre.iimoff.mutantService.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StatEntity {
	
	private long countMutantDna;
	
	private long countHumanDna;
	
	private float ratio;
	
	public StatEntity(){
		super();
	}	
	
	public StatEntity(long countMutantDna, long countHumanDna, float ratio) {
		super();
		this.countMutantDna = countMutantDna;
		this.countHumanDna = countHumanDna;
		this.ratio = ratio;
	}

	@JsonProperty("count_mutant_dna")
	public long getCountMutantDna() {
		return countMutantDna;
	}

	public void setCountMutantDna(long countMutantDna) {
		this.countMutantDna = countMutantDna;
	}
	
	@JsonProperty("count_human_dna")
	public long getCountHumanDna() {
		return countHumanDna;
	}

	public void setCountHumanDna(long countHumanDna) {
		this.countHumanDna = countHumanDna;
	}
	
	public float getRatio() {
		return ratio;
	}

	public void setRatio(float ratio) {
		this.ratio = ratio;
	}
	
}
