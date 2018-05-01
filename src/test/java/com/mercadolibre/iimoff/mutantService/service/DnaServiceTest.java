package com.mercadolibre.iimoff.mutantService.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class DnaServiceTest {	
	
	
	@Autowired
	private DnaService dnaService;
	
	@Test
	public void isHorizontalHit() {		
		
		String[]dna = {
							"AAAAAA",
							"QQQQQQ",
							"QQQQQQ",
							"QQQQQQ",
							"QQQQQQ",
							"AAAAAA"
		};
		
		assertTrue("isHorizontalHit must be true", dnaService.isMutant(dna));    
		
	}
	
	
	@Test
	public void isVerticallHit() {		
		
		String[]dna = {
							"AQQQQA",
							"AQQQQA",
							"AQQQQA",
							"AQQQQA",
							"QQQQQQ",
							"QQQQQQ"
		};
		
		assertTrue("isHorizontalHit must be true", dnaService.isMutant(dna));  
		
	}
	
	
	@Test
	public void isDownRightDiagonalHit() {
				
		String[]dna = {
							"AQAQQQ",
							"QAQAQQ",
							"QQAQAQ",
							"QQQAQA",
							"QQQQQQ",
							"QQQQQQ"
		};		
		assertTrue("isHorizontalHit must be true", dnaService.isMutant(dna));  
		
	}

	
	@Test
	public void isDownLeftDiagonalHit() {		
		
		String[]dna = {
							"QQQAQQ",
							"QQAQQQ",
							"QAQQQA",
							"AQQQAQ",
							"QQQAQQ",
							"QQAQQQ"
		};
		
		assertTrue("isHorizontalHit must be true", dnaService.isMutant(dna));
	}

	
	@Test
	public void isProvidedExampleMatrixHit() {
		
		String [] dna = {
							"ATGCGA",
							"CAGTGC",
							"TTATGT",
							"AGAAGG",
							"CCCCTA",
							"TCACTG"						
						};
				
		assertTrue("isHorizontalHit must be true", dnaService.isMutant(dna));    
		
	}
	
	
	@Test
	public void doesNotMatchTest() {
		
		String [] dna = {
							"QQQQQQ",
							"QQQQQQ",
							"QQQQQQ",
							"QQQQQQ",
							"QQQQQQ",
							"QQQQQQ"						
						};
				
		assertFalse("isHorizontalHit must be false", dnaService.isMutant(dna));    
		
	}
	
	
	@Test
	public void verticalDoesNotFit() {		
		
		String [] dna = {
							"AQQQQQ",
							"AQQQQQ",
							"AQAQQQ",
							"QQAQQA",
							"QQAQQA",
							"QQQQQA"						
						};
	
		assertFalse("isHorizontalHit must be false", dnaService.isMutant(dna));   
		
	}
	
	
	@Test
	public void horizontalDoesNotFit() {
		
		String [] dna = {
							"AAAQQQ",
							"QQQQQQ",
							"QQAAAQ",
							"QQQQQQ",
							"QQQQQQ",
							"QQQAAA"						
						};
				
		assertFalse("isHorizontalHit must be false", dnaService.isMutant(dna));
	}
	
	
	@Test
	public void downRightDiagonalDoesNotFit() {
		
		String[]dna = {
							"AQQQQQ",
							"QAQAQQ",
							"QQAQAQ",
							"QQQQQA",
							"QQQQQQ",
							"QQQQQQ"
		};
		
		assertFalse("isHorizontalHit must be false", dnaService.isMutant(dna));      
		
	}
	
	
	@Test
	public void downLeftDiagonalDoesNotFit() {
		
		String[]dna = {
							"QQQQQQ",
							"QQAQQQ",
							"QAQQQA",
							"AQQQAQ",
							"QQQAQQ",
							"QQQQQQ"
		};
		
		assertFalse("isHorizontalHit must be false", dnaService.isMutant(dna));
		
	}	
	
	@Test
	public void downLeftDiagonalOverVerticallHit() {
		
		String[]dna = {
							"QAQQAQ",
							"QAQAQQ",
							"QAAQQQ",
							"QAQQQQ",
							"QQQQQQ",
							"QQQQQQ"
		};
		
		assertFalse("isHorizontalHit must be false", dnaService.isMutant(dna));
		
	}
	
	
	@Test
	public void downrRightDiagonalOverHorizontalHit() {		
		
		String[]dna = {
							"QQQQQQ",
							"QQQQQQ",
							"QAAAAQ",
							"QQQAQQ",
							"QQQQAQ",
							"QQQQQA"
		};
		
		assertFalse("isHorizontalHit must be false", dnaService.isMutant(dna));       
		
	}
	
	
	@Test
	public void horizontalOverVerticallHit() {
		
		String[]dna = {
							"QAQQQQ",
							"QAQQQQ",
							"QAQQQQ",
							"QAAAAQ",
							"QQQQQQ",
							"QQQQQQ"
		};
		
		assertFalse("isHorizontalHit must be false", dnaService.isMutant(dna));      
		
	}
		
			
	@Test
	public void oneHorizontalHit() {
		
		String[]dna = {
							"AAAAAA",
							"QQQQQQ",
							"QQQQQQ",
							"QQQQQQ",
							"QQQQQQ",
							"QQQQQQ"
		};
		
		assertFalse("isHorizontalHit must be false", dnaService.isMutant(dna));       
		
	}
	
	
	@Test
	public void oneVerticallHit() {
		
		String[]dna = {
							"QQQQQA",
							"QQQQQA",
							"QQQQQA",
							"QQQQQA",
							"QQQQQQ",
							"QQQQQQ"
		};
		
		assertFalse("isHorizontalHit must be false", dnaService.isMutant(dna));       
		
	}
	
	
	@Test
	public void oneDownRightDiagonalHit() {
		
		String[]dna = {
							"QQAQQQ",
							"QQQAQQ",
							"QQQQAQ",
							"QQQQQA",
							"QQQQQQ",
							"QQQQQQ"
		};
		
		assertFalse("isHorizontalHit must be false", dnaService.isMutant(dna));     
		
	}
	
	
	@Test
	public void oneDownLeftDiagonalHit() {
		
		String[]dna = {
							"QQQAQQ",
							"QQAQQQ",
							"QAQQQQ",
							"AQQQQQ",
							"QQQQQQ",
							"QQQQQQ"
		};
		
		assertFalse("isHorizontalHit must be false", dnaService.isMutant(dna));
		
	}
	

}
