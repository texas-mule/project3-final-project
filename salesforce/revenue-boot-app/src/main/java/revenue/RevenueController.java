package revenue;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/revenue")
public class RevenueController {

	@Autowired
	RevenueService service;

	@PostMapping("/add/{name}/{cost}/{item}")
	public void addRevenue(@PathVariable("name") String name, @PathVariable("cost") float cost,
			@PathVariable("item") String item) {

		service.addRevenueEntry(new RevenueDomain(name, item, BigDecimal.valueOf(cost), null));
	}

	@GetMapping("/{organization}")
	public List<RevenueDomain> selectAll(@PathVariable("organization") String organization,
			@RequestParam("start") Optional<String> startDate, @RequestParam("end") Optional<String> endDate) {

		return service.selectAll(organization, startDate.orElse(null), endDate.orElse(null));
	}

	@GetMapping("/{organization}/summary")
	public List<RevenueNoDate> selectCollated(@PathVariable("organization") String organization,
			@RequestParam("start") Optional<String> startDate, @RequestParam("end") Optional<String> endDate) {
		return service.selectCollated(organization, startDate.orElse(null), endDate.orElse(null));
	}

	@GetMapping("/allRevenue")
	public List<RevenueDomain> allRevenue(@RequestParam("start") Optional<String> startDate,
			@RequestParam("end") Optional<String> endDate) {
		return service.selectAll(null, startDate.orElse(null), endDate.orElse(null));
	}

	@GetMapping("/name/{name}")
	public List<RevenueDomain> getName(@PathVariable String name) {
		return service.selectByName(name);
	}

	@GetMapping("/Abovecost/{cost}")
	public List<RevenueDomain> abovecost(@PathVariable("cost") float cost) {
		return service.selectAbove(cost);
	}

	@GetMapping("/Belowcost/{cost}")
	public List<RevenueDomain> belowCost(@PathVariable("cost") float cost) {
		return service.selectBelow(cost);
	}

	@GetMapping("/betweenDates/{date1}/{date2}")
	public List<RevenueDomain> betweenDates(@PathVariable String date1, @PathVariable String date2) {
		return service.selectByDate(date1, date2);
	}

	@PutMapping("/overwriteByID/{ID}/{name}/{cost}/{item}/{date}")
	public void overwriteById(@PathVariable("ID") int id, @PathVariable("name") String name,
			@PathVariable("cost") float cost, @PathVariable("item") String item, @PathVariable("date") String date) {
		service.overwriteById(id, name, cost, date, item);
	}

	@DeleteMapping("/deleteByID/{ID}")
	public void deleteById(@PathVariable("ID") int cost) {
		service.deleteByID(cost);
	}

}
