package edu.zipcloud.cloudstreetmarket.core.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import edu.zipcloud.cloudstreetmarket.core.dtos.ProductOverviewDTO;
import edu.zipcloud.cloudstreetmarket.core.entities.Product;

public interface IProudctService<T extends Product, U extends ProductOverviewDTO> {
	/**
	 * 按名称模糊查询产品列表
	 * @param startWith
	 * @param spec
	 * @param pageable
	 * @return
	 */
	Page<U> getProductsOverview(String startWith, Specification<T> spec, Pageable pageable);
}
