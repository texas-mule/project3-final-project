package com.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class try3Controller {

		@Autowired
		try3Service service;
		
		Try3Domain domain;
		
		@GetMapping("/SelectAll")
		public String SelectAll()
		{
			return service.SelectAll();
		}
		
		@GetMapping("/allRevenue")
		public String allRevenue()
		{
			return "hello";
		}
		
		@PostMapping("/AddRevenue/{name}/{cost}/{item}")
		public void AddRevenue(@PathVariable String name, @PathVariable float cost, @PathVariable String item)
		{
			service.AddRevenueEntry(new Try3Domain(name,item,cost,"none"));
		}
		
		@GetMapping("/revenue/{name}")
		public String getName(@PathVariable String name)
		{
			return service.SelectByName(name);
		}
		
		@GetMapping("/revenue/Abovecost/{int}")
		public String Abovecost(@PathVariable float cost)
		{
			return service.SelectAbove(cost);
		}
		
		@GetMapping("/revenue/Belowcost/{int}")
		public String BelowCost(@PathVariable float cost)
		{
			return service.SelectBelow(cost);
		}
}
