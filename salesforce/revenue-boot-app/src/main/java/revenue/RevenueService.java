package revenue;

import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
@ImportResource({ "classpath*:applicationContext.xml" })
public class RevenueService {

	@Autowired
	JdbcTemplate temp;

	RevenueMapper revenueMapper = new RevenueMapper();

	public List<RevenueDomain> SelectAll(String organization, String start, String end) {
		List<Object> args = new LinkedList<Object>();
		String sqlquery = "select * from revenue where true";
		if (organization != null) {
			sqlquery += " and name = ?";
			args.add(organization);
		}
		if (start != null) {
			try {
				Date startDate = Date.valueOf(start);
				sqlquery += " and date >= ?";
				args.add(startDate);
			} catch (IllegalArgumentException e) {
			}
		}
		if (end != null) {
			try {
				Date endDate = Date.valueOf(end);
				sqlquery += " and date <= ?";
				args.add(endDate);
			} catch (IllegalArgumentException e) {
			}
		}
		return temp.query(sqlquery, args.toArray(), revenueMapper);
	}

	public void AddRevenueEntry(RevenueDomain domain) {
		temp.update("insert into revenue (description, funds, name, date) values(?, ?, ?, NOW())", domain.getItem(),
				domain.getCost(), domain.getName());
	}

	public List<RevenueDomain> SelectByName(String name) {
		Object[] args = { name };
		return temp.query("select * from revenue where name = ?", args, revenueMapper);
	}

	public List<RevenueDomain> SelectByDate(String start, String end) {
		Object[] args = { Date.valueOf(start), Date.valueOf(end) };
		List<RevenueDomain> domain = temp.query("select * from revenue where date between ? and ?", args,
				revenueMapper);
		return domain;
	}

	public List<RevenueDomain> SelectAbove(float cost) {
		Object[] args = { cost };
		return temp.query("select * from revenue where funds > ?", args, revenueMapper);
	}

	public List<RevenueDomain> SelectBelow(float cost) {
		Object[] args = { cost };
		return temp.query("select * from revenue where funds < ?", args, revenueMapper);
	}

	public void deleteByID(int ID) {
		Object[] args = { ID };
		temp.update("delete from revenue where ID = ?", args);
	}

	public void overwriteById(int id, String name, float cost, String date, String item) {
		Object[] args = { name, cost, item, Date.valueOf(date), id };
		temp.update("update revenue set name = ?, funds = ?, description = ?, date = ? where id = ?", args);
	}

}

