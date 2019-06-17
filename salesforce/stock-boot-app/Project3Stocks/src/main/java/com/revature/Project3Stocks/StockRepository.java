package com.revature.Project3Stocks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Associate
 *
 */
@Repository
public interface StockRepository extends JpaRepository<DomainStock, String> {}
