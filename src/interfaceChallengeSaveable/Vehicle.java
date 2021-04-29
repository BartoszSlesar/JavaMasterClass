package interfaceChallengeSaveable;

public class Vehicle {
    private String name;
    private int numberOfTires;
    private boolean electric;
    private String color;


    public Vehicle(String name, int numberOfTires, boolean electric, String color) {
        this.name = name;
        this.numberOfTires = numberOfTires;
        this.electric = electric;
        this.color = color;
    }

    public Vehicle() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfTires() {
        return numberOfTires;
    }

    public void setNumberOfTires(int numberOfTires) {
        this.numberOfTires = numberOfTires;
    }

    public boolean isElectric() {
        return electric;
    }

    public void setElectric(boolean electric) {
        this.electric = electric;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
