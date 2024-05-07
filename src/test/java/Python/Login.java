package Python;

import Helper.PropertiesReader;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Login {
    private static final String DATABASE = "PracticeQuestionSetsTests";
    private static final String COLLECTION = "UsersTest";
    private static final Properties properties = new PropertiesReader().properties;

    @Test
    public void login() throws IOException, InterruptedException {
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("mystring", "value_of_my_string"));

        HttpPost httppost = new HttpPost("http://...");
        httppost.setEntity(new UrlEncodedFormEntity(params));

        HttpClient client = HttpClient.newHttpClient();
        HttpResponse httpResponse = client.execute(httppost);

//        String jsonBody = "{\n" +
//                "    \"email\": \"a2@a.com\",\n" +
//                "    \"password\": \"Password1234.\",\n" +
//                "}";
//
//        HttpClient client = HttpClient.newHttpClient();
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create(String.format("%s/login", properties.getProperty("PYTHON_URL"))))
//                .header("Content-Type", "application/json")
//                .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
//                .build();
//
//        // Send the request and handle the response
//        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//        assertEquals(statusCode, 200);

        assertEquals(response, "responseBody");
    }
}
