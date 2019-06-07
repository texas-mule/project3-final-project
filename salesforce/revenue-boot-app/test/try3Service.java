package com.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
@ImportResource({"classpath*:applicationContext.xml"})
public class try3Service {

	@Autowired
	JdbcTemplate temp;
	
	
	
	public String SelectAll()
	{
		return temp.queryForMap("select * from revenue").toString().replace("=", ":");
	}
	
	
	public void AddRevenueEntry(Try3Domain domain)
	{
		temp.execute("insert into revenue (description, funds, name, date) "+
					 "values("+ domain.getItem() + "," + domain.getCost() +", " + domain.getName() + ", NOW())");
	}
	
	
	public String SelectByName(String name)
	{
		return temp.queryForMap("select * from revenue where name = " + name).toString().replace("=", ":");
	}
	
	
	public String SelectAbove(float cost)
	{
		return temp.queryForMap("select * from revenue where funds > " + cost).toString().replace("=", ":");
	}
	
	public String SelectBelow(float cost)
	{
		return temp.queryForMap("select * from revenue where funds < " + cost).toString().replace("=", ":");
	}
	
}
