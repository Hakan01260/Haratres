package haratres;

import exceptions.TextValidationException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MergeStringTest {

    @Test()
    public void it_should_throw_exception_when_parameter_is_null() {

        // Arrange
        String a = null;
        String b = null;

        // Act
        TextValidationException exception = assertThrows(
                TextValidationException.class, () -> MergeString.merge(a, b), ""
        );

        // Assert
        assertEquals("text cannot be null", exception.getMessage());
    }

    @Test()
    public void it_should_throw_exception_when_parameter_is_empty() {

        // Arrange
        String a = "";
        String b = "";

        // Act
        TextValidationException exception = assertThrows(
                TextValidationException.class, () -> MergeString.merge(a, b), ""
        );

        // Assert
        assertEquals("text must be between 1 and 2500", exception.getMessage());
    }

    @Test()
    public void it_should_merge_string() {
        // Arrange
        String a = "hrte";
        String b = "aars";

        // Act
        String mergedString = MergeString.merge(a, b);

        // Assert
        assertEquals("haratres", mergedString);
    }
}
