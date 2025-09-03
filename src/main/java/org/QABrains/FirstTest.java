package org.QABrains;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class FirstTest {
    static Playwright playwright;
    static Browser browser;

    /**
     * low Summary:
     *
     * Playwright.create() → start engine
     *
     * playwright.chromium().launch() → open browser process
     *
     * browser.newContext() → create isolated browser profile
     *
     * context.newPage() → open a tab
     *
     * page.navigate("URL") → load a site
     *
     * Interact with page (click, type, assert, etc.)
     *
     * Close everything (page → context → browser → playwright)
     *
     * ----------------------------
     * Close one tab: page.close()
     *
     * Close all tabs in a context: context.close()
     *
     * Close all browsers & tabs: browser.close()
     *
     * Shutdown engine (final step): playwright.close()
     */

    @BeforeAll
    static void setup() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

    }

    @AfterAll
    static void tearDown() {
        browser.close();
        playwright.close();
    }

    @Test
    public void openGoogle() {
        BrowserContext context = browser.newContext(
                new Browser.NewContextOptions().setViewportSize(null)
        //new Browser.NewContextOptions().setViewportSize(1920, 1080)
        );
        Page page = context.newPage();
        page.navigate("https://www.google.com");
        page.waitForLoadState();
        page.waitForTimeout(5000);
        Assertions.assertTrue(page.title().contains("Google"));
        page.close();

    }
}
