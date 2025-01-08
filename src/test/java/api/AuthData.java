package api;

import data.TestData;
import io.qameta.allure.Step;
import models.auth.AuthRequestBody;
import models.auth.AuthResponseBody;

import static io.restassured.RestAssured.given;
import static specs.BaseSpec.requestSpec;
import static specs.BaseSpec.responseSpecSuccess;

public class AuthData extends TestData {
    @Step("Получаем данные авторизации")
    public static AuthResponseBody getAuth() {
        AuthRequestBody authData = new AuthRequestBody();
        authData.setUserName(login);
        authData.setPassword(password);

        return given(requestSpec)
                .body(authData)
                .when()
                .post("/Account/v1/Login")
                .then()
                .spec(responseSpecSuccess)
                .extract().as(AuthResponseBody.class);
    }
}
