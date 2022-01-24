package model;

public class Apartment extends Location {

    private Floor floor;

    public Apartment(int id, String name, Floor floor) {
        super(id, name);
        this.floor = floor;
    }

    public Floor getFloor() {
        return this.floor;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }

    @Override
    public String toString() {
        return "Tower: " + this.floor.getTower().getName() + "\nFloor: " + this.floor.getName() + "\nApartment: "
                + super.getName();
    }
}
