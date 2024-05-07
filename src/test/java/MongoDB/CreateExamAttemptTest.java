package MongoDB;

import Helper.PropertiesReader;
import org.junit.After;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateExamAttemptTest {
    private static final String DATABASE = "PracticeQuestionSetsTests";
    private static final String COLLECTION = "UsersTest";
    private static final Properties properties = new PropertiesReader().properties;

    @After
    public void clearExamAttempt(){

    }

    @Test
    public void createExamAttempt() throws IOException, InterruptedException {
        String jsonBody = "{\n" +
                "    \"userId\": \"6524fa01cf1d3d988bd82c60\",\n" +
                "    \"exam\": \"AZ-204\",\n" +
                "    \"correctAnswers\": [\"question1\"],\n" +
                "    \"incorrectAnswers\": [\"question2\"],\n" +
                "    \"skippedQuestions\": [\"question3\"],\n" +
                "    \"timeCompleted\": 98\n" +
                "}";

        // Set up the HTTP client and request
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format("%s/api/createExamAttempt", properties.getProperty("MONGODB_URL"))))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                .build();

        // Send the request and handle the response
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Response code: " + response.statusCode());
        System.out.println("Response body: " + response.body());

        String expectedResult = "[{\"exam\":\"AZ-204\",\"correctQuestions\":[\"question1\",\"question2\"],\"incorrectQuestions\":[\"question3\"],\"skippedQuestions\":[\"question4\"]},{\"exam\":\"AZ-204\"}]";

        assertEquals(response.statusCode(), 200);
        assertEquals(expectedResult, response.body());
    }
}
