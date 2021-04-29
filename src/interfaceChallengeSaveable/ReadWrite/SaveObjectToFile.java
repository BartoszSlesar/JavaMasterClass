package interfaceChallengeSaveable.ReadWrite;

import interfaceChallengeSaveable.utils.ReadWriteObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class SaveObjectToFile {

    private static final String RESOURCE_PATH = "resource/interfaceChallengeResource/";


    public static boolean saveToFile(ReadWriteObject readWriteObject, String fileName) {
        return saveToFile(readWriteObject, RESOURCE_PATH, fileName);
    }

    public static boolean saveToFile(ReadWriteObject readWriteObject, String path, String fileName) {

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
            fileWriter.write(0 + ":" + readWriteObject.getClassName() + "\n");
            int index = 1;
            for (String val : readWriteObject.getValues()) {
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
