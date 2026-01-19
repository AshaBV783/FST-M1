import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class GitHubSSHTest {
    
    // Declare RequestSpecification and variables
    RequestSpecification requestSpec;
    String sshKey;
    int sshKeyId;
    
    // Replace with your actual GitHub Token
    String token = "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";

    @BeforeClass
    public void setUp() {
        // Initialize the SSH key (Public Key format)
        sshKey = "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIJCo8/PRXJpC95YVM9SHn8zceUm6jV3l9ls3GZ2QSwJg azuread\\\\ashabv@IBM-585SMM3\r\n"
        		+ "";
        
        // Build the Request Specification
        requestSpec = new RequestSpecBuilder()
            .setBaseUri("https://api.github.com")
            .addHeader("Authorization", "token " + token)
            .setContentType(ContentType.JSON)
            .build();
    }

    @Test(priority = 1)
    public void addSSHKey() {  
        // Create the request body
        Map<String, Object> body = new HashMap<>();
        body.put("title", "TestAutomationKey");
        body.put("key", sshKey);

        // POST request to add the key
        sshKeyId = given()
            .spec(requestSpec)
            .body(body)
        .when()
            .post("/user/keys")
        .then()
            .log().ifError()
            .statusCode(201)
            .body("title", equalTo("TestAutomationKey"))
            .extract()
            .path("id"); // Capture ID for future tests
            
        System.out.println("Generated Key ID: " + sshKeyId);
    }

    @Test(priority = 2, dependsOnMethods = "addSSHKey")
    public void getSSHKeys() {
        // GET request to retrieve all keys
        given()
            .spec(requestSpec)
        .when()
            .get("/user/keys")
        .then()
            .statusCode(200)
            .body("id", hasItem(sshKeyId)) // Validate created key exists in the list
            .log().body();
    }

    @Test(priority = 3, dependsOnMethods = "getSSHKeys")
    public void deleteSSHKey() {
        // DELETE request using the captured ID
        given()
            .spec(requestSpec)
            .pathParam("keyId", sshKeyId)
        .when()
            .delete("/user/keys/{keyId}")
        .then()
            .statusCode(204);
            
        System.out.println("Key " + sshKeyId + " deleted successfully.");
    }
}