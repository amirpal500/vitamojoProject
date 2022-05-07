package resass;

import io.restassured.RestAssured;
import org.json.simple.JSONObject;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
public class Signup {
	
	
	private static String requestBody = "{\n" +
      " \"email\": \"eve.holt@reqres.in\",\n" +
      " \"password\": \"welcome\"}";
  @BeforeTest
  public static void setup() {
    RestAssured.baseURI = "https://reqres.in/";
  }
  @Test(priority=1)
  public void signupRequest() {
    Response response = RestAssured.given()
        .header("Content-type", "application/json")
        .and()
        .body(requestBody)
        .when()
        .post("api/register")
        .then()
        .extract().response();
    System.out.println("Signup response is "+response.asPrettyString());
    Assert.assertEquals(200, response.statusCode());
    
  }
  @Test(priority=2)
  public void loginRequest() {
	  Response response = RestAssured.given()
		        .header("Content-type", "application/json")
		        .and()
		        .body(requestBody)
		        .when()
		        .post("api/login")
		        .then()
		        .extract().response();
		    System.out.println("Login response is "+response.asPrettyString());
		    Assert.assertEquals(200, response.statusCode());
	  
  }
}


