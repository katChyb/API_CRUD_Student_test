package apiHelpersTest;

import com.github.javafaker.Faker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Locale;


public class StudentFactory {

    private static final Logger logger = LoggerFactory.getLogger("StudentFactory.class");

    static Faker usFaker = new Faker(new Locale("en-US"));

    public static StudentRequestBody createRandomStudent(){
        logger.info("<------------------ Start creating new Student Object ------------------>");
        return new StudentRequestBody(
                usFaker.name().firstName(),
                usFaker.name().name(),
                usFaker.name().lastName(),
                usFaker.date().birthday(18,65)
        );
    }

    public static void changeStudentMiddleName(StudentResponse item) {
        logger.info("<------------------ Change Middle Name in given Student Object ------------------>");
        item.getData().setMiddle_name(usFaker.name().firstName());
    }
}
