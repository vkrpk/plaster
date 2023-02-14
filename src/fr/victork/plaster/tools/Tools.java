package victork.plaster.tools;

import org.apache.commons.lang3.StringUtils;

public interface Tools {
    default boolean checkRegexDigitsLength(String string, int length) {
        if (StringUtils.isNumeric(string) && string.length() == length){
            return true;
        }else {
            throw new IllegalArgumentException("Parameter " + string + " is invalid.");
        }
    }

    default String generateStringOfNumbers(int length){
        String AlphaNumericString = "0123456789";
        StringBuilder stringBuilder = new StringBuilder(length);
        for (int i = 0; i < length; i++){
            int index = (int)(AlphaNumericString.length() * Math.random());
            stringBuilder.append(AlphaNumericString.charAt(index));
        }
        return stringBuilder.toString();
    }
}