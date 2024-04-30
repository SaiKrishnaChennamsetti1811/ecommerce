package DBCon;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Products;

public class GetAllProducts {
	public ArrayList<Products> getAllProducts() {
		ArrayList<Products> al = new ArrayList<Products>();
		Dbconnect dc = new Dbconnect();
		Connection con = dc.connect();
		CallableStatement cs;
		try {
			cs = con.prepareCall("{call getAllProd}");
			ResultSet rs = cs.executeQuery();
			while (rs.next()) {
				Products p = new Products();
				p.setProduct_id(rs.getInt("proid"));
				p.setProduct_name(rs.getString("name"));
				p.setProduct_price(rs.getInt("price"));
				p.setProduct_image(rs.getString("imgpath"));
				p.setProduct_catid(rs.getInt("catid"));

				al.add(p);

			}
			rs.close();
			cs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return al;
	}

	public ArrayList<Products> getAllProductsId(String id) {
		ArrayList<Products> al = new ArrayList<Products>();
		Dbconnect dc = new Dbconnect();
		Connection con = dc.connect();
		CallableStatement cs;
		try {
			cs = con.prepareCall("{call getProdByCat(?)}");
			cs.setInt(1, Integer.parseInt(id));
			ResultSet rs = cs.executeQuery();
			while (rs.next()) {
				Products p = new Products();
				p.setProduct_id(rs.getInt("proid"));
				p.setProduct_name(rs.getString("name"));
				p.setProduct_price(rs.getInt("price"));
				p.setProduct_image(rs.getString("imgpath"));
				p.setProduct_catid(rs.getInt("catid"));

				al.add(p);

			}
			rs.close();
			cs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return al;
	}
}
