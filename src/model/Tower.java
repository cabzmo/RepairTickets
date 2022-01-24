package model;

public class Tower extends Location {

    public Tower(int id, String name) {
        super(id, name);
    }

    @Override
    public String toString() {
        return "Tower: " + super.getName();
    }
}
