package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.WebDriverProvider;
import helpers.AllureAttach;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {
    @BeforeAll
    public static void setUp() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        RestAssured.baseURI = "https://demoqa.com";
        Configuration.baseUrl = "https://demoqa.com";
        new WebDriverProvider();
    }

    @AfterEach
    void addAttachments() {
        AllureAttach.screenshotAs("Last screenshot");
        if (!Configuration.browser.equals("firefox")) {
            AllureAttach.pageSource();
            AllureAttach.browserConsoleLogs();
        }
        AllureAttach.addVideo();
        Selenide.closeWebDriver();
    }
}
