package model;

import java.util.ArrayList;

import main.CentralException;

public class Central {

    private final ArrayList<Manager> managers = new ArrayList<>();
    private final ArrayList<Tenant> tenants = new ArrayList<>();
    private final ArrayList<Tower> towers = new ArrayList<>();
    private final ArrayList<Floor> floors = new ArrayList<>();
    private final ArrayList<Apartment> apartments = new ArrayList<>();
    private final ArrayList<Ticket> tickets = new ArrayList<>();
    private final ArrayList<Status> statuses = new ArrayList<>();

    // public ArrayList<Person> getPeople() {
    // return this.people;
    // }

    public ArrayList<Person> getPeople() {
        ArrayList<Person> people = new ArrayList<Person>();
        people.addAll(this.getManagers());
        people.addAll(this.getTenants());
        return people;
    }

    public void addManager(Manager manager) {
        this.managers.add(manager);
    }

    public void removeManager(Manager manager) {
        this.managers.remove(manager);
    }

    public ArrayList<Manager> getManagers() {
        return this.managers;
    }

    public void addTenant(Tenant tenant) {
        this.tenants.add(tenant);
    }

    public void removeTenant(Tenant tenant) {
        this.tenants.remove(tenant);
    }

    public ArrayList<Tenant> getTenants() {
        return this.tenants;
    }

    // public void removePerson(Person searchPerson) {
    // for (Person person : this.people) {
    // if (searchPerson == person) {
    // this.people.remove(person);
    // break;
    // }
    // }
    // }

    public Person getPersonByID(int id) {
        for (Person person : this.getPeople()) {
            if (person.getID() == id) {
                return person;
            }
        }
        return null;
    }

    public Person getPersonByName(String name) {
        for (Person person : this.getPeople()) {
            if (person.getName() == name) {
                return person;
            }
        }
        return null;
    }

    public ArrayList<Location> getLocations() {
        ArrayList<Location> locations = new ArrayList<Location>();
        locations.addAll(this.getTowers());
        locations.addAll(this.getFloors());
        locations.addAll(this.getApartments());
        return locations;
    }

    // public void addLocation(Location location) {
    // this.locations.add(location);
    // }

    public void addTower(Tower tower) {
        this.towers.add(tower);
    }

    public void addFloor(Floor floor) {
        this.floors.add(floor);
    }

    public void addApartment(Apartment apartment) {
        this.apartments.add(apartment);
    }

    // public void removeLocation(Location searchLocation) {
    // for (Location location : this.locations) {
    // if (searchLocation == location) {
    // this.locations.remove(location);
    // break;
    // }
    // }

    // }

    public void removeTower(Tower searchTower) {
        for (Tower tower : this.towers) {
            if (searchTower == tower) {
                this.towers.remove(tower);
                break;
            }
        }

    }

    public void removeFloor(Floor searchFloor) {
        for (Floor floor : this.floors) {
            if (searchFloor == floor) {
                this.floors.remove(floor);
                break;
            }
        }

    }

    public void removeApartment(Apartment searchApartment) {
        for (Apartment apartment : this.apartments) {
            if (searchApartment == apartment) {
                this.apartments.remove(apartment);
                break;
            }
        }

    }

    // public Location getLocationByID(int id) {
    // for (Location location : this.locations) {
    // if (location.getID() == id) {
    // return location;
    // }
    // }
    // return null;
    // }

    // public ArrayList<Location> getTowers() {
    // ArrayList<Location> towers = new ArrayList<Location>();
    // for (Location location : locations) {
    // if (location.getClass().getSimpleName().equals("Tower")) {
    // towers.add(location);
    // }
    // }
    // return towers;
    // }

    // public ArrayList<Location> getFloors() {
    // ArrayList<Location> towers = new ArrayList<Location>();
    // for (Location location : locations) {
    // if (location.getClass().getSimpleName().equals("Floor")) {
    // towers.add(location);
    // }
    // }
    // return towers;
    // }

    // public ArrayList<Location> getApartments() {
    // ArrayList<Location> towers = new ArrayList<Location>();
    // for (Location location : locations) {
    // if (location.getClass().getSimpleName().equals("Apartment")) {
    // towers.add(location);
    // }
    // }
    // return towers;
    // }

    public ArrayList<Tower> getTowers() {
        return this.towers;
    }

    public Tower getTowerByID(int towerID) {
        for (Tower tower : this.getTowers()) {
            if (tower.getID() == towerID) {
                return tower;
            }
        }
        return null;
    }

    public ArrayList<Floor> getFloors() {
        return this.floors;
    }

    public ArrayList<Apartment> getApartments() {
        return this.apartments;
    }

    public ArrayList<Ticket> getTickets() {
        return this.tickets;
    }

    public void addTicket(Ticket ticket) {
        this.tickets.add(ticket);
    }

    public void removeTicket(Ticket searchTicket) {
        for (Ticket ticket : this.tickets) {
            if (searchTicket == ticket) {
                this.tickets.remove(ticket);
                break;
            }
        }
    }

    public Ticket getTicketByID(int id) {
        for (Ticket ticket : this.tickets) {
            if (ticket.getID() == id) {
                return ticket;
            }
        }
        return null;
    }

    public ArrayList<Ticket> getTicketsByLocation(Location location) {
        ArrayList<Ticket> locationTickets = new ArrayList<>();
        for (Ticket ticket : this.tickets) {
            if (ticket.getLocation() == location) {
                locationTickets.add(ticket);
            }
        }
        return locationTickets;
    }

    public ArrayList<Ticket> getTicketsByPerson(Person person) {
        ArrayList<Ticket> personTickets = new ArrayList<>();
        for (Ticket ticket : this.tickets) {
            if (ticket.getPerson() == person) {
                personTickets.add(ticket);
            }
        }
        return personTickets;
    }

    public ArrayList<Status> getStatuses() {
        return this.statuses;
    }

    public void addStatus(Status status) {
        this.statuses.add(status);
    }

    public void removeStatus(Status searchStatus) {
        for (Status status : this.statuses) {
            if (searchStatus == status) {
                this.statuses.remove(status);
                break;
            }
        }
    }

    public Status getStatusByID(int id) {
        for (Status status : this.statuses) {
            if (status.getID() == id) {
                return status;
            }
        }
        return null;
    }

}
