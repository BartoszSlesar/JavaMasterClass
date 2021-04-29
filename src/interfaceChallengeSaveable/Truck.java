package interfaceChallengeSaveable;

import java.util.ArrayList;
import java.util.List;

public class Truck extends Vehicle implements ISaveable {

    private String truckType;

    public Truck(String name, int numberOfTires, String truckType) {
        this(name, numberOfTires, false, "", truckType);
    }

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
    public List<String> saveData() {
        List<String> truck = new ArrayList<>();
        truck.add(super.getName());
        truck.add(String.valueOf(super.getNumberOfTires()));
        truck.add(String.valueOf(super.isElectric()));
        truck.add(super.getColor());
        truck.add(this.truckType);
        return truck;
    }

    @Override
    public void populateObject() {

    }
}
