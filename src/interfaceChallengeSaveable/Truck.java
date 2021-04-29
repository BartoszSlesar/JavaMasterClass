package interfaceChallengeSaveable;

import interfaceChallengeSaveable.utils.ReadWriteObject;

import java.util.ArrayList;
import java.util.List;

public class Truck extends Vehicle implements ISaveable {

    private String truckType;

    public Truck() {
        super();

    }

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
    public ReadWriteObject saveData() {

        List<String> truck = new ArrayList<>();
        truck.add(super.getName());
        truck.add(String.valueOf(super.getNumberOfTires()));
        truck.add(String.valueOf(super.isElectric()));
        truck.add(super.getColor());
        truck.add(this.truckType);
        ReadWriteObject readWriteObject = new ReadWriteObject(Truck.class.toString(), truck);
        return readWriteObject;
    }

    @Override
    public void populateObject(ReadWriteObject object) {
        if (object == null) {
            System.out.println("Null object was passed");
        } else {
            if (object.getClassName().equals(Truck.class.toString())) {
                List<String> values = object.getValues();
                super.setName(values.get(0));
                super.setNumberOfTires(Integer.parseInt(values.get(1)));
                super.setElectric(values.get(2).equals("True"));
                super.setColor(values.get(3));
                this.truckType = values.get(4);
            }
        }
    }


    @Override
    public String toString() {
        return super.getName() + " : Truck type: " + truckType;
    }
}
