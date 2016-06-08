package edu.zipcloud.cloudstreetmarket.core.daos;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.zipcloud.cloudstreetmarket.core.entities.Index;
import edu.zipcloud.cloudstreetmarket.core.entities.Market;
@Repository
public interface IndexProductRepository extends JpaRepository<Index, String>{
	
	List<Index> findByMarket(Market market);
	Page<Index> findByMarket(Market market, Pageable pageable);
	Index findByCode(String code);
}
