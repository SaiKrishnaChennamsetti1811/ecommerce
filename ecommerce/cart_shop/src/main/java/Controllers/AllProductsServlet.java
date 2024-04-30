package Controllers;

import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import DBCon.GetAllProducts;
import Model.Products;

@WebServlet("/AllProductsServlet")
public class AllProductsServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) {
		GetAllProducts gap = new GetAllProducts();
		ArrayList<Products> products = null;
		ArrayList<ArrayList<String>> ars = new ArrayList<>();
		JSONObject ob = new JSONObject();
		products = gap.getAllProducts();
		for (Products it : products) {
			ArrayList<String> temp = new ArrayList<String>();
			temp.add(it.getProduct_id() + "");
			temp.add(it.getProduct_name());
			temp.add(it.getProduct_price() + "");
			temp.add(it.getProduct_image());
			temp.add(it.getProduct_catid() + "");
			ars.add(temp);
		}
		try {
			ob.put("AllProducts", ars);
			res.getWriter().write(ob.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
