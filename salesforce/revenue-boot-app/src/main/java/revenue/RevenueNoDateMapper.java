package revenue;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class RevenueNoDateMapper implements RowMapper<RevenueNoDate> {

	@Override
	public RevenueNoDate mapRow(ResultSet rs, int rowNum) throws SQLException {
		RevenueNoDate entry = new RevenueNoDate();
		entry.setCost(rs.getBigDecimal("cost"));
		entry.setName(rs.getString("name"));
		entry.setItem(rs.getString("item"));
		entry.setQuantity(rs.getInt("quantity"));
		return entry;
	}

}
