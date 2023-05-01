package com.qa.rest.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.hamcrest.Matchers;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.parsing.Parser;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ResponseBodyExtractionOptions;
import io.restassured.specification.RequestSpecification;
import pojo.Results;
import pojo.getreq;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;



public class PracticeNstuff {

	
	@Test(enabled = false)
	
	public void GetCall() {
		
		//RestAssured.baseURI="https://vpic.nhtsa.dot.gov/api/vehicles";
		
				Response res  = given().get("https://ghibliapi.herokuapp.com/people");
				String responsebody = res.getBody().asString();
				//String responsestring = res.prettyPrint();
				
				//ystem.out.println(responsestring);
				
			
				
				//ResponseBody body  = given().get("https://dog.ceo/api/breeds/list/all").body();
				//String rebody = body.asString();
				

				//System.out.println(body.peek());

		//JsonPath jsonres = new JsonPath(responsestring);
			JsonPath jsonres =	res.jsonPath();
		
		/*System.out.println("size===== " + jsonres.getInt("message.size()"));

				List<String> allbulldogtypes = jsonres.getList("message.bulldog");
				System.out.println("types===== " + allbulldogtypes);

				//List<String> namesList = Arrays.asList("boston", "english", "french");
				ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList("boston", "english", "french"));

				//assertTrue(allbulldogtypes.containsAll(arrayList));
				if(allbulldogtypes.containsAll(arrayList))	{
					System.out.println("******Passed****");
				}
				else {
					System.out.println("******failedd****");

				}*/
		
				//res.then().header("Server", "cloudflare");
				/*for(String bulldog:allbulldogtypes) {
					System.out.println("all bulldoges type " + bulldog.matches(responsestring));
					
				}*/
				
				/*List<String> jsonResponseRoot = res.jsonPath().getList("name");
				
				System.out.println(jsonResponseRoot.size());
				System.out.println(jsonResponseRoot);
				
				String films = res.jsonPath().getString("films[1]");
				System.out.println("film name is------"+ films);*/
				
				/*List<Object> jsonResponseRoot = res.jsonPath().getList("Results.VehicleTypes");
				System.out.println(jsonResponseRoot.size());
				

				
				for( Object result:jsonResponseRoot) {
					System.out.println("all result type " + result);
				}*/
			
			
			List<Map<String, Object>> jsonResponseRoot = jsonres.getList("Results");

			for(Map<String, Object> result:jsonResponseRoot) {
				//System.out.println("count is--" + result.get("Name"));
			}
			JSONObject jobj = new JSONObject();
			
		JSONArray jsonarray = (JSONArray)jobj.get("Name");
		
		Iterator iterator = jsonarray.iterator();
		
			while(iterator.hasNext()) {
				System.out.println(iterator.next());
			}
		
		
				/*List<String> names = res.jsonPath().getList("Results.Country");

				System.out.println("all the names********"+names);
				
				for(String name:names) {
					System.out.println("all result type " + name);
				}*/
				
		
	}
	
	/*@Test(enabled = true)
	public void CodeTest() {
		
		int a [] = {1,5,8,9,7};
		
		int size = a.length;
		
		Arrays.sort(a);
		
		System.out.println("sorted Array::"+Arrays.toString(a));
		
		int res = a[size-1];
		
		System.out.println("2nd largest::"+res);
		
	}*/
	@Test(enabled = false)

	public void PostCall() {
	
		Response res  = given().get("https://ghibliapi.herokuapp.com/people");

	
		JsonPath js = res.jsonPath();
		
		List<String> jsonResponseRoot = res.jsonPath().getList("id");

		int i=0;
		for(String id:jsonResponseRoot) {
			//System.out.println("printing all ids"+ id);
			

			if(id.equals("e08880d0-6938-44f3-b179-81947e7873fc")) {
				System.out.println("--------successssssss----------"+i);
				
				ArrayList<String> json = new ArrayList<String>();
				json.add(js.getString("name["+i+"]"));
				json.add(js.getString("gender["+i+"]"));
				json.add(js.getString("age["+i+"]"));
				json.add(js.getString("eye_color["+i+"]"));
				json.add(js.getString("hair_color["+i+"]"));

				System.out.println(json);
				
				/*System.out.println(js.getString("name["+i+"]"));
				System.out.println(js.getString("gender["+i+"]"));
				System.out.println(js.getString("age["+i+"]"));*/


			}
			i=i+1;
		}
	}
		
		
		@Test(enabled=false)
		public void weather() {
			Response res  = given().get("https://samples.openweathermap.org/data/2.5/history/city?q=London,UK&appid=b1b15e88fa797225412429c1c50c122a1");
		
		
		JsonPath js = res.jsonPath();
		
		String city = js.getString("city_id");
		System.out.println(city);	
		
		List<Object> humidity = js.getList("list.main.humidity");

		for(Object humid : humidity) {
			System.out.println(humid);
		}
		
	}
		@Test(enabled=false)
		public void Vehicles() {
			
			Response res  = given().get("https://vpic.nhtsa.dot.gov/api/vehicles/getallmanufacturers?format=json");

			JsonPath js = res.jsonPath();
			
			List<String>result = js.getList("Results");
			
			System.out.println(result.size());

			List<Object> names = js.getList("Results.VehicleTypes.Name");
			
			for(Object name : names) {
				System.out.println(name);
					
				}
		}
		
		@Test(enabled=false)
		public void Vehicles2() throws ParseException {
			
			Response res  = given().get("https://vpic.nhtsa.dot.gov/api/vehicles/getallmanufacturers?format=json");
			
			String responsebody= res.getBody().asString();
			JsonPath js = res.jsonPath();
						
			List<String>result = js.getList("Results");
			
			System.out.println(result.size());

			List<Object> names = js.getList("Results.VehicleTypes.Name[0]");
			
			System.out.println(names.get(2));
			
				JSONParser jsonParser = new JSONParser();
				
				JSONObject jsonObj = (JSONObject) jsonParser.parse(responsebody);
								
				JSONArray jsonArray = (JSONArray) jsonObj.get("Results");
				
				JSONObject jsonObj1 = (JSONObject)jsonObj.get("Results");
								
				//System.out.println(jsonObj1.get("VehicleTypes"));
				

				//JSONObject jsonArray1 = (JSONObject) jsonObj.get("VehicleTypes");

			/*	Object tag = jsonArray.get(1);  
				System.out.println(tag);
				

		        JSONObject jo = (JSONObject) jsonObj;
		        JSONArray ja = (JSONArray) jo.get("Results");

		        System.out.println(ja);
				
				/*for (int i = 0; i < tag .length(); i++) {
				    JSONObject jsonobject = jsonarray.getJSONObject(i);
				    JSONArray temp= jsonobject .getJSONArray("TagValues"); */

			/*	for (int i = 0; i < jsonArray.size(); i++) {
	                System.out.println("The " + i + " element of the array: " + jsonArray.get(i));
	            }*/
				
				
				}
		@Test
		public void Vehicles3() {		
			
		//getreq gc = given().expect().defaultParser(Parser.JSON).when().get("https://vpic.nhtsa.dot.gov/api/vehicles/getallmanufacturers?format=json").getBody().as(getreq.class);
		String res = given().when().get("https://vpic.nhtsa.dot.gov/api/vehicles/getallmanufacturers?format=json").asString();
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
		
		JSONObject jsonobj = new JSONObject(res);
		JSONArray jsonarr = jsonobj.getJSONArray("Results");
		JSONObject jsonobj1 = jsonarr.getJSONObject(0);
		
		System.out.println(jsonobj1.getString("Mfr_Name"));
		
		
		}
		
		
		
		@Test(enabled=false)
		public void JsonObjCompare() throws JsonMappingException, JsonProcessingException {
			
			String s1 = "{\n"
					+ "    \"employee\":\n"
					+ "    {\n"
					+ "        \"id\": \"1212\",\n"
					+ "        \"fullName\": \"John Miles\",\n"
					+ "        \"age\": 34,\n"
					+ "        \"skills\": [\"Java\", \"C++\", \"Python\"]\n"
					+ "    }\n"
					+ "}";
			
			String s2 = "{\n"
					+ "    \"employee\":\n"
					+ "    {\n"
					+ "        \"id\": \"1212\",\n"
					+ "        \"age\": 34,\n"
					+ "        \"fullName\": \"John Miles\",\n"
					+ "        \"skills\": [\"Java\", \"C++\", \"Python\"] \n"
					+ "    } \n"
					+ "}";
			
			ObjectMapper mapper = new ObjectMapper();
			
			//way 1
			AssertJUnit.assertEquals(mapper.readTree(s1), mapper.readTree(s2));
			//way 2
			JsonNode jsonNode1 = mapper.readTree(s1);
			JsonNode jsonNode2 = mapper.readTree(s2);
			
			// Checking if both json objects are same
			System.out.println(jsonNode1.equals(jsonNode2));

		}
		
		
		@Test(enabled=false)
		public void jsonschemaValidator() {
		      RestAssured.baseURI = "https://samples.openweathermap.org/data/2.5/history/city?q=London,UK&appid=b1b15e88fa797225412429c1c50c122a1";

		 given().when().get()
		 .then()
		 .assertThat()
			.statusCode(200)
			.body(JsonSchemaValidator.matchesJsonSchema(new File("/Users/parthasarathiparhi/git/RestAssuredBDD/src/test/java/resources/jsonPayload.json")));

		 
		}
		BufferedReader bufferedReader;
		public static class JsonDataManager {
	
		/*public static Map<String, String> jsonParser(String key, int i) throws IOException, ParseException {
			

			JSONParser jsonParser = new JSONParser();
	        BufferedReader bufferedReader = java.nio.file.Files.newBufferedReader(Paths.get("/Users/parthasarathiparhi/git/RestAssuredBDD/src/test/java/resources/jsonPayload.json"));

			//FileReader reader = new FileReader("/Users/parthasarathiparhi/git/RestAssuredBDD/src/test/java/resources/jsonPayload.json");

			JSONObject jsonObj = (JSONObject) jsonParser.parse(bufferedReader);
			JSONArray jsonArray = (JSONArray) jsonObj.get(key);

			return (JSONObject) jsonArray.get(i);
		}*/

		}
		
		@Test(enabled=false)

		public void testMethod() throws IOException, ParseException {
			
			/*System.out.println(JsonDataManager.jsonParser("users", 0).get("emailAddress"));
			System.out.println(JsonDataManager.jsonParser("users", 1).get("emailAddress"));
			System.out.println(JsonDataManager.jsonParser("users", 2).get("emailAddress"));
			System.out.println(JsonDataManager.jsonParser("users", 3).get("emailAddress"));
			System.out.println(JsonDataManager.jsonParser("users", 4).get("emailAddress"));
			System.out.println(JsonDataManager.jsonParser("users", 5).get("emailAddress"));*/
			
			//System.out.println(JsonDataManager.jsonParser("addresses", 0).get("nickName"));
			//System.out.println(JsonDataManager.jsonParser("addresses", 1).get("nickName"));
			//System.out.println(JsonDataManager.jsonParser("addresses", 2).get("nickName"));
			

	        //System.out.println(jsonResponse.size());
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
}
