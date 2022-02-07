package model;

public class Floor extends Location {

    private int towerID;

    public Floor(int id, String name, int towerID) {
        super(id, name);
        this.towerID = towerID;
    }

    public int getTowerID() {
        return this.towerID;
    }

    public void setTowerID(int towerID) {
        this.towerID = towerID;
    }

    @Override
    public String toString() {
        return "Floor: " + this.getName() + "\nID: " + this.getID() + "\nTowerID: " + this.getTowerID() + "\nTickets: "
                + super.getTickets();
    }
}
