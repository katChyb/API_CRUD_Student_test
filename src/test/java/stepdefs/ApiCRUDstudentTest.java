package stepdefs;

import apiHelpersTest.ReqResSpecifications;
import apiHelpersTest.StudentFactory;
import apiHelpersTest.StudentResponse;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import models.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static apiHelpers.Endpoints.STUDENT_DETAILS_ENDPOINT;
import static io.restassured.RestAssured.given;

public class ApiCRUDstudentTest {

    private static final Logger log = LoggerFactory.getLogger("ApiCRUDstudentTest.class");
    private ReqResSpecifications specifications = new ReqResSpecifications();
    int id;
    StudentResponse studentResponse;


    @Given("I create new Student")
    public void i_create_new_student() {

        Student newStudent = StudentFactory.definedStudent();

       id =
             given()
                .spec(specifications.setupRequestSpecification())
                .basePath(STUDENT_DETAILS_ENDPOINT)
                .body(newStudent).
             when()
                .post().
             then()
                .spec(specifications.setupResponseSpecification())
                .statusCode(201)
                .extract()
                .path("id");

        log.info(">>>>>>>> create new student <<<<<<<<<");
    }

    @Then("new student is created successfully and exist in the system")
    public void GETnewStudentDetails() {

        studentResponse =
                given()
                        .spec(specifications.setupRequestSpecification())
                        .basePath(STUDENT_DETAILS_ENDPOINT+id).
                when()
                        .get().
                then()
                        .spec(specifications.setupResponseSpecification())
                        .statusCode(200)
                        .extract()
                        .as(StudentResponse.class);
        log.info(">>>>>>>> get information about new student <<<<<<<<<");
    }
}
