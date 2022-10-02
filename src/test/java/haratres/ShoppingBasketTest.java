package haratres;

import exceptions.ValidateShoppingArrayException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ShoppingBasketTest {

    @Test()
    public void it_should_throw_exception_when_array_is_null() {

        // Arrange
        int[] arr = null;

        // Act
        ValidateShoppingArrayException exception = assertThrows(
                ValidateShoppingArrayException.class, () -> ShoppingBasket.applyDiscount(arr), ""
        );

        // Assert
        assertEquals("Shopping array couldn't be null", exception.getMessage());
    }

    @Test()
    public void it_should_throw_exception_when_array_is_empty() {

        // Arrange
        int[] arr = {};

        // Act
        ValidateShoppingArrayException exception = assertThrows(
                ValidateShoppingArrayException.class, () -> ShoppingBasket.applyDiscount(arr), ""
        );

        // Assert
        assertEquals("The size of the array must be between 1 and 100", exception.getMessage());
    }

    @Test()
    public void it_should_throw_exception_when_array_has_unsuitable_value() {

        // Arrange
        int[] arr = {-2100, 10, 4000};

        // Act
        ValidateShoppingArrayException exception = assertThrows(
                ValidateShoppingArrayException.class, () -> ShoppingBasket.applyDiscount(arr), ""
        );

        // Assert
        assertEquals("The array values must be between 0 and 2.000", exception.getMessage());
    }

    @Test()
    public void it_should_apply_discount() {

        // Arrange
        int[] arr = {5, 6, 4, 3, 4 };

        // Act
        String result = ShoppingBasket.applyDiscount(arr);

        // Assert
        assertEquals("Toplam tutar: 15, İndirim yapılmayan kalemler, C = {3, 4, 5}", result);
    }
}
