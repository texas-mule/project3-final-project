package com.revature.Project3Stocks;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Associate
 *
 */
@Service
public class StockService {

	@Autowired
	StockRepository stockRepository;

	/**
	 * @param stockRepository
	 */
	public void setStockRepository(StockRepository stockRepository) {
		this.stockRepository = stockRepository;
	}

	/**
	 * @param bullstock
	 */
	@Transactional
	public void create(DomainStock bullstock) {
		bullstock.setId(bullstock.getOrganizationName() + bullstock.getTickerSymbol());
		stockRepository.save(bullstock);

	}

	/**
	 * @param organization
	 * @param tickersymbol
	 * @return
	 */
	@Transactional
	public Optional<DomainStock> getByTickerSymbol(String organization, String tickersymbol) {
		return stockRepository.findById(organization + tickersymbol);
	}

	/**
	 * @param organization
	 * @param tickersymbol
	 */
	@Transactional
	public void deleteStock(String organization, String tickersymbol) {
		stockRepository.deleteById(organization + tickersymbol);

	}

	/**
	 * @param organization
	 * @param tickersymbol
	 * @param bullstock
	 * @return
	 */
	@Transactional
	public boolean overwriteStock(String organization, String tickersymbol, DomainStock bullstock) {
		Optional<DomainStock> ods = stockRepository.findById(organization + tickersymbol);
		if (ods.isPresent()) {
			bullstock.setId(bullstock.getOrganizationName() + bullstock.getTickerSymbol());
			stockRepository.save(bullstock);
			return true;
		}
		return false;
	}

	/**
	 * @return
	 */
	@Transactional
	public List<DomainStock> getAllStocks() {
		return this.stockRepository.findAll();

	}

}
