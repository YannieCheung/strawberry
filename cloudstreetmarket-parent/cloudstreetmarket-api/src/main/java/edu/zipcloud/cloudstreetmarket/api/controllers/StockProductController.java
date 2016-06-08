package edu.zipcloud.cloudstreetmarket.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mangofactory.swagger.annotations.ApiIgnore;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import edu.zipcloud.cloudstreetmarket.core.dtos.StockProductOverviewDTO;
import edu.zipcloud.cloudstreetmarket.core.entities.StockProduct;
import edu.zipcloud.cloudstreetmarket.core.services.IProudctService;
import net.kaczmarzyk.spring.data.jpa.domain.EqualEnum;
import net.kaczmarzyk.spring.data.jpa.domain.LikeIgnoreCase;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Or;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;

@Api(value = "stocks", description = "Financial stocks")
@RestController
@RequestMapping(value=ProductController.PRODUCT_PATH + "/stocks", produces = {"application/json","application/xml"})
public class StockProductController extends ProductController{
	
	@Autowired
	private IProudctService<StockProduct, StockProductOverviewDTO> productService;
	
	/**
	 * 通过名称模糊查找股票列表信息
	 * @param spec
	 * @param startWith
	 * @param contain
	 * @param pageable
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET)
	@ApiOperation(value = "Get overviews of stocks", notes = "Return a page of stock-overviews")
	public Page<StockProductOverviewDTO> SearchControls(
			@And(value={@Spec(params = "mkt", path = "market.code", spec = EqualEnum.class)},
			and={@Or({@Spec(params = "cn", path = "code", spec = LikeIgnoreCase.class),
					@Spec(params = "cn", path = "name", spec = LikeIgnoreCase.class)})}
			) @ApiIgnore Specification<StockProduct> spec,
			@ApiParam(value="Starts with filter") @RequestParam(value="sw",defaultValue="") String startWith,
			@ApiParam(value="Contains filter") @RequestParam(value="cn",defaultValue="") String contain,
			@PageableDefault(size=10,page=0,sort="{dailyLatestValue}",direction=Direction.DESC) Pageable pageable){
		return productService.getProductsOverview(startWith, null, pageable);
	}
	
	
	/**
	 * 通过股票代码查询股票信息
	 * @param stock
	 * @return
	 */
	@RequestMapping(value="/{code}", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Get one stock-overview", notes = "Return one stock-overview")
	public StockProductOverviewDTO getByCode(
			@ApiParam(value="Stock code: CCH.L") @PathVariable(value="code") StockProduct stock){
		return StockProductOverviewDTO.build(stock);
	}
}
