package Controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import DBCon.GetAllCategories;

@WebServlet("/CategoriesServlet")
public class CategoriesServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) {
		GetAllCategories gpbci = new GetAllCategories();
		ArrayList<String> arrc = gpbci.getAllCategories();
		JSONObject ob = new JSONObject();
		System.out.println(arrc);
		for (int i = 0; i < arrc.size(); i += 2) {
			int j = Integer.parseInt(arrc.get(i));
			try {
				ob.put(arrc.get(i + 1), j);

			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		try {
			res.getWriter().write(ob.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
