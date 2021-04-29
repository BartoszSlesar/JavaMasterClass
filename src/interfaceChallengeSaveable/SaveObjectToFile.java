package interfaceChallengeSaveable;

import java.io.File;
import java.util.List;
import java.util.regex.Pattern;

public class SaveObjectToFile {

    private static final String RESOURCE_PATH = "resource/interfaceChallengeResource";
    private static final Pattern REGEX_FILE_NAME = Pattern.compile("^[a-zA-Z0-9_-]+(.txt)$");
    private static final Pattern REGEX_REMOVE_EXTENSION = Pattern.compile("[.]{1}[a-zA-Z0-9]{3,4}$");


    public static boolean saveToFile(List<String> values, String fileName) {
        return saveToFile(values, RESOURCE_PATH, fileName);
    }

    public static boolean saveToFile(List<String> values, String path, String fileName) {
        fileName = checkExtension(fileName);
        System.out.println(fileName);
        String fName = path + "/" + fileName;
        File file = new File(fName);
        if (file.exists()) {
            System.out.println("Fuck");
        }
        return false;
    }

    private static String checkExtension(String fileName) {
        if (REGEX_FILE_NAME.matcher(fileName).matches()) {
            return fileName;
        }
        fileName = removeExtensions(fileName);
        System.out.println(fileName);
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
