package org.QABrains;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.WaitForSelectorState;

public class QaBrainsBase extends PlaywrightFactory {

    /**
     * Test: Should navigate to the Google (practice.qabrains.com) home page.
     */
    public void googleNavTo() {
        page.navigate("https://practice.qabrains.com");
        page.waitForLoadState();
    }

    /**
     * Test: Should enter the provided email address into the email input field.
     *
     * @param text The email address to input.
     */
    public void enterEmailAddress(String text) {
        //        fill() → clear + type (most common)
        //         type() → type with delay (realistic typing)
        page.locator("//*[@id=\"email\"]").fill(text);
    }

    /**
     * Test: Should enter the provided password into the password input field.
     *
     * @param text The password to input.
     */
    public void enterPassword(String text) {
        page.locator("//*[@id=\"password\"]").fill(text);
    }

    /**
     * Test: Should return the current page title.
     *
     * @return The title of the current page.
     */
    public String getTitle() {
        return page.title();
    }

    /**
     * Test: Should simulate pressing the Enter key.
     */
    public void clickEnterButton() {
        page.keyboard().press("Enter");
    }

    /**
     * Test: Should click the login button on the page.
     */
    public void clickLoginButton() {
        page.locator("//*[@id=\"home-page\"]/div/div[1]/form/button").click();
    }

    public void clickLogoutButton() {
        page.locator("//*[@id=\"home-page\"]/div/div[1]/form/button").click();
    }

    /**
     * Test: Should return the successful login header title.
     *
     * @return The successful login header title.
     */
    public String getSuccessfulLoginHeader() {
        return page.locator("#success-msg > div.success-msg.border.dark\\:\\!border-gray-500.rounded-sm.px-10.py-8.text-center > h2").textContent();
    }


    /**
     * Test: Should return the successful login paragraph.
     *
     * @return The successful login paragraph.
     */
    public String getSuccessfulLoginParagraph() {
        return page.locator("//*[@id=\"success-msg\"]/div[2]/p\n").textContent();
    }

    /**
     * Test: Should return the login error message.
     *
     * @return The login error message.
     */

    public String getUnsuccessfulLoginError() {
        page.locator("//div[@id='home-page']/div/div[1]/form/div[1]/div")
                .waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
        return page.locator("//div[@id='home-page']/div/div[1]/form/div[1]/div").innerText();
    }

    public void waitForContentLoad() {
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
    }
}
