package de.clark

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

/**
 * This class is page class, which is reserved for all selectors and
 * additional function for filling out personal information, which is called
 * in the main (AutomationTest) class.
 */
class ClarkPage(val driver: WebDriver) {

    var firstWeiterButton = By.xpath("/html/body/div[3]/div/div/div/main/div[2]/button")
    val selfInsuranceSelection: By = By.xpath("/html/body/div[3]/div/div/div/main/div[3]/section/div/div/div/div/ul/li[1]")
    val publicServiceSelection: By = By.xpath("/html/body/div[3]/div/div/div/main/div[3]/section/div/div/div/div/ul/li[1]")
    val damageParticipationSelection: By = By.xpath("/html/body/div[3]/div/div/div/main/div[3]/section/div/div/div/div/ul/li[1]/h2")
    val angebotAnfordernButton: By = By.xpath("/html/body/div[3]/div/div/div/main/div[3]/div/div/button[2]")
    val zumAngebotButton: By = By.xpath("/html/body/div[3]/div/div/div/main/div[2]/div/div[1]")
    val empfelendenAbschliesenButton: By = By.id("ember57")

    val registrationEmailField: By = By.xpath("/html/body/div[3]/div/div/div/main/form/div[2]/div[1]/div/input")
    val registrationPassField: By = By.xpath("/html/body/div[3]/div/div/div/main/form/div[2]/div[2]/div/input")
    val jetztRegistrierenButton: By = By.xpath("/html/body/div[3]/div/div/div/main/form/button")

    val herrRadioButton: By = By.className("_radio-button_g3c5yd")
    val firstNameInputField: By = By.xpath("/html/body/div[3]/div/div/div/main/div[2]/div/div[1]/div[2]/form/div/div[2]/div[1]/div[1]/div/div/input")
    val lastNameInputField: By = By.xpath("/html/body/div[3]/div/div/div/main/div[2]/div/div[1]/div[2]/form/div/div[2]/div[1]/div[2]/div/div/input")
    val dateOfBirthInputField: By = By.xpath("/html/body/div[3]/div/div/div/main/div[2]/div/div[1]/div[2]/form/div/div[2]/div[1]/div[3]/div/div/input")
    val streetNameInputField: By = By.xpath("/html/body/div[3]/div/div/div/main/div[2]/div/div[1]/div[2]/form/div/div[2]/div[2]/div[1]/div[1]/div/div/input")
    val streetNumberInputField: By = By.xpath("/html/body/div[3]/div/div/div/main/div[2]/div/div[1]/div[2]/form/div/div[2]/div[2]/div[1]/div[2]/div/div/input")
    val areaCodeNumberInputField: By = By.xpath("/html/body/div[3]/div/div/div/main/div[2]/div/div[1]/div[2]/form/div/div[2]/div[2]/div[2]/div[1]/div/div/input")
    val cityNameInputField: By = By.xpath("/html/body/div[3]/div/div/div/main/div[2]/div/div[1]/div[2]/form/div/div[2]/div[2]/div[2]/div[2]/div/div/input")
    val phoneNumberInputField: By = By.xpath("/html/body/div[3]/div/div/div/main/div[2]/div/div[1]/div[2]/form/div/div[2]/div[2]/div[3]/div/div/input")
    val weiterButtonOnRegistrationPage: By = By.xpath("/html/body/div[3]/div/div/div/main/div[2]/div/div[2]/div[2]")

    val ibanNumberInputField: By = By.xpath("/html/body/div[3]/div/div/div/main/div[2]/div/section/div/ul/div/div/input")
    val scrollPageDown: By = By.cssSelector("body")
    val radioButtonOnPaymentScreen: By = By.xpath("/html/body/div[3]/div/div/div/main/div[2]/div/section/div/div[3]/li/div/label")
    val tarifBestellenButton: By = By.xpath("/html/body/div[3]/div/div/div/main/div[2]/div/div[2]/div/button[2]")

    val jetztVerbindlichKaufenButton: By = By.xpath("/html/body/div[3]/div/div/div/main/div[2]/div/div[2]/div/button[2]")
    val bestellungAbgeschlossenLabel: By = By.className("offers__confirmation__header__title")
    val zueruckZurUbersichtButton: By = By.xpath("/html/body/div[3]/div/div/div/main/div[2]/div/div/div[2]/div/button")

    fun fillOutPersonalInformationFields() {
        driver.findElement(herrRadioButton).click()
        driver.findElement(firstNameInputField).sendKeys("Test")
        driver.findElement(lastNameInputField).sendKeys("User1")
        driver.findElement(dateOfBirthInputField).sendKeys("01.01.1990")
        driver.findElement(streetNameInputField).sendKeys("Test Street")
        driver.findElement(streetNumberInputField).sendKeys("1")
        driver.findElement(areaCodeNumberInputField).sendKeys("60306")
        driver.findElement(cityNameInputField).sendKeys("Test City")
        driver.findElement(phoneNumberInputField).sendKeys("015229320777")
    }

}