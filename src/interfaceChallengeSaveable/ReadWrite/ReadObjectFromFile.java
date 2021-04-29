package interfaceChallengeSaveable.ReadWrite;

import interfaceChallengeSaveable.ISaveable;
import interfaceChallengeSaveable.utils.ReadWriteObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadObjectFromFile {

    private static final String RESOURCE_PATH = "resource/interfaceChallengeResource/";

    public static ISaveable readObject(ISaveable object, String fileName) {
        List<String> values = new ArrayList<String>();
        fileName = CheckExtension.checkExtension(fileName);
        String filePath = RESOURCE_PATH + fileName;
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("File do not exist");
            return null;
        }

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String[] value = scanner.nextLine().split(":");
                int index = Integer.parseInt(value[0]);
                String variable = value[1];
                values.add(index, variable);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        object.populateObject(new ReadWriteObject(values.remove(0), values));
        return object;
    }


}
