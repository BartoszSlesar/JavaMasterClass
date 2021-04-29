package interfaceChallengeSaveable;

import interfaceChallengeSaveable.utils.ReadWriteObject;

import java.util.ArrayList;
import java.util.List;

public class Car extends Vehicle implements ISaveable {

    private String numberOfDoors;
    private boolean hasOpenRoof;

    public Car(String name) {
        this(name, 4, false, "", false);
    }


    public Car(String name, int numberOfTires, boolean hasOpenRoof) {
        this(name, numberOfTires, false, "", hasOpenRoof);

    }

    public Car(String name, int numberOfTires, boolean electric, String color, boolean hasOpenRoof) {
        super(name, numberOfTires, electric, color);
        this.hasOpenRoof = hasOpenRoof;
    }


    public String getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(String numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public boolean isHasOpenRoof() {
        return hasOpenRoof;
    }

    public void setHasOpenRoof(boolean hasOpenRoof) {
        this.hasOpenRoof = hasOpenRoof;
    }


    @Override
    public ReadWriteObject saveData() {
        return null;
    }

    @Override
    public void populateObject(ReadWriteObject object) {

    }
}
