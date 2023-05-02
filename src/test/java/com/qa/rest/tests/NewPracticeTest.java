package com.qa.rest.tests;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class NewPractice {

	@Test
	public void Vehicles3() {		
		
	//getreq gc = given().expect().defaultParser(Parser.JSON).when().get("https://vpic.nhtsa.dot.gov/api/vehicles/getallmanufacturers?format=json").getBody().as(getreq.class);
	Response res = given().when().get("https://vpic.nhtsa.dot.gov/api/vehicles/getallmanufacturers?format=json");
	//String respbody = res.getBody().asString();
	//JsonPath js = res.jsonPath();
	//ObjectMapper objectMapper = new ObjectMapper();
    //JsonPath jsonevaluator = res.jsonPath();
    //List<HashMap<String,String>> jsonresproot = jsonevaluator.getList("$");
    //List<Results> servresplist = new ArrayList<Results>();
	//System.out.println(gr.getResults().size());

	
	
	/*JSONParser jsonParser = new JSONParser();
	JSONObject jsonObj = (JSONObject) jsonParser.parse(respbody);
	JSONArray jsonArray = (JSONArray) jsonObj.get("Results");
	
	System.out.println(jsonArray.get(0));
	
	HashMap<String, Integer> jsonpa = new HashMap<String, Integer>();*/
	
	/*JSONObject jsonobj = new JSONObject(res);
	JSONArray jsonarr = jsonobj.getJSONArray("Results");
	JSONObject jsonobj1 = jsonarr.getJSONObject(1);
	
	JSONArray jsonarr1 = jsonobj1.getJSONArray("VehicleTypes");
	//JSONObject jsonobj2 = jsonarr1.getJSONObject(1);

	//JSONArray jsonarr2 = jsonobj2.getJSONArray("Name");

	//System.out.println(jsonobj2.getString("Name"));
	System.out.println(jsonarr1.length());

	List<String> objects = new ArrayList<String>();
	Map<String,String> hm = new HashMap<String,String>();
	
	for(int i = 0; i<jsonarr1.length();i++) {
		JSONObject jsonobj2 = jsonarr1.getJSONObject(i);
		String Name = jsonobj2.getString("Name");
		boolean IsPrimary = jsonobj2.getBoolean("IsPrimary");
		String value = String.valueOf(IsPrimary);

		objects.add(Name);
		objects.add(value);
	}
	System.out.println(objects);*/
	
	JsonPath jsonpathevaluator = res.jsonPath();
	List<object> jsonresponseRoot = jsonpathevaluator.getList("$");
	
	System.out.println(jsonresponseRoot);
	
	
	}

	
	
	
	
	
	
}
