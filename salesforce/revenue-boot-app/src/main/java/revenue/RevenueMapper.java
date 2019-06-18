package revenue;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class RevenueMapper implements RowMapper<RevenueDomain> {
	public RevenueDomain mapRow(ResultSet rs, int rowNum) throws SQLException {
		RevenueDomain entry = new RevenueDomain();
		entry.setCost(rs.getBigDecimal("funds"));
		entry.setName(rs.getString("name"));
		entry.setItem(rs.getString("description"));
		entry.setDate(rs.getDate("date"));
		return entry;
	}
}