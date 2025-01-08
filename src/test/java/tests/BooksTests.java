package tests;

import api.BookApiSteps;
import data.TestData;
import helpers.WithLogin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.ProfilePage;
@DisplayName("Работа с книгами")
public class BooksTests extends TestBase{

    @Test
    @WithLogin
    @DisplayName("Проверка удаления книг из профиля")
    @Tag("Smoke")
    void addedDeletedItemTest() {
        BookApiSteps booksSteps = new BookApiSteps();
        ProfilePage page = new ProfilePage();
        TestData data = new TestData();

        booksSteps.deleteBookApi();
        booksSteps.addBookApi(data.isbn);
        page.openPageUI();
        page.checkUserNameUI();
        page.checkAddBookUI("Learning JavaScript Design Patterns");
        page.deleteBookUI();
        page.checkProfileIsEmptyUI();
    }
}
