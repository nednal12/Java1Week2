package com.bmarohnic.JSONData;

import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

import com.bmarohnic.constants.Deals;

public class JSON {


	public static JSONObject buildJSON() {

		// create Deals JSON Object
		JSONObject dealsObject = new JSONObject();

		try {

			// create query JSON Object
			JSONObject queryObject = new JSONObject();

			// create Deal object in query
			for (Deals deal : Deals.values()) {

				// create DealDetails Object
				JSONObject detailsObject = new JSONObject();

				// add Deals to Object
				detailsObject.put("dealLocation", deal.setDealLocation());
				detailsObject.put("dealDescription",deal.setDealDescription());
				detailsObject.put("dealAddress", deal.setDealAddress());
				detailsObject.put("dealDate", deal.setDealDate());

				queryObject.put(deal.name().toString(), detailsObject);

			}
			// add query to deals
			dealsObject.put("query", queryObject);

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dealsObject;

	}

	public static String readJSON(String selected) {
		
		String result, location, description, address, date;
		
		JSONObject object = buildJSON();
		
		try {
			location = object.getJSONObject("query").getJSONObject(selected).getString("dealLocation");
			description = object.getJSONObject("query").getJSONObject(selected).getString("dealDescription");
			address = object.getJSONObject("query").getJSONObject(selected).getString("dealAddress");
			date = object.getJSONObject("query").getJSONObject(selected).getString("dealDate");
			
			result = "Location: " + location + "\r\n"
					+"Description: " + description + "\r\n"
					+"Address: " + address + "\r\n"
					+"Date: " + date;
			
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = e.toString();
		}
		
		
		
		return result;

	}
}
