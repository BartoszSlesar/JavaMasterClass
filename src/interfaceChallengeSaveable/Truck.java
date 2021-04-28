package interfaceChallengeSaveable;

import java.util.ArrayList;

public class Truck extends Vehicle implements ISaveable {

    private String truckType;

    public Truck(String name, int numberOfTires, boolean electric, String color, String truckType) {
        super(name, numberOfTires, electric, color);
        this.truckType = truckType;
    }

    public String getTruckType() {
        return truckType;
    }

    public void setTruckType(String truckType) {
        this.truckType = truckType;
    }

    @Override
    public ArrayList<String> saveData() {
        return null;
    }

    @Override
    public void populateObject() {

    }
}
