package edu.zipcloud.cloudstreetmarket.core.services;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import edu.zipcloud.cloudstreetmarket.core.dtos.HistoProductDTO;
import edu.zipcloud.cloudstreetmarket.core.dtos.IndexOverviewDTO;
import edu.zipcloud.cloudstreetmarket.core.enums.MarketCode;
import edu.zipcloud.cloudstreetmarket.core.enums.QuotesInterval;

public interface IMarketService {
	/**
	 * 按市场获取最近指标
	 * @param market
	 * @param pageable
	 * @return
	 */
	Page<IndexOverviewDTO> getLastDayIndicesOverview(MarketCode market, Pageable pageable);
	/**
	 * 获取最近指标
	 * @param pageable
	 * @return
	 */
	Page<IndexOverviewDTO> getLastDayIndicesOverview(Pageable pageable);
	/**
	 * 获取历史指标
	 * @param code
	 * @param market
	 * @param fromDate
	 * @param toDate
	 * @param interval
	 * @return
	 */
	HistoProductDTO getHistoIndex(String code, MarketCode market, Date fromDate, Date toDate, QuotesInterval interval);
}
