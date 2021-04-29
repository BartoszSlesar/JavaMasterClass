package main;

import interfaceChallengeSaveable.Car;
import interfaceChallengeSaveable.ISaveable;
import interfaceChallengeSaveable.SaveObjectToFile;
import interfaceChallengeSaveable.Truck;

import java.util.ArrayList;
import java.util.List;

public class interfaceChallengeMain {

    public static void main(String[] args) {

        ISaveable saveable = new Truck("Mercedes", 8, false, "Red", "Tank Truck");
        List<String> list = saveable.saveData();
        System.out.println(list.size());
        SaveObjectToFile.saveToFile(list, "testFileName");
    }
}
