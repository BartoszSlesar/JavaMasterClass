package interfaceChallengeSaveable.ReadWrite;

import java.util.regex.Pattern;

public class CheckExtension {
    private static final Pattern REGEX_FILE_NAME = Pattern.compile("^[a-zA-Z0-9_-]+(.txt)$");
    private static final Pattern REGEX_REMOVE_EXTENSION = Pattern.compile("[.]{1}[a-zA-Z0-9]{3,4}$");

    public static String checkExtension(String fileName) {
        if (REGEX_FILE_NAME.matcher(fileName).matches()) {
            return fileName;
        }
        fileName = removeExtensions(fileName);
        return fileName + ".txt";

    }

    private static String removeExtensions(String fileName) {
        if (!REGEX_REMOVE_EXTENSION.matcher(fileName).find()) {
            return fileName;
        } else {
            fileName = REGEX_REMOVE_EXTENSION.matcher(fileName).replaceAll("");
            return removeExtensions(fileName);
        }
    }
}
