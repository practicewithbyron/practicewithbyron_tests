import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class LoginSteps {

    @Given("I am on the login page")
    public void iAmOnLoginPage() {
        // Code to navigate to the login page
    }

    @When("I enter valid credentials")
    public void iEnterValidCredentials() {
        // Code to enter valid credentials
    }

    @When("I click the login button")
    public void iClickLoginButton() {
        // Code to click the login button
    }

    @Then("I should be redirected to the dashboard page")
    public void iShouldBeRedirectedToDashboardPage() {
        // Code to verify redirection to the dashboard page
    }

    @Then("I should see a welcome message")
    public void iShouldSeeWelcomeMessage() {
        // Code to verify the presence of a welcome message
    }
}
