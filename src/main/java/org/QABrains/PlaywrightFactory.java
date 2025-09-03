package org.QABrains;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.WaitForSelectorState;

import java.util.Arrays;

public class PlaywrightFactory {
    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;

    public void start(boolean headless) {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(headless)
                        .setArgs(Arrays.asList("--start-maximized"))
        );
    }

    public void newPageMaximized() {
        context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
        page = context.newPage();
    }

    public void closeContext() {
        if (context != null) context.close();
    }

    public void stop() {
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
    }

    public void waitForElementVisible(String selector) {
        page.locator(selector).waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
    }

}
