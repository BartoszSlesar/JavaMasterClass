package interfaceChallengeSaveable.ReadWrite;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class SaveObjectToFile {

    private static final String RESOURCE_PATH = "resource/interfaceChallengeResource/";


    public static boolean saveToFile(List<String> values, String fileName) {
        return saveToFile(values, RESOURCE_PATH, fileName);
    }

    public static boolean saveToFile(List<String> values, String path, String fileName) {

        fileName = CheckExtension.checkExtension(fileName);
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
                fileWriter.write(index + ":" + val + "\n");
                index++;
            }
            fileWriter.close();
        } catch (IOException e) {
            return false;
        }

        return true;
    }


}
