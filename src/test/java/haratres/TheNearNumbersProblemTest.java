package haratres;

import exceptions.ValidateNearNumbersException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TheNearNumbersProblemTest {

    @Test()
    public void it_should_throw_exception_when_array_is_null() {

        // Arrange
        int[] arr = null;

        // Act
        ValidateNearNumbersException exception = assertThrows(
                ValidateNearNumbersException.class, () -> TheNearNumbersProblem.findNearNumbers(arr), ""
        );

        // Assert
        assertEquals("Arrays couldn't be null", exception.getMessage());
    }

    @Test()
    public void it_should_throw_exception_when_array_is_empty() {

        // Arrange
        int[] arr = {};

        // Act
        ValidateNearNumbersException exception = assertThrows(
                ValidateNearNumbersException.class, () -> TheNearNumbersProblem.findNearNumbers(arr), ""
        );

        // Assert
        assertEquals("The size of the array must be between 1 and 1000", exception.getMessage());
    }

    @Test()
    public void it_should_throw_exception_when_array_has_unsuitable_value() {

        // Arrange
        int[] arr = {-21000, 10, 21000};

        // Act
        ValidateNearNumbersException exception = assertThrows(
                ValidateNearNumbersException.class, () -> TheNearNumbersProblem.findNearNumbers(arr), ""
        );

        // Assert
        assertEquals("The array values must be between -20.000 and 20.000", exception.getMessage());
    }

    @Test()
    public void it_should_find_near_numbers() {

        // Arrange
        int[] arr = { 3, 1, 5, 23, 2, 4, 9, 10, 15, 31 };

        // Act
        String nearNumbers = TheNearNumbersProblem.findNearNumbers(arr);

        // Assert
        assertEquals("{1 2, 2 3, 3 4, 4 5, 9 10}", nearNumbers);
    }
}
