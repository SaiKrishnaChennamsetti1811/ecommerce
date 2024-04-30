package DBCon;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GetAllCategories {
	public ArrayList<String> getAllCategories() {
		Dbconnect dc = new Dbconnect();
		Connection con = dc.connect();
		ArrayList<String> arrc = new ArrayList<>();
		try {
			CallableStatement cs = con.prepareCall("{call getAllCategories()}");
			ResultSet rs = cs.executeQuery();
			while (rs.next()) {
				arrc.add(rs.getInt(1) + "");
				arrc.add(rs.getString(2));
			}
			rs.close();
			cs.close();
			return arrc;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
