package edu.zipcloud.cloudstreetmarket.core.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.zipcloud.cloudstreetmarket.core.entities.Market;
import edu.zipcloud.cloudstreetmarket.core.enums.MarketCode;
@Repository
public interface MarketRepository extends JpaRepository<Market, MarketCode>{
	Market findByCode(MarketCode code);
}
