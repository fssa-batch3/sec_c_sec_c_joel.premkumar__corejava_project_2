package com.fssa.stockmangementapp.validator;
import com.fssa.stockmanagementapp.exception.ValidatorException;
import com.fssa.stockmanagementapp.model.User;
import com.fssa.stockmanagementapp.validator.UserValidator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserValidatorTest {

    @Test
    public void testValidUser() {
        User validUser = new User("Joel AP", "joel.ap@example.com", 9080096570L, "Joel@2002%ap$");

        assertDoesNotThrow(() -> UserValidator.validate(validUser));
    }

    @Test
    public void testNullUser() {
        assertThrows(ValidatorException.class, () -> UserValidator.validate(null));
    }

    @Test
    public void testInvalidFullName() {
        String invalidFullName = "J1"; // Less than 3 characters

        assertThrows(ValidatorException.class, () -> UserValidator.validateFullName(invalidFullName));
    }

    @Test
    public void testValidFullName() {
        String validFullName = "Joel AP";

        assertDoesNotThrow(() -> UserValidator.validateFullName(validFullName));
    }

    @Test
    public void testInvalidEmailId() {
        String invalidEmail = "joel.com"; // Invalid email format

        assertThrows(ValidatorException.class, () -> UserValidator.validateEmailId(invalidEmail));
    }

    @Test
    public void testValidEmailId() {
        String validEmail = "joel.ap@example.com";

        assertDoesNotThrow(() -> UserValidator.validateEmailId(validEmail));
    }

    @Test
    public void testInvalidPhoneNumber() {
        long invalidPhoneNumber = 12345; // Less than 10 digits

        assertThrows(ValidatorException.class, () -> UserValidator.validatePhoneNumber(invalidPhoneNumber));
    }

    @Test
    public void testValidPhoneNumber() {
        long validPhoneNumber = 9080096570L;

        assertDoesNotThrow(() -> UserValidator.validatePhoneNumber(validPhoneNumber));
    }

    @Test
    public void testInvalidPassword() {
        String invalidPassword = "pass"; // Invalid password format

        assertThrows(ValidatorException.class, () -> UserValidator.validatePassword(invalidPassword));
    }

    @Test
    public void testValidPassword() {
        String validPassword = "Joel@2002"; // At least 6 characters, one uppercase, one lowercase, one digit

        assertDoesNotThrow(() -> UserValidator.validatePassword(validPassword));
    }
}
