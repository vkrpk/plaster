package victork.plaster;

import org.apache.commons.lang3.StringUtils;

public interface Tools {
    default boolean checkRegexDigitsLength(String string, int length) {
        if (StringUtils.isNumeric(string) && string.length() == length){
            return true;
        }else {
            throw new IllegalArgumentException("Parameter is invalid.");
        }
    }
}
