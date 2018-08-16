package com.states.rest;

import org.junit.BeforeClass;
import org.junit.Test;


import static io.restassured.RestAssured.get;
import static org.junit.Assert.*;

import java.util.List;
import java.util.HashMap;

import io.restassured.RestAssured;
import io.restassured.response.ResponseBody;


public class StateSearchServiceTest {
	
	 @BeforeClass
	    public static void init() {
	        RestAssured.baseURI = "http://localhost";
	        RestAssured.port = 8087;
	    }

	    @Test
	    public void testAlabamaSuccess() {
	       ResponseBody resp =  get("StateSearch/rest/states/get/Alabama")
	        .body();
	      List<Object> states =  (List<Object>) resp.jsonPath().getList("");
	      assertEquals(states.size(), 1);
	      assertEquals(((HashMap<String,String>)states.get(0)).get("abbr"), "AL");
	      assertEquals(((HashMap<String,String>)states.get(0)).get("name"), "Alabama");
	   }
	    
	    @Test
	    public void testMultiStateSuccess() {
	       ResponseBody resp =  get("StateSearch/rest/states/get/AL,GA,NH")
	        .body();
	      List<Object> states =  (List<Object>) resp.jsonPath().getList("");
	      assertEquals(states.size(), 3);
	      assertEquals(((HashMap<String,String>)states.get(0)).get("abbr"), "AL");
	      assertEquals(((HashMap<String,String>)states.get(1)).get("name"), "Georgia");
	      assertEquals(((HashMap<String,String>)states.get(2)).get("largest_city"), "Manchester");
	   }
	    
	    @Test
	    public void testNoStatesSuccess() {
	       ResponseBody resp =  get("StateSearch/rest/states/get/")
	        .body();
	      List<Object> states =  (List<Object>) resp.jsonPath().getList("");
	      assertEquals(states.size(), 55);
	   }

}
