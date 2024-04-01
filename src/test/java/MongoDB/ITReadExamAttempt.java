package MongoDB;

import Helper.PropertiesReader;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Properties;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.URLENC;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 'Users' collection already created inside mongodb to test the 'readExamAttempt' functionality
 * - No test setup required
 */
@RunWith(JUnit4.class)
public class ITReadExamAttempt {
    private static final String DATABASE = "PracticeQuestionSetsTests";
    private static final String COLLECTION = "UsersTest";
    private static final Properties properties = new PropertiesReader().properties;

    @Test
    public void readExamAttempts() {
        // Send a POST request with form data
        Response response = given()
                .contentType(URLENC)
                .formParam("userId", "66076e48ffbb1e0c3f3152f3")
                .formParam("database", DATABASE)
                .formParam("collection", COLLECTION)
                .header("api-key", properties.getProperty("API_KEY"))
                .post(String.format("%s/api/readExamAttempts", properties.getProperty("BASE_URL")));

        // Extract the response details
        int statusCode = response.getStatusCode();
        String responseBody = response.getBody().asString();

        // Print response details
        System.out.println("Status code: " + statusCode);
        System.out.println("Response body: " + responseBody);

        String expectedResult = "[{\"exam\":\"AZ-204\",\"correctQuestions\":[\"question1\",\"question2\"],\"incorrectQuestions\":[\"question3\"],\"skippedQuestions\":[\"question4\"]},{\"exam\":\"AZ-204\"}]";

        assertEquals(statusCode, 200);
        assertEquals(expectedResult, responseBody);
    }
}
