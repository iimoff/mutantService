package com.mercadolibre.iimoff.mutantService.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.mercadolibre.iimoff.matrixFinder.search.AddressableMatrixSearch;
import com.mercadolibre.iimoff.matrixFinder.search.impl.RightHorizontalSearch;
import com.mercadolibre.iimoff.mutantService.dao.DnaDao;
import com.mercadolibre.iimoff.mutantService.entity.DnaEntity;
import com.mercadolibre.iimoff.mutantService.entity.StatEntity;
import com.mongodb.DuplicateKeyException;
import com.mercadolibre.iimoff.matrixFinder.search.impl.DownRightDiagonalSearch;
import com.mercadolibre.iimoff.matrixFinder.search.impl.DownVerticalSearch;
import com.mercadolibre.iimoff.matrixFinder.search.impl.DownLeftDiagonalSearch;

@Service
public class DnaService {
	
	@Value("${adn.matrix.rows}")
	private int matrixRows;
	
	@Value("${adn.matrix.cols}")
	private int matrixCols;
	
	@Value("${adn.mutant.secuence.cells.hits.required}")
	private int mutantSecuenceCellsHitsRequired;
	
	@Value("${adn.mutant.secuence.acum.required}")
	private int mutantSecuencesAcumRequired;
	
	@Value("${adn.mutant.keys}")
	private String mutantKeys;	
	
	
	@Autowired
	private DnaDao dnaDao;
	
	protected AddressableMatrixSearch [] searchDirections = {
			new RightHorizontalSearch(),
			new DownRightDiagonalSearch(),
			new DownVerticalSearch(),				
			new DownLeftDiagonalSearch()
	};
		
	
				
	public boolean isMutant(String [] dna) {
		int i = 0;
		int countHits = 0;
		boolean isMutant = false;		
		
		Set<String> cellsHitted = new HashSet<>();
		/*WHILE THE MATRIX  HAS ROWS TO ITERATE AND I DIDN'T  
		 * FIND THE ADN HITS REQUIRED, I'LL MOVE TO THE NEXT ROW*/		
		while(i < matrixRows && countHits < mutantSecuencesAcumRequired) {	
			
			/*WHILE THE MATRIX  HAS COLS TO ITERATE AND I DIDN'T 
			 * FIND THE ADN HITS REQUIRED, I'LL MOVE TO THE NEXT COL*/	
			int j = 0;			
			while(j < matrixCols && countHits < mutantSecuencesAcumRequired) {	
				
				int x = 0;
				boolean isHit = false;
				/*WHILE THE LIST HAS VALIDATIONS TO PERMORM AND I DIDN'T 	
				 * FIND THE ADN HITS REQUIRED, I'LL MOVE TO THE NEXT COL*/				
				while(x < searchDirections.length && countHits < mutantSecuencesAcumRequired ) {
					
					isHit = searchDirections[x].execute(dna, cellsHitted ,mutantKeys, mutantSecuenceCellsHitsRequired, i, j);					
					if(isHit) {						
						countHits++;
					}						
					x++;
				}
				j++;
			}
			i++;			
		}
		
		isMutant = countHits >= mutantSecuencesAcumRequired;
		dnaDao.save(new DnaEntity(dna, isMutant));
		
		return isMutant;
	}	
	
	
	protected float calculateStats(long mutantsCount, long humansCont) {
		float ratio = 0F;
		
		if(humansCont > 0) {
			int scale = (int) Math.pow(10, 1);
			double result = ((double) mutantsCount/humansCont);
			ratio = (float) Math.round(result * scale) / scale;			
		}
		return ratio;
	}
	
	public StatEntity getDnaVerificationStats(){		
				
		long mutantsCount = dnaDao.count(Example.of(new DnaEntity(true)));			
		long humansCont = dnaDao.count(Example.of(new DnaEntity(false)));
		float ratio = calculateStats(mutantsCount, humansCont);
			
		return new StatEntity(mutantsCount, humansCont, ratio);
		
	}
	
	

}
