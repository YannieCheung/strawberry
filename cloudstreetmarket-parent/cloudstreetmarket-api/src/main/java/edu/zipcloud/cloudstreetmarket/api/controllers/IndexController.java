package edu.zipcloud.cloudstreetmarket.api.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mangofactory.swagger.annotations.ApiIgnore;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import edu.zipcloud.cloudstreetmarket.core.dtos.HistoProductDTO;
import edu.zipcloud.cloudstreetmarket.core.dtos.IndexOverviewDTO;
import edu.zipcloud.cloudstreetmarket.core.enums.MarketCode;
import edu.zipcloud.cloudstreetmarket.core.enums.QuotesInterval;
import edu.zipcloud.cloudstreetmarket.core.services.IMarketService;

@Api(value = "indices", description="Financial indices")
@RestController
@RequestMapping(value="/indices", produces={"application/xml","application/json"})
public class IndexController extends CloudstreetApiWCI{
	
	@Autowired
	@Qualifier(value="marketServiceImpl")
	private IMarketService marketService;
	
	@RequestMapping(method=RequestMethod.GET)
	@ApiOperation(value = "Get overviews of indices", notes = "Return a page of index-overviews")
	public Page<IndexOverviewDTO> getIndices(
		@ApiIgnore @PageableDefault(size=10,page=0,sort={"dailyLatestValue"},direction=Direction.DESC) Pageable pageable) {
		return marketService.getLastDayIndicesOverview(pageable);
	}
	
	@RequestMapping(value="/{market}",method=RequestMethod.GET)
	@ApiOperation(value = "Get overviews of indices filtered by market", notes = "Return a page of index-overviews")
	public Page<IndexOverviewDTO> getIndicesPerMarket(
			@PathVariable(value="market") MarketCode market,
			@ApiIgnore @PageableDefault(size=10,page=0,sort={"dailyLatestValue"},direction=Direction.DESC) Pageable pageable) {
		return marketService.getLastDayIndicesOverview(market, pageable);
	}
	
	@RequestMapping(value="/{market}/{index}/histo", method=RequestMethod.GET)
	@ApiOperation(value = "Get historical-data for one index", notes = "Return a set of historical-data from one index")
	public HistoProductDTO getHistoIndex(
			@ApiParam(value="Market Code: EUROPE") @PathVariable(value="market") MarketCode market,
			@ApiParam(value="Index code: ^OEX") @PathVariable(value="index") String indexCode,
			@ApiParam(value="Start date: 2014-01-01") @RequestParam(value="fd", defaultValue="") Date fromDate,
			@ApiParam(value="End date: 2020-12-12") @RequestParam(value="td", defaultValue="") Date toDate,
			@ApiParam(value="Period between snapshots") @RequestParam(value="i",defaultValue="MINUTE_30") QuotesInterval interval) {
		return marketService.getHistoIndex(indexCode, market, fromDate, toDate, interval);
	}
}
