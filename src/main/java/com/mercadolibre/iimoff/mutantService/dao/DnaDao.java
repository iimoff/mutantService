package com.mercadolibre.iimoff.mutantService.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import com.mercadolibre.iimoff.mutantService.entity.DnaEntity;


public interface DnaDao extends MongoRepository<DnaEntity, String>, QueryByExampleExecutor<DnaEntity>  {
	
	List<DnaEntity> findDnaEntityByIsMutant(boolean isMutant);	

}
