package interfaceChallengeSaveable;

import java.util.ArrayList;

public class Motorcycle extends Vehicle implements ISaveable {




    public Motorcycle(String name, int numberOfTires, boolean electric, String color) {
        super(name, numberOfTires, electric, color);
    }

    @Override
    public ArrayList<String> saveData() {
        return null;
    }

    @Override
    public void populateObject() {

    }
}
