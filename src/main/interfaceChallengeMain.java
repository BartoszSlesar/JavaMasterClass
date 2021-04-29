package main;

import interfaceChallengeSaveable.Car;
import interfaceChallengeSaveable.SaveObjectToFile;

import java.util.ArrayList;

public class interfaceChallengeMain {

    public static void main(String[] args) {

        SaveObjectToFile.saveToFile(new ArrayList<String>(),"testFileName");
    }
}
