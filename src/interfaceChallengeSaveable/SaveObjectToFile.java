package interfaceChallengeSaveable;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class SaveObjectToFile {

    private static final String RESOURCE_PATH = "resource/interfaceChallengeResource/";
    private static final Pattern REGEX_FILE_NAME = Pattern.compile("^[a-zA-Z0-9_-]+(.txt)$");
    private static final Pattern REGEX_REMOVE_EXTENSION = Pattern.compile("[.]{1}[a-zA-Z0-9]{3,4}$");


    public static boolean saveToFile(List<String> values, String fileName) {
        return saveToFile(values, RESOURCE_PATH, fileName);
    }

    public static boolean saveToFile(List<String> values, String path, String fileName) {

        fileName = checkExtension(fileName);
        String fName = path + fileName;
        File file = new File(fName);
        if (file.exists()) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("File with name: " + fileName + " already exist, do you want to overwrite it ? Yes/No");
            String response = scanner.nextLine().trim();
            if (response.equalsIgnoreCase("no")) {
                return false;
            }
            scanner.close();
        }

        try {
            FileWriter fileWriter = new FileWriter(fName);
            int index = 0;
            for (String val : values) {
                fileWriter.write(index + ":" + val+"\n");
                index++;
            }
            fileWriter.close();
        } catch (IOException e) {
            return false;
        }

        return true;
    }

    private static String checkExtension(String fileName) {
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
