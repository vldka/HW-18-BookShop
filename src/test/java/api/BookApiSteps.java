package api;

import io.qameta.allure.Step;
import models.book.AddBookRequest;
import models.book.IsbnBook;

import java.util.List;

import static io.restassured.RestAssured.given;
import static specs.BaseSpec.*;

public class BookApiSteps {

    @Step("Добавление книги в корзину")
    public BookApiSteps addBookApi(String ibsn){
        IsbnBook isbnModel = new IsbnBook(ibsn);
        AddBookRequest request = new AddBookRequest(AuthData.getAuth().getUserId(), List.of(isbnModel));

        given(requestSpec)
                .header("Authorization", "Bearer " + AuthData.getAuth().getToken())
                .body(request)
                .when()
                .post("/BookStore/v1/Books")
                .then()
                .spec(responseSpecSuccessCreated)
                .extract().response();
        return this;
    }

    @Step("Удаление всех книг из корзины")
    public void deleteBookApi(){
        given(requestSpec)
                .header("Authorization", "Bearer " + AuthData.getAuth().getToken())
                .queryParams("UserId", AuthData.getAuth().getUserId())
                .when()
                .delete("/BookStore/v1/Books")
                .then()
                .spec(responseSpecSuccessDelete);
    }
}
