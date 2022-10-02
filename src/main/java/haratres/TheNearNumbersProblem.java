package haratres;

import exceptions.ValidateNearNumbersException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class TheNearNumbersProblem {

    public static String findNearNumbers(int[] arr) {
        validateArray(arr);
        Map<Integer, ArrayList<String>> diffResultsMap = new HashMap<>();
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            int a = arr[i];
            int b = arr[i + 1];
            int diff = b - a;
            if (diff == 0 || diff > min) {
                continue;
            }
            if (diff < min) {
                min = diff;
            }
            if (!diffResultsMap.containsKey(diff)) {
                diffResultsMap.put(diff, new ArrayList<>());
            }
            diffResultsMap.get(diff).add(a + " " + b);
        }
        return diffResultsMap
                .get(min)
                .stream()
                .collect(Collectors.joining(", ",  "{", "}"));
    }

    private static void validateArray(int[] arr) {
        if (arr == null) {
            throw new ValidateNearNumbersException("Arrays couldn't be null");
        }
        if (arr.length < 1  || arr.length > 1000) {
            throw new ValidateNearNumbersException("The size of the array must be between 1 and 1000");
        }
        for (int j : arr) {
            if (j < -20000 || j > 20000 ) {
                throw new ValidateNearNumbersException("The array values must be between -20.000 and 20.000");
            }
        }
    }


}
