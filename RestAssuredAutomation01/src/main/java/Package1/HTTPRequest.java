package Package1;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


import java.util.HashMap;

import org.testng.annotations.Test;

public class HTTPRequest {

	@Test
	void getUsers()
	{
		given()
		
		.when()
		 .get("https://reqres.in/api/users?page=2")
		 
		.then()
		 .statusCode(200)
		 .body("page",equalTo(2))     //equalTo() is RestAssured Assertion
		 .log().all();
	}
	
	//@Test
	void createUser()
	{
		//Using Hashmap Approach
		HashMap data = new HashMap();
		data.put("name","Dinesh");
		data.put("Job","Software Tester");
		
		 given()
		 .contentType("application/json")
		 .body(data)
		 
		.when()
		 .post("https://reqres.in/api/users")
		 //.jsonPath().getInt("id");
		 
		.then()
		 .statusCode(201)
		 .log().all();
	}
	
	/*void updateUser()
	{
		
		HashMap data = new HashMap();
		data.put("name","Dinesh Jadhav");
		data.put("Job","Tester");
		
		id=given()
		 .contentType("application/json")
		 .body(data)
		 
		.when()
		 .post("https://reqres.in/api/users/")
		 
		.then()
		 .statusCode(201)
		 .log().all();
		
	}*/

}


