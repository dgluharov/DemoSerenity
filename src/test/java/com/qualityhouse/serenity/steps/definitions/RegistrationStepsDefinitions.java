package com.qualityhouse.serenity.steps.definitions;

import com.qualityhouse.serenity.entities.AddressDetails;
import com.qualityhouse.serenity.entities.User;
import com.qualityhouse.serenity.page_objects.HomePage;
import com.qualityhouse.serenity.page_objects.RegistrationPage;
import com.qualityhouse.serenity.steps.libraries.RegistrationActions;
import cucumber.api.Transpose;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.SoftAssertions;

import java.util.List;
import java.util.Map;

import static com.qualityhouse.serenity.page_objects.components.RegistrationFormComponent.REGISTRATION_ALERT;
import static com.qualityhouse.serenity.page_objects.components.RegistrationFormComponent.REGISTRATION_BUTTON;
import static com.qualityhouse.serenity.utils.Randomiser.randomizeValue;
import static com.qualityhouse.serenity.utils.TestObjectFactory.prepareTestObjectFrom;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author yakimfb
 * @since 18.03.20
 **/
public class RegistrationStepsDefinitions {
    RegistrationPage registrationPage;
    HomePage homePage;
    private User user;

    @Steps
    private RegistrationActions mitko;

    @Given("^(?:.*) has started an account registration with \"(.*)\" email$")
    public void registrationProcessIsStarted(String email) {
        mitko.startsRegistrationWithEmail(randomizeValue(email));
    }

    @When("^(?:.*) enters his personal details:$")
    public void userEntersPersonalDetailsInRegistrationForm(@Transpose Map<String, String> rawUserData) {
        this.user = prepareTestObjectFrom(User.class,
                rawUserData);
        randomizeValue(user.getEmail());
        mitko.entersHisPersonalDetails(user);
    }

    @When("^s?he enters his|her address details:$")
    public void he_enters_his_address_details(List<AddressDetails> rawAddressDetails) {
        AddressDetails addressDetails = rawAddressDetails.get(0);
        mitko.entersHisAddressDetails(addressDetails);
    }

    @And("^s?he submits his registration details$")
    public void userSubmitsHisRegistrationDetails() {
        mitko.clicksOn(REGISTRATION_BUTTON);
    }

    @Then("^the registration is successful$")
    public void theRegistrationIsSuccessful() {

        userShouldLoginSuccessfully(this.user.getFirstName());
    }

    @And("^s?he is logged in successfully$")
    public void userShouldLoginSuccessfully(String userName) {
        SoftAssertions softly = new SoftAssertions();

        softly.assertThat(mitko.readsTextFrom(homePage.userMenu))
                .as("User Menu items should contain the user name")
                .containsIgnoringCase(userName);

        softly.assertThat(mitko.canSeeElement(homePage.logOutMenu))
                .as("Logout menu should be visible, when user is logged in")
                .isTrue();

        softly.assertAll();
    }

    @Then("^error \"([^\"]*)\" message should display$")
    public void errorMessageShouldDisplay(String error_message) {
        assertThat(mitko.readsTextFrom(REGISTRATION_ALERT))
                .as("Alert-danger box contains")
                .containsIgnoringCase(error_message);
    }
}
