package model;

public class Floor extends Location {

    private Tower tower;

    public Floor(int id, String name, Tower tower) {
        super(id, name);
        this.tower = tower;
    }

    public Tower getTower() {
        return this.tower;
    }

    public void setTower(Tower tower) {
        this.tower = tower;
    }

    @Override
    public String toString() {
        return "Tower: " + this.tower.getName() + "\nFloor: " + this.getName();
    }
}
