package interfaceChallengeSaveable;

import java.util.ArrayList;
import java.util.List;

public class Motorcycle extends Vehicle implements ISaveable {




    public Motorcycle(String name, int numberOfTires, boolean electric, String color) {
        super(name, numberOfTires, electric, color);
    }

    @Override
    public List<String> saveData() {
        return null;
    }

    @Override
    public void populateObject() {

    }
}
