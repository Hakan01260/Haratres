package haratres;

import exceptions.ValidateShoppingArrayException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ShoppingBasket {

    public static String applyDiscount(int[] arr) {
        validateArray(arr);
        List<Integer> notSuitableForDiscount = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if ((i + 1) != arr.length && arr[i] > arr[i + 1]) {
                arr[i] -= arr[i + 1];
            } else {
                notSuitableForDiscount.add(arr[i]);
            }
        }
        int result =Arrays.stream(arr).sum();
        return notSuitableForDiscount
                .stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "Toplam tutar: "+ result+", İndirim yapılmayan kalemler, C = {", "}"));
    }

    private static void validateArray(int[] arr) {
        if (arr == null) {
            throw new ValidateShoppingArrayException("Shopping array couldn't be null");
        }
        if (arr.length < 1  || arr.length > 100) {
            throw new ValidateShoppingArrayException("The size of the array must be between 1 and 100");
        }
        for (int j : arr) {
            if (j < 1 || j > 2000 ) {
                throw new ValidateShoppingArrayException("The array values must be between 0 and 2.000");
            }
        }
    }
}
