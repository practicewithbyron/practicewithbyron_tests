package MongoDB;

import Helper.PropertiesReader;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.Properties;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.URLENC;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReadUserTest {
    private static final String DATABASE = "PracticeQuestionSetsTests";
    private static final String COLLECTION = "UsersTest";
    private static final Properties properties = new PropertiesReader().properties;

    @Test
    public void readUser() {
        // Send a POST request with form data
        Response response = given()
                .contentType(URLENC)
                .formParam("email", "a2@a.com")
                .formParam("database", DATABASE)
                .formParam("collection", COLLECTION)
                .header("api-key", properties.getProperty("API_KEY"))
                .post(String.format("%s/api/readUser", properties.getProperty("MONGODB_URL")));

        // Extract the response details
        int statusCode = response.getStatusCode();
        String responseBody = response.getBody().asString();

        // Print response details
        System.out.println("Status code: " + statusCode);
        System.out.println("Response body: " + responseBody);

        String expectedResult = "{\"_id\":\"66076e48ffbb1e0c3f3152f3\",\"email\":\"a2@a.com\",\"password\":\"$2b$12$mCbAq1xSc21dn8o2Rj5KouTo8qwMfBApxf6a9CuVV1WpNhvIl6Se6\",\"catalog\":[\"CPA-21-02\",\"CPE-20-01\",\"JSE-40-01\",\"AZ-204\"],\"admin\":\"False\",\"examAttempts\":[{\"exam\":\"AZ-204\",\"correctQuestions\":[\"question1\",\"question2\"],\"incorrectQuestions\":[\"question3\"],\"skippedQuestions\":[\"question4\"]},{\"exam\":\"AZ-204\"}]}";

        assertEquals(statusCode, 200);
        assertEquals(expectedResult, responseBody);
    }
}
