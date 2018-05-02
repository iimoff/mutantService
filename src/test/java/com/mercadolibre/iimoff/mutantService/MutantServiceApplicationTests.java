package com.mercadolibre.iimoff.mutantService;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

//@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MutantServiceApplicationTests {
	
	public static final String POST_MUTANT_URL = "/mutant";
	public static final String GET_STATS_URL = "/stats";
	
	@Autowired
    private MockMvc mockMvc;

	
    @Test
    public void getStatsOkStatus() throws Exception {
        this.mockMvc.perform(get(GET_STATS_URL)).andDo(print()).andExpect(status().isOk());
                //.andExpect(content().string(containsString("Hello World")));
    }
    
    
    public void testApplicationBuilder() throws Exception {
    	SpringApplicationBuilder application = new SpringApplicationBuilder(MutantServiceApplication.class);
    	assertNotNull(application.sources(MutantServiceApplication.class));
    }
           
    @Test
    public void postMutantMLExample() throws Exception {
    	
    	String body = "{\"dna\":["
				+ "\"ATGCGA\","
				+ "\"CAGTGC\","
				+ "\"TTATGT\","
				+ "\"AGAAGG\","
				+ "\"CCCCTA\","
				+ "\"TCACTG\""				
			+ "]}";	

    	
        this.mockMvc.perform(post(POST_MUTANT_URL)
        	.contentType(MediaType.APPLICATION_JSON).content(body))
			.andExpect(status().isOk());        
    }
    
           
    @Test
    public void postMutantVerticalBorderOkStatus() throws Exception {
    	
    	String body = "{\"dna\":["
				+ "\"AQQQQQ\","
				+ "\"AQQQQQ\","
				+ "\"AQQQQA\","
				+ "\"AQQQQA\","
				+ "\"QQQQQA\","
				+ "\"QQQQQA\""				
			+ "]}";	

    	
        this.mockMvc.perform(post(POST_MUTANT_URL)
        	.contentType(MediaType.APPLICATION_JSON).content(body))
			.andExpect(status().isOk());        
    }    
    
    
    @Test
    public void postMutantVerticalBorderFullHeightOkStatus() throws Exception {
    	
    	String body = "{\"dna\":["
				+ "\"AQQQQA\","
				+ "\"AQQQQA\","
				+ "\"AQQQQA\","
				+ "\"AQQQQA\","
				+ "\"AQQQQA\","
				+ "\"AQQQQA\""				
			+ "]}";	

    	
        this.mockMvc.perform(post(POST_MUTANT_URL)
        	.contentType(MediaType.APPLICATION_JSON).content(body))
			.andExpect(status().isOk());
        
    }
    
    
    @Test
    public void postMutantVerticalMiddleOkStatus() throws Exception {
    	
    	String body = "{\"dna\":["
				+ "\"QQQQQQ\","
				+ "\"QQAQQQ\","
				+ "\"QQAAQQ\","
				+ "\"QQAAQQ\","
				+ "\"QQAAQQ\","
				+ "\"QQQAQQ\""				
			+ "]}";	

    	
        this.mockMvc.perform(post(POST_MUTANT_URL)
        	.contentType(MediaType.APPLICATION_JSON).content(body))
			.andExpect(status().isOk());
        
    }
    
    @Test
    public void postMutantVerticalMiddleFullHeightOkStatus() throws Exception {
    	
    	String body = "{\"dna\":["
				+ "\"QQAAQQ\","
				+ "\"QQAAQQ\","
				+ "\"QQAAQQ\","
				+ "\"QQAAQQ\","
				+ "\"QQAAQQ\","
				+ "\"QQAAQQ\""				
			+ "]}";	

    	
        this.mockMvc.perform(post(POST_MUTANT_URL)
        	.contentType(MediaType.APPLICATION_JSON).content(body))
			.andExpect(status().isOk());
        
    }
    
    
    @Test
    public void postMutantHorizontalBordersOkStatus() throws Exception {
    	
    	String body = "{\"dna\":["
				+ "\"AAAAQQ\","
				+ "\"QQQQQQ\","
				+ "\"QQQQQQ\","
				+ "\"QQQQQQ\","
				+ "\"QQQQQQ\","
				+ "\"QQAAAA\""				
			+ "]}";	

    	
        this.mockMvc.perform(post(POST_MUTANT_URL)
        	.contentType(MediaType.APPLICATION_JSON).content(body))
			.andExpect(status().isOk());
        
    }
    
    @Test
    public void postMutantHorizontalMiddleOkStatus() throws Exception {
    	
    	String body = "{\"dna\":["
				+ "\"QQQQQQ\","
				+ "\"QQQQQQ\","
				+ "\"QAAAAQ\","
				+ "\"QAAAAQ\","
				+ "\"QQQQQQ\","
				+ "\"QQQQQQ\""				
			+ "]}";	

    	
        this.mockMvc.perform(post(POST_MUTANT_URL)
        	.contentType(MediaType.APPLICATION_JSON).content(body))
			.andExpect(status().isOk());
        
    }
    
    
    @Test
    public void postMutantHorizontalMiddleFullWidthOkStatus() throws Exception {
    	
    	String body = "{\"dna\":["
				+ "\"QQQQQQ\","
				+ "\"QQQQQQ\","
				+ "\"AAAAAA\","
				+ "\"AAAAAA\","
				+ "\"QQQQQQ\","
				+ "\"QQQQQQ\""				
			+ "]}";	

    	
        this.mockMvc.perform(post(POST_MUTANT_URL)
        	.contentType(MediaType.APPLICATION_JSON).content(body))
			.andExpect(status().isOk());
        
    }
    
    @Test
    public void postMutantHorizontalBordersFullWidthOkStatus() throws Exception {
    	
    	String body = "{\"dna\":["
				+ "\"AAAAAA\","
				+ "\"QQQQQQ\","
				+ "\"QQQQQQ\","
				+ "\"QQQQQQ\","
				+ "\"QQQQQQ\","
				+ "\"AAAAAA\""				
			+ "]}";	

    	
        this.mockMvc.perform(post(POST_MUTANT_URL)
        	.contentType(MediaType.APPLICATION_JSON).content(body))
			.andExpect(status().isOk());
        
    }
    
    
    
    
    @Test
	public void postMutantLeftDiagonalBordersOkStatus() throws Exception {
	
		String body = "{\"dna\":["
				+ "\"QQQAQQ\","
				+ "\"QQAQQQ\","
				+ "\"QAQQQA\","
				+ "\"AQQQAQ\","
				+ "\"QQQAQQ\","
				+ "\"QQAQQQ\""				
			+ "]}";	
	
		
	    this.mockMvc.perform(post(POST_MUTANT_URL)
	    	.contentType(MediaType.APPLICATION_JSON).content(body))
			.andExpect(status().isOk());
	    
    }
       
        
    
    @Test
	public void postMutantLeftDiagonalMiddleOkStatus() throws Exception {
	
		String body = "{\"dna\":["
				+ "\"QQQQQA\","
				+ "\"QQQQAA\","
				+ "\"QQQAAQ\","
				+ "\"QQAAQQ\","
				+ "\"QAAQQQ\","
				+ "\"AAQQQQ\""				
			+ "]}";	
	
		
	    this.mockMvc.perform(post(POST_MUTANT_URL)
	    	.contentType(MediaType.APPLICATION_JSON).content(body))
			.andExpect(status().isOk());
	    
    }
    
    
    
    @Test
	public void postMutantRightDiagonalBordersOkStatus() throws Exception {
	
		String body = "{\"dna\":["
				+ "\"AQQQQQ\","
				+ "\"QAQQQQ\","
				+ "\"AQAQQQ\","
				+ "\"QAQAQQ\","
				+ "\"QQAQQQ\","
				+ "\"QQQAQQ\""				
			+ "]}";	
	
		
	    this.mockMvc.perform(post(POST_MUTANT_URL)
	    	.contentType(MediaType.APPLICATION_JSON).content(body))
			.andExpect(status().isOk());
	    
    }

    @Test
   	public void postMutantRightDiagonalMiddleOkStatus() throws Exception {
   	
   		String body = "{\"dna\":["
   				+ "\"QQQQQQ\","
   				+ "\"QAQQQQ\","
   				+ "\"AQAQQQ\","
   				+ "\"QAQAQQ\","
   				+ "\"QQAQAQ\","
   				+ "\"QQQAQQ\""				
   			+ "]}";	
   	
   		
   	    this.mockMvc.perform(post(POST_MUTANT_URL)
   	    	.contentType(MediaType.APPLICATION_JSON).content(body))
   			.andExpect(status().isOk());
   	    
    }
    
    
    @Test
   	public void postMutantRightDiagonalFullOkStatus() throws Exception {
   	
   		String body = "{\"dna\":["
   				+ "\"AQQQQQ\","
   				+ "\"QAQQQQ\","
   				+ "\"AQAQQQ\","
   				+ "\"QAQAQQ\","
   				+ "\"QQAQAQ\","
   				+ "\"QQQAQA\""				
   			+ "]}";	
   	
   		
   	    this.mockMvc.perform(post(POST_MUTANT_URL)
   	    	.contentType(MediaType.APPLICATION_JSON).content(body))
   			.andExpect(status().isOk());
   	    
     }
    
    
    
    @Test
   	public void postMutantIsNotMuttant() throws Exception {
   	
   		String body = "{\"dna\":["
   				+ "\"ACTAQA\","
   				+ "\"TACTAA\","
   				+ "\"ATACTA\","
   				+ "\"AATCAG\","
   				+ "\"ATTGCA\","
   				+ "\"CGGGAC\""				
   			+ "]}";	   		
   		
   	    this.mockMvc.perform(post(POST_MUTANT_URL)
   	    	.contentType(MediaType.APPLICATION_JSON).content(body))
   			.andExpect(status().isForbidden());
   	    
     }
    
    
    @Test
   	public void onlyOneVericalHitIsNotMuttant() throws Exception {
   	
   		String body = "{\"dna\":["
   				+ "\"AQQQQQ\","
   				+ "\"AQQQQQ\","
   				+ "\"AQQQQQ\","
   				+ "\"AQQQQQ\","
   				+ "\"QQQQQQ\","
   				+ "\"QQQQQQ\""				
   			+ "]}";	   		
   		
   	    this.mockMvc.perform(post(POST_MUTANT_URL)
   	    	.contentType(MediaType.APPLICATION_JSON).content(body))
   			.andExpect(status().isForbidden());
   	    
     }
    
    @Test
   	public void vericalDoesNotFitIsNotMuttant() throws Exception {
   	
   		String body = "{\"dna\":["
   				+ "\"AQQQQQ\","
   				+ "\"AQQQQQ\","
   				+ "\"AQQQQQ\","
   				+ "\"QQQQQA\","
   				+ "\"QQQQQA\","
   				+ "\"QQQQQA\""				
   			+ "]}";	   		
   		
   	    this.mockMvc.perform(post(POST_MUTANT_URL)
   	    	.contentType(MediaType.APPLICATION_JSON).content(body))
   			.andExpect(status().isForbidden());
   	    
     }
    
    
    @Test
   	public void onlyOneHorizontalHitIsNotMuttant() throws Exception {
   	
   		String body = "{\"dna\":["
   				+ "\"QQAAAA\","
   				+ "\"QQQQQQ\","
   				+ "\"QQQQQQ\","
   				+ "\"QQQQQQ\","
   				+ "\"QQQQQQ\","
   				+ "\"QQQQQQ\""				
   			+ "]}";	   		
   		
   	    this.mockMvc.perform(post(POST_MUTANT_URL)
   	    	.contentType(MediaType.APPLICATION_JSON).content(body))
   			.andExpect(status().isForbidden());
   	    
     }
    
    
    @Test
   	public void horizontalDoesNotFitIsNotMuttant() throws Exception {
   	
   		String body = "{\"dna\":["
   				+ "\"QQQAAA\","
   				+ "\"QQQQQQ\","
   				+ "\"QQQQQQ\","
   				+ "\"QQQQQQ\","
   				+ "\"QQQQQQ\","
   				+ "\"AAAQQQ\""				
   			+ "]}";	   		
   		
   	    this.mockMvc.perform(post(POST_MUTANT_URL)
   	    	.contentType(MediaType.APPLICATION_JSON).content(body))
   			.andExpect(status().isForbidden());
   	    
    }
    
    @Test
   	public void onlyOneLeftDiagonalHitIsNotMuttant() throws Exception {
   	
   		String body = "{\"dna\":["
   				+ "\"QQQQQQ\","
   				+ "\"QQQQQQ\","
   				+ "\"QQQQQA\","
   				+ "\"QQQQAQ\","
   				+ "\"QQQAQQ\","
   				+ "\"QQAQQQ\""				
   			+ "]}";	   		
   		
   	    this.mockMvc.perform(post(POST_MUTANT_URL)
   	    	.contentType(MediaType.APPLICATION_JSON).content(body))
   			.andExpect(status().isForbidden());
   	    
     }
    
    
    @Test
   	public void leftDiagonalDoesNotFitIsNotMuttant() throws Exception {
   	
   		String body = "{\"dna\":["
   				+ "\"QQQAQQ\","
   				+ "\"QQAQQQ\","
   				+ "\"QAQAQQ\","
   				+ "\"QQAQQQ\","
   				+ "\"QAQQQQ\","
   				+ "\"QQQQQQ\""				
   			+ "]}";	   		
   		
   	    this.mockMvc.perform(post(POST_MUTANT_URL)
   	    	.contentType(MediaType.APPLICATION_JSON).content(body))
   			.andExpect(status().isForbidden());
   	    
     }	
    
    
    @Test
   	public void onlyOneRightDiagonalHitIsNotMuttant() throws Exception {
   	
   		String body = "{\"dna\":["
   				+ "\"QQQQQQ\","
   				+ "\"QQQQQQ\","
   				+ "\"QQAQQQ\","
   				+ "\"QQQAQQ\","
   				+ "\"QQQQAQ\","
   				+ "\"QQQQQA\""				
   			+ "]}";	   		
   		
   	    this.mockMvc.perform(post(POST_MUTANT_URL)
   	    	.contentType(MediaType.APPLICATION_JSON).content(body))
   			.andExpect(status().isForbidden());
   	    
     }
    
    
    @Test
   	public void rightDiagonalDoesNotFitIsNotMuttant() throws Exception {
   	
   		String body = "{\"dna\":["
   				+ "\"QQQQQQ\","
   				+ "\"QAQAQQ\","
   				+ "\"QQAQAQ\","
   				+ "\"QQQAQA\","
   				+ "\"QQQQQQ\","
   				+ "\"QQQQQQ\""				
   			+ "]}";	   		
   		
   	    this.mockMvc.perform(post(POST_MUTANT_URL)
   	    	.contentType(MediaType.APPLICATION_JSON).content(body))
   			.andExpect(status().isForbidden());
   	    
     }
    
    
    
    @Test
   	public void horizontalOverVerticalTopNotMuttant() throws Exception {
   	
   		String body = "{\"dna\":["
   				+ "\"AAAAQQ\","
   				+ "\"AQQQQQ\","
   				+ "\"AQQQQQ\","
   				+ "\"AQQQQQ\","
   				+ "\"QQQQQQ\","
   				+ "\"QQQQQQ\""				
   			+ "]}";	   		
   		
   	    this.mockMvc.perform(post(POST_MUTANT_URL)
   	    	.contentType(MediaType.APPLICATION_JSON).content(body))
   			.andExpect(status().isForbidden());
   	    
     }
    
    
    @Test
   	public void horizontalOverVerticalBottomNotMuttant() throws Exception {
   	
   		String body = "{\"dna\":["
   				+ "\"QQQQQQ\","
   				+ "\"QQQQQQ\","
   				+ "\"QQQQQA\","
   				+ "\"QQQQQA\","
   				+ "\"QQQQQA\","
   				+ "\"QQAAAA\""				
   			+ "]}";	   		
   		
   	    this.mockMvc.perform(post(POST_MUTANT_URL)
   	    	.contentType(MediaType.APPLICATION_JSON).content(body))
   			.andExpect(status().isForbidden());
   	    
     }
    
    @Test
   	public void horizontalOverVerticalCrossNotMuttant() throws Exception {
   	
   		String body = "{\"dna\":["
   				+ "\"QQQQQQ\","
   				+ "\"QQAQQQ\","
   				+ "\"QAAAAQ\","
   				+ "\"QQAQQQ\","
   				+ "\"QQAQQQ\","
   				+ "\"QQQQQQ\""				
   			+ "]}";	   		
   		
   	    this.mockMvc.perform(post(POST_MUTANT_URL)
   	    	.contentType(MediaType.APPLICATION_JSON).content(body))
   			.andExpect(status().isForbidden());
   	    
     }
    
    
    @Test
   	public void rightOverLeftTopDiagonalIsNotMuttant() throws Exception {
   	
   		String body = "{\"dna\":["
   				+ "\"QQAQQQ\","
   				+ "\"QQQAQQ\","
   				+ "\"QQAQAQ\","
   				+ "\"QAQQQA\","
   				+ "\"AQQQQQ\","
   				+ "\"QQQQQQ\""				
   			+ "]}";	   		
   		
   	    this.mockMvc.perform(post(POST_MUTANT_URL)
   	    	.contentType(MediaType.APPLICATION_JSON).content(body))
   			.andExpect(status().isForbidden());
   	    
     }
    
    
    @Test
   	public void rightOverLeftBottomDiagonalIsNotMuttant() throws Exception {
   	
   		String body = "{\"dna\":["
   				+ "\"QQQQQQ\","
   				+ "\"AQQQQQ\","
   				+ "\"QAQQQA\","
   				+ "\"QQAQAQ\","
   				+ "\"QQQAQQ\","
   				+ "\"QQAQQQ\""				
   			+ "]}";	   		
   		
   	    this.mockMvc.perform(post(POST_MUTANT_URL)
   	    	.contentType(MediaType.APPLICATION_JSON).content(body))
   			.andExpect(status().isForbidden());
   	    
     }
    
    
    @Test
   	public void rightOverLeftCorssDiagonalIsNotMuttant() throws Exception {
   	
   		String body = "{\"dna\":["
   				+ "\"QQQQQQ\","
   				+ "\"QAQQQQ\","
   				+ "\"QQAQAQ\","
   				+ "\"QQQAQQ\","
   				+ "\"QQAQAQ\","
   				+ "\"QAQQQQ\""				
   			+ "]}";	   		
   		
   	    this.mockMvc.perform(post(POST_MUTANT_URL)
   	    	.contentType(MediaType.APPLICATION_JSON).content(body))
   			.andExpect(status().isForbidden());
   	    
     }
  
    
    @Test
   	public void leftDiagonalCorssHorizontalIsNotMuttant() throws Exception {
   	
   		String body = "{\"dna\":["
   				+ "\"QQQAQQ\","
   				+ "\"AAAAQQ\","
   				+ "\"QAQQQQ\","
   				+ "\"AQQQQQ\","
   				+ "\"QQQQQQ\","
   				+ "\"QQQQQQ\""				
   			+ "]}";	   		
   		
   	    this.mockMvc.perform(post(POST_MUTANT_URL)
   	    	.contentType(MediaType.APPLICATION_JSON).content(body))
   			.andExpect(status().isForbidden());
   	    
     }
    
    
    @Test
   	public void rightDiagonalCorssHorizontalIsNotMuttant() throws Exception {
   	
   		String body = "{\"dna\":["
   				+ "\"QQAQQQ\","
   				+ "\"QQQAQQ\","
   				+ "\"QQQQAQ\","
   				+ "\"QQAAAA\","
   				+ "\"QQQQQQ\","
   				+ "\"QQQQQQ\""				
   			+ "]}";	   		
   		
   	    this.mockMvc.perform(post(POST_MUTANT_URL)
   	    	.contentType(MediaType.APPLICATION_JSON).content(body))
   			.andExpect(status().isForbidden());
   	    
     }

     
    @Test
   	public void leftDiagonalCorssVerticalIsNotMuttant() throws Exception {
   	
   		String body = "{\"dna\":["
   				+ "\"QQQAQQ\","
   				+ "\"QQAQQQ\","
   				+ "\"QAQQQQ\","
   				+ "\"AAQQQQ\","
   				+ "\"QAQQQQ\","
   				+ "\"QAQQQQ\""				
   			+ "]}";	   		
   		
   	    this.mockMvc.perform(post(POST_MUTANT_URL)
   	    	.contentType(MediaType.APPLICATION_JSON).content(body))
   			.andExpect(status().isForbidden());
   	    
     }
    
    
    @Test
   	public void rightDiagonalCorssVerticalIsNotMuttant() throws Exception {
   	
   		String body = "{\"dna\":["
   				+ "\"QQQQQQ\","
   				+ "\"QQQAQQ\","
   				+ "\"QQAAQQ\","
   				+ "\"QQQAQQ\","
   				+ "\"QQQAAQ\","
   				+ "\"QQQQQA\""				
   			+ "]}";	   		
   		
   	    this.mockMvc.perform(post(POST_MUTANT_URL)
   	    	.contentType(MediaType.APPLICATION_JSON).content(body))
   			.andExpect(status().isForbidden());
   	    
     }

    
    @Test
    public void postWithEmptyObject() throws Exception {
    	
    	String body = "{}";	

    	
        this.mockMvc.perform(post(POST_MUTANT_URL)
        	.contentType(MediaType.APPLICATION_JSON).content(body))
			.andExpect(status().isForbidden());        
    }
    
    @Test
    public void postNotSquareMatrix() throws Exception {
    	
    	String body = "{\"dna\":["
				+ "\"AQQQQQQQ\","
				+ "\"AQQQQQ\","
				+ "\"AQQ\","
				+ "\"AQQQ\","
				+ "\"QQQQQAAAA\","
				+ "\"QQQQQAQ\""				
			+ "]}";	

    	
        this.mockMvc.perform(post(POST_MUTANT_URL)
        	.contentType(MediaType.APPLICATION_JSON).content(body))
			.andExpect(status().isForbidden());        
    }
    
    @Test
    public void postWithEmptyDna() throws Exception {
    	
    	String body = "{\"dna\":[]}";
    	
        this.mockMvc.perform(post(POST_MUTANT_URL)
        	.contentType(MediaType.APPLICATION_JSON).content(body))
			.andExpect(status().isForbidden());        
    }    
   
    
    @Test
    public void postWithBrokenObject() throws Exception {
    	
    	String body = "{\"dna\":["
   				+ "\"QQQQQQ\","
   				+ "\"QQQAQQ\",";
    	
        this.mockMvc.perform(post(POST_MUTANT_URL)
        	.contentType(MediaType.APPLICATION_JSON).content(body))
			.andExpect(status().isBadRequest());        
    }
    
    

}
