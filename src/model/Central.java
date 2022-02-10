package model;

import java.util.ArrayList;

public class Central {

    private final ArrayList<Manager> managers = new ArrayList<>();
    private final ArrayList<Tenant> tenants = new ArrayList<>();
    private final ArrayList<Tower> towers = new ArrayList<>();
    private final ArrayList<Floor> floors = new ArrayList<>();
    private final ArrayList<Apartment> apartments = new ArrayList<>();
    private final ArrayList<Ticket> tickets = new ArrayList<>();
    private final ArrayList<OpenStatus> openStatuses = new ArrayList<>();
    private final ArrayList<InProgressStatus> inProgressStatuses = new ArrayList<>();
    private final ArrayList<ClosedStatus> closedStatuses = new ArrayList<>();

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

    public Manager getManagerByID(int id) {
        for (Manager manager : this.managers) {
            if (manager.getID() == id) {
                return manager;
            }
        }
        return null;
    }

    public Person getTenantByID(int id) {
        for (Tenant tenant : this.tenants) {
            if (tenant.getID() == id) {
                return tenant;
            }
        }
        return null;
    }

    public Person getPersonByID(int personID) {
        for (Person person : this.getPeople()) {
            if (person.getID() == personID) {
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

    public void addTower(Tower tower) {
        this.towers.add(tower);
    }

    public void addFloor(Floor floor) {
        this.floors.add(floor);
    }

    public void addApartment(Apartment apartment) {
        this.apartments.add(apartment);
    }

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

    public Floor getFloorByID(int floorID) {
        for (Floor floor : this.getFloors()) {
            if (floor.getID() == floorID) {
                return floor;
            }
        }
        return null;
    }

    public ArrayList<Apartment> getApartments() {
        return this.apartments;
    }

    public Apartment getApartmentByID(int apartmentID) {
        for (Apartment apartment : this.getApartments()) {
            if (apartment.getID() == apartmentID) {
                return apartment;
            }
        }
        return null;
    }

    public Location getLocationByID(int locationID) {
        for (Location location : this.getLocations()) {
            if (location.getID() == locationID) {
                return location;
            }
        }
        return null;
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
            if (ticket.getStatus().getPerson() == person) {
                personTickets.add(ticket);
            }
        }
        return personTickets;
    }

    public ArrayList<Status> getStatuses() {
        ArrayList<Status> statuses = new ArrayList<Status>();
        statuses.addAll(this.getOpenStatuses());
        statuses.addAll(this.getInProgressStatuses());
        statuses.addAll(this.getClosedStatuses());
        return statuses;
    }

    public ArrayList<OpenStatus> getOpenStatuses() {
        return this.openStatuses;
    }

    public ArrayList<InProgressStatus> getInProgressStatuses() {
        return this.inProgressStatuses;
    }

    public ArrayList<ClosedStatus> getClosedStatuses() {
        return this.closedStatuses;
    }

    public void addOpenStatus(OpenStatus openStatus) {
        this.openStatuses.add(openStatus);
    }

    public void addInProgressStatus(InProgressStatus inProgressStatus) {
        this.inProgressStatuses.add(inProgressStatus);
    }

    public void addClosedStatus(ClosedStatus closedStatus) {
        this.closedStatuses.add(closedStatus);
    }

    public void removeOpenStatus(OpenStatus searchOpenStatus) {
        for (OpenStatus openStatus : this.openStatuses) {
            if (searchOpenStatus == openStatus) {
                this.openStatuses.remove(openStatus);
                break;
            }
        }
    }

    public void removeInProgressStatus(InProgressStatus searchInProgressStatus) {
        for (InProgressStatus inProgressStatus : this.inProgressStatuses) {
            if (searchInProgressStatus == inProgressStatus) {
                this.inProgressStatuses.remove(inProgressStatus);
                break;
            }
        }
    }

    public void removeClosedStatus(ClosedStatus searchClosedStatus) {
        for (ClosedStatus closedStatus : this.closedStatuses) {
            if (searchClosedStatus == closedStatus) {
                this.closedStatuses.remove(closedStatus);
                break;
            }
        }
    }

    public Status getStatusByID(int id) {
        for (Status status : this.getStatuses()) {
            if (status.getID() == id) {
                return status;
            }
        }
        return null;
    }

    public void addOpenStatusToTicket(Ticket ticket, OpenStatus status) {
        this.openStatuses.add(status);
        ticket.getLocation().addTicket(ticket);
        status.getPerson().addTicket(ticket);
        ticket.setStatus(status);
    }

    public void addInProgressStatusToTicket(Ticket ticket, InProgressStatus status) {
        this.inProgressStatuses.add(status);
        ticket.setStatus(status);
    }

    public void addClosedStatusToTicket(Ticket ticket, ClosedStatus status) {
        this.closedStatuses.add(status);
        ticket.setStatus(status);
    }

    public boolean canCleanTower(Tower tower) {
        for (Floor floor : this.floors) {
            if (floor.getTowerID() == tower.getID()) {
                return false;
            }
        }
        return true;
    }

    public boolean canCleanFloor(Floor floor) {
        for (Apartment apartment : this.apartments) {
            if (apartment.getFloorID() == floor.getID()) {
                return false;
            }
        }
        return true;
    }

    public boolean canCleanPerson(Person person) {
        if (person.getTickets().size() > 0) {
            return false;
        }
        return true;
    }

}
