package apiHelpersTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;


import static apiHelpers.Endpoints.BASE_URL;


public class ReqResSpecifications {

    public RequestSpecification setupRequestSpecification() {
        return RestAssured.given()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON);
    }

    public ResponseSpecification setupResponseSpecification() {
        return RestAssured.expect()
                .contentType(ContentType.JSON);
    }

}
