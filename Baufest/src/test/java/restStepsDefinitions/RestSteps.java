package restStepsDefinitions;

import org.junit.Assert;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;


import pages.PetInfo;


public class RestSteps {
	
	PetInfo petInfo = PetInfo.getInfo(); // Clase generadora de los valores a enviar
	Gson gson = new GsonBuilder().create(); //Objeto de tipo GSON para enviar como JSON
	String json;
	RequestSpecification request;
	Response response;
	int petID;
	
	
	//POST
	@Given ("^a new pet$")
	public void a_new_pet() throws Throwable {
		RestAssured.baseURI = "https://petstore.swagger.io/";
		json = gson.toJson(petInfo); //String que toma los valores convertidos de petInfo a JSON por medio del GSON 
		request = RestAssured.given();
	}
	
	@When ("^I try to add it to the server$")
	public void I_try_to_add_it_to_the_server() throws Throwable {
		request.header("Content-Type", "application/json");
		request.body(json);
		response = request.post("/v2/pet");
		
	}
	
	@Then ("^I should succesfully save it$")
	public void I_should_succesfully_save_it() throws Throwable {
		int status = response.getStatusCode();
		Assert.assertEquals(200, status);
		response
        .then()
        .assertThat()
        .body(matchesJsonSchemaInClasspath("SwaggerSchema.json")); //Valida el schema
	}

	
	//GET
	
	@Given ("^a known pet on the server$")
	public void a_known_pet_on_the_server() throws Throwable {
		
		RestAssured.baseURI = "https://petstore.swagger.io/v2/pet";
		request = RestAssured.given();
	}
	
	@When ("^I ask for an existing pet$")
	public void I_ask_for_an_existing_pet() throws Throwable {
		petID = petInfo.id;
		request.header("Content-Type", "application/json");
		response = request.get("/"+petID); //Realiza un GET del registro hecho en el POST
		
	}
	
	@Then ("^I should succesfully get it$")
	public void I_should_succesfully_get_it() throws Throwable {
		int status = response.getStatusCode();
		Assert.assertEquals(200, status);
		 response
         .then()
         .assertThat()
         .body(matchesJsonSchemaInClasspath("SwaggerSchema.json"));
	}
	
	
	// PUT
	
	@Given ("^a pet on the server$")
	public void a_pet_on_the_server() throws Throwable {
		RestAssured.baseURI = "https://petstore.swagger.io/";
		request = RestAssured.given();
		
	}
	
	@When ("^I try to edit it$")
	public void I_try_to_edit_it() throws Throwable {
		petInfo.name = "Doge"; //Modifica el valor del argumento "name" del registro hecho en el POST 
		json = gson.toJson(petInfo);
		request.header("Content-Type", "application/json");
		request.body(json);
		response = request.put("v2/pet");
		
	}
	
	@Then ("^I should succesfully modify it$")
	public void I_should_succesfully_modify_it() throws Throwable {
		int status = response.getStatusCode();
		Assert.assertEquals(200, status);
		response
        .then()
        .assertThat()
        .body(matchesJsonSchemaInClasspath("SwaggerSchema.json"));
	}
	
	
}
