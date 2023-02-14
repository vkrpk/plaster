package victork.plaster;

import org.apache.commons.lang3.StringUtils;

public interface Tools {
    default boolean checkRegexDigitsLength(String string, int length) {
        return StringUtils.isNumeric(string) && string.length() == length;
    }
}
