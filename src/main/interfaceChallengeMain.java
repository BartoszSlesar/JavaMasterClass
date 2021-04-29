package main;

import interfaceChallengeSaveable.ISaveable;
import interfaceChallengeSaveable.ReadWrite.ReadObjectFromFile;
import interfaceChallengeSaveable.ReadWrite.SaveObjectToFile;
import interfaceChallengeSaveable.Truck;
import interfaceChallengeSaveable.utils.ReadWriteObject;

import java.util.List;

public class interfaceChallengeMain {

    public static void main(String[] args) throws ClassNotFoundException {

//        ISaveable saveable = new Truck("Mercedes", 8, false, "Red", "Tank Truck");
//        SaveObjectToFile.saveToFile(saveable, "testFileName");
        ISaveable truck = ReadObjectFromFile.readObject(new Truck(), "testFileName");
        System.out.println(truck.toString());


    }

}
