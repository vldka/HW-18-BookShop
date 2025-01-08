package helpers;

import api.AuthData;
import io.qameta.allure.Step;
import models.auth.AuthResponseBody;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class LoginExtension implements BeforeEachCallback {

    public static AuthResponseBody loginModel;
    @Step("Авторизация пользователя")
    @Override
    public void beforeEach (ExtensionContext context){
        loginModel = AuthData.getAuth();
        open("/favicon.ico");
        getWebDriver().manage().addCookie(new Cookie("userID", loginModel.getUserId()));
        getWebDriver().manage().addCookie(new Cookie("token", loginModel.getToken()));
        getWebDriver().manage().addCookie(new Cookie("expires", loginModel.getExpires()));
    }
}
