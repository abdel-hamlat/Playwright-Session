package googleDommain.smokeTestUI;

import org.QABrains.QABrainUser;
import org.QABrains.QaBrainsBase;
import org.junit.jupiter.api.*;

/**
 * Test Suite: User Login Tests
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserLoginTest {

    private final QaBrainsBase qBBase = new QaBrainsBase();
    QABrainUser user = new QABrainUser();
    String inValidEmail = "Invalid@gmail.com";
    String inValidPassword = "QA1234567";

    @BeforeAll
    void suiteSetup() {
        qBBase.start(false);
        qBBase.newPageMaximized(); // headless=false, maximized=true
        qBBase.googleNavTo();

    }


    @Test
    @Order(1)
    void TestLoginValidCredentials() {
        // Test with valid email and valid password
        qBBase.enterEmailAddress(user.getEmail());
        qBBase.enterPassword(user.getPassword());
        qBBase.clickLoginButton();
        Assertions.assertTrue(qBBase.getTitle().contains("QA Practice"));
        Assertions.assertEquals("Login Successful", qBBase.getSuccessfulLoginHeader());
        Assertions.assertEquals("Congratulations. You have successfully logged in. When you are done click logout below.", qBBase.getSuccessfulLoginParagraph());
    }

    @Test
    @Order(2)
    void TestLoginInvalidCredentials() throws InterruptedException {
        // Test with invalid email and invalid password
        qBBase.clickLogoutButton();
        qBBase.waitForContentLoad();
        qBBase.enterEmailAddress(inValidEmail);
        qBBase.enterPassword("Invalid Password");
        qBBase.clickLoginButton();
        Thread.sleep(5000);
        Assertions.assertEquals("Your email and password both are invalid!", qBBase.getUnsuccessfulLoginError());
    }

    @Test
    @Order(3)
    void TestLoginInvalidEmail() throws InterruptedException {
        // Test with invalid email and valid password
        qBBase.enterEmailAddress(inValidEmail);
        qBBase.enterPassword(user.getPassword());
        qBBase.clickLoginButton();
        Thread.sleep(5000);
        Assertions.assertEquals("Your email is invalid!", qBBase.getUnsuccessfulLoginError());
    }

    @Test
    @Order(4)
    void TestLoginInvalidPassword() throws InterruptedException {
        // Test with valid email and invalid password
        qBBase.enterEmailAddress(user.getEmail());
        qBBase.enterPassword(inValidPassword);
        qBBase.clickLoginButton();
        Thread.sleep(5000);
        Assertions.assertEquals("Your password is invalid!", qBBase.getUnsuccessfulLoginError());
    }

    @AfterAll
    void suiteTearDown() {
        qBBase.closeContext();
    }
}
