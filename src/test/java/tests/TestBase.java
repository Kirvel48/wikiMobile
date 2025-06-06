package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import drivers.BrowserstackDriver;
import drivers.LocalDriver;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class TestBase {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = null;
        Configuration.timeout = 30000;
        Configuration.browser = BrowserstackDriver.class.getName();
        if ("browserstack".equals(System.getProperty("deviceHost")))
            Configuration.browser = BrowserstackDriver.class.getName();
        if ("emulation".equals(System.getProperty("deviceHost")))
            Configuration.browser = LocalDriver.class.getName();
    }

    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    void addAttachments() {
        String sessionId = Selenide.sessionId().toString();

        Attach.pageSource();
        if ("emulation".equals(System.getProperty("deviceHost"))) {
            Attach.screenshotAs("Скриншот");
            closeWebDriver();
        } else {
            Attach.addVideo(sessionId);
        }
        closeWebDriver();

    }
}

