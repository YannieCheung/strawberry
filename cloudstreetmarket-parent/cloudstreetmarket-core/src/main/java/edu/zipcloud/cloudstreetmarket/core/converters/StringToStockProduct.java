package edu.zipcloud.cloudstreetmarket.core.converters;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import edu.zipcloud.cloudstreetmarket.core.daos.ProductRepository;
import edu.zipcloud.cloudstreetmarket.core.entities.StockProduct;

@Component
public class StringToStockProduct implements Converter<String, StockProduct>{

	@Autowired
	private ProductRepository<StockProduct> productRepository;
	
	@Override
	public StockProduct convert(String code) {
		StockProduct stockProduct = productRepository.findOne(code);
		if(stockProduct == null){
			throw new NoResultException("No result has been found for the value " + code + "!");
		}
		return stockProduct;
	}

}
