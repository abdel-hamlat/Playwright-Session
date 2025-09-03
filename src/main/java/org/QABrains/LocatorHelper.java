package org.QABrains;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LocatorHelper {
    public final Page page;

    public LocatorHelper(Page page) {
        this.page = page;
    }

    // ✅ Click by ID
    public void clickById(String id) {
        page.click("#" + id);
    }

    // ✅ Click by XPath
    public void clickByXpath(String xpath) {
        page.click("xpath=" + xpath);
    }

    // ✅ Click by visible text
    public void clickByText(String text) {
        page.click("text=" + text);
    }

    // ✅ Fill input by name attribute
    public void fillByName(String name, String value) {
        page.fill("input[name='" + name + "']", value);
    }

    // ✅ Get page title
    public String getTitle() {
        return page.title();
    }

    // ✅ Get element text by CSS selector
    public String getText(String selector) {
        return page.textContent(selector);
    }

    // ✅ Generic: return a Locator (flexible for chaining)
    public Locator getByCss(String selector) {
        return page.locator(selector);
    }
}
