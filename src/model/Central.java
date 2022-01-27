package model;

import java.util.ArrayList;
import java.util.Map;

public class Central {

    private final ArrayList<Person> people = new ArrayList<>();
    private final ArrayList<Location> locations = new ArrayList<>();
    private final ArrayList<Ticket> tickets = new ArrayList<>();

    public ArrayList<Person> getPeople() {
        return this.people;
    }

    public void addPerson(Person person) {
        this.people.add(person);
    }

    public void removePerson(Person searchPerson) {
        for (Person person : this.people) {
            if (searchPerson == person) {
                this.people.remove(person);
                break;
            }
        }
    }

    public Person getPersonByID(int id) {
        for (Person person : this.people) {
            if (person.getID() == id) {
                return person;
            }
        }
        return null;
    }

    public Person getPersonByName(String name) {
        for (Person person : this.people) {
            if (person.getName() == name) {
                return person;
            }
        }
        return null;
    }

    public ArrayList<Location> getLocations() {
        return this.locations;
    }

    public void addLocation(Location location) {
        this.locations.add(location);
    }

    public void removeLocation(Location searchLocation) {
        for (Location location : this.locations) {
            if (searchLocation == location) {
                this.locations.remove(location);
                break;
            }
        }

    }

    public Location getLocationByID(int id) {
        for (Location location : this.locations) {
            if (location.getID() == id) {
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
            if (ticket.getPerson() == person) {
                personTickets.add(ticket);
            }
        }
        return personTickets;
    }

}
