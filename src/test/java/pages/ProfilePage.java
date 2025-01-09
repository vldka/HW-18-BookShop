package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ProfilePage {
    private final SelenideElement emptyList = $(".rt-noData");
    private final SelenideElement userName = $("#userName-value");

    private final SelenideElement tableItem = $(".rt-tbody");
    private final SelenideElement deleteButton = $("#delete-record-undefined");
    private final SelenideElement okButton = $("#closeSmallModal-ok");

    @Step("открытие профиля")
    public ProfilePage openPageUI() {
        open("/profile");
        return this;
    }

    @Step("проверка отображения User Name в UI")
    public ProfilePage checkUserNameUI(String login) {
        userName.shouldBe(text(login));
        return this;
    }

    @Step("проверка наличия книг в UI")
    public void checkAddBookUI(String value) {

        tableItem.shouldHave(text(value));
    }

    @Step("проверка на удаление книг")
    public ProfilePage checkProfileIsEmptyUI() {
        emptyList.shouldHave(text("No rows found"));
        return this;
    }

    @Step("Удаление книги из списка")
    public ProfilePage deleteBookUI() {
        deleteButton.click();
        okButton.click();
        return this;
    }
}
