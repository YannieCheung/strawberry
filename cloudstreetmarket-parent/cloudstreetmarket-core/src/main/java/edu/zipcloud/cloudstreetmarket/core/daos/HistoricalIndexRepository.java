package edu.zipcloud.cloudstreetmarket.core.daos;

import java.util.Date;

import edu.zipcloud.cloudstreetmarket.core.entities.HistoricalIndex;

public interface HistoricalIndexRepository {
	/**
	 * 查看某日指标的历史记录
	 * @param code 指标代码
	 * @param of 日期
	 * @return
	 */
	Iterable<HistoricalIndex> findIntraDay(String code, Date of);
	/**
	 * 查看最近一天的指标历史记录
	 * @param code
	 * @return
	 */
	Iterable<HistoricalIndex> findLastIntraDay(String code);
	/**
	 * 查询最近一次的指标历史记录
	 * @param code
	 * @return
	 */
	HistoricalIndex findLastHistoric(String code);
}
