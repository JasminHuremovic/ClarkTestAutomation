package de.clark

import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver
import org.testng.Assert.assertEquals
import org.testng.Assert.assertTrue
import org.testng.annotations.AfterTest
import org.testng.annotations.BeforeTest
import org.testng.annotations.Test
import java.util.*

/**
 * Created by Jasmin Huremovic.
 *
 * Automated web UI test to verify the entire flow of choosing and buying an insurance through clark.de website
 */
class AutomationTest {

    private var driver: WebDriver? = null
    private var clarkPage: ClarkPage? = null

    @BeforeTest
    fun createDriver() {
        System.setProperty("webdriver.chrome.driver", "src/test/kotlin/de/clark/drivers/chromedriver.exe")
        driver = ChromeDriver()
        clarkPage = ClarkPage(driver!!)
    }

    @AfterTest
    fun tearDown() {
        driver!!.quit()
    }

    /**
     * Opening the correct web page needed for this test.
     */
    @Test
    fun openClarkHomeWebPage() {
        driver!!.manage().window().maximize()
        val url = "https://staging.clark.de/de/app/offers/request"
        driver!!.get(url)

        val privathaftpflichtVersicherungsUrl = "https://staging.clark.de/de/app/questionnaire/C22lKY?source=offers%2Frequest%3Aselect-popular-category"
        driver!!.get(privathaftpflichtVersicherungsUrl)
        threadSleepShort()
    }

    /**
     * Simulating going through a flow of answering some questions
     * and navigating to a page with insurance offers.
     */
    @Test(dependsOnMethods = ["openClarkHomeWebPage"])
    fun offersFlow() {
        driver!!.findElement(clarkPage!!.firstWeiterButton).click()
        driver!!.findElement(clarkPage!!.selfInsuranceSelection).click()
        threadSleepShort()
        driver!!.findElement(clarkPage!!.publicServiceSelection).click()
        threadSleepShort()
        driver!!.findElement(clarkPage!!.damageParticipationSelection).click()
        threadSleepShort()
        driver!!.findElement(clarkPage!!.angebotAnfordernButton).click()
        threadSleepLong()
        driver!!.findElement(clarkPage!!.zumAngebotButton).click()
        threadSleepShort()
        driver!!.findElement(clarkPage!!.empfelendenAbschliesenButton).click()
        threadSleepLong()
    }

    /**
     * User is going through a registration by enteing their
     * email and password.
     */
    @Test(dependsOnMethods = ["offersFlow"])
    fun registration() {
        driver!!.findElement(clarkPage!!.registrationEmailField).sendKeys("${UUID.randomUUID()}@testuseremail.org")
        driver!!.findElement(clarkPage!!.registrationPassField).sendKeys("Testuser1")
        driver!!.findElement(clarkPage!!.jetztRegistrierenButton).click()
        threadSleepShort()
    }

    /**
     * Automated filling out of all user's personal information
     * needed for completing registration.
     */
    @Test(dependsOnMethods = ["registration"])
    fun fillingOutPersonalInformation() {
        clarkPage!!.fillOutPersonalInformationFields()
        threadSleepLong()
        driver!!.findElement(clarkPage!!.weiterButtonOnRegistrationPage).click()
        threadSleepShort()
    }

    /**
     * Automated filling out IBAN information and confirm the input.
     */
    @Test(dependsOnMethods = ["fillingOutPersonalInformation"])
    fun fillingOutBankingInformation() {
        driver!!.findElement(clarkPage!!.ibanNumberInputField).sendKeys("DE55500105174529223988")
        driver!!.findElement(clarkPage!!.scrollPageDown).sendKeys(Keys.END)
        driver!!.findElement(clarkPage!!.radioButtonOnPaymentScreen).click()
        driver!!.findElement(clarkPage!!.tarifBestellenButton).click()
        threadSleepShort()
    }

    /**
     * Finalizing order and checking if a user is navigated to the correct page
     * after completing an order.
     */
    @Test(dependsOnMethods = ["fillingOutBankingInformation"])
    fun finalizingOrder() {
        driver!!.findElement(clarkPage!!.jetztVerbindlichKaufenButton).click()
        threadSleepLong()
        assertTrue(driver!!.findElement(clarkPage!!.bestellungAbgeschlossenLabel).isDisplayed, "Order has not been completed")
        driver!!.findElement(clarkPage!!.zueruckZurUbersichtButton).click()
        threadSleepLong()
        val closePopupButton: WebElement? = driver!!.findElement(By.xpath("/html/body/div[2]/div/div/div/button"))
        if (closePopupButton!!.isDisplayed)
            closePopupButton.click()
        val finalUrl = "https://staging.clark.de/de/app/manager"
        assertEquals(finalUrl, "https://staging.clark.de/de/app/manager", "Order hasn't been completed")
    }

    /**
     * Function for 2 second thread pause.
     */
    fun threadSleepShort() {
        Thread.sleep(2000)
    }

    /**
     * Function for 4 second thread pause.
     */
    fun threadSleepLong() {
        Thread.sleep(4000)
    }
}