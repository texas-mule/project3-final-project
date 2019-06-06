package com.revature.Project3Stocks;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<DomainStock, String> {

}
//
// @Repository
// public interface ArtistRepository extends JpaRepository<Artist, Long>{
// Artist findByName(String name);
//
// @Transactional
// List<Artist> findByIdBetween(Integer min, Integer max);