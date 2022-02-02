package model;

public class Apartment extends Location {

    private int floorID;

    public Apartment(int id, String name, int floorID) {
        super(id, name);
        this.floorID = floorID;
    }

    public int getFloorID() {
        return this.floorID;
    }

    public void setFloorID(int floorID) {
        this.floorID = floorID;
    }

    @Override
    public String toString() {
        return "Apartment: " + super.getName() + "\nFloorID: " + this.getFloorID();
    }
}
