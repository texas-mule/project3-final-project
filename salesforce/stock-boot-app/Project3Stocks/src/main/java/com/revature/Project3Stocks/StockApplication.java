package com.revature.Project3Stocks;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Associate
 *
 */
//@EnableDiscoveryClient
@SpringBootApplication
@RestController
@RequestMapping("/stock")

public class StockApplication extends SpringBootServletInitializer {

	@Autowired
	StockService stockService;

	/**
	 * @param bullstock
	 */
	@PostMapping
	public void create(@RequestBody DomainStock bullstock) {
		stockService.create(bullstock);
	}

	/**
	 * @return
	 */
	@GetMapping("/{organization}")
	public List<Map<String,Object>> getAll(@PathVariable("organization") String organization) {
		return stockService.getAllStocks(organization);
	}

	/**
	 * @param organization
	 * @param tickersymbol
	 * @return
	 */
	@GetMapping("/{organization}/{tickersymbol}")
	public Map<String,Object> getByTickerSymbol(@PathVariable("organization") String organization,
			@PathVariable("tickersymbol") String tickersymbol) {
		return stockService.getByTickerSymbol(organization, tickersymbol);
	}

	/**
	 * @param organization
	 * @param tickersymbol
	 */
	@DeleteMapping("/{organization}/{tickersymbol}")
	public void delete(@PathVariable("organization") String organization, @PathVariable("tickersymbol") String tickersymbol) {
		stockService.deleteStock(organization, tickersymbol);
	}

	/**
	 * @param organization
	 * @param tickersymbol
	 * @param bullstock
	 * @param response
	 */
	@PutMapping("/{organization}/{tickersymbol}")
	public void overwrite(@PathVariable("organization") String organization,
			@PathVariable("tickersymbol") String tickersymbol, @RequestBody DomainStock bullstock,
			HttpServletResponse response) {
		if (!stockService.overwriteStock(organization, tickersymbol, bullstock))
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
	}

	/*
	 * @PostMapping("/signin") public String login()
	 */
	/* (non-Javadoc)
	 * @see org.springframework.boot.web.servlet.support.SpringBootServletInitializer#configure(org.springframework.boot.builder.SpringApplicationBuilder)
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder stockapp) {
		return stockapp.sources(StockApplication.class).properties("spring.config.name: application.stock)");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.setProperty("spring.config.name", "application.stock");
		SpringApplication.run(StockApplication.class, args);
	}

}
