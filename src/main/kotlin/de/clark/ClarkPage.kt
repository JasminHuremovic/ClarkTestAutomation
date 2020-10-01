package de.clark

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

/**
 * This class is page class, which is reserved for all selectors and
 * additional function for filling out personal information, which is called
 * in the main (AutomationTest) class.
 */
class ClarkPage(val driver: WebDriver) {

    val firstWeiterButton = By.cssSelector("._continue_n83it3")
    val firstChoiceSelection = By.xpath("//*[@id=\"radioButtonsSingleSelect\"]/li[1]")
    val angebotAnfordernButton = By.cssSelector(".btn-primary")
    val zumAngebotButton = By.className("_action_yje2cq")
    val empfelendenAbschliesenButton = By.id("ember57")

    val registrationEmailField = By.xpath("//*[@id=\"ember97\"]")
    val registrationPassField = By.xpath("//*[@id=\"ember98\"]")
    val jetztRegistrierenButton = By.cssSelector("._button_dsfphm")

    val herrRadioButton = By.className("_radio-button_g3c5yd")
    val firstNameInputField = By.name("firstName")
    val lastNameInputField = By.name("lastName")
    val dateOfBirthInputField = By.name("birthdate")
    val streetNameInputField = By.name("street")
    val streetNumberInputField = By.name("houseNumber")
    val zipCodeNumberInputField = By.name("zipcode")
    val cityNameInputField = By.name("city")
    val phoneNumberInputField = By.name("phoneNumber")
    val weiterButtonOnRegistrationPage = By.cssSelector("._button_dsfphm")

    val ibanNumberInputField = By.cssSelector(".iban-offer-form__form__text")
    val scrollPageDown = By.cssSelector("body")
    val radioButtonOnPaymentScreen = By.cssSelector(".custom-checkbox__label.cucumber-accept-terms-checkbox")
    val confirmButton = By.cssSelector(".btn-primary")

    val bestellungAbgeschlossenLabel = By.className("offers__confirmation__header__title")

    fun fillOutPersonalInformationFields() {
        driver.findElement(herrRadioButton).click()
        driver.findElement(firstNameInputField).sendKeys("Test")
        driver.findElement(lastNameInputField).sendKeys("User1")
        driver.findElement(dateOfBirthInputField).sendKeys("01.01.1990")
        driver.findElement(streetNameInputField).sendKeys("Test Street")
        driver.findElement(streetNumberInputField).sendKeys("1")
        driver.findElement(zipCodeNumberInputField).sendKeys("60306")
        driver.findElement(cityNameInputField).sendKeys("Test City")
        driver.findElement(phoneNumberInputField).sendKeys("015229320777")
    }

}