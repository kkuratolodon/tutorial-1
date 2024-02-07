package id.ac.ui.cs.advprog.eshop.functional;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
@SpringBootTest(webEnvironment = RANDOM_PORT)
@ExtendWith(SeleniumJupiter.class)
class CreateProductFunctionalTest {

    /**
     * The port number assigned to the running application during test execution. * Set automatically during each test run by Spring Framework's test context. */
    @LocalServerPort
    private int serverPort;

    /**
     * The base URL for testing. Default to {@code http://localhost}.
     */
    @Value("${app.baseUrl:http://localhost}")
    private String testBaseUrl;

    private String baseUrl;

    @BeforeEach
    void setupTest() {
        baseUrl = String.format("%s:%d", testBaseUrl, serverPort);
    }

    @Test
    void pageTitle_isCorrect (ChromeDriver driver) throws Exception {
        // Exercise
        driver.get(baseUrl+"/product/create");
        String pageTitle = driver.getTitle();
        // Verify
        assertEquals("Create New Product", pageTitle);
    }

    @Test
    void welcomeMessage_homePage_isCorrect(ChromeDriver driver) throws Exception {
        // Exercise
        driver.get(baseUrl);
        String welcomeMessage = driver.findElement(By.tagName("h3")).getText();
        // Verify
        assertEquals("Welcome", welcomeMessage);
    }

    @Test
    void testCreateProductRedirect(ChromeDriver driver) throws Exception {
        driver.get(baseUrl+"/product/create");

        // find element for inputs and submit button
        WebElement nameInput = driver.findElement(By.id("nameInput"));
        WebElement quantityInput = driver.findElement(By.id("quantityInput"));
        WebElement submitButton = driver.findElement(By.cssSelector(".btn.btn-primary"));

        // fill the input and click the button
        nameInput.sendKeys("Test Product");
        quantityInput.sendKeys("6");
        submitButton.click();

        // check if it's redirected to /product/list
        assertEquals(baseUrl + "/product/list", driver.getCurrentUrl());
    }

    @Test
    void testCreateProduct_success(ChromeDriver driver) throws Exception {
        driver.get(baseUrl+"/product/create");

        // find element for inputs and submit button
        WebElement nameInput = driver.findElement(By.id("nameInput"));
        WebElement quantityInput = driver.findElement(By.id("quantityInput"));
        WebElement submitButton = driver.findElement(By.cssSelector(".btn.btn-primary"));

        // fill the input and click the button
        nameInput.sendKeys("Test Product");
        quantityInput.sendKeys("6");
        submitButton.click();

        // check if new product is added to the list
        String pageSource = driver.getPageSource();
        assertTrue(pageSource.contains("Test Product"));
        assertTrue(pageSource.contains("6"));
    }
}