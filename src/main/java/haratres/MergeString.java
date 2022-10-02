package haratres;

import exceptions.TextValidationException;

public class MergeString {

    public static String merge(String a, String b) {
        validateText(a);
        validateText(b);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < a.length() || i < b.length(); i++) {
            if (i < a.length())
                result.append(a.charAt(i));
            if (i < b.length())
                result.append(b.charAt(i));
        }
        return result.toString();
    }

    private static void validateText(String text) {
        if (text == null) {
            throw new TextValidationException("text cannot be null");
        }
        if (text.length() <= 1 || text.length() > 2500) {
            throw new TextValidationException("text must be between 1 and 2500");
        }
    }
}
