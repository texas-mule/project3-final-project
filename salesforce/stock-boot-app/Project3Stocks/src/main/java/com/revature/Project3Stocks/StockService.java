package com.revature.Project3Stocks;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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
		bullstock.setId(StockKey.from(bullstock.getOrganizationName(), bullstock.getTickerSymbol()));
		stockRepository.save(bullstock);

	}

	/**
	 * @param organization
	 * @param tickersymbol
	 * @return
	 */
	@Transactional
	public Map<String, Object> getByTickerSymbol(String organization, String tickersymbol) {
		Optional<DomainStock> ods = stockRepository.findById(StockKey.from(organization, tickersymbol));
		if (ods.isPresent()) {
			return ods.get().toMap();
		}
		return null;
	}

	/**
	 * @param organization
	 * @param tickersymbol
	 */
	@Transactional
	public void deleteStock(String organization, String tickersymbol) {
		stockRepository.deleteById(StockKey.from(organization, tickersymbol));

	}

	/**
	 * @param organization
	 * @param tickersymbol
	 * @param bullstock
	 * @return
	 */
	@Transactional
	public boolean overwriteStock(String organization, String tickersymbol, DomainStock bullstock) {
		Optional<DomainStock> ods = stockRepository.findById(StockKey.from(organization, tickersymbol));
		if (ods.isPresent()) {
			bullstock.setId(StockKey.from(bullstock.getOrganizationName(), bullstock.getTickerSymbol()));
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

	public List<Map<String, Object>> getAllStocks(String organization) {
		List<Map<String, Object>> filteredList = new LinkedList<Map<String, Object>>();
		for (DomainStock ds : this.stockRepository.findAll())
			if (ds.getOrganizationName().equals(organization))
				filteredList.add(ds.toMap());
		return filteredList;
	}
}
